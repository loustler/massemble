package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {
  public static void main(String[] args) {
     System.out.println(solve("babad")); // bab
     System.out.println(solve("baab")); // baab
     System.out.println(solve("abcbe")); // bcb
     System.out.println(solve("aabccb")); // bccb
     System.out.println(solve("aabaab")); // aabaa
     System.out.println(solve("abcdef")); // empty string
  }
  
  public static String solve(String s) {
     if (s == null || "".equals(s)) return s;
     
     String ans = "";
     
     int len = s.length(), max = 0, i = 0, j = 0;
     
     boolean[][] dp = new boolean[len][len];
     
     while (j < len) {
       boolean judge = s.charAt(i) == s.charAt(j);
       
       // "abba"의 경우, i = 0, j = 4일 때 a, a 이므로 judge = true
       // j - i > 2 성립. 그 사이 글자 체크한 결과와 현재 결과를 비교
       dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge;
       
       if (dp[i][j] && j - i + 1 > max) {
         max = j - i + 1;
         ans = s.substring(i, j + 1);
       }
       
       if (i == j) {
         i = 0;
         j++;
       } else i++;
     }
     
     return ans;
  }
}
