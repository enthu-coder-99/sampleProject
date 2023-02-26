package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Minimum_Increment_Make_Array_Unique_945 {

  public static void main(String[] args) {
    System.err.println(minIncrementForUnique_sol4(new int[]{3, 2, 1, 2, 1, 7}));// answer is 6
    //System.err.println(minIncrementForUnique_sol4(new int[]{1, 2, 2})); // Ans=1

  }

  /**
   * 1 2 2 2 3 4 8
   *
   * @param nums
   * @return
   */
  public static int minIncrementForUnique_sol4(int[] nums) {
    Arrays.sort(nums);
    int move = 0;
    int currentNumSeries = nums[0];
    int numberJustAssigned = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int currentNum = nums[i];
      System.out.println(i + "- currentNum=" + currentNum);
      numberJustAssigned = Math.max(numberJustAssigned + 1, currentNum);
      move += numberJustAssigned - currentNum;
      nums[i] = numberJustAssigned;
      System.out.println("Move=" + move + " numberJustAssigned=" + numberJustAssigned);
    }
    Arrays.stream(nums).forEach(e -> System.out.print(e + ", "));
    return move;
  }

  public static int minIncrementForUnique_sol3(int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap();
    int move = 0;

    for (int i = 0; i < nums.length; i++) {
      int currentNum = nums[i];
      map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);
    }
    int maxNumberTillNow = map.firstKey();
    for (Integer key : map.keySet()) {
      Integer frequency = map.get(key);
      if (maxNumberTillNow >= key) {
        move += ((frequency - 1) * frequency / 2) * (maxNumberTillNow - key);
        maxNumberTillNow = maxNumberTillNow + frequency;
      } else if (frequency > 1) {
        move += ((frequency - 1) * frequency / 2);
        maxNumberTillNow = maxNumberTillNow + frequency - 1;

      } else {
        maxNumberTillNow = key;
      }
    }
    return move;
  }

  public static int minIncrementForUnique_sol2(int[] nums) {
    Arrays.sort(nums);
    int move = 0;
    int latestMaxNum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int currentNum = nums[i];
      if (currentNum <= latestMaxNum) {
        latestMaxNum++;
        move += latestMaxNum - currentNum;
      } else {
        latestMaxNum = currentNum;
      }
    }
    return move;
  }


  // minIncrementForUnique_sol1 - Throeing Time Exceed exception
  public static int minIncrementForUnique_sol1(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int move = 0;
    for (int i : nums) {
      while (set.contains(i)) {
        i++;
        move++;
      }
      set.add(i);
    }
    return move;
  }
}
