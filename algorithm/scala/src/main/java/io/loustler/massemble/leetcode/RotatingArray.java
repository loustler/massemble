package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/rotate-array
public class RotatingArray {
  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
    int aShuffle = 3;
    // // [5, 6, 7, 1, 2, 3, 4]
    solve(a, aShuffle);
    print(a);

    int[] b = new int[]{-1, -100, 3, 99};
    int bShuffle = 2;
    // [3, 99, -1, -100]
    solve(b, bShuffle);
    print(b);
  }

  public static void solve(int[] nums, int k) {
    k %= nums.length;

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private static void reverse(int[] array, int start, int end) {
    while (start < end) {
      swap(array, start++, end--);
    }
  }

  private static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  private static void print(int[] array) {
    StringBuilder builder = new StringBuilder();
    builder.append("[");

    for (int i = 0; i < array.length; i++) {
      if (i == array.length - 1)
        builder.append(array[i]);
      else
        builder.append(array[i]).append(",");
    }

    builder.append("]");

    System.out.println(builder.toString());
  }
}
