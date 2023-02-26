import java.util.Arrays;

public class Number_of_Ways_to_Split_Array_2270 {

  public static void main(String[] args) {
    System.err.println(waysToSplitArray(new int[]{10, 4, -8, 7}));
  }

  public static int waysToSplitArray(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    int count = 0;
    int leftSum = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      leftSum += nums[i];
      int rightSum = sum - leftSum;
      if (leftSum >= rightSum)
        count++;
    }
    return count;
  }


}
