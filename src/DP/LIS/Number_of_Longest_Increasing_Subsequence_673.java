package DP.LIS;

import java.util.Arrays;

public class Number_of_Longest_Increasing_Subsequence_673 {

  public static void main(String[] args) {
    Number_of_Longest_Increasing_Subsequence_673 obj = new Number_of_Longest_Increasing_Subsequence_673();
    int[] nums = {1, 3, 5, 4, 7};
    System.out.println("Ans= " + obj.findNumberOfLIS(nums));
  }

  public int findNumberOfLIS(int[] nums) {

    int l = nums.length;
    int[] dp = new int[l];
    dp[l - 1] = 1;
    int maxLICLength = 1;
    int maxLICCount = 1;

    for (int i = l - 2; i >= 0; i--) {
      int num_i = nums[i];
      dp[i] = 1;
      System.out.println("\ni=== " + i + "- num_i= " + num_i + ", maxLICLength=" + maxLICLength + ", maxLICCount=" + maxLICCount + ", dp=" + Arrays.toString(dp));

      for (int j = i + 1; j <= l - 1; j++) {
        int num_j = nums[j];
        if (num_j > num_i) {
          int new_LIC_length = dp[j] + 1;
          dp[i] = Math.max(dp[i], new_LIC_length);
          System.out.println(j + "- num_j= " + num_j + ", new_LIC_length=" + new_LIC_length + ", maxLICLength="
            + maxLICLength + ", maxLICCount=" + maxLICCount);

          if (new_LIC_length > maxLICLength) {
            maxLICLength = new_LIC_length;
            maxLICCount = 1;
          } else if (new_LIC_length == maxLICLength) {
            maxLICCount++;
          }
        }
      }
    }
    return maxLICCount;
  }
}
