package io.loustler.massemble.leetcode;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    solve("abcabcbb"); // 3
    solve("bbbbb"); // 1
    solve("pwwkew"); // 3
  }
  
  public static int solve(String s) {
    int ans = 0, len = s.length();
    
    Map<Character, Integer> table = new HashMap<>(len);
    
    for (int idx = 0, latestIdx = 0; idx < len; idx++) {
      Character c = s.charAt(idx);
      
      if (table.containsKey(c))
        latestIdx = Math.max(table.get(c), latestIdx);
        
      ans = Math.max(ans, idx - latestIdx + 1);
      table.put(c, idx + 1);
    }
    
    return ans;
  }
}
