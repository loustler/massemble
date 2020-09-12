package io.loustler.massemble.codility;

import java.util.*;

public class TapeEquilibrium {
  public static void main(String[] args) {
    System.out.println(solve(new int[] {3, 1, 2, 4, 3})); // 1
    System.out.println(solve(new int[] {-1000, 1000})); // 2000
    System.out.println(solve(new int[] {-2, -3, -4, -1})); // 0
  }

  public static int solve(int[] A) {
    Map<Integer, Integer> table = new HashMap<>(A.length);

    int sum = 0;

    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      table.put(i, sum);
    }

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < A.length - 1; i++) {
      int diff = Math.abs(table.get(i) - (sum - table.get(i)));

      min = Math.min(diff, min);
    }

    return min;
  }
}
