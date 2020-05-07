package io.loustler.massemble.cache

/**
  * Fixed size LFU(Least Frequently Used) Cache
  *
  * @param capacity capacity for LFU cache. It means max size is capacity
  * @tparam K key type
  * @tparam V value type
  */
final class LFU[K, V](capacity: Int) extends Cache[K, V] {
  override def get(key: K): Option[V] = ???

  override def put(key: K, value: V): Unit = ???

  override def keys: Seq[K] = ???

  override def values: Seq[V] = ???

  override def size: Int = ???

  override def clean(): Unit = ???

  override def trim(): Unit = ???
}

object LFU {
  val DefaultCapacity: Int = 10

  def apply[K, V](capacity: Int = DefaultCapacity): LFU[K, V] = new LFU[K, V](capacity = capacity)
}
