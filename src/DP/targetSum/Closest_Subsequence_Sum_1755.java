package DP.targetSum;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Closest_Subsequence_Sum_1755 {

  public static void main(String[] args) throws Exception {
    Closest_Subsequence_Sum_1755 obj = new Closest_Subsequence_Sum_1755();
    int[] nums = {7, -9, 15, -2};
    int goal = -5;
    nums = new int[]{1, 2, 3};
    goal = -7;
   /* nums = new int[]{-7074297, 3076735, -5846354, 5008659, -126683, 7039557, 6708811, 3189666, -6102417, 6078975, -6448946, -4995910, 2964239, -3248847, -4392269, 7473223, -1356059,
      3978911, 8009187, -316441, 6524770, 8280309, -2798383, 1310839, 6306594, -6548611, -9712711, 1639314};
    goal = 493409180;*/
    System.out.println(obj.minAbsDifference(nums, goal));
  }

  public int minAbsDifference(int[] nums, int goal) {
    int l = nums.length;
    int l_2 = l / 2;
    Set<Integer> sum1Set = getSubSetSum(nums, 0, l_2);
    if (sum1Set.contains(goal)) return 0;

    TreeSet<Integer> sum2Set = new TreeSet<>(getSubSetSum(nums, l_2, l));
    if (sum2Set.contains(goal)) return 0;
    System.out.println("sum1Set= " + sum1Set);
    System.out.println("sum2Set= " + sum2Set);

    int ans = Math.abs(goal);// In case we do not choose any number from nums so max Diff can be the "goal" only.
    for (int sum1Num : sum1Set) {
      int reminder = goal - sum1Num;
      if (sum2Set.contains(reminder)) return 0;
      Integer floor = sum2Set.floor(reminder);
      if (floor != null) {
        ans = Math.min(ans, Math.abs(reminder - floor));
      }
      Integer ceiling = sum2Set.ceiling(reminder);
      if (ceiling != null) {
        ans = Math.min(ans, Math.abs(reminder - ceiling));
      }
    }

    return ans;
  }

  public Set<Integer> getSubSetSum(int[] nums, int startIndex, int endIndex) {

    Set<Integer> result = new HashSet<>();
    for (int i = startIndex; i < endIndex; i++) {
      int num = nums[i];
      Set<Integer> newSet = new HashSet<>();
      for (int setNum : result) {
        newSet.add(setNum + num);
      }
      newSet.add(num);
      result.addAll(newSet);
    }
    return result;
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
