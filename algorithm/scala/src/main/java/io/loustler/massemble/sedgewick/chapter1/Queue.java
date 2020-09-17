package io.loustler.massemble.sedgewick.chapter1;

public interface Queue<T> extends Iterable<T> {
  void enqueue(T value);

  T dequeue();
}
