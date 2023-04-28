package DP;

import utils.CommonLogging;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Value_of_K_Coins_From_Piles_2218 {

  public static void main(String[] args) {
    int k = 3;
    List<List<Integer>> piles = new ArrayList<>();
    piles.add(List.of(155, 160));
    piles.add(List.of(165, 5));
    piles.add(List.of(175, 5));


     piles.add(List.of(170, 6));
     piles.add(List.of(120, 7));
     piles.add(List.of(130, 8));
     piles.add(List.of(120, 9, 10, 101));
     piles.add(List.of(190));
    System.err.println("Ans=" + maxValueOfCoins_my(piles, k));
  }

  private static int maxValueOfCoins_my(List<List<Integer>> piles, int k) {
    int l = piles.size();
    int[][] dp = new int[l + 1][k + 1];// pile_no, coin_count
    List<Integer> pile_0 = piles.get(0);
    int coinsSum = 0;
    for (int i = 1; i <= k; i++) {
      if (i <= pile_0.size())
        coinsSum += pile_0.get(i - 1);
      dp[1][i] = coinsSum;// coin and pile starts with 1.
    }

    for (int pile_no = 2; pile_no <= l; pile_no++) {
      optimizePile(piles, dp, k, pile_no);
      System.err.println("");
    }
    CommonLogging.print(dp);
    return dp[l][k];
  }

  public static void optimizePile(List<List<Integer>> piles, int[][] dp, int k, int pile_no) {
    System.err.println("optimizePile()- pile_no=" + pile_no);
    List<Integer> pile = piles.get(pile_no - 1);
    int l = pile.size();
    for (int i = 1; i <= k; i++) {
      /// i.e no coins from this pile.
      dp[pile_no][i] = dp[pile_no - 1][i];
    }


    for (int i = 1; i <= k; i++) {
      int total_no_of_coins = i;
      int sum_of_coins = 0;
      System.err.println("total_no_of_coins=" + total_no_of_coins);

      for (int j = 1; j <= Math.min(total_no_of_coins, pile.size()); j++) {
        sum_of_coins = sum_of_coins + pile.get(j - 1);

        int no_of_coins_from_this_pile = j;
        int no_of_coins_from_previous_pile = i - j;
        System.err.println("j/total_no_of_coins= " + j + "/" + total_no_of_coins + ", dp[" + pile_no + "][" + j + "] = " + dp[pile_no][j]
          + ", no_of_coins_from_this_pile=" + no_of_coins_from_this_pile + ", no_of_coins_from_previous_pile=" + no_of_coins_from_previous_pile + ", sum_of_coins=" + sum_of_coins);

        dp[pile_no][total_no_of_coins] = Math.max(dp[pile_no][total_no_of_coins],
          dp[pile_no - 1][no_of_coins_from_previous_pile] + sum_of_coins);// Set current dp[] value as from previous pile.
        System.err.println("Finally- dp[" + pile_no + "][" + j + "]= " + +dp[pile_no][j]);
      }
    }
  }

  private static int f(List<List<Integer>> piles, int i, int coins, int[][] dp) {
    System.err.println("i= " + i + ", coins=" + coins);
    if (i == 0) {
      return 0;
    }
    if (dp[i][coins] != -1) {
      return dp[i][coins];
    }
    int currentSum = 0;
    for (int currentCoins = 0; currentCoins <= Math.min(piles.get(i - 1).size(), coins); currentCoins++) {
      if (currentCoins > 0) {
        currentSum += piles.get(i - 1).get(currentCoins - 1);
      }
      dp[i][coins] = Math.max(dp[i][coins], f(piles, i - 1, coins - currentCoins, dp) + currentSum);
    }
    return dp[i][coins];
  }

  public static int maxValueOfCoins_2(List<List<Integer>> piles, int k) {
    int n = piles.size();
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 1; i <= n; i++) {
      for (int coins = 0; coins <= k; coins++) {
        dp[i][coins] = -1;
      }
    }
    int ans = f(piles, n, k, dp);
    CommonLogging.print(dp);
    return ans;
  }

  public static int maxValueOfCoins_1(List<List<Integer>> piles, int k) {
    int n = piles.size();
    int dp[][] = new int[n + 1][k + 1];
    for (int i = 1; i <= n; i++) {
      System.err.println("\n\nPile number=" + i);
      for (int coins = 1; coins <= k; coins++) {
        int currentSum = 0;
        System.err.println("\ni=" + i + ", coins=" + coins);

        for (int currentCoins = 0; currentCoins <= Math.min((int) piles.get(i - 1).size(), coins); currentCoins++) {
          if (currentCoins > 0) {
            currentSum += piles.get(i - 1).get(currentCoins - 1);
          }
          System.err.println("Comparing- " + "dp[" + i + "][" + coins + "]= " + dp[i][coins] + " AND dp[" + (i - 1) + "][" + (coins - currentCoins) + "] (" + dp[i - 1][coins - currentCoins] + ")"
            + " + " + currentSum);
          dp[i][coins] = Math.max(dp[i][coins], dp[i - 1][coins - currentCoins] + currentSum);
          System.err.println("Finally- i=" + i + ", coins=" + coins + ", currentCoins=" + currentCoins + ", currentSum=" + currentSum + ", dp[i][coins]=" + dp[i][coins]);
        }
      }
      CommonLogging.print(dp);
    }
    CommonLogging.print(dp);
    return dp[n][k];
  }
}
