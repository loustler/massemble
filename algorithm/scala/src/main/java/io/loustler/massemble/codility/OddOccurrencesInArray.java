package io.loustler.massemble.codility;

import java.util.*;

public class OddOccurrencesInArray {
  public static void main(String[] args) {
    System.out.println(solve(new int[] {9, 3, 9, 3, 9, 7, 9})); // 7
  }

  public static int solve(int[] A) {
    if (A.length == 1) return A[0];

    Map<Integer, Integer> table = new HashMap<>(A.length);

    for (int i = 0; i < A.length; i++) {
      if (table.containsKey(A[i])) table.put(A[i], table.get(A[i]) + 1);
      else table.put(A[i], 1);
    }

    for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
      if (entry.getValue() % 2 == 1) return entry.getKey();
    }

    return -1;
  }
}
