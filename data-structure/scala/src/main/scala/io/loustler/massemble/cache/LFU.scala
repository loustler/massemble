package io.loustler.massemble.cache

import collection.mutable.{ Map => MMap }

/**
  * Fixed size LFU(Least Frequently Used) Cache
  *
  * @param capacity capacity for LFU cache. It means max size is capacity
  * @tparam K key type
  * @tparam V value type
  */
final class LFU[K, V](capacity: Int) extends Cache[K, V] {

  final case class Node(key: K, value: V, count: Int) {
    def increase: Node = copy(count = count + 1)
  }

  object Node {

    def init(key: K, value: V): Node =
      Node(key, value, count = 1)
  }

  var min: Int = 0

  val map: MMap[K, Node] = init[K, Node]

  // key: frequency, value: nodes of value(V)
  val freqMap: MMap[Int, List[Node]] = init[Int, List[Node]]

  val freqPosMap: MMap[K, Int] = init[K, Int]

  override def get(key: K): Option[V] = {
    map
      .updateWith(key) {
        case Some(oldNode) =>
          val newNode = oldNode.increase

          freqMap.updateWith(oldNode.count) {
            case Some(freqNodes) =>
              // remove old node
              Some {
                freqPosMap
                  .get(key)
                  .fold(freqNodes)(freq => freqNodes.filterNot(_ == oldNode))
              }

            case _ => None
          }

          freqMap.updateWith(newNode.count) {
            case Some(freqNodes) =>
              freqPosMap.update(key, freqNodes.size)

              Some(freqNodes :+ newNode)

            case _ => Some(List(newNode))
          }

          freqMap.get(min) match {
            case Some(ls) =>
              if (ls.isEmpty) min = min + 1
              else min = min

            case _ => ()
          }

          Some(newNode)

        // new
        case _ => None
      }
      .map(_.value)
  }

  override def put(key: K, value: V): Unit = {
    if (size <= capacity) trim()

    val newNode: Option[Node] = map.updateWith(key) {
      case Some(old) => Some(old.increase)

      case _ => Some(Node.init(key, value))
    }

    newNode.tapEach { node =>
      freqMap.updateWith(node.count) {
        case Some(list) =>
          val nodes: List[Node] = list :+ node

          freqPosMap += node.key -> list.size

          Some(nodes)

        case _ =>
          freqPosMap += node.key -> 0

          Some(List(node))
      }
    }

    min = 1
  }

  override def keys: Seq[K] = map.keys.toSeq

  override def values: Seq[V] = map.values.map(_.value).toSeq

  override def size: Int = map.size

  override def clean(): Unit = {
    map.clear()
    freqMap.clear()
    freqPosMap.clear()
  }

  override def trim(): Unit =
    if (size >= capacity) {
      freqMap.updateWith(min) {
        case Some(h :: tail) => {
          map.remove(h.key)

          freqPosMap.remove(h.key)

          Some(tail)
        }

        case _ => None
      }
    }

  private def init[KEY, VALUE]: MMap[KEY, VALUE] = {
    val builder = MMap.newBuilder[KEY, VALUE]

    builder.sizeHint(capacity)

    builder.result()
  }
}

object LFU {
  val DefaultCapacity: Int = 10

  def apply[K, V](capacity: Int = DefaultCapacity): LFU[K, V] = new LFU[K, V](capacity = capacity)
}
