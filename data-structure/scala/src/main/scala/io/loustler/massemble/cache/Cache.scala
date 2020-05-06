package io.loustler.massemble.cache

trait Cache[K, V] {
  def get(key: K): V

  def put(key: K, value: V): Unit
}
