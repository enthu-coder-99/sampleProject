package DP;

import java.util.Arrays;

public class Coin_Change_II_518 {

  public static void main(String[] args) {
    Coin_Change_II_518 obj = new Coin_Change_II_518();
    int[] coins = {1, 2, 5};
    int amount = 5;
    int ans = obj.change(amount, coins);
    System.out.println("Answer = " + ans);
  }

  public int change(int amount, int[] coins) {
    return coinChange_2D_Dim_dp_with_sort_coins(coins, amount);
  }

  public int coinChange_1D_Dim_dp_with_sort_coins2(int[] coins, int amount) {
    int coin_cnt = coins.length;
    if (amount == 0 || coin_cnt == 0) return 0;
    Arrays.sort(coins);
    if (coins[0] > amount) return 0;
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin_indx = 0; coin_indx < coin_cnt; coin_indx++) {
      int coin_amt = coins[coin_indx];
      for (int tatal_amt = coin_amt; tatal_amt <= amount; tatal_amt++) {
        dp[tatal_amt] = dp[tatal_amt] + dp[tatal_amt - coin_amt];
      }
    }
    return dp[amount];
  }


  public int coinChange_2D_Dim_dp_with_sort_coins(int[] coins, int amount) {
    int coin_cnt = coins.length;
    if (amount == 0 || coin_cnt == 0) return 0;
    Arrays.sort(coins);
    if (coins[0] > amount) return 0;

    int[][] dp = new int[coin_cnt + 1][amount + 1];
    for (int coin_indx = 1; coin_indx <= coin_cnt; coin_indx++) {
      int coin_amt = coins[coin_indx - 1];
      if (coin_amt > amount) return dp[coin_indx - 1][amount];
      for (int amt = 1; amt <= amount; amt++) {
        dp[coin_indx][amt] = dp[coin_indx - 1][amt];
      }
      dp[coin_indx][coin_amt]++;// Increment coin_amt by one.
      for (int curr_amt = coin_amt + 1; curr_amt <= amount; curr_amt++) {//amount x l
        int residual_amt = curr_amt - coin_amt;
        dp[coin_indx][curr_amt] += dp[coin_indx][residual_amt];
      }
    }
    return dp[coin_cnt][amount];
  }
}
