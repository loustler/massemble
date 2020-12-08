package io.loustler.massemble.leetcode;

import io.loustler.massemble.leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(
      2,
      new ListNode(
        4,
        new ListNode(3)
      )
    );

    ListNode l2 = new ListNode(
      5,
      new ListNode(
        6,
        new ListNode(4)
      )
    );

    System.out.println(solve2(l1, l2));
  }

  public static ListNode solve(ListNode l1, ListNode l2) {
    boolean carry = false;

    ListNode node = null;

    int i = 1;

    while(true) {
      int val = 0;
      if (carry) val = 1;
      carry = false;

      val += l1.val + l2.val;

      if (val >= 10) {
        carry = true;
        val -= 10;
      }

      if (node == null) node = new ListNode(val);
      else node = new ListNode(node.val, new ListNode(val, node.next));


      l1 = l1.next;
      l2 = l2.next;

      if (l1 == null && l2 == null) return node;
      i++;
    }
  }

  public static ListNode solve2(ListNode l1, ListNode l2) {
    ListNode list = new ListNode(0);
    ListNode p = l1, q = l2, curr = list;
    int carry = 0;

    while (p != null || q != null) {
      int x = p != null ? p.val : 0;
      int y = q != null ? q.val : 0;
      int sum = carry + x + y;

      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }

    if (carry > 0)
      curr.next = new ListNode(carry);

    return list.next;
  }
}
