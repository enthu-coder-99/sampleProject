package Backtracking;

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
    calcCounter(nums, target, memo);
    System.err.println("memo=" + memo);
    return -1;
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
