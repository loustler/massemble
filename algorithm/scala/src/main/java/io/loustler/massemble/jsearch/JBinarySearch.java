package io.loustler.massemble.jsearch;

public class JBinarySearch {
    public static int search(int[] arr, int target) {
      int left = 0, right = arr.length - 1, mid;

      while (left <= right) {
        mid = (left + right) / 2;

        if (target == arr[mid]) return mid;
        else {
          if (target < arr[mid]) right = mid - 1;
          else left = mid + 1;
        }
      }

      return -1;
    }

    public static void main(String[] args) {
      System.out.println(search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7));
    }
}
