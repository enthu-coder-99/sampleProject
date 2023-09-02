package interval_merging;

import java.util.Arrays;

public class Minimum_Number_of_Taps_to_Open_to_Water_a_Garden_1326 {

  public int minTaps(int n, int[] ranges) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n + 2);

    for (int i = 0; i < ranges.length; i++) {
      int range = ranges[i];
      if (range == 0) continue;
      int start = Math.max(0, i - range);
      int end = Math.min(n, i + range);
      for (int j = start; j <= end; j++) {
        dp[j] = Math.min(dp[j], dp[start] + 1);
      }
    }
    for (int i = 0; i <= n; i++) {

      if (dp[i] == n + 2)
        return -1;
    }
    return dp[n];

  }
}
