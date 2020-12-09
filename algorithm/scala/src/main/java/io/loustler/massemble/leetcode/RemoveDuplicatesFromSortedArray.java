package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    System.out.println(solve(new int[] {1, 1, 2}));
    System.out.println(solve(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }

  public static int solve(int[] nums) {
    if (nums == null) return 0;
    if (nums.length < 2) return nums.length;

    int x = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[x] != nums[i]) nums[++x] = nums[i];
    }

    return x + 1;
  }
}
