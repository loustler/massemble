package io.loustler.massemble.cache

final class LFU[K, V] extends Cache[K , V] {
  override def get(key: K): V = ???

  override def put(key: K, value: V): Unit = ???
}
