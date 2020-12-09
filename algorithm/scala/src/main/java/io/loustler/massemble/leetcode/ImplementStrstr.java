package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/implement-strstr/
public class ImplementStrstr {
  public static void main(String[] args) {
    System.out.println(strStr("hello", "ll")); // 2
    System.out.println(strStr("aaaaa", "bba")); // -1
    System.out.println(strStr("", "")); // 0
    System.out.println(strStr("a", "a")); // 0
    System.out.println(strStr("mississippi", "issip")); // 4
  }

  public static int strStr(String haystack, String needle) {
    if (needle == null || needle.equals("")) return 0;
    if (haystack == null || haystack.equals("")) return -1;

    int nLength = needle.length(), hLength = haystack.length();

    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == nLength) return i;
        if (i + j == hLength) return -1;
        if (haystack.charAt(i + j) != needle.charAt(j)) break;
      }
    }
  }
}
