package gfg;

import java.util.Arrays;

public class Cutting_a_Rod_GFG_DP_13 {

  public static void main(String[] args) {
    Cutting_a_Rod_GFG_DP_13 obj = new Cutting_a_Rod_GFG_DP_13();
    int n = 8;
    int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
    int ans = obj.cutRod(prices, n);
    System.out.println("Ans = " + ans);
  }

  public int cutRod(int price[], int n) {
    byDP(price, n);
    byRecursion(price, n, 0, 0);
    return ans;
  }

  int ans = 0;

  private void byRecursion(int[] prices, int n, int startIndex, int localCost) {
    int p_len = prices.length;
    if (n == 0) {
      ans = Math.max(ans, localCost);
      System.out.println("New ans=" + ans + ", localCost=" + localCost);
      return;
    }
    if (n < 0) return;
    System.out.println("n=" + n + ", localCost=" + localCost);

    for (int i = 0; i < p_len; i++) {
      int price = prices[i];
      byRecursion(prices, n - i - 1, i, localCost + price);
    }
    System.out.println("Loop ended....   n=" + n + ", startIndex=" + startIndex + " and ans=" + ans);
  }

  public int byDP(int prices[], int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = prices[0] * (i);
    }
    System.out.println(0 + " === " + Arrays.toString(dp));

    for (int i = 2; i <= n; i++) {
      int price_i = prices[i - 1];
      System.out.println("i=" + i + " and price_i=" + price_i + ", dp[i]=" + dp[i]);

      dp[i] = Math.max(dp[i], price_i);
      for (int j = i + 1; j <= n; j++) {
        System.out.println("j=" + j + " and (j-i)=" + (j - i) + "  and comparing= dp[j]= " + dp[j] + ", price_i + dp[j - i]" + (price_i + dp[j - i]));
        dp[j] = Math.max(dp[j], price_i + dp[j - i]);
      }
      System.out.println(i + " === " + Arrays.toString(dp));
    }
    System.out.println(Arrays.toString(dp));
    return dp[n];
  }
}
