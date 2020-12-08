package io.loustler.massemble.leetcode.model;

public class ListNode {
  public int val;

  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode of(Integer... values) {
    ListNode n = new ListNode(values[0]);
    ListNode p = n;

    for (int i = 1; i < values.length; i++) {
      p.next = new ListNode(values[i]);
      p = p.next;
    }

    return n;
  }

  private StringBuilder nodeToString(StringBuilder builder, ListNode p) {
    if (p == null) return builder;

    builder.append("ListNode(")
        .append("value = ")
        .append(p.val)
        .append(")");

    if (p.next != null) builder.append(" => ");

    return builder;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    ListNode p = this;

    while (p != null) {
      builder = nodeToString(builder, p);

      p = p.next;
    }

    return builder.toString();
  }
}
