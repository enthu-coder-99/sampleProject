package DP.stock_buy_sell_series;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {

  public static void main(String[] args) {

  }

  public static int maxProfit(int[] prices) {
    int l = prices.length;
    if (l < 2) return 0;
    int[][] dp = new int[l][2];
    dp[0][0] = -prices[0];
    dp[1][0] = Math.max(-prices[0], -prices[1]);
    dp[1][1] = Math.max(0, prices[1] - prices[0]);

    for (int i = 2; i < l; i++) {
      int price = prices[i];
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - price);//BUY
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + price);//SELL

    }
    return Math.max(dp[l - 1][1], dp[l - 1][0]);
  }
}
