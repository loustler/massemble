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

  public static boolean isSorted(String[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1].compareTo(arr[i]) > 0) return false;
    }

    return true;
  }
}
