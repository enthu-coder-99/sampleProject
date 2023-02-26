package DP;

public class Valid_Partition_For_The_Array_2369 {

  public static void main(String[] args) {
    System.err.println(validPartition(new int[]{1, 2}));
    // System.err.println(validPartition(new int[]{4, 4, 4, 5, 6}));
    //System.err.println(validPartition(new int[]{1, 1, 1, 2}));
  }

  public static boolean validPartition(int[] nums) {
    if (nums == null || nums.length < 2)
      return false;

    boolean[] dp = new boolean[nums.length];
    dp[0] = false;
    dp[1] = nums[0] == nums[1];
    if (nums.length == 2)
      return dp[1];

    dp[2] = isValidThree(nums, 2);
    for (int i = 3; i < nums.length; i++) {
      dp[i] = ((dp[i - 2] && nums[i] == nums[i - 1]) || (dp[i - 3] && isValidThree(nums, i)));
    }
    return dp[nums.length - 1];
  }

  private static boolean isValidThree(int[] nums, int index) {

    return ((nums[index] == nums[index - 1] && nums[index - 1] == nums[index - 2]) ||
      ((nums[index] - nums[index - 1] == 1) && (nums[index - 1] - nums[index - 2] == 1)));

  }
}
