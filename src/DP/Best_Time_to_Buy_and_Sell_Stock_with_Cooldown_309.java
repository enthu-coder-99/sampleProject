package DP;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {

  public static void main(String[] args) {

  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int buyPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      int todayPrice = prices[i];
      int yesterdayPrice = prices[i - 1];
      int tomorrowPrice = prices[i + 1];
    }
    return maxProfit;
  }
}
