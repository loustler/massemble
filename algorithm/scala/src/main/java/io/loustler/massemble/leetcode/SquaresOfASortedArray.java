package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
public class SquaresOfASortedArray {
  public static void main(String[] args) {
    print(solve(new int[] {-4,-1,0,3,10})); // [0,1,9,16,100]
    print(solve(new int[] {-7,-3,2,3,11})); // [4,9,9,49,121]
  }

  public static int[] solve(int[] A) {
    if (A == null) return null;

    int left = 0, right = A.length - 1, idx = right;

    int[] ans = new int[A.length];

    while (left <= right) {
      int x = pow(A[left]);
      int y = pow(A[right]);

      if (x < y) {
        ans[idx--] = y;
        right--;
      } else {
        ans[idx--] = x;
        left++;
      }
    }

    return ans;
  }

  private static int pow(int n) {
    return n * n;
  }

  private static void print(int[] arr) {
    StringBuilder builder = new StringBuilder("[");

    for (int i = 0; i < arr.length; i++) {
      int x = arr[i];

      if (i == arr.length - 1)
        builder.append(x);
      else
        builder.append(x)
               .append(",");
    }
    builder.append("]");

    System.out.println(builder.toString());
  }
}
