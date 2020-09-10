package io.loustler.massemble.leetcode;

// https://leetcode.com/problems/arranging-coins/
public class ArrangingCoins {
  public static void main(String[] args) {
    System.out.println(solve(5)); // 2
    System.out.println(solve(8)); // 3
  }

  /**
   * 코인의 개수로 나열을 해서 규칙을 살펴보면,
   * 1 2 3 4 5 6 , .... , k
   * row k까지 생길 수 있음
   * 즉 row k까지 가기 위해서는 본인 row를 포함하여 이전의 모든 row들의 합을 만족하여야만 된다는 것
   * 누적합들을 이용하여 k를 구할 수 있음
   *
   * @param n coins
   * @return
   */
  public static int solve(int n) {
    /**
     * 1
     * 1 1
     * 1 1 1
     * 1 1 1 1
     * 1 1 1 1 1     여기가 최대수 k
     * 1 1 1         x 해당 안됨
     *
     * row 1: 1
     * row 2: 3
     * row 3: 6
     * row 4: 10
     *
     * k(k + 1) / 2는 n까지 숫자의 합
     * 공식을 도출하면
     * k(k + 1) / 2 = N
     * k^2 + k / 2 = N
     * k^2 + k = 2N
     * k^2 + k + 1/4 = 2N + 1/4
     * (k + 1/2)^2 = 2N + 1/4
     * k + 1/2 = root(2N + 1/4)
     * k = root(2N + 1/4) - 1/2
     */
    // long casting for integer overflow
    return (int)(Math.sqrt((2 * (long)n) + 0.25d) - 0.5d);
  }
}
