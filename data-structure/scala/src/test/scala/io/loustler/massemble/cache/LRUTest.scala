package io.loustler.massemble.cache

import org.scalatest.Assertion
import org.scalatest.funsuite.AnyFunSuite

final class LRUTest extends AnyFunSuite with CacheTestHelper {
  test("LRU") {
    val cache = LRU[String, Int](capacity = 3)

    val hit: (String, Int) => Assertion       = assertHit(cache)
    val miss: String => Assertion             = assertMiss(cache)
    val size: Int => Assertion                = assertSize(cache)
    val expect: Map[String, Int] => Assertion = assertCache(cache)

    cache.put("a", 1)
    hit("a", 1)
    size(1)
    expect(Map("a" -> 1))

    cache.put("b", 2)
    hit("a", 1)
    hit("b", 2)
    size(2)
    expect(Map("a" -> 1, "b" -> 2))

    cache.put("c", 3)
    size(3)
    hit("a", 1)
    hit("b", 2)
    hit("c", 3)
    miss("d")
    expect(Map("a" -> 1, "b" -> 2, "c" -> 3))

    cache.put("d", 4)
    size(3)
    miss("a")
    hit("d", 4)
    hit("c", 3)
    hit("b", 2)
    expect(Map("b" -> 2, "c" -> 3, "d" -> 4))

    cache.put("e", 5)
    size(3)
    hit("e", 5)
    hit("b", 2)
    hit("c", 3)
    miss("a")
    miss("d")
    expect(Map("b" -> 2, "c" -> 3, "e" -> 5))
  }
}
