package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
  public static void main(String[] args) {
    System.out.println(solve(7, new int[]{2, 3, 1, 2, 4, 3})); // 2
  }

  public static int solve(int s, int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int ans = Integer.MAX_VALUE, left = 0, sum = 0;

    /**
     * 2 pointer
     *
     * i는 오른쪽으로 이동하는 포인터
     */
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      /**
       * left는 오른쪽으로 점차 이동하며 조건을 만족하는 최소값의 포인터를 만족하는 포인터가 될 인덱스를 검색
       */
      while (sum >= s) {
        ans = Math.min(ans, i - left + 1);
        sum -= nums[left++];
      }
    }

    return ans;
  }
}
