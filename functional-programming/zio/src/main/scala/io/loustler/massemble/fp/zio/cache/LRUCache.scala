package io.loustler.massemble.fp.zio.cache

import zio.duration.Duration
import zio.stm.{ STM, TMap, TRef }
import zio.{ Task, UIO }

final class LRUCache[K, V] private (
  private val capacity: Int,
  private val ttl: Duration,
  private val items: TMap[K, CacheItem[K, V]],
  private val startRef: TRef[Option[K]],
  private val endRef: TRef[Option[K]]
) extends Cache[K, V] { self =>

  override def get(key: K): Task[Option[V]] =
    (
      for {
        itemOpt <- self.items.get(key)

        item <- STM.fromOption(itemOpt)

        _ <- removeKeyFromList(key) *> addKeyToStartOfList(key)
      } yield item.value
    ).commit

  override def getOrUpdate(key: K)(update: => V): Task[V] = ???

  override def put(key: K, value: V): UIO[Unit] =
    (
      for {
        startOpt <- self.startRef.get

        endOpt <- self.endRef.get

        _ <- STM.ifM(self.items.contains(key))(
          updateItem(key, value),
          addNewItem(key, value)
        )
      } yield ()
    ).commitEither.orDie

  private def updateItem(key: K, value: V): STM[Throwable, Unit] =
    removeKeyFromList(key) *>
      self.items.put(key, CacheItem[K, V](value, None, None)) *>
      addKeyToStartOfList(key)

  private def addNewItem(key: K, value: V): STM[Throwable, Unit] = {
    val newCacheItem: CacheItem[K, V] = CacheItem[K, V](value, None, None)

    STM.ifM(self.items.keys.map(_.length < self.capacity))(
      self.items.put(key, newCacheItem) *> addKeyToStartOfList(key),
      replaceEndCacheItem(key, newCacheItem)
    )
  }

  private def replaceEndCacheItem(key: K, newCacheItem: CacheItem[K, V]): STM[Throwable, Unit] =
    self.endRef.get.flatMap {
      case Some(end) =>
        removeKeyFromList(end) *> self.items.delete(end) *> self.items.put(key, newCacheItem) *> addKeyToStartOfList(
          key
        )
      case None => STM.fail(new Error(s"End is not defined!"))
    }

  private def addKeyToStartOfList(key: K): STM[Throwable, Unit] =
    for {
      oldOptionStart <- self.startRef.get
      _ <- getExistingCacheItem(key).flatMap { cacheItem =>
        self.items.put(key, cacheItem.copy(left = None, right = oldOptionStart))
      }
      _ <- oldOptionStart match {
        case Some(oldStart) =>
          getExistingCacheItem(oldStart).flatMap { oldStartCacheItem =>
            self.items.put(oldStart, oldStartCacheItem.copy(left = Some(key)))
          }
        case None => STM.unit
      }
      _ <- self.startRef.set(Some(key))
      _ <- self.endRef.updateSome { case None => Some(key) }
    } yield ()

  private def removeKeyFromList(key: K): STM[Throwable, Unit] =
    for {
      cacheItem <- getExistingCacheItem(key)

      optionLeftKey = cacheItem.left

      optionRightKey = cacheItem.right

      _ <- (optionLeftKey, optionRightKey) match {
        case (Some(l), Some(r)) =>
          updateLeftAndRightCacheItems(l, r)
        case (Some(l), None) =>
          setNewEnd(l)
        case (None, Some(r)) =>
          setNewStart(r)
        case (None, None) =>
          clearStartAndEnd
      }
    } yield ()

  private def updateLeftAndRightCacheItems(l: K, r: K): STM[Throwable, Unit] =
    for {
      leftCacheItem  <- getExistingCacheItem(l)
      rightCacheItem <- getExistingCacheItem(r)

      _ <- self.items.put(l, leftCacheItem.copy(right = Some(r)))
      _ <- self.items.put(r, rightCacheItem.copy(left = Some(l)))
    } yield ()

  private def setNewEnd(newEnd: K): STM[Throwable, Unit] =
    for {
      cacheItem <- getExistingCacheItem(newEnd)
      _         <- self.items.put(newEnd, cacheItem.copy(right = None)) *> self.endRef.set(Some(newEnd))
    } yield ()

  private def setNewStart(newStart: K): STM[Throwable, Unit] =
    for {
      cacheItem <- getExistingCacheItem(newStart)
      _         <- self.items.put(newStart, cacheItem.copy(left = None)) *> self.startRef.set(Some(newStart))
    } yield ()

  private val clearStartAndEnd: STM[Nothing, Unit] = self.startRef.set(None) *> self.endRef.set(None)

  private def getExistingCacheItem(key: K): STM[Throwable, CacheItem[K, V]] =
    STM.require(new Error(s"Key does not exist: $key"))(self.items.get(key))

}
