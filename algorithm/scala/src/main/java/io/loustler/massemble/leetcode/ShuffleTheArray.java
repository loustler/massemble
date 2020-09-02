// https://leetcode.com/problems/shuffle-the-array/
public class ShuffleTheArray {
  public static void main(String[] args) {
    solve(new int[]{2,5,1,3,4,7}, 3); // [2,3,5,4,1,7] 
    solve(new int[]{1,2,3,4,4,3,2,1}, 4); // [1,4,2,3,3,2,4,1]
    solve(new int[]{1,1,2,2}, 2); // [1,2,1,2]
  }
  
  public static int[] solve(int[] nums, int n) {
    int length = nums.length;
    int[] ans = new int[length];
    int mid = length / 2;
    int i = 0, j = mid, p = 0;
    
    while(i < mid && j < length) {
      if (i == n - 1) {
        ans[length - 2] = nums[i];
        ans[length - 1] = nums[j];
      } else {
        ans[p++] = nums[i];
        ans[p++] = nums[j];
      }
      
      i++;
      j++;
    }
    
    return ans;
  }
}
