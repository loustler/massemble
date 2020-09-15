package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/bitwise-and-of-numbers-range/
public class BitwiseANDOfNumbersRange {
  public static void main(String[] args) {
    System.out.println(solve(5, 7)); // 4
    System.out.println(solve(0, 1)); // 0
  }

  public static int solve(int m, int n) {
    int shift = 0;

    while (m < n) {
      m >>= 1;
      n >>= 1;
      shift++;
    }

    return m << shift;
  }
}
