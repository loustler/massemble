package io.loustler.massemble.leetcode;

import java.util.*;

// https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {
  public static void main(String[] args) {
    assert solve("III") == 3;
    assert solve("IV") == 4;
  }

  public static int solve(String s) {
    Map<Character, Integer> table = new HashMap<>(7);
    
    table.put('I', 1);
    table.put('V', 5);
    table.put('X', 10);
    table.put('L', 50);
    table.put('C', 100);
    table.put('D', 500);
    table.put('M', 1000);
    
     int n = s.length();
        
     int result = 0;
        
     for(int i = 0; i < n; i++) {
       char cur = s.charAt(i);
            
       if (i + 1 < n) {
         char next = s.charAt(i + 1);
                
         int x = table.get(cur);
         int y = table.get(next);
         
         if (x < y) {
           result += y - x;
           i++;
         } else result += x;
       } else {
         int x = table.get(cur);
                
         result += x;
       }
     }
        
     return result;
  }
}
