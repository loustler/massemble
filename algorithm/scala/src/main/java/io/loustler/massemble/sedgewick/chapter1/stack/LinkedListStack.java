package io.loustler.massemble.sedgewick.chapter1.stack;

import io.loustler.massemble.sedgewick.chapter1.list.LinkedList;
import io.loustler.massemble.sedgewick.chapter1.list.List;

import java.util.function.Consumer;

public class LinkedListStack<T> implements Stack<T> {
  private final List<T> list = new LinkedList<>();

  public LinkedListStack() {}

  @Override
  public void push(T value) {
    list.add(value);
  }

  @Override
  public T pop() {
    return list.remove(list.size() - 1);
  }

  @Override
  public T peek() {
    return list.last();
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public <V> void foreach(Consumer<T> f) {
    list.foreach(f);
  }

  public static void main(String[] args) {
    final Stack<Integer> stack = new LinkedListStack<>();

    stack.push(0);
    stack.push(1);
    stack.push(2);
    System.out.printf("1. current stack size is %d\n", stack.size());
    stack.foreach(System.out::println);
    stack.push(3);
    stack.push(4);
    System.out.printf("2. current stack size is %d\n", stack.size());
    stack.foreach(System.out::println);
    System.out.printf("pop %d from stack\n", stack.pop());
    System.out.printf("3. current stack size is %d\n", stack.size());
    stack.foreach(System.out::println);
  }
}
