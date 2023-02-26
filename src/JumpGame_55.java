public class JumpGame_55 {

  public static void main(String[] args) {
    System.err.println(canJump(new int[]{2, 3, 1, 1, 4}));
    System.err.println(canJump(new int[]{3, 2, 1, 0, 4}));
  }

  public static boolean canJump(int[] nums) {
    if (nums.length == 1) {
      return true;
    }
    int maxJump = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (i > maxJump) return false;
      maxJump = Math.max(maxJump, (i + nums[i]));
      if (maxJump >= nums.length - 1)
        return true;
    }
    return false;
  }

  public static boolean solution2(int[] nums) {
    if (nums.length == 1) {
      return true;
    }

    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] == 0) {
        // We need to find a index which can make it cross.
        int i1 = canCrossTheZeroValue(i, nums);
        if (i1 < 0)
          return false;
      }
    }
    return true;
  }

  private static int canCrossTheZeroValue(int indexWithZeroValue, int[] nums) {
    for (int i = indexWithZeroValue - 1; i >= 0; i--) {
      int currentNum = nums[i];
      if (currentNum + i > indexWithZeroValue) {
        return i;
      }
    }
    return -1;
  }

  //DP- Dymanic programming
  public static boolean canJump_sol1(int[] nums) {
    if (nums.length == 1) {
      return true;
    }
    boolean[] dp = new boolean[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      dp[i] = canJumpFromHere(i, nums, dp);
    }
    return dp[0];
  }

  private static boolean canJumpFromHere(int currentIndex, int[] nums, boolean[] dp) {
    int lastIndexValue = nums.length - 1;
    int currentNum = nums[currentIndex];
    int maxJumpIndex = currentIndex + currentNum;
    if (maxJumpIndex >= lastIndexValue) {
      //If we can directly jump from this index to last...
      return true;
    } else {
      for (int i = currentIndex; i <= maxJumpIndex; i++) {
        if (dp[i] == true) {
          return true;
        }
      }
    }
    return false;
  }
}
