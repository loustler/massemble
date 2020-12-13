package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/maximum-subarray/solution/
public class MaximumSubArray {
  public static void main(String[] args) {
    System.out.println(maxSubArray(new int[] { -2, -1 , -3, 4, -1, 2, 1, -5, 4 })); // 6
    System.out.println(maxSubArray(new int[] { 1 })); // 1
    System.out.println(maxSubArray(new int[] { 0 })); // 0
    System.out.println(maxSubArray(new int[] { -1 })); // -1
    System.out.println(maxSubArray(new int[] { -2147483647 })); // -2147483647
  }

  public static int maxSubArray(int[] nums) {
    if (nums.length == 1) return nums[0];

    int n = nums.length, maxSum = nums[0];

    for (int i = 1; i < n; i++) {
      if (nums[i - 1] > 0 ) nums[i] += nums[i - 1];

      maxSum = Math.max(nums[i], maxSum);
    }

    return maxSum;
  }
}
