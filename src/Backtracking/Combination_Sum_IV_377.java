package Backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Combination_Sum_IV_377 {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    int target = 4;
    System.err.println(combinationSum4(nums, target));
  }

  public static int combinationSum4(int[] nums, int target) {
    Map<Integer, Integer> memo = new HashMap<>();
    int ans = dp_bottom_up(nums, target);
    System.out.println("ans=" + ans);
    return ans;
  }

  public static int dp_bottom_up(int[] nums, int target) {
    int[] dp = new int[target + 1];

    for (int combSum = 1; combSum < target + 1; ++combSum) {// This should be in OUTER loop only.
      System.out.println("\n------ combSum= " + combSum);
      for (int num : nums) {// This should be in INNER loop only.
        System.out.print("num= " + num);
        if (num > combSum) continue;
        if (num == combSum) {
          dp[num]++;
        } else {
          dp[combSum] += dp[combSum - num];
        }
        System.out.print(", dp[combSum]= " + dp[combSum]);
        System.out.println("\n" + Arrays.toString(dp));
      }
    }
    return dp[target];
  }

  public static int calcCounter(int[] nums, int target, Map<Integer, Integer> memo) {
    int l = nums.length;

    if (target == 0)
      return 1;
    if (target < 0) return 0;
    int count = 0;

    for (int i = 0; i < l; i++) {
      int num = nums[i];
      int nextTarget = target - num;
      count = count + calcCounter(nums, nextTarget, memo);
      System.err.println("nextTarget=" + nextTarget + " count=" + count);
    }
    System.err.println("target=" + target + ", count=" + count);

    return count;
  }
}


