package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/submissions/
public class SearchInRotatedSortedArray2 {
  public static void main(String[] args) {
    System.out.println(solve(new int[] {2, 5, 6, 0, 0, 1, 2}, 0)); // true
    System.out.println(solve(new int[] {2, 5, 6, 0, 0, 1, 2}, 3)); // false
  }

  // Binary Search 사용
  public static boolean solve(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int pivot = left + (right - left) / 2;

      int pivotValue = nums[pivot];

      if (pivotValue == target) return true;

      /**
       * pivot을 기준으로 확인.
       * 정렬된 array가 rotate된 상태이기 때문에
       * 2개의 포인터를 사용함
       *
       * 어떻게 rotate가 되었는지 알 수 없으므로, pivot을 기준으로 왼쪽부터 확인
       *
       * 1. left value가 pivot value 보다 작은 케이스
       * 2. left value가 pivot value 보다 큰 케이스
       * 3. 같은 케이스
       */
      if (nums[left] < pivotValue) {
        /**
         * 1. target이 left value보다 작거나
         * 2. target이 pivot value보다 크다는 것
         *
         * pivot을 기준으로 오른쪽에 target value가 있을 수 있다는 것
         */
        if (target < nums[left] || target > pivotValue) left = pivot + 1;
        else right = pivot - 1;
      } else if (nums[left] > pivotValue) {
        /**
         * 1. target이 pivot value보다 작거나
         * 2. target이 right value보다 크다는 것
         *
         * pivot을 기준으로 왼족에 있다는 것         */
        if (target < pivotValue || target > nums[right]) right = pivot - 1;
        else left = pivot + 1;
      } else {
        // pivot value를 기준으로 찾을 수 없으므로 left를 이동하여 다시 확인
        left++;
      }
    }

    return false;
  }
}
