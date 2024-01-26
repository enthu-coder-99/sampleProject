package Backtracking;

import java.util.HashMap;

public class Partition_to_K_Equal_Sum_Subsets_698 {
  static HashMap<Integer, Boolean> memo = new HashMap<>();

  public static void main(String[] args) {
    int n = 5;
    int nthBit = 1 << n;
    int max = (int) Math.pow(2, n);
    Integer i1 = Integer.valueOf("1000000", 2);
    Integer i2 =  Integer.valueOf("1111111", 2);
    System.out.println(i1+" : "+i2);
    for (int i = 64; i <= 127; ++i) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i);
      String bitmask2 = Integer.toBinaryString(i).substring(1);


      System.out.println(i + ": " + bitmask + " || " + bitmask2);
    }
    //System.err.println(canPartitionKSubsets1(new int[]{6,4,5,4,1,1,10,1,7,6,4,2,10,1,3,5, 10}, 10));
    System.err.println(canPartitionKSubsets1(new int[]{4, 5, 6, 10}, 14));
  }

  public static boolean canPartitionKSubsets1(int[] nums, int k) {
    int i = 0;
    int l = nums.length;
    int sum = getSum(nums);
    if (sum % k != 0) return false;
    return backtrack(nums, 0, 0, 0, k, sum / k, new boolean[l], 0);
  }

  private static boolean backtrack(int[] arr, int index, int count, int currSum, int k,
                                   int targetSum, boolean[] taken, int loop) {

    int n = arr.length;
    for (int j = index; j < n; ++j) {
      if (!taken[j]) {
        taken[j] = true;
        System.out.println("j=" + j + ", num=" + arr[j] + ", currSum=" + currSum + ", totalSum= " + (currSum + arr[j]) + " loop=" + loop);
        if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken, loop + 1)) {
          return true;
        }
        taken[j] = false;
      }
    }

    // We were not able to make a valid combination after picking each element from the array,
    // hence we can't make k subsets.
    return false;
  }

  public static int getSum(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum;
  }
}