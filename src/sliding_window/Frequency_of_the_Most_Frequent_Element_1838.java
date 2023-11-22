package sliding_window;

import java.util.Arrays;

public class Frequency_of_the_Most_Frequent_Element_1838 {

  public static void main(String[] args) {
    int[] nums = {3, 9, 6};
    int ans = maxFrequency(nums, 2);
    System.out.println("ans= " + ans);
  }

  public static int maxFrequency(int[] nums, int k) {

    Arrays.sort(nums);
    int l = nums.length;
    int ans = 1;
    int right = l - 1;
    int left = l - 1;
    int realSum = 0;

    while (right >= 0) {
      System.out.println("Start--> left= " + left + ", right= " + right + " ans= " + ans + ", realSum=" + realSum);
      int right_num = nums[right];
      // Loop to optimize the Left. Slide Left
      while (left >= 0) {
        int numLen = right - left + 1;
        int expectedSumShouldBe = numLen * right_num;
        if (expectedSumShouldBe <= k + realSum + nums[left]) {
          realSum = realSum + nums[left];
          ans = Math.max(ans, numLen);
          left--;
        } else {
          // invalid range
          break;
        }
      }

      // Loop to optimize the Right. Slide Right
      while (right >= 0 && nums[right] == right_num) {
        realSum = realSum - nums[right];
        right--;
      }
      System.out.println("End--> left= " + left + ", right= " + right + " ans= " + ans + ", realSum=" + realSum);

    }
    return ans;
  }
}
