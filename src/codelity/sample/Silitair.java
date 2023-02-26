package codelity.sample;

import utils.CommonLogging;

public class Silitair {

  public static void main(String[] args) {
    System.err.println(solution(new int[]{1, -2, 0, 9, -1, -2}));
  }

  public static int solution(int[] A) {
    int[] dp = new int[A.length];
    dp[0] = A[0];
    for (int i = 1; i < A.length; i++) dp[i] = Integer.MIN_VALUE;

    for (int i = 0; i < A.length; i++) {
      for (int k = 1; k <= 6 && i + k < A.length; k++) {
        System.err.println("i=" + i + " :k=" + k + " :(i+k)=" + (i + k));
        System.err.println((i + k) + "- dp[i + k]:" + dp[i + k] + " : " + (dp[i] + A[i + k]));
        dp[i + k] = Math.max(dp[i + k], dp[i] + A[i + k]);
      }
    }

    return dp[A.length - 1];
  }
}
