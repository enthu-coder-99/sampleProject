package DP;

import java.util.Arrays;

public class Burst_Balloons_312 {

  public static void main(String[] args) {
    Burst_Balloons_312 obj = new Burst_Balloons_312();
    int[] nums = new int[]{3, 2, 5};
    int result = obj.maxCoins(nums);
    System.out.println("Result = " + result);
  }

  public int maxCoins(int[] nums) {
    // add 1 before and after nums
    int n = nums.length + 2;
    int[] newNums = new int[n];
    System.arraycopy(nums, 0, newNums, 1, n - 2);
    newNums[0] = 1;
    newNums[n - 1] = 1;

    // cache the results of dp
    int[][] memo = new int[n][n];

    // we can not burst the first one and the last one
    // since they are both fake balloons added by ourselves
    int finalAns = dp(memo, newNums, 1, n - 2);
    for (int i = 0; i < n; i++) {
      System.out.println(Arrays.toString(memo[i]));
    }
    return finalAns;
  }

  public int dp(int[][] memo, int[] nums, int left, int right) {
    // return maximum if we burst all nums[left]...nums[right], inclusive
    if (right - left < 0) {
      return 0;
    }

    // we've already seen this, return from cache
    if (memo[left][right] > 0) {
      return memo[left][right];
    }

    // find the last burst one in nums[left]...nums[right]
    int result = 0;
    for (int i = left; i <= right; i++) {
      // nums[i] is the last burst one
      int gain = nums[left - 1] * nums[i] * nums[right + 1];
      // nums[i] is fixed, recursively call left side and right side
      int remaining = dp(memo, nums, left, i - 1) + dp(memo, nums, i + 1, right);
      result = Math.max(result, remaining + gain);
    }
    // add to the cache
    memo[left][right] = result;
    return result;
  }


  public int maxCoins_myversion(int[] nums) {
    int l = nums.length;
    if (l == 1) return nums[0];

    int[][] dp = new int[l][l];
    int[] newNums = new int[l + 2];
    newNums[0] = 1;
    newNums[l - 1] = 1;

    for (int i = 0; i < l; i++) {
      int num = nums[i];
      dp[i][i] = num;
    }

    for (int i = 0; i < l - 1; i++) {
      int num_0 = nums[i];
      int num_1 = nums[i + 1];
      dp[i][i + 1] = (num_0 * num_1) + Math.max(num_0, num_1);
    }

    for (int i = 2; i < l; i++) {
      for (int j = 0; j < l; j++) {
        if (j + i >= l) break;
        int left = j;
        int right = j + i;
        calculateDP(left, right, dp, nums);
      }
    }
    for (int i = 0; i < l; i++) {
      System.out.println(Arrays.toString(dp[i]));
    }
    maxCoins_copied(nums);
    return dp[0][l - 1];
  }

  public int maxCoins_copied(int[] nums) {
    // add 1 before and after nums
    int n = nums.length + 2;
    int[] newNums = new int[n];
    System.arraycopy(nums, 0, newNums, 1, n - 2);
    newNums[0] = 1;
    newNums[n - 1] = 1;
    // dp[i][j] represents
    // maximum if we burst all nums[left]...nums[right], inclusive
    int[][] dp = new int[n][n];
    // do not include the first one and the last one
    // since they are both fake balloons added by ourselves and we can not burst
    // them
    for (int left = n - 2; left >= 1; left--) {
      for (int right = left; right <= n - 2; right++) {
        // find the last burst one in newNums[left]...newNums[right]
        for (int i = left; i <= right; i++) {
          // newNums[i] is the last burst one
          int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
          // recursively call left side and right side
          int remaining = dp[left][i - 1] + dp[i + 1][right];
          // update
          dp[left][right] = Math.max(remaining + gain, dp[left][right]);
        }
      }
    }
    // burst newNums[1]...newNums[n-2], excluding the first one and the last one
    for (int i = 0; i < dp.length; i++) {
      System.out.println(Arrays.toString(dp[i]) + "    - Copied");
    }
    return dp[1][n - 2];
  }


  private void calculateDP(int left, int right, int[][] dp, int[] nums) {
    dp[left][right] = Math.max(dp[left][right], nums[left] + dp[left + 1][right]);
    dp[left][right] = Math.max(dp[left][right], nums[right] + dp[left][right - 1]);

    for (int mid = left + 1; mid < right - 1; mid++) {// mid is the last balloon to bust
      int gain = nums[left - 1] * nums[mid] * nums[right + 1];
      int left_gain = dp[left][mid - 1];
      int right_gain = dp[mid + 1][right];
      int totalGain = gain + left_gain + right_gain;
      dp[left][right] = Math.max(dp[left][right], totalGain);

    }
  }
}
