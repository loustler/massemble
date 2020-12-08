package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
  public static void main(String[] args) {
    System.out.println(
        longestCommonPrefix(new String[] { "flower", "flow", "flight" })
    );
    System.out.println("-------------");
    System.out.println(
        longestCommonPrefix(new String[] { "dog", "racecar", "car" })
    );
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    int minLength = Integer.MAX_VALUE;

    for (int i = 0; i < strs.length; i++)
      minLength = Math.min(minLength, strs[i].length());

    int left = 1;
    int right = minLength;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (haveCommonPrefix(strs, mid)) left = mid + 1;
      else right = mid - 1;
    }

    return strs[0].substring(0, (left + right) / 2);
  }

  private static boolean haveCommonPrefix(String[] strs, int len) {
    String s = strs[0].substring(0, len);

    for (int i = 1; i < strs.length; i++)
      if (!strs[i].startsWith(s)) return false;

    return true;
  }
}
