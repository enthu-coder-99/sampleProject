package DP.LIS;

public class Number_of_Longest_Increasing_Subsequence_673 {

  public static void main(String[] args) {
    Number_of_Longest_Increasing_Subsequence_673 obj = new Number_of_Longest_Increasing_Subsequence_673();
    int[] nums = {1, 3, 5, 4, 7};
    System.out.println("Ans= " + obj.findNumberOfLIS(nums));
  }

  public int findNumberOfLIS(int[] nums) {

    int l = nums.length;
    int[][] dp = new int[l][2];// LIS length/size(0th element) , count(1st element)
    dp[l - 1] = new int[]{1, 1};

    for (int i = l - 2; i >= 0; i--) {
      int num_i = nums[i];
      System.out.println("\ni=== " + i + "- num_i= " + num_i);
      dp[i] = new int[]{1, 1};
      for (int j = i + 1; j <= l - 1; j++) {
        int num_j = nums[j];
        if (num_j > num_i) {
          int new_LIC_length = dp[j][0] + 1;
          int new_LIC_count = dp[j][1];

          int curr_LIC_length = dp[i][0];
          int curr_LIC_count = dp[i][1];

          if (new_LIC_length > curr_LIC_length) {
            dp[i][0] = new_LIC_length;
            dp[i][1] = new_LIC_count;

          } else if (new_LIC_length == curr_LIC_length) {
            dp[i][1] = dp[i][1] + new_LIC_count;
          }
        }
      }
    }

    int maxLICLength = 0;
    int maxLICCount = 0;
    for (int i = 0; i < l; i++) {
      int LIC_length = dp[i][0];
      int LIC_count = dp[i][1];
      if (LIC_length > maxLICLength) {
        maxLICLength = LIC_length;
        maxLICCount = LIC_count;
      } else if (LIC_length == maxLICLength) {
        maxLICCount += LIC_count;
      }
    }
    return maxLICCount;
  }
}
