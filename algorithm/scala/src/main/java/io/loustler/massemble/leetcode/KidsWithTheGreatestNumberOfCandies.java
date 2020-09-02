package io.loustler.massemble.leetcode;

import java.util.*;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithTheGreatestNumberOfCandies {
  public static void main(String[] args) {
    solve(new int[] {2,3,5,1,3}, 3); // [true,true,true,false,true]
    solve(new int[] {4,2,1,1,2}, 1); // [true,false,false,false,false]
    solve(new int[] {[12,1,12]}, 10); // [true,false,true]
  }
  
  public static List<Boolean> solve(int[] candies, int extraCandies) {
    List<Boolean> list = new ArrayList<>(candies.length);
    
    int max = 0;
    
    for (int i = 0; i < candies.length; i++) {
      max = Math.max(max, candies[i]);
    }
    
    for (int i = 0; i < candies.length; i++) {
      list.add(max <= candies[i] + extraCandies);
    }
    
    return list;
  }
}
