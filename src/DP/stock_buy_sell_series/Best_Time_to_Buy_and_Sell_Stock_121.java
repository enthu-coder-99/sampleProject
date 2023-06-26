package DP.stock_buy_sell_series;

public class Best_Time_to_Buy_and_Sell_Stock_121 {

  public static void main(String[] args) {

  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      int todayPrice = prices[i];
      int todayProfit = todayPrice - minPrice;
      maxProfit = Math.max(todayProfit, maxProfit);
      minPrice = Math.min(minPrice, todayPrice);
    }
    return maxProfit;
  }
}
