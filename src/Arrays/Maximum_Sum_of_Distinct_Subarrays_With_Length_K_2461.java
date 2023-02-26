package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Maximum_Sum_of_Distinct_Subarrays_With_Length_K_2461 {

  public static long maximumSubarraySum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    int startingIndex = 0;
    long maxSum = 0;
    long localSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      while (set.contains(num)) {
        set.remove(nums[startingIndex]);
        localSum = localSum - nums[startingIndex];
        startingIndex++;
      }
      set.add(num);
      localSum = localSum + num;
      if (set.size() == k) {
        maxSum = Math.max(maxSum, localSum);
        set.remove(nums[startingIndex]);
        localSum = localSum - nums[startingIndex];
        startingIndex++;
      }
    }
    return maxSum;
  }

}
