package io.loustler.massemble.cache

trait Cache[K, V] {

  /**
    * Get from cache
    *
    * @param key key
    * @return
    */
  def get(key: K): Option[V]

  /**
    * Write key and value pair to cache
    *
    * @param key key
    * @param value values
    */
  def put(key: K, value: V): Unit

  /**
    * Keys
    *
    * @return if non-empty sequences which means cache has keys, otherwise empty sequence.
    */
  def keys: Seq[K]

  /**
    * Values
    *
    * @return if non-empty sequences means cache has values, otherwise empty sequence.
    */
  def values: Seq[V]

  /**
    * Cache size
    *
    * @return current size of cache
    */
  def size: Int

  /**
    * Empty check
    *
    * @return if true cache is empty, otherwise false
    */
  def isEmpty: Boolean = size == 0

  /**
    * non-empty
    *
    * @return if true cache is non-empty, otherwise false
    */
  def nonEmpty: Boolean = !isEmpty

  /**
    * Clean cache
    */
  def clean(): Unit

  /**
    * Remove the eldest entries
    */
  def trim(): Unit
}
