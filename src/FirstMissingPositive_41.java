public class FirstMissingPositive_41 {

  /**
   * Input: nums = [3,4,-1,1]
   * Output: 2
   * #41
   *
   * @param args
   */
  public static void main(String[] args) {

    System.err.println("Missing=" + firstMissingPositive(new int[]{2, 6, 1}));
  }

  public static int firstMissingPositive(int[] nums) {
    int length = nums.length;

    for (int i = 0; i < length; i++) {
      if (nums[i] <= 0) {
        nums[i] = length + 1;
      }
    }
    printArray("1", nums);

    for (int i = 0; i < length; i++) {
      int value = Math.abs(nums[i]);
      if (value > length) {
        continue;
      }
      //get index of value
      int valueIndex = value - 1;
      if (valueIndex >= 0 && nums[valueIndex] > 0) {
        nums[valueIndex] = nums[valueIndex] * -1;
      }
    }

    printArray("2", nums);

    for (int i = 0; i < length; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    printArray("2", nums);
    return (nums.length + 1);
  }

  private static void printArray(String str, int[] nums) {
    StringBuffer sb = new StringBuffer(str + ": ");
    for (int num : nums) {
      sb.append(num + ",");
    }
    System.err.println(str + " and SB=" + sb);
  }

}
