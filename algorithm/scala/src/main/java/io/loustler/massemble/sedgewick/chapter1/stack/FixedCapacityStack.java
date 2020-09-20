package io.loustler.massemble.sedgewick.chapter1.stack;

import java.util.function.Consumer;

public final class FixedCapacityStack<T> extends AbstractArrayStack<T> {
  public FixedCapacityStack(int initCapacity) {
    super(initCapacity);
  }

  public static void main(String[] args) {
    Stack<String> stack = new FixedCapacityStack<>(3);
    stack.push("hello");
    stack.push("world");
    stack.push("!");
    System.out.println("---all push---");
    stack.foreach(System.out::println);
    try {
      stack.push("overflow");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Stack overflow!");
    }
    System.out.println(stack.pop());
    System.out.println("---after pop---");
    stack.foreach(System.out::println);
    stack.push("!!");
    System.out.println("---After push new string---");
    stack.foreach(System.out::println);

  }
}
