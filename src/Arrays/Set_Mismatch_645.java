package Arrays;

import java.util.Arrays;

public class Set_Mismatch_645 {
  public static void main(String[] args) {
    System.err.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
  }

  public static int[] findErrorNums(int[] nums) {
    int l = nums.length;
    int[] result = new int[2];
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      int numAbs = Math.abs(num);
      if (nums[numAbs - 1] > 0) {
        nums[numAbs - 1] = nums[numAbs - 1] * -1;
      } else {
        result[0] = num;
      }
    }
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      int numAbs = Math.abs(num);
      if (num > 0)
        result[1] = i + 1;
    }
    return result;

  }

}
