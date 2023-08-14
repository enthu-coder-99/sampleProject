package DP.stock_buy_sell_series;

public class Best_Time_to_Buy_and_Sell_Stock_III_123 {

  public static int maxProfit(int[] prices) {
    int l = prices.length;
    if (l < 2) return 0;
    return 0;
  }

  public int sol_two_arrays(int[] prices) {
    int l = prices.length;
    int[] from_left_max_profit_sale_one_stock = new int[l + 1];
    int[] from_right_max_profit_sale_one_stock = new int[l + 1];
    int min_from_left = prices[0];
    for (int i = 1; i < l; i++) {
      int price = prices[i];
      from_left_max_profit_sale_one_stock[i] = Math.max(from_left_max_profit_sale_one_stock[i - 1], price - min_from_left);
      min_from_left = Math.min(min_from_left, price);
    }

    int max_from_right = prices[l - 1];
    for (int i = l - 2; i >= 0; i--) {
      int price = prices[i];
      from_right_max_profit_sale_one_stock[i] = Math.max(from_right_max_profit_sale_one_stock[i + 1], max_from_right - price);
      max_from_right = Math.max(max_from_right, price);
    }
    int total_max_profit = 0;
    for (int i = 0; i < l - 1; i++) {
      int profitFromLeft = from_left_max_profit_sale_one_stock[i];
      int profitFromRight = from_left_max_profit_sale_one_stock[i + 1];
      total_max_profit = Math.max(total_max_profit, profitFromLeft + profitFromRight);
    }
    return total_max_profit;
  }
}
