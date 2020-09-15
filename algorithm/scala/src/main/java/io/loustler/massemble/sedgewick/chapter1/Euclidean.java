package io.loustler.massemble.sedgewick.chapter1;

public class Euclidean {
  public static int gcb(int x, int y) {
    if (y == 0) return x;

    int r = y % x;

    return gcb(y, r);
  }
}
