package io.loustler.massemble.cache

final class LFU[K, V] extends Cache[K, V] {
  override def get(key: K): V = ???

  override def put(key: K, value: V): Unit = ???
}

object LFU {
  def apply[K, V]: LFU[K, V] = new LFU[K, V]
}
