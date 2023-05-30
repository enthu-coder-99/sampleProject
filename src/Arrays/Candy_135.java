package Arrays;

public class Candy_135 {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] dp = new int[n];
    dp[0] = 1;

    for (int i = 1; i < n; i++) {
      int rating_i = ratings[i];
      dp[i] = 1;
      if (rating_i > ratings[i - 1])
        dp[i] = dp[i - 1] + 1;
    }
    int ans = dp[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      int rating_i = ratings[i];
      if (rating_i > ratings[i + 1])
        dp[i] = Math.max(dp[i], dp[i + 1] + 1);
      ans = ans + dp[i];
    }
    return ans;
  }
}
