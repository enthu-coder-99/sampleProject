import utils.CommonLogging;

public class Move_Zeroes_233 {

  public static void main(String[] args) {
    int[] input = {0, 1, 0, 3, 12};
    moveZeroes(input);
    CommonLogging.printArray("", input);
  }

  public static void moveZeroes(int[] nums) {

    int begin = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[begin++] = nums[i];
      }
    }

    for (int i = begin; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
