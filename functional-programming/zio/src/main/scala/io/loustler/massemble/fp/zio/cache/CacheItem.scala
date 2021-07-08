package io.loustler.massemble.fp.zio.cache

/**
 *
 * @param value value
 * @param left left key
 * @param right right key
 * @tparam K key
 * @tparam V value
 */
private[cache] final case class CacheItem[K, V](value: V, left: Option[K], right: Option[K])