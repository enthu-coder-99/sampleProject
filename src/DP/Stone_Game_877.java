package DP;

import utils.CommonLogging;

import java.util.Arrays;

public class Stone_Game_877 {

  public static void main(String[] args) {

    int[] piles = {1, 3, 1};
    int[] maxStonesByAlice = new int[0];
    int left = 0;
    int right = piles.length - 1;
    boolean b = false;
    //b = stoneGame(piles);
    System.err.println(b);
    b = stoneGame_mySol(piles);
    System.err.println(b);

  }

  /**
   * i+2,j // (i+1)(j-1)              (i+1)(j-1)/i,j-2
   * (i+1),j                            i,j-1
   * i--------------------------------j
   *
   * @param nums
   * @return
   */
  public static boolean stoneGame_mySol(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][n];
    int sum = Arrays.stream(nums).sum();
    for (int gap = 0; gap < n; gap++) {
      for (int i = 0, j = gap; j < n; i++, j++) {
        System.err.println("i=" + i + ",j=" + j + ", gap= " + gap + " | " + dp[i][j]);
        if (i == j) {
          dp[i][j] = nums[i];
        } else if (gap == 1) {
          dp[i][j] = Math.max(nums[i], nums[j]);
        } else {
          dp[i][j] = Math.max(nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]), nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
        }
      }
    }
    CommonLogging.printArray(dp);
    System.err.println("sum=" + sum);
    return (dp[0][n - 1]) * 2 >= (sum);
  }

  public static boolean stoneGame(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = nums[i];
    }
    for (int len = 1; len < n; len++) {
      for (int i = 0; i < n - len; i++) {
        int j = i + len;
        dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
      }
    }
    CommonLogging.printArray(dp);
    return dp[0][n - 1] >= 0;
  }
}
