package DP;

import utils.CommonLogging;

import java.util.Arrays;

public class Coin_Change_322 {

  public static void main(String[] args) {
    Coin_Change_322 obj = new Coin_Change_322();

    int[] coins = {5, 2, 1};
    int amount = 11;
    System.err.println(obj.coinChange(coins, amount));

    coins = new int[]{1, 2, 5, 10};
    amount = 18;
    //System.err.println(coinChange(coins, amount));
    System.err.println(obj.coinChange(coins, amount));
  }

  private int coinChange(int[] coins, int amount) {
    int answer = coinChange_1D_Dim_dp_without_sort_coins(coins, amount);
    System.out.println("Anwer = " + answer);
    return answer;
  }

  public int coinChange_1D_Dim_dp_without_sort_coins(int[] coins, int amount) {
    if (amount == 0) return 0;
    int l = coins.length;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);

    for (int curr_amt = 1; curr_amt <= amount; curr_amt++) {//amount x l
      for (int coin_indx = 0; coin_indx < l; coin_indx++) {
        int coin_amt = coins[coin_indx];
        if (coin_amt == amount) return 1;
        if (coin_amt > curr_amt) continue;// coin_amt=15 , curr_amt=10
        if (coin_amt == curr_amt) {
          dp[coin_amt] = 1;
          continue;
        }
        int residual_amt = curr_amt - coin_amt;
        if (dp[residual_amt] > 0 && dp[residual_amt] != Integer.MAX_VALUE) {
          dp[curr_amt] = Math.min(dp[curr_amt], dp[residual_amt] + 1);
        }
      }
    }
    return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
  }

  public int coinChange_1D_Dim_dp_with_sort_coins(int[] coins, int amount) {
    if (amount == 0) return 0;
    int l = coins.length;
    int[] dp = new int[amount + 1];
    Arrays.sort(coins);// l(LOGl)
    int coin_0 = coins[0];
    if (coin_0 > amount) return -1;
    dp[coin_0] = 1;
    for (int curr_amt = coin_0 + 1; curr_amt <= amount; curr_amt++) {
      int residual_amt = curr_amt - coin_0;
      if (dp[residual_amt] != 0)
        dp[curr_amt] = dp[residual_amt] + 1;
    }

    for (int coin_indx = 1; coin_indx < l; coin_indx++) { //l x amount
      int coin_amt = coins[coin_indx];
      if (coin_amt == amount) return 1;
      if (coin_amt > amount) return (dp[amount] == 0) ? -1 : dp[amount];

      dp[coin_amt] = 1;
      System.out.println("coin_indx=" + coin_indx + ", coin_amt=" + coin_amt);
      for (int curr_amt = coin_amt + 1; curr_amt <= amount; curr_amt++) {
        int residual_amt = curr_amt - coin_amt;
        if (dp[residual_amt] != 0) {
          if (dp[curr_amt] == 0) {
            dp[curr_amt] = dp[residual_amt] + 1;
          } else {
            dp[curr_amt] = Math.min(dp[curr_amt], dp[residual_amt] + 1);
          }
        }
      }
    }
    return (dp[amount] == 0) ? -1 : dp[amount];
  }

  public int coinChange_2D_Dim_dp_with_sort_coins(int[] coins, int amount) {
    if (amount == 0) return 0;
    int l = coins.length;
    int[][] dp = new int[l + 1][amount + 1];
    Arrays.sort(coins);
    int coin_0 = coins[0];
    if (coin_0 > amount) return -1;

    dp[1][coin_0] = 1;
    for (int i = coin_0 + 1; i <= amount; i++) {
      if (dp[1][i - coin_0] != 0)
        dp[1][i] = dp[1][i - coin_0] + 1;
    }
    System.out.println(Arrays.toString(dp[1]));

    for (int coin_indx = 2; coin_indx <= coins.length; coin_indx++) {
      int coin = coins[coin_indx - 1];
      System.out.println("coin_indx= " + coin_indx + ", coin= " + coin);
      if (coin == amount) return 1;
      if (coin > amount) {
        return dp[coin_indx - 1][amount] == 0 ? -1 : dp[coin_indx - 1][amount];
      }

      int curr_amt = 1;
      for (; curr_amt < coin; curr_amt++) {
        dp[coin_indx][curr_amt] = dp[coin_indx - 1][curr_amt];
      }
      dp[coin_indx][coin] = 1;
      System.out.println("1- " + Arrays.toString(dp[coin_indx]));
      for (curr_amt = coin + 1; curr_amt <= amount; curr_amt++) {
        dp[coin_indx][curr_amt] = dp[coin_indx - 1][curr_amt];
        //System.out.println("1- coin= " + coin + ", " + Arrays.toString(dp[coin_indx]));

        if (dp[coin_indx][curr_amt - coin] > 0) {
          if (dp[coin_indx][curr_amt] == 0) {
            dp[coin_indx][curr_amt] = dp[coin_indx][curr_amt - coin] + 1;
          } else {
            dp[coin_indx][curr_amt] = Math.min(dp[coin_indx][curr_amt], dp[coin_indx][curr_amt - coin] + 1);
          }
        }
      }
      System.out.println("2- coin= " + coin + ", " + Arrays.toString(dp[coin_indx]));
    }
    return dp[l][amount] == 0 ? -1 : dp[l][amount];
  }

  public static int coinChange_sol2(int[] coins, int amount) {
    if (amount == 0)
      return 0;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    for (int j = 0; j < coins.length; j++) {
      int coinDenomination = coins[j];
      for (int amount_i = coinDenomination; amount_i <= amount; amount_i++) {
        System.err.println("amount_i=" + amount_i + ", coinDenomination=" + coinDenomination);
        int remainAmount = amount_i - coinDenomination;
        if (remainAmount == 0) {
          //Coin and donomination is same so just one coin.
          dp[amount_i] = 1;
          continue;
        } else {
          dp[amount_i] = Math.min(1 + dp[remainAmount], dp[amount_i]);
        }
      }
    }
    if (dp[amount] > amount)
      return -1;
    return dp[amount];
  }

  public static int coinChange_sol1(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] dp = new int[amount + 1];
    int sum = 0;

    while (++sum <= amount) {
      int min = -1;
      for (int coin : coins) {
        if (sum >= coin && dp[sum - coin] != -1) {
          int temp = dp[sum - coin] + 1;
          min = min < 0 ? temp : (temp < min ? temp : min);
        }
      }
      dp[sum] = min;
    }
    CommonLogging.printArray("CoinChange322", dp);
    return dp[amount];
  }
}
