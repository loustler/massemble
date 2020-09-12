package io.loustler.massemble.codility;

public class CyclicRotation {
  public static void main(String[] args) {
    print(solve(new int[] {3, 8, 9, 7, 6}, 3)); // [9, 7, 6, 3, 8]
    print(solve(new int[] {0, 0, 0}, 1)); // [[0, 0, 0]
    print(solve(new int[] {1, 2, 3, 4}, 4)); // [1, 2, 3, 4]
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
      swap(arr, start++, end--);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  private static void print(int[] arr) {
    StringBuilder builder = new StringBuilder();

    builder.append("[");

    for (int i = 0; i < arr.length; i++) {
      builder.append(arr[i]);

      if (i < arr.length - 1) builder.append(",");
    }

    builder.append("]");

    System.out.println(builder.toString());
  }
}
