package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Count_Nice_Pairs_in_an_Array_1814 {

  public static void main(String[] args) {
    System.err.println(countNicePairs(new int[]{42, 11, 1, 97}));
    System.err.println(countNicePairs(new int[]{13, 10, 35, 24, 76}));

  }

  public static int bruteForce(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])) {
          System.err.println("i=" + i + ", j=" + j + " and sum1=" + (nums[i] + rev(nums[j]))
            + ", diff_i=" + (nums[i] - rev(nums[i])) + ", diff_j=" + (nums[j] - rev(nums[j])));
        }
      }
    }
    System.err.println();
    return 0;
  }

  //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
  // nums[i] - rev(nums[i]
  public static int countNicePairs(int[] nums) {
    int count = 0;
    int mod = (int)1e9 + 7;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = nums[i] - rev(nums[i]);
      count = (count +  map.getOrDefault(diff, 0))%mod;
      map.put(diff, map.getOrDefault(diff, 0) + 1);
    }
    return count;
  }

  public static int rev(int i) {
    return Integer.valueOf(new StringBuilder().append(i).reverse().toString());
  }

}
