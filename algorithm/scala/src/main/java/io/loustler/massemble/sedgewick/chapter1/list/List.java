package io.loustler.massemble.sedgewick.chapter1.list;

import io.loustler.massemble.sedgewick.chapter1.Iterable;

public interface List<T> extends Iterable<T> {
  void add(T value);

  void addAll(T... values);

  void replace(T oldValue, T newValue);

  void remove(T value);

  boolean exists(T value);
}
