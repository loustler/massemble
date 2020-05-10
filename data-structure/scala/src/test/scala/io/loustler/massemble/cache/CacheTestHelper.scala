package io.loustler.massemble.cache

import org.scalatest.{ Assertion, Assertions }

trait CacheTestHelper { self: Assertions =>

  def assertHit[K, V](cache: Cache[K, V])(key: K, value: V): Assertion =
    assertResult(Some(value))(cache.get(key))

  def assertMiss[K, V](cache: Cache[K, V])(key: K): Assertion =
    assertResult(None)(cache.get(key))

  def assertSize[K, V](cache: Cache[K, V])(size: Int): Assertion =
    assertResult(size)(cache.size)

  def assertCache[K, V](cache: Cache[K, V])(expect: Map[K, V]): Assertion = {
    val expectKeySet = expect.keySet
    val expectValue  = expect.values.toSeq

    val actuallyKeys   = cache.keys
    val actuallyValues = cache.values

    assertResult(expectKeySet.size)(actuallyKeys.size)
    assertResult(expectValue.size)(actuallyValues.size)

    assert(actuallyKeys.forall(expectKeySet.contains))
    assert(actuallyValues.forall(expectValue.contains))
  }
}
