package io.loustler.massemble.leetcode;

import io.loustler.massemble.JPrinter;

// https://leetcode.com/problems/plus-one/
public class PlusOne {
  public static void main(String[] args) {
    JPrinter.print(plusOne(new int[] { 1, 2, 3 })); // [1, 2, 4], 124
    JPrinter.print(plusOne(new int[] { 4, 3, 2, 1 })); // [4, 3, 2, 2], 4322
    JPrinter.print(plusOne(new int[] { 0 })); // [1], 1
    JPrinter.print(plusOne(new int[] { 9 })); // [1, 0], 10
  }

  public static int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) return digits;

    int carry = 0, limit = digits.length - 1;

    for (int i = limit; i >= 0; i--) {
      digits[i] += i == limit ? 1 : carry;

      if (digits[i] >= 10) {
        digits[i] -= 10;
        carry = 1;
      } else carry = 0;
    }

    if (carry == 1) {
      int[] newArray = new int[limit + 2];
      newArray[0] = 1;

      for (int i = 1; i < newArray.length; i++) {
        newArray[i] = digits[i - 1];
      }

      return newArray;
    }

    return digits;
  }
}
