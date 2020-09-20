package io.loustler.massemble.sedgewick.chapter1.stack;

import io.loustler.massemble.sedgewick.chapter1.Iterable;

public interface Stack<T> extends Iterable<T> {
  void push(T value);

  T pop();

  T peek();
}
