package Arrays;

public class Maximum_Absolute_Sum_of_Any_Subarray_1749 {

  public int maxAbsoluteSum(int[] nums) {
    if (nums.length == 1)
      return Math.abs(nums[0]);
    int maxSumSubArray = nums[0];
    int minSumSubArray = nums[0];

    int localSumMax = nums[0];
    int localSumMin = nums[0];
    for (int i = 1; i < nums.length; i++) {
      localSumMax = Math.max(localSumMax + nums[i], nums[i]);
      localSumMin = Math.min(localSumMin + nums[i], nums[i]);
      maxSumSubArray = Math.max(maxSumSubArray, localSumMax);
      minSumSubArray = Math.min(minSumSubArray, localSumMin);
    }
    return Math.abs(maxSumSubArray) > Math.abs(minSumSubArray) ? Math.abs(maxSumSubArray) : Math.abs(minSumSubArray);
  }
}
