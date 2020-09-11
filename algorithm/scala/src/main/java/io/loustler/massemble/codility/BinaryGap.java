package io.loustler.massemble.codility;

// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
public class BinaryGap {
  public static void main(String[] args) {
    System.out.println(solve(1041)); //
    System.out.println(solve(15)); //
    System.out.println(solve(32)); //
    System.out.println(solve(1)); //
    System.out.println(solve(5)); //
    System.out.println(solve(6)); //
    System.out.println(solve(9)); //
  }

  public static int solve(int N) {
    String s = Integer.toBinaryString(N);

    int ans = 0, start = 0;

    // 2 pointer
    for (int i = 0; i < s.length(); i++) {
      int count = 0;

      while (s.charAt(i) == '1' && start < i) {
        if (s.charAt(start++) == '0') {
          count++;
          ans = Math.max(ans, count);
        }
      }

      if (s.charAt(i) == '1') start = i;
    }

    return ans;
  }
}
