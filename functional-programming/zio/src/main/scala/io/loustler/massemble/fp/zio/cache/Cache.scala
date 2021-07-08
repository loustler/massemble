package io.loustler.massemble.fp.zio.cache

import zio.{ Task, UIO }

trait Cache[K, V] {

  /**
    * Retrieves value associated with given key.
    *
    * @param key key
    * @return
    */
  def get(key: K): Task[Option[V]]

  /**
    * Retrieves value associated with given key.
    *
    * But if value not exists, update cache and return updated value.
    *
    * @param key key
    * @param update to update value if not exists
    * @return
    */
  def getOrUpdate(key: K)(update: => V): Task[V]

  /**
    * Stores new key and value to cache
    *
    * @param key key
    * @param value value
    * @return
    */
  def put(key: K, value: V): UIO[Unit]
}
object Cache {}
