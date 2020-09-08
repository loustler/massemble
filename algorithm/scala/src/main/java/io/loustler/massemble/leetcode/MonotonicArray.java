package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/monotonic-array/
public class MonotonicArray {
  public static void main(String[] args) {
    System.out.println(solve(new int[] {1, 2, 3, 4})); // true
    System.out.println(solve(new int[] {6, 5, 4, 4})); // true
    System.out.println(solve(new int[] {1, 3, 2})); // false
    System.out.println(solve(new int[] {1, 2, 4, 5})); // true
    System.out.println(solve(new int[] {1, 1, 1})); // true
  }

  public static boolean solve(int[] A) {
    boolean increase = true, decrease = true;

    for (int i = 0; i < A.length - 1; i++) {
      if (A[i] > A[i + 1]) increase = false;
      if (A[i] < A[i + 1]) decrease = false;
    }

    return increase || decrease;
  }
}
