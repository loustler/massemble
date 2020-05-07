package io.loustler.massemble.cache

import scala.collection.mutable.{ ArrayDeque => DeQue }

/**
  * Fixed size LRU(Least Recently Used) Cache
  *
  * @param capacity capacity for LRU cache. It means max size is capacity
  * @tparam K key type
  * @tparam V value type
  */
final class LRU[K, V](capacity: Int) extends Cache[K, V] {

  val deque: DeQue[(K, V)] = locally {

    val builder = DeQue.newBuilder[(K, V)]

    builder.sizeHint(capacity)

    builder.result()
  }

  override def get(key: K): Option[V] = deque.find(_._1 == key).map(_._2)

  override def put(key: K, value: V): Unit = {
    if (size <= capacity) removeEldestValue()

    add(key, value)
  }

  override def keys: Seq[K] = deque.toSeq.map(_._1)

  override def values: Seq[V] = deque.toSeq.map(_._2)

  override def size: Int = deque.size

  override def isEmpty: Boolean = deque.isEmpty

  override def clean(): Unit = deque.clear()

  override def trim(): Unit = deque.trimToSize()

  private def add(key: K, value: V): Unit = {
    val pair = key -> value

    deque.indexOf(pair) match {
      case -1 => deque += pair

      case idx =>
        deque.remove(idx)
        deque += pair
    }
  }

  private def removeEldestValue(): Unit = {
    if (nonEmpty) {
      // create new array in deque
      deque.removeHead(resizeInternalRepr = true)
    }
  }
}

object LRU {
  val DefaultCapacity: Int = 10

  def apply[K, V](capacity: Int = DefaultCapacity): LRU[K, V] = new LRU[K, V](capacity = capacity)
}
