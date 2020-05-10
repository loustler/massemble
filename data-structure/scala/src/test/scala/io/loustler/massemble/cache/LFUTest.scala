package io.loustler.massemble.cache

import org.scalatest.Assertion
import org.scalatest.funsuite.AnyFunSuiteLike

final class LFUTest extends AnyFunSuiteLike with CacheTestHelper {
  test("LFU") {
    val cache = LFU[String, Int](capacity = 3)

    val hit: (String, Int) => Assertion       = assertHit(cache)
    val miss: String => Assertion             = assertMiss(cache)
    val size: Int => Assertion                = assertSize(cache)
    val expect: Map[String, Int] => Assertion = assertCache(cache)

    // A: 1
    cache.put("a", 1)
    size(1)
    hit("a", 1)
    miss("b")
    expect(Map("a" -> 1))

    // A: 2, B: 1
    cache.put("b", 2)
    size(2)
    hit("a", 1)
    hit("b", 2)
    expect(Map("a" -> 1, "b" -> 2))

    // A: 3, B: 1, C: 2
    cache.put("c", 3)
    size(3)
    hit("a", 1)
    hit("c", 3)
    hit("c", 3)
    expect(Map("a" -> 1, "b" -> 2, "c" -> 3))

    // A: 3, B: 1, C: 2, D: 2
    // A: 3, C: 2, D: 2
    cache.put("d", 4)
    size(3)
    hit("a", 1)
    hit("d", 4)
    hit("c", 3)
    hit("d", 4)
    expect(Map("a" -> 1, "c" -> 3, "d" -> 4))

    // A: 2, C: 2, D: 2, E: 1
    cache.put("e", 5)
    size(3)
    expect(Map("a" -> 1, "c" -> 3, "e" -> 5))
  }
}
