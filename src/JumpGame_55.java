public class JumpGame_55 {

  public static void main(String[] args) {
    System.err.println(canJump(new int[]{2, 3, 1, 1, 4}));
    System.err.println(canJump(new int[]{3, 2, 1, 0, 4}));
  }

  public static boolean canJump(int[] nums) {
    return sol_with_one_variable(nums);
  }

  public static boolean sol_with_two_variables(int[] nums) {
    int l = nums.length;
    if (l == 1) {
      return true;
    }
    int maxJump = nums[0];
    int nextMaxJump = nums[0];// After we reached to maxJump, we will choose nextMaxJump.

    for (int index = 1; index < l; index++) {
      int num = nums[index];
      if (maxJump == index) {
        maxJump = nextMaxJump;
      }
      nextMaxJump = Math.max(nextMaxJump, index + num);
      if (nextMaxJump >= l - 1) return true;
      if (nextMaxJump <= index) return false;
    }
    return false;
  }


  public static boolean sol_with_one_variable(int[] nums) {
    int l = nums.length;
    if (l == 1) {
      return true;
    }
    int maxJump = -1;
    for (int index = 0; index < nums.length; index++) {
      int num = nums[index];
      maxJump = Math.max(maxJump, index + num);
      if (maxJump >= l - 1) return true;
      if (maxJump <= index) return false;
    }
    return false;
  }

  public static boolean solution_justCheckIfWeCanCrossZero(int[] nums) {
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
