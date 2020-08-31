package io.loustler.massemble.leetcode;

import java.util.*;

/**
 *  https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
  public static int[] solve(int[] nums, int target) {
    final Map<Integer, Integer> table = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      int value = nums[i];
      int rest = target - value;

      if (table.containsKey(rest))
        return new int[]{ table.get(rest), i};

      table.put(value, i);
    }

    return new int[]{};
  }
}
