package io.loustler.massemble.fp.zio.cache

import zio.{Task, UIO}

trait Cache[K, V] {
  def get(key: K): Task[Option[V]]

  def getOrUpdate(key: K)(update: => V): Task[V]

  def put(key: K, value: V): UIO[Unit]
}
object Cache {

}