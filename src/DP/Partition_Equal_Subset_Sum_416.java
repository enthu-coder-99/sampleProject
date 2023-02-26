package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Partition_Equal_Subset_Sum_416 {

  public static void main(String[] args) {
    int[] inputArray1 = new int[]{1, 5, 11, 5};
    boolean result = false;
    longestConsecutive(inputArray1);

    result = canPartition(new int[]{14, 9, 8, 4, 3, 2});
    System.err.println("inputArray4 result = " + (result ? "Correct" : "Incorrect"));

    result = canPartition(inputArray1);
    System.err.println("inputArray1 result = " + (result ? "Correct" : "Incorrect"));

    int[] inputArray2 = new int[]{1, 2, 5};
    result = canPartition(inputArray2);
    System.err.println("inputArray2 result = " + (result ? "Incorrect" : "Correct"));

    int[] inputArray3 = new int[]{1, 2, 5};
    result = canPartition(inputArray3);
    System.err.println("inputArray3 result = " + (result ? "Incorrect" : "Correct"));

  }

  public static boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 != 0) return false;
    Set<Integer> permutationDpSet = new HashSet<>();
    permutationDpSet.add(0);
    //return canPartitionDP_sol1(nums, sum / 2, permutationDpSet);
    return canPartitionDP_dp_sol3(nums, sum / 2);
  }

  // Working fine. Solution#1
  public static boolean canPartitionDP_dp_sol3(int[] nums, int targetSum) {
    boolean dp[] = new boolean[targetSum + 1];
    dp[0] = true;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num > targetSum) continue;
      if (num == targetSum) return true;
      for (int j = targetSum; j >= num; j--) {
        // 10, 5,  15, 1 ,1
        dp[j] = dp[j] || dp[j - num];
      }
    }
    return dp[targetSum];
  }

  // TIme limit exceeds. Solution#2
  public static boolean canPartition_dynamicProgramming_sol2(int[] nums, int sumOfFewNumbers, int indexOfNum, int targetSum) {

    if (indexOfNum >= nums.length || sumOfFewNumbers > targetSum) return false;

    if (sumOfFewNumbers == targetSum || (sumOfFewNumbers + nums[indexOfNum]) == targetSum) return true;

    return (canPartition_dynamicProgramming_sol2(nums, sumOfFewNumbers, indexOfNum + 1, targetSum) ||
      canPartition_dynamicProgramming_sol2(nums, sumOfFewNumbers + nums[indexOfNum], indexOfNum + 1, targetSum));
  }

  // Working fine. Solution#1
  public static boolean canPartitionDP_sol1(int[] nums, int targetSum, Set<Integer> permutationDpSet) {
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num > targetSum) continue;
      Set newPermutationDpSet = new HashSet();
      for (int setNum : permutationDpSet) {
        int sum = setNum + num;
        if (sum == targetSum) {
          return true;
        } else if (sum < targetSum) {
          newPermutationDpSet.add(sum);
        }
      }
      newPermutationDpSet.addAll(permutationDpSet);
      newPermutationDpSet.add(num);
      permutationDpSet = newPermutationDpSet;
    }
    return false;
  }

  public static int longestConsecutive(int[] nums) {
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    int result = 1;
    for (int num : set) {
      if (!set.contains(num - 1)) {
        int localCount = 1;
        while (set.contains(num + 1)) {
          num++;
          localCount++;
        }
        result = Math.max(localCount, result);
      }
    }
    return result;

  }


}
