package io.loustler.massemble.sedgewick.chapter1.queue;

import io.loustler.massemble.sedgewick.chapter1.Iterable;

public interface Queue<T> extends Iterable<T> {
  void enqueue(T value);

  T dequeue();
}
