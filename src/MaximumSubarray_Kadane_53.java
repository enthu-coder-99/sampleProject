public class MaximumSubarray_Kadane_53 {

  public static void main(String[] args) {
    System.err.println(maxSubArray_trial2(new int[]{-2, 1}));

    System.err.println(maxSubArray_trial2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.err.println(maxSubArray_trial2(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, 4}));
    System.err.println(maxSubArray_trial2(new int[]{-2, 1}));

  }

  public static int maxSubArray_trial2(int[] nums) {

    if (nums == null || nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];

    int maxSum = nums[0];
    int maxSumTillThisIndex = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int currentNum = nums[i];

      if (maxSumTillThisIndex < 0)
        maxSumTillThisIndex = 0;
      maxSumTillThisIndex += currentNum;
      maxSum = Math.max(maxSumTillThisIndex, maxSum);

    }

    return maxSum;
  }

  public static int maxSubArray_trial1(int[] nums) {

    int maxSumFinalTillNow = Integer.MIN_VALUE;
    int maxSumForCurrentSubIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      maxSumForCurrentSubIndex = maxSumForCurrentSubIndex + num;
      if (maxSumForCurrentSubIndex > maxSumFinalTillNow) {
        maxSumFinalTillNow = maxSumForCurrentSubIndex;
      }
      if (maxSumForCurrentSubIndex < 0) {
        maxSumForCurrentSubIndex = 0;
      }
    }
    return maxSumFinalTillNow;
  }


}
