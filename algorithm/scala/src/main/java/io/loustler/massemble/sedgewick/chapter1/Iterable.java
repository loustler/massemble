package io.loustler.massemble.sedgewick.chapter1;

import java.util.function.Consumer;

public interface Iterable<T> {
  int size();

  default boolean isEmpty() {
    return size() == 0;
  }

  default boolean isNonEmpty() {
    return isEmpty();
  }

  <V> void foreach(Consumer<T> f);
}
