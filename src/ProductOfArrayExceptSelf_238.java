import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

  public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] result = new int[length];
    int totalProductOfAllNums = 1;
    int totalZeroValues = 0;

    for (int i = 0; i < length; i++) {
      if (nums[i] == 0) {
        totalZeroValues++;
        if (totalZeroValues > 1) {
          Arrays.fill(result, 0);
          return result;
        }
      } else {
        totalProductOfAllNums = totalProductOfAllNums * nums[i];
      }
    }
    for (int i = 0; i < length; i++) {
      int num = nums[i];
      if (num != 0) {
        result[i] = totalProductOfAllNums / num;
      }
    }
    return result;
  }
}
