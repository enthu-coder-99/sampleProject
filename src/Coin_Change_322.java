import utils.CommonLogging;

import java.util.Arrays;

public class Coin_Change_322 {

  public static void main(String[] args) {
    int[] coins = {5, 2, 1};
    int amount = 11;
    //System.err.println(coinChange(coins, amount));
    System.err.println(coinChange(coins, amount));

  }

  private static boolean coinChange(int[] coins, int amount) {

    return false;
  }

  public static int coinChange_sol2(int[] coins, int amount) {
    if (amount == 0)
      return 0;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    amount:
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
          int currentCombination = 1 + dp[remainAmount];
          dp[amount_i] = Math.min(currentCombination, dp[amount_i]);
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
