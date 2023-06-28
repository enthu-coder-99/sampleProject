package DP.targetSum;

import java.util.HashSet;
import java.util.Set;

public class Closest_Subsequence_Sum_1755 {

  public static void main(String[] args) throws Exception {
    Closest_Subsequence_Sum_1755 obj = new Closest_Subsequence_Sum_1755();
    int[] nums = {7, -9, 15, -2};
    int goal = -5;
    nums = new int[]{-7074297, 3076735, -5846354, 5008659, -126683, 7039557, 6708811, 3189666, -6102417, 6078975, -6448946, -4995910, 2964239, -3248847, -4392269, 7473223, -1356059,
      3978911, 8009187, -316441, 6524770, 8280309, -2798383, 1310839, 6306594, -6548611, -9712711, 1639314};
    goal = 493409180;
    System.out.println(obj.minAbsDifference(nums, goal));
  }

  public int minAbsDifference(int[] nums, int goal) throws Exception {
    int sum = getSum(nums);
    System.out.println("Total sum=" + sum + " , goal=" + goal);
    Set<Integer> set = new HashSet();
    int diff = Math.abs(goal);

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      diff = getNewDiff(diff, num, goal);
      System.out.println(i+"- num=" + num + ", diff=" + diff + " set_l=" + set.size());
      Thread.sleep(1000);
      Set<Integer> newSet = new HashSet();

      for (int setNum : set) {
        int newNum = setNum + num;
        diff = getNewDiff(diff, newNum, goal);
        System.out.print("newNum=" + newNum + ", diff=" + diff + " | ");
        newSet.add(newNum);
      }
      newSet.add(num);
      System.out.println("newSet_l= " + newSet.size() + ", set_l=" + set.size());

      if (diff == 0) return 0;
      set.addAll(newSet);
    }
    System.out.println("Final set= " + set);
    System.out.println("Final diff= " + diff);

    return diff;
  }

  static int getNewDiff(int currentDiff, int num, int goal) {
    int newDiff = Math.abs(num - goal);
    if (newDiff < currentDiff) return newDiff;
    return currentDiff;
  }

  public int getSum(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      sum += num;
    }
    return sum;
  }
}
