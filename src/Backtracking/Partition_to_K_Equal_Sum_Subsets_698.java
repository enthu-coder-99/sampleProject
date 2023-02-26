package Backtracking;

import utils.CommonLogging;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Partition_to_K_Equal_Sum_Subsets_698 {
  static HashMap<Integer, Boolean> memo = new HashMap<>();

  public static void main(String[] args) {
    //System.err.println(canPartitionKSubsets1(new int[]{6,4,5,4,1,1,10,1,7,6,4,2,10,1,3,5, 10}, 10));
    System.err.println(canPartitionKSubsets1(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
  }


  public static boolean canPartitionKSubsets1(int[] nums, int k) {

    int sum = 0;
    Integer[] numsArray = new Integer[nums.length];
    int i = 0;
    for (int num : nums) {
      numsArray[i++] = num;
      sum += num;
    }
    if (sum % k != 0)
      return false;
    Arrays.sort(numsArray, Collections.reverseOrder());
    return backtrack(numsArray, k, new boolean[nums.length], sum / k, 0, 0);
  }

  static boolean backtrack(Integer[] nums, int k, boolean[] seen, int targetSum, int idx, int subsetSum) {

    if (k == 0) {
      return true;
    }

    if (targetSum == subsetSum) {
      System.err.println("idx=" + idx);
      CommonLogging.printArray(seen);
      boolean res = backtrack(nums, k - 1, seen, targetSum, 0, 0);
      memo.put(idx, res);
      return res;
    }
    if (memo.containsKey(idx)) {
      System.err.println("map contains idx=" + idx);
      return memo.get(idx);
    }

    for (int i = idx; i < nums.length; i++) {
      if (seen[i] || subsetSum + nums[i] > targetSum)
        continue;
      seen[i] = true;
      if (backtrack(nums, k, seen, targetSum, i + 1, subsetSum + nums[i]))
        return true;
      seen[i] = false;
    }

    return false;
  }
}
