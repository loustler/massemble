package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/remove-element/
public class RemoveElement {
  public static void main(String[] args) {
    System.out.println(solution(new int[] { 3, 2, 2, 3}, 3));
    System.out.println(solution(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
  }

  public static int solution(int[] nums, int val) {
    if (nums == null || nums.length == 0) return 0;

    int left = 0, right = nums.length;

    while (left < right) {
      if (nums[left] == val)
        nums[left] = nums[--right];
      else
        left++;
    }

    return left;
  }
}
