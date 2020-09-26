package io.loustler.massemble.codility;

import io.loustler.massemble.JArraySwap;
import io.loustler.massemble.JPrinter;

public class CyclicRotation {
  public static void main(String[] args) {
    JPrinter.print(solve(new int[] {3, 8, 9, 7, 6}, 3)); // [9, 7, 6, 3, 8]
    JPrinter.print(solve(new int[] {0, 0, 0}, 1)); // [[0, 0, 0]
    JPrinter.print(solve(new int[] {1, 2, 3, 4}, 4)); // [1, 2, 3, 4]
  }

  public static int[] solve(int[] A, int K) {
    if (A == null || A.length == 0 || A.length == K || K == 0) return A;

    K %= A.length;

    reverse(A, 0, A.length - 1);
    reverse(A, 0, K - 1);
    reverse(A, K, A.length - 1);

    return A;
  }

  private static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      JArraySwap.swap(arr, start++, end--);
    }
  }
}
