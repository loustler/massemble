package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakIndexInAMountainArray {
  public static void main(String[] args) {
    System.out.println(solve(new int[] {0, 1, 0})); // 1
    System.out.println(solve(new int[] {0, 2, 1, 0})); // 1
    System.out.println(solve(new int[] {0, 10, 5, 2})); // 1
    System.out.println(solve(new int[] {3, 4, 5, 1})); // 2
    System.out.println(solve(new int[] {24, 69, 100, 99, 79, 78, 67, 36, 26, 19})); // 2
  }

  public static int solve(int[] arr) {
    if (arr.length < 3) return -1;

    int ans = 0;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] < arr[i]) ans = i;
      else break;
    }

    return ans;
  }
}
