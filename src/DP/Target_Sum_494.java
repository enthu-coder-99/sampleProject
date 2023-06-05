package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Target_Sum_494 {

  public static void main(String[] args) {
    int[] nums = null;
    nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
    int target = 1;
    int l = nums.length;

    System.out.println("\nfindTargetSumWays_lc= " + findTargetSumWays_lc(nums, target));
    System.out.println("\nfindTargetSumWays_dp_map = " + findTargetSumWays_dp_map(nums, target));
    int numsSum = getSum(nums);
    int[][] memo = new int[l][numsSum * 2 + 1];
    for (int i = 0; i < memo.length; i++)
      Arrays.fill(memo[i], Integer.MAX_VALUE);
    System.out.println("\nfindTargetSumWays_dp_map = " + findTargetSumWays_recursion(nums, 0, 0, target, numsSum, memo));

  }


  public static int findTargetSumWays_recursion(int[] nums, int newIndex, int localSum, int targetSum, int numsSum, int[][] memo) {
    int l = nums.length;

    if (newIndex == l) {
      if (localSum == targetSum) return 1;
      return 0;
    }
    if (memo[newIndex][numsSum + localSum] != Integer.MAX_VALUE) return memo[newIndex][numsSum + localSum];
    int num = nums[newIndex];
    int newPlusSum = localSum + num;
    int newNegativeSum = localSum - num;
    int count1 = findTargetSumWays_recursion(nums, newIndex + 1, newPlusSum, targetSum, numsSum, memo);
    int count2 = findTargetSumWays_recursion(nums, newIndex + 1, newNegativeSum, targetSum, numsSum, memo);
    memo[newIndex][localSum + numsSum] = count1 + count2;// From this newIndex and with this "localSum" how many ways are there we can reach to targetSum.
    return memo[newIndex][localSum + numsSum];
  }

  /**
   * Not working for  {0, 0, 0, 0, 0, 0, 0, 0, 1} and "1"
   */
  public static int findTargetSumWays_dp_map(int[] nums, int target) {
    int l = nums.length;
    int sum = getSum(nums);
    if (Math.abs(target) > sum) return 0;
    HashMap<Integer, Integer>[] dp = new HashMap[l];// We are using Map so that we can use for negative sum value also as Array can not handle negative sum value as their Index.
    for (int i = 0; i < dp.length; i++) {
      dp[i] = new HashMap<>();
    }
    dp[0].put(nums[0], 1);// Because
    dp[0].put(nums[0] * -1, 1 + dp[0].getOrDefault(nums[0] * -1, 0));// Because

    for (int i = 1; i < l; i++) {
      int num = nums[i];

      Set<Map.Entry<Integer, Integer>> all_sums_with_previous_nums_set = dp[i - 1].entrySet();
      for (Map.Entry<Integer, Integer> sum_with_previous_num : all_sums_with_previous_nums_set) {
        int previous_num_sum = sum_with_previous_num.getKey();
        int previous_num_sum_count = sum_with_previous_num.getValue();
        dp[i].put(previous_num_sum + num, previous_num_sum_count + dp[i].getOrDefault(previous_num_sum + num, 0));
        dp[i].put(previous_num_sum - num, previous_num_sum_count + +dp[i].getOrDefault(previous_num_sum - num, 0));
      }
    }
    System.out.println(Arrays.toString(dp));
    return dp[l - 1].get(target);
  }


  public static int findTargetSumWays_lc(int[] nums, int S) {
    int total = Arrays.stream(nums).sum();
    int[][] dp = new int[nums.length][2 * total + 1];
    dp[0][nums[0] + total] = 1;
    dp[0][-nums[0] + total] += 1;

    for (int i = 1; i < nums.length; i++) {
      for (int sum = -total; sum <= total; sum++) {
        if (dp[i - 1][sum + total] > 0) {
          dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
          dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
        }
      }
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print("i=" + i + ", j=" + j + " dp=" + dp[i][j] + "# ");
      }
    }
    return Math.abs(S) > total ? 0 : dp[nums.length - 1][S + total];
  }

  /**
   * This logic is same in Leetcode# 416.
   * /**
   * s1 + s2 = sum
   * s1 - s2 = target
   * s1 = (target + sum)/2
   */

  public static int findTargetSumWays_subArraySum(int[] nums, int target) {
    int sum = getSum(nums);
    int newTargetSum = (sum + target) / 2;// New target sum of subset of nums.
    if ((target + sum) % 2 != 0 || sum < target) return 0;
    int ans = calculateSubSetSum(nums, newTargetSum);
    return ans;
  }

  public static int calculateSubSetSum(int[] nums, int newTargetSum) {
    System.out.println("calculateSubSetSum - target sum= " + newTargetSum + ", nums=" + Arrays.toString(nums));
    int[] dp = new int[newTargetSum + 1];
    dp[0] = 1;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      for (int j = newTargetSum; j >= num; j--) {
        dp[j] += dp[j - num];
      }
    }
    System.out.println("calculateSubSetSum = " + Arrays.toString(dp));
    return dp[newTargetSum];
  }

  public static int getSum(int[] nums) {
    int sum = 0;
    for (int num : nums)
      sum = sum + num;
    return sum;
  }
}
