package io.loustler.massemble.codility;

public class FrogJmp {
  public static void main(String[] args) {
    System.out.println(solve(10, 85, 30)); // 3
    System.out.println(solve(10, 10, 30)); // 0
  }

  public static int solve(int X, int Y, int D) {
    int distance = Y - X;

    if (distance == 0) return 0;

    int jumps = distance / D;
    int rest = distance % D;

    return (rest > 0) ? jumps + 1 : jumps;
  }
}
