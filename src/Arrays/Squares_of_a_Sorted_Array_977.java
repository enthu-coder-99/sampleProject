package Arrays;

import utils.CommonLogging;

public class Squares_of_a_Sorted_Array_977 {

  public static void main(String[] args) {
    int[] sqInts = sortedSquares(new int[]{-4, -1, 0, 3, 10});
    CommonLogging.printArray("", sqInts);
  }

  public static int[] sortedSquares(int[] nums) {
    int[] result = new int[nums.length];
    int indexSize = nums.length - 1;
    int l = 0;
    int r = nums.length - 1;
    while (indexSize >= 0) {
      if (Math.abs(nums[r]) > Math.abs(nums[l])) {
        result[indexSize--] = nums[r] * nums[r];
        r--;
      } else {
        result[indexSize--] = nums[l] * nums[l];
        l++;
      }
    }
    return result;
  }
}
