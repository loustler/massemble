package io.loustler.massemble.leetcode;

import io.loustler.massemble.leetcode.model.ListNode;

public class ReverseLinkedList {
  public static void main(String[] args) {
    ListNode node = new ListNode(
      1,
      new ListNode(
        2,
        new ListNode(
          3,
          new ListNode(
            4,
            new ListNode(
              5
            )
          )
        )
      )
    );

    print(solve(node)); // 5 -> 4 -> 3 -> 2 -> 1
  }

  private static ListNode solve(ListNode head) {
    ListNode ans = null, cur = head;

    while (cur != null) {
      ListNode next = cur.next;
      cur.next = ans;
      ans = cur;
      cur = next;
    }

    return ans;
  }

  private static void print(ListNode node) {
    StringBuilder builder = new StringBuilder();

    while (node != null) {
      builder.append(node.val);

      if (node.next != null) builder.append("->");

      node = node.next;
    }

    System.out.println(builder.toString());
  }
}
