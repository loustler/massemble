package io.loustler.massemble.sedgewick.chapter1;

public class StringUtil {
  public static boolean  isPalindrome(String s) {
    if (s == null || s.length() == 1) return false;

    int len = s.length();

    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1))
        return false;
    }

    return true;
  }
}
