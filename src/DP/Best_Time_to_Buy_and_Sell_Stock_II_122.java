package DP;

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {

  public static void main(String[] args) {
    int[] arry = new int[]{5, 18, 6, 5, 4, 7, 13, 21};
    System.err.println(maxProfit(arry));
  }

  public static int maxProfit(int[] A) {
    if (A.length < 2) return 0;
    return dfs(A);
  }

  public static int dfs(int[] prices) {
    int[][] dp = new int[prices.length][2];//0- Buy, 1- Sold
    dp[0][0] = -prices[0];
    dp[0][1] = 0;
    for (int i = 1; i < prices.length; i++) {
      int todayPrice = prices[i];
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - todayPrice);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + todayPrice);
    }
    System.err.println(dp);
    return dp[prices.length-1][1];
  }

  public static int maxProfit_my(int[] prices) {
    if (prices == null || prices.length < 2)
      return 0;
    int maxProfit = 0;
    int minPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      int yesterdayPrice = prices[i - 1];
      int todayPrice = prices[i];

      if (yesterdayPrice > todayPrice) {
        int yesterdayProfit = yesterdayPrice - minPrice;
        maxProfit = maxProfit + yesterdayProfit;
        minPrice = todayPrice;
      } else {
        minPrice = Math.min(minPrice, todayPrice);
      }
      if (i == prices.length - 1 && todayPrice > minPrice)
        maxProfit = maxProfit + (todayPrice - minPrice);
    }
    return maxProfit;
  }
}
