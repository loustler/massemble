package io.loustler.massemble.sedgewick.chapter1;

public class IntegerToBinaryString {
  public static String toBinaryString(int x) {
    String s = "";

    for (int i = x;  i > 0; i  /= 2) {
      s = (i % 2) + s;
    }

    return s;
  }
}
