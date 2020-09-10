package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {
  static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(
      1,
      new ListNode(
        2,
        new ListNode(
          6,
          new ListNode(
            3,
            new ListNode(
              4,
              new ListNode(
                5,
                new ListNode(
                  6
                )
              )
            )
          )
        )
      )
    );

    System.out.println(solve(node, 6)); // 1 -> 2 -> 3 -> 4 -> 5
  }

  public static ListNode solve(ListNode head, int val) {
    if (head == null) return null;

    ListNode ans = new ListNode(), cur = head, p = ans;

    if (head.val == val) cur = cur.next;

    while (cur != null) {
      if (cur.val != val) {
        p.next = new ListNode(cur.val);
        p = p.next;
      }

      cur = cur.next;
    }

    return ans.next;
  }
}
