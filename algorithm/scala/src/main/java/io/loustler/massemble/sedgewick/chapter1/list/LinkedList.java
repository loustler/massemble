package io.loustler.massemble.sedgewick.chapter1.list;

import java.util.function.Consumer;

public class LinkedList<T> implements List<T> {
  private static class Node<V> {
    V    value;
    Node next;

    public Node(V value) {
      this.value = value;
    }

    public Node(V value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  private Node node;
  private int  size;

  public LinkedList() {
    node = null;
    size = 0;
  }

  public LinkedList(T... value) {
    for (int i = 0; i < value.length; i++) {
      add(value[i]);
    }
  }

  @Override
  public void add(T value) {
    addNode_(new Node<>(value));

    this.size++;
  }

  @Override
  public void addAll(T... values) {
    Node<T> newNode = new Node<>(values[0]), pointer = newNode;
    size++;

    for (int i = 1; i < values.length; i++) {
      pointer.next = new Node<>(values[i]);
      pointer = pointer.next;
      size++;
    }

    addNode_(newNode);
  }

  private void addNode_(Node<T> newNode) {
    if (this.node == null) this.node = newNode;
    else {
      Node<T> cur = this.node;

      while (cur != null) {
        if (cur.next == null) {
          cur.next = newNode;
          break;
        }

        cur = cur.next;
      }
    }
  }

  @Override
  public void replace(T oldValue, T newValue) {
    Node<T> cur = this.node;

    while (cur != null) {
      if (cur.value == oldValue) cur.value = newValue;

      cur = cur.next;
    }
  }

  @Override
  public void remove(T value) {
    Node<T> cur = this.node, acc = new Node(value), pointer = acc;

    while (cur != null) {
      if (cur.value != value) {
        pointer.next = new Node<>(cur.value);
        pointer = pointer.next;
      } else size--;

      cur = cur.next;
    }

    this.node = acc.next;
  }

  @Override
  public boolean exists(T value) {
    Node<T> cur = this.node;

    while (cur != null) {
      if (cur.value == value) return true;
      else cur = cur.next;
    }

    return false;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public <V> void foreach(Consumer<T> f) {
    Node<T> cur = this.node;

    while (cur != null) {
      f.accept(cur.value);
      cur = cur.next;
    }
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();

    foreach(n -> builder.append(n).append("->"));

    return builder.toString();
  }

  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();

    list.add(0);
    list.add(1);
    list.add(2);
    System.out.println("---init---");
    System.out.printf("size is %d \n", list.size());
    list.foreach(System.out::println);
    list.remove(0);
    System.out.println("---remove 0---");
    System.out.printf("size is %d \n", list.size());
    list.foreach(System.out::println);
    list.add(3);
    list.add(4);
    list.add(4);
    System.out.println("---add new values---");
    System.out.printf("size is %d \n", list.size());
    list.foreach(System.out::println);
    list.remove(4);
    System.out.println("---remove duplicate value 4---");
    System.out.printf("size is %d \n", list.size());
    list.foreach(System.out::println);
    list.add(4);
    list.add(5);
    System.out.println("---add new values---");
    System.out.printf("size is %d \n", list.size());
    list.foreach(System.out::println);
    list.replace(5, 6);
    System.out.println("---replace 5 to 6---");
    System.out.printf("size is %d \n", list.size());
    list.foreach(System.out::println);
    System.out.printf("---5 is exists? %s ---\n", Boolean.toString(list.exists(5)));
    list.remove(3);
    System.out.println("---remove 3---");
    System.out.printf("size is %d \n", list.size());
    list.foreach(System.out::println);
    list.addAll(7, 8, 9, 10);
    System.out.println("---Add 7, 8, 9, 10---");
    System.out.printf("size is %d \n", list.size());
    list.foreach(System.out::println);
  }
}
