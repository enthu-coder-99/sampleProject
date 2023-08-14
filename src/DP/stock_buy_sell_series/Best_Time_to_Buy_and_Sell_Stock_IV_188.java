package DP.stock_buy_sell_series;

public class Best_Time_to_Buy_and_Sell_Stock_IV_188 {


  // 0 - BUY, 1 - SELL
  //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/1299248/very-easy-memoization-recursive-java-solution
  //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/2555606/Daily-LeetCoding-Challenge-September-Day-10
  //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54125/Very-understandable-solution-by-reusing-Problem-III-idea
  int BUY = 0;
  int SELL = 1;

  public int maxProfit(int k, int[] prices) {
    return sol1_recursion(k, prices);
  }


  public int sol2_iterative_dp(int k, int[] prices) {
    int l = prices.length;
    int[][][] memo = new int[l][k + 1][2];
    for (int j = 1; j <= k; j++) {
      memo[0][j][BUY] = -prices[0];
    }
    for (int i = 1; i < l; i++) {
      int price = prices[i];
      for (int j = 1; j <= k; j++) {
        memo[i][j][SELL] = Math.max(memo[i - 1][j][SELL], memo[i - 1][j][BUY] + price);
        memo[i][j][BUY] = Math.max(memo[i - 1][j][BUY], memo[i - 1][j - 1][SELL] - price);
      }
    }
    return memo[l - 1][k][SELL];
  }

  public int sol1_recursion(int k, int[] prices) {
    int l = prices.length;
    int[][][] memo = new int[l][k + 1][2];
    for (int i = 0; i < l; i++) {
      int price = prices[i];
      for (int j = 1; j <= k; j++) {
        memo[i][j][SELL] = Math.max(memo[i - 1][j][SELL], memo[i - 1][j][BUY] + price);
        memo[i][j][BUY] = Math.max(memo[i - 1][j][BUY], memo[i - 1][j][SELL] - price);
        ;
      }
    }
    return recursion(prices, 0, k, SELL, memo);
  }

  public int recursion(int[] prices, int startIndex, int k, int buy, int[][][] memo) {

    int l = prices.length;
    if (k <= 0 || startIndex >= l) return 0;
    if (memo[startIndex][k][buy] != -1) return memo[startIndex][k][buy];
    int price = prices[startIndex];
    int maxProfit = 0;
    if (buy == BUY) {
      int donotDoAnything = recursion(prices, startIndex + 1, k, buy, memo);
      int buy_profit = recursion(prices, startIndex + 1, k, SELL, memo) - price;
      maxProfit = Math.max(donotDoAnything, buy_profit);
    } else {
      int donotDoAnything = recursion(prices, startIndex + 1, k, buy, memo);
      int sell_profit = recursion(prices, startIndex + 1, k - 1, BUY, memo) + price;
      maxProfit = Math.max(donotDoAnything, sell_profit);
    }
    memo[startIndex][k][buy] = maxProfit;
    // System.out.println("startIndex="+startIndex+", k="+k+", maxProfit="+maxProfit);
    return maxProfit;
  }
}
