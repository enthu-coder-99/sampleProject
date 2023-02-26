package DP;

public class Number_of_Longest_Increasing_Subsequence_673 {
  public static void main(String[] args) {
    int[] arrys = {1, 2, 0};
    int sum = 0;
    int counting = 0;
    for (int i = 0; i < arrys.length; i++) {
      int currrentNum = arrys[i];
      sum = sum + currrentNum - counting++;
    }
    System.err.println("sum=" + sum);
  }

  public static void main1(String[] args) {
    System.err.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}) + ",,,,");
  }

  public static int findNumberOfLIS(int[] nums) {
    int lengthOfLIS = 1;
    int length = nums.length;
    int[] memoDP = new int[length];
    memoDP[length - 1] = 1;
    for (int i = length - 2; i >= 0; i--) {
      int currentElement = nums[i];
      memoDP[i] = memoDP[i] == 0 ? 1 : memoDP[i];
      System.err.println("currentElement=" + currentElement);
      for (int j = i + 1; j < length; j++) {
        int rightSideElement = nums[j];
        if (rightSideElement > currentElement) {
          System.err.println("memoDP[j] + 1= " + (memoDP[j] + 1));
          if (memoDP[j] + 1 > memoDP[i]) {
            System.err.println(", rightSideElement= " + rightSideElement + " : " + memoDP[j]);
            memoDP[i] = memoDP[j] + 1;
          }
        }
        lengthOfLIS = Math.max(lengthOfLIS, memoDP[i]);
      }
    }
    int result = 0;
    for (int i : memoDP) {
      if (i == lengthOfLIS)
        result++;
    }
    return result;
  }
}
