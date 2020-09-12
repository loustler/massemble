package io.loustler.massemble.codility;

public class PermMissingElem {
  public static void main(String[] args) {
    System.out.println(solve(new int[] {2, 3, 1, 5})); // 4
    System.out.println(solve(new int[] {2, 1})); // 4
    System.out.println(solve(new int[] {1})); // 4

    int x = 100000 * 100000;
    long y = 100000 * 100000;

    System.out.println(x);
    System.out.println(y);
  }

  public static int solve(int[] A) {
    int sum = 0;

    for (int i = 0; i <= A.length + 1; i++) {
      sum += i;
    }

    for (int i = 0; i < A.length; i++) {
      sum -= A[i];
    }

    return sum;
  }
}
