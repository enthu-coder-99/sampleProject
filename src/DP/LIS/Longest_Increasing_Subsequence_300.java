package DP.LIS;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_300 {

  public static void main(String[] args) {
    System.err.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}) + ";;");
  }

  public static int lengthOfLIS(int[] nums) {
    int lengthOfLIS = 1;
    int length = nums.length;
    int[] memoDP = new int[length];
    Arrays.fill(memoDP, 1);
    for (int i = length - 2; i >= 0; i--) {
      int num = nums[i];
      for (int j = i + 1; j < length; j++) {
        int rightSideNumSeqCount = nums[j];
        if (rightSideNumSeqCount >= num) {
          memoDP[i] = Math.max(memoDP[i], memoDP[j] + 1);
        }
      }
      lengthOfLIS = Math.max(lengthOfLIS, memoDP[i]);
    }
    Arrays.stream(memoDP).forEach(value -> System.err.println(value));
    return lengthOfLIS;
  }

}
