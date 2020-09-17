package io.loustler.massemble.sedgewick.chapter1;

public interface Stack<T> extends Iterable<T> {
  void push(T value);

  T pop();

  T peek();
}
