// https://leetcode.com/problems/running-sum-of-1d-array/
public class RunningSumOfArray {
  public static void main(String[] args) {
    solve(new int[] {1, 2, 3, 4}); // [1,3,6,10]
    solve(new int[] {1,1,1,1,1}); // [1,2,3,4,5]
    solve(new int[] {3,1,2,10,1}); // [3,4,6,16,17]
  }

  public static int[] solve(int[] nums) {
    int[] ans = new int[nums.length];
    int sum = 0;
    
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      ans[i] = sum;
    }
    
    return ans;
  }
}
