package DP;

import java.util.Arrays;
import java.util.Comparator;

public class Russian_Doll_Envelopes_354 {

  public static void main(String[] args) {
    int[][] envelops = new int[][]{{15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7}, {11, 19}, {8, 11}, {13, 11},
      {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {16, 1}, {18, 13}, {14, 17}, {18, 19}};
    System.out.println("Ans= " + maxEnvelopes(envelops));
  }

  public static int maxEnvelopes(int[][] envelopes) {
    // sort on increasing in first dimension and decreasing in second
    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] arr1, int[] arr2) {
        return arr1[1] * arr1[0] - arr2[1] * arr2[0];
      }
    });
    int ans = 1;
    for (int[] env : envelopes)
      System.out.println(Arrays.toString(env));

    // extract the second dimension and run LIS
    int[] dp = new int[envelopes.length];
    for (int i = envelopes.length - 1; i >= 0; i--) {
      dp[i] = 1;
      int[] env_i = envelopes[i];

      for (int j = i + 1; j < envelopes.length; j++) {
        int[] env_j = envelopes[j];
        if (env_j[0] > env_i[0] && env_j[1] > env_i[1])
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
      ans = Math.max(dp[i], ans);
    }
    System.out.println(Arrays.toString(dp));
    return ans;
  }
}
