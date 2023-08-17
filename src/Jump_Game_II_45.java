import java.util.Arrays;

public class Jump_Game_II_45 {

  public static void main(String[] args) {
    //System.err.println(jump_sol1(new int[]{2, 3, 1, 1, 4}));
    System.err.println(sol1_dp(new int[]{2, 3, 0, 1, 4}));

  }

  public static int jump_sol2(int[] nums) {
    int l = nums.length;
    int jump = 0;
    int maxJump = 0;
    int nextMaxJumpIndex = 0;

    for (int i = 0; i < l - 1; i++) {
      int num = nums[i];
      nextMaxJumpIndex = Math.max(nextMaxJumpIndex, i + num);
      if (maxJump == i) {
        maxJump = nextMaxJumpIndex;
        jump++;
      }
      if (maxJump <= i) return -1;
    }
    return jump;
  }

  public static int sol1_dp(int[] nums) {
    int destinationIndex = nums.length - 1;
    int[] dp = new int[nums.length];
    for (int i = nums.length - 2; i >= 0; i--) {
      int currentNum = nums[i];
      System.err.println(i + " and currentNum=" + currentNum);
      int maxIndexReachFromThisIndex = currentNum + i;
      if (currentNum != 0) {
        dp[i] = dp[i + 1] + 1;
        if (maxIndexReachFromThisIndex >= destinationIndex) {
          System.err.println("Setting #1");
          dp[i] = 1;
        } else {
          for (int j = i + 2; (j <= destinationIndex - 1) && j <= maxIndexReachFromThisIndex; j++) {
            if (dp[j] != 0)
              dp[i] = Math.min(dp[i], dp[j] + 1);
          }
        }
      }
      System.err.println(Arrays.toString(dp));
    }
    return dp[0];
  }
}
