package twoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Minimum_Operations_to_Reduce_X_to_Zero_1658 {


  public static void main(String[] args) {
    Minimum_Operations_to_Reduce_X_to_Zero_1658 obj = new Minimum_Operations_to_Reduce_X_to_Zero_1658();
    int[] nums = new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
    int x = 134365;
    nums = new int[]{1, 1, 4, 2, 3};//Ans = 2
    x = 5;
    int final_ans = obj.minOperations(nums, x);
    final_ans = final_ans == Integer.MAX_VALUE ? -1 : final_ans;
    System.err.println("Final_Ans= " + final_ans);

  }

  public int minOperations(int[] nums, int x) {
    int l = nums.length;
    int ans = sol1(nums, x);
    return ans;
  }

  // Sum of left and right side contigous array
  public int sol2(int[] nums, int x) {
    if (x == 0) return 0;

    int l = nums.length;
    int totalSum = 0;
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      totalSum = totalSum + num;
    }
    if (x == totalSum) return l;// Edge case

    int ans = Integer.MAX_VALUE;
    System.out.println("totalSum = " + totalSum + ", ");

    int leftIndex = 0;

    //i+1 --> l-1

    // 0 -- 4

    // 4 -7 == l-1 -i
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      totalSum = totalSum - num;
      while (totalSum < x && leftIndex < i) {
        totalSum = totalSum + nums[leftIndex++];
      }
      if (totalSum == x) {
        int lengthOfArray = leftIndex + (l - i - 1);
        System.out.println("i=" + i + ", leftIndex=" + leftIndex + ", lengthOfArray=" + lengthOfArray);
        ans = Math.min(ans, lengthOfArray);
      }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  // Sum of middle contigous array
  public int sol1(int[] nums, int x) {
    if (x == 0) return 0;

    int l = nums.length;
    int totalSum = 0;
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      totalSum = totalSum + num;
    }
    if (x == totalSum) return l;// Edge case

    int ans = Integer.MIN_VALUE;
    int desiredSumOfSubArrayForAnswer = totalSum - x;// This is the value we want to the contigous array and length should be MAXIMUM. Now, objective is to find a contigous array with max length and sum = desiredSumOfSubArrayForAnswer
    System.out.println("totalSum = " + totalSum + ", desiredSumOfSubArrayForAnswer= " + desiredSumOfSubArrayForAnswer);

    int leftIndex = 0;
    int tmpSum = 0;
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      tmpSum = tmpSum + num;
      while (tmpSum > desiredSumOfSubArrayForAnswer && leftIndex < i) {
        tmpSum = tmpSum - nums[leftIndex++];
      }
      if (tmpSum == desiredSumOfSubArrayForAnswer) {
        int lengthOfArray = i - leftIndex + 1;
        System.out.println("i=" + i + ", leftIndex=" + leftIndex + ", lengthOfArray=" + lengthOfArray);
        ans = Math.max(ans, lengthOfArray);
      }
    }
    return l - ans;
  }

  // TLE
  public int recursion(int[] nums, int x, int opsCnt, int left, int right, Map<Integer, List<Integer>> map) {
    if (x == 0) {
      return opsCnt;
    }
    if (x < 0 || right < left) {
      return Integer.MAX_VALUE;
    }

    int ans1 = recursion(nums, x - nums[left], opsCnt + 1, left + 1, right, map);
    int ans2 = recursion(nums, x - nums[right], opsCnt + 1, left, right - 1, map);
    int ans = Math.min(ans1, ans2);
    System.out.println("x=" + x + ", ans1=" + ans1 + ", ans2=" + ans2 + ", ans= " + ans);
    if (!map.containsKey(x)) map.put(x, new ArrayList());
    map.get(x).add(ans);
    map.get(x).add(ans1);
    map.get(x).add(ans2);

    return ans;
  }
}
