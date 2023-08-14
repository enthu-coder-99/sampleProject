package DP.stock_buy_sell_series;

public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714 {

  //0- CAN BUY       1- CAN SELL
  public int maxProfit(int[] prices, int fee) {
    int l = prices.length;
    int[][] dp = new int[l][2];
    dp[0][0] = -prices[0];

    for (int i = 1; i < l; i++) {
      int price = prices[i];
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - price);//BUY
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + price - fee);//SELL

    }
    return dp[l - 1][1];
  }
}
