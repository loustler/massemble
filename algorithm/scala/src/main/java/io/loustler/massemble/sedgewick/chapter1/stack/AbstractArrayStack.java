package io.loustler.massemble.sedgewick.chapter1.stack;

import java.util.function.Consumer;

public abstract class AbstractArrayStack<T> implements Stack<T> {
  private Object[] arr;
  private int pointer;

  public AbstractArrayStack(int initCapacity) {
    arr = new Object[initCapacity];
    pointer = 0;
  }

  @Override
  public void push(T value) {
    if (pointer + 1 > arr.length)
      throw new IndexOutOfBoundsException(pointer);
    else
      arr[pointer++] = value;
  }

  @Override
  public T pop() {
    return (T)arr[--pointer];
  }

  @Override
  public T peek() {
    return (T)arr[pointer - 1];
  }

  @Override
  public int size() {
    return pointer;
  }

  @Override
  public <V> void foreach(Consumer<T> f) {
    for (int i = pointer; i > 0; i--) {
      f.accept((T)arr[i - 1]);
    }
  }

  protected Object[] getArray() {
    return arr;
  }

  protected void reassignArray(Object[] newArray) {
    arr = newArray;
  }
}
