package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
  public static void main(String[] args) {
    System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5)); // 2
    System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2)); // 1
    System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7)); // 4
    System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0)); // 0
    System.out.println(searchInsert(new int[] { 1 }, 0)); // 0
    System.out.println(searchInsert(new int[] { 1, 3 }, 2)); // 1
  }

  public static int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1, pivot;

    while (left <= right) {
//      pivot = left + (right - left) / 2;
      pivot = (left + right) >>> 1;

      if (nums[pivot] == target) return pivot;

      if (nums[pivot] > target)
        right = pivot - 1;
      else
        left = pivot + 1;
    }

    return left;
  }
}
