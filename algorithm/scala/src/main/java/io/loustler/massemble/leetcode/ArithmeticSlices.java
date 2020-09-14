package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/arithmetic-slices/
public class ArithmeticSlices {
  public static void main(String[] args) {
    System.out.println(solve(new int[]{1, 3, 5, 7, 9})); // 6
    System.out.println(solve(new int[]{7, 7, 7, 7})); // 3
    System.out.println(solve(new int[]{3, -1, -5, -9})); // 3
    System.out.println(solve(new int[]{1, 2, 3, 4})); // 3
  }
  
  public static int solve(int[] A) {
    int ans = 0;
    
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; i + 2 < A.length && A[i + 1] - A[i] == A[i + 2] - A[i + 1]; i++) {
        j++;
        ans += j;
      }
    }
    
    return ans;
  }
}
