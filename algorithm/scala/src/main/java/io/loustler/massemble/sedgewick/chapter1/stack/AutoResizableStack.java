package io.loustler.massemble.sedgewick.chapter1.stack;

import java.util.function.Consumer;

public final class AutoResizableStack<T> extends AbstractArrayStack<T> {
  private int capacity;

  public AutoResizableStack(int initCapacity) {
    super(initCapacity);
    capacity = initCapacity;
  }

  @Override
  public void push(T value) {
    resizeIfNeed();

    super.push(value);
  }

  private void resizeIfNeed() {
    if (size() > 1 && size() % capacity == 0) {
      Object[] old = getArray();
      Object[] newArray = new Object[size() + capacity];

      for (int i = 0; i < old.length; i++) {
        newArray[i] = old[i];
      }

      reassignArray(newArray);
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new AutoResizableStack<Integer>(3);

    stack.push(0);
    stack.push(1);
    stack.push(2);
    System.out.printf("1. current stack size is %d\n", stack.size());
    stack.foreach(System.out::println);
    stack.push(3);
    stack.push(4);
    System.out.printf("2. current stack size is %d\n", stack.size());
    stack.foreach(System.out::println);
    System.out.printf("pop %d from stack", stack.pop());
    System.out.printf("3. current stack size is %d\n", stack.size());
    stack.foreach(System.out::println);
  }
}
