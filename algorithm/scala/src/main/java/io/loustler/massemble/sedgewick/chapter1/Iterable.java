package io.loustler.massemble.sedgewick.chapter1;

import java.util.function.Function;

public interface Iterable<T> {
  int size();

  boolean isEmpty();

  default boolean isNonEmpty() {
    return isEmpty();
  }

  <V> void foreach(Function<T, V> f);
}
