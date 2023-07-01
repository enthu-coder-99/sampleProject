package DP.targetSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Partition_Equal_Subset_Sum_416 {

  public static void main(String[] args) {
    int[] inputArray1 = null;
    boolean result = false;

    inputArray1 = new int[]{1, 2, 5};
    result = canPartition(inputArray1);
    System.out.println("inputArray = " + Arrays.toString(inputArray1) + " , result = " + (result));

    inputArray1 = new int[]{1, 5, 11, 5};
    result = canPartition(inputArray1);
    System.out.println("inputArray = " + Arrays.toString(inputArray1) + " , result = " + (result));

    result = canPartition(new int[]{14, 9, 8, 4, 3, 2});
    System.out.println("inputArray4 result = " + (result ? "Correct" : "Incorrect"));

    result = canPartition(inputArray1);
    System.out.println("inputArray1 result = " + (result ? "Correct" : "Incorrect"));

    int[] inputArray2 = new int[]{1, 2, 5};
    result = canPartition(inputArray2);
    System.out.println("inputArray2 result = " + (result ? "Incorrect" : "Correct"));

    int[] inputArray3 = new int[]{1, 2, 5};
    result = canPartition(inputArray3);
    System.out.println("inputArray3 result = " + (result ? "Incorrect" : "Correct"));

  }

  public static boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 != 0) return false;
    //return canPartitionDP_sol1(nums, sum / 2, permutationDpSet);
    return canPartitionDP(nums, sum / 2);
  }

  private static boolean canPartitionDP(int[] nums, int targetSum) {
    System.out.println("TargetSum = " + targetSum + ", nums =" + Arrays.toString(nums));
    if (targetSum < 0) return false;
    boolean dp[] = new boolean[targetSum + 1];
    dp[0] = true;
    for (int i = 0; i < nums.length; i++) {
      int num_i = nums[i];
      System.out.println("num_i=" + num_i);
      if (num_i > targetSum) continue;
      // for (int j = 0; j <= targetSum - num; j--) {
      for (int j = targetSum; j >= num_i; j--) {
        // WE should start "j" from the end (and not from the starting of nums[]).
        // Otherwise recently modified values in DP will generate wrong result. i.e. try with [1,2,5] and it will generate wrong result.
        dp[j + num_i] = dp[j + num_i] || dp[j];
      }
    }
    for (int i = 0; i <= targetSum; i++) {
      System.out.print("i=" + i + " dp[i]=" + dp[i] + ", ");
    }
    System.out.println("");
    return dp[targetSum];
  }


  // Working fine. Solution#1 and dp bottom Up
  public static boolean canPartitionDP_dp_sol3_best_solution(int[] nums, int targetSum) {
    boolean dp[] = new boolean[targetSum + 1];
    dp[0] = true;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num > targetSum) continue;
      if (num == targetSum) return true;
      for (int j = targetSum; j >= num; j--) {
        // WE should start "j" from the end (and not from the starting of nums[]).
        // Otherwise recently modified values in DP will generate wrong result. i.e. try with [1,2,5] and it will generate wrong result.
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
