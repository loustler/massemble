package io.loustler.massemble.leetcode;

import io.loustler.massemble.leetcode.model.ListNode;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList {
  public static void main(String[] args) {
    System.out.println(
        mergeTwoLists(
            ListNode.of(1, 2, 4),
            ListNode.of(1, 3, 4)
        )
    );
    System.out.println(
        mergeTwoLists(
            new ListNode(),
            new ListNode()
        )
    );
    System.out.println(
        mergeTwoLists(
            new ListNode(),
            ListNode.of(0)
        )
    );
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode l = new ListNode();
    ListNode p = l;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        p.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        p.next = new ListNode(l2.val);
        l2 = l2.next;
      }

      p = p.next;
    }

    if (l1 != null) p.next = l1;
    if (l2 != null) p.next = l2;

    return l.next;
  }
}
