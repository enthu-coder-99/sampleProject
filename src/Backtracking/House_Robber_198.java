package Backtracking;

import java.util.HashMap;
import java.util.Map;


public class House_Robber_198 {

  public static void main(String[] args) {
    System.err.println(maxOperations(new int[]{63, 10, 28, 31, 90, 53, 75, 77, 72, 47, 45, 6, 49, 13, 77, 61, 68, 43, 33, 1, 14, 62, 55, 55, 38, 54, 8, 79, 89, 14, 50, 68, 85, 12, 42, 57, 4, 67, 75, 6, 71, 8, 61, 26, 11, 20, 22, 3, 70, 52, 82, 70,
      67, 18, 66, 79, 84, 51, 78, 23, 19, 84, 46, 61, 63, 73, 80, 61, 15, 12, 58, 3, 21, 66, 42, 55, 7, 58, 85, 60, 23, 69, 41, 61, 35, 64, 58, 84, 61, 77, 45, 14, 1, 38, 4, 8, 42, 16, 79, 60, 80, 39, 67, 10, 24, 15, 6, 37, 68, 76, 30, 53, 63, 87, 11, 71, 86, 82, 77,
      76, 37, 21, 85, 7, 75, 83, 80, 8, 19, 25, 11, 10, 41, 66, 70, 14, 23, 74, 33, 76, 35, 89, 68, 85, 83, 57, 6, 72, 34, 21, 57, 72, 79, 29, 65, 3, 67, 8, 24, 24, 18, 26, 27, 68, 78, 64, 57, 55, 68, 28, 9, 11, 38, 45, 61, 37, 81, 89, 38, 43, 45, 26, 84, 62, 22, 37, 51,
      15, 30, 67, 75, 24, 66, 40, 81, 74, 48, 43, 78, 14, 33, 19, 73, 5, 1, 2, 53, 29, 49, 73, 23, 5}, 59));
  }

  public static int rob(int[] nums) {
    int totalRob = 0;
    if (nums.length == 1)
      return nums[0];

    int[] dp = new int[nums.length];
    for (int i = 2; i < nums.length; i++) {

    }
    return totalRob;
  }


  public static int maxOperations(int[] nums, int k) {

    int result = 0;
    Map<Integer, Integer> map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      int desiredNum = k - nums[i];
      System.err.println(i + "- num[i]=" + nums[i] + " and desiredNum=" + desiredNum + " and map=" + map);
      if (map.getOrDefault(desiredNum, 0) > 0) {
        map.put(desiredNum, map.get(desiredNum) - 1);
        result++;
      } else {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      }
    }
    return result;
  }
}
