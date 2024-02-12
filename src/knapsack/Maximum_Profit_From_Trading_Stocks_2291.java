package knapsack;

import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Profit_From_Trading_Stocks_2291 {

  public static void main(String[] args) {
    int[] present = {2, 2, 5};
    int[] future = {3, 4, 10};
    int budget = 6;
    Maximum_Profit_From_Trading_Stocks_2291 obj = new Maximum_Profit_From_Trading_Stocks_2291();
    var ans = obj.maximumProfit(present, future, budget);
    System.out.println("ans= " + ans);
  }

  public int maximumProfit(int[] present, int[] future, int budget) {
    int l = present.length;
    int[][] prices = new int[l][2];
    for (int i = 0; i < l; i++) {
      int todayPrice = present[i];
      int futurePrice = future[i];
      prices[i][0] = todayPrice;
      prices[i][1] = futurePrice;
    }

    Arrays.sort(prices, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int[] dp = new int[budget + 1];

    for (int i = 0; i < l; i++) {
      int todayPrice = prices[i][0];
      int futurePrice = prices[i][1];
      int profit = futurePrice - todayPrice;
      System.out.println(i + "- todayPrice=" + todayPrice + ", futurePrice=" + futurePrice + ", profit=" + profit);
      if (profit < 0 || todayPrice > budget) continue;
      for (int j = budget; j >= todayPrice; j--) {
        dp[j] = Math.max(dp[j], profit + dp[j - todayPrice]);
      }
      System.out.println(Arrays.toString(dp));

    }
    System.out.println("Final= " + Arrays.toString(dp));
    return dp[budget];
  }
}
