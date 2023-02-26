package DP;

import java.util.Arrays;

public class Maximum_Length_of_Pair_Chain_646 {
  public static void main(String[] args) {
    int[][] pairs = {{4, 5}, {1, 2}, {2, 3}, {3, 4}};
    System.err.println(findLongestChain(pairs));
  }

  public static int findLongestChain(int[][] pairs) {
    return solution_1_with_DP(pairs);
  }

  public static int solution_2_with_greedy(int[][] pairs) {
    Arrays.sort(pairs, (p1, p2) -> (p1[1] - p2[1]) != 0 ? (p1[1] - p2[1]) : (p1[0] - p2[0]));
    int len = pairs.length;
    int count = 1;
    int[] previousPair = pairs[0];
    for (int i = 1; i < len; i++) {
      int[] currentPair = pairs[i];
      int currentLeft = currentPair[0];
      if (previousPair[1] < currentLeft) {
        count++;
        previousPair = currentPair;
      }
    }
    return count;
  }

  public static int solution_1_with_DP(int[][] pairs) {
    Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
    int len = pairs.length;
    int[] dp = new int[len];
    dp[len - 1] = 1;
    for (int i = len - 2; i >= 0; i--) {
      int[] pair = pairs[i];
      int left = pair[0];
      int right = pair[1];
      for (int j = i + 1; j < len; j++) {
        if (right < pairs[j][0]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          break;
        } else {
          dp[i] = Math.max(dp[i], dp[j]);
        }
      }
    }
    return dp[0];
  }
}
