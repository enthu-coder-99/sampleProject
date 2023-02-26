package Arrays;

import java.util.Set;
import java.util.TreeSet;

public class Contains_Duplicate_III_220 {
  public static void main(String[] args) {
    Set set = Set.of(1, 2, 3, 8, 9, 10, 11, 12, 13);
    TreeSet treeSet = new TreeSet<>(set);
    System.err.println(treeSet.floor(5));
    System.err.println(treeSet.ceiling(5));
    System.err.println("XOR=" + (55 ^ 1));
    int[] nums = {1, 2};
    System.err.println(containsNearbyAlmostDuplicate(nums, 0, 1));
  }

  //abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
  public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int diff) {
    if (indexDiff <= 0)
      return false;
    TreeSet<Long> treeSet = new TreeSet();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      Long higherLimit = treeSet.floor((long) num + diff);
      Long lowerLimit = treeSet.ceiling((long) num - diff);
      if ((lowerLimit != null && num >= lowerLimit) || (higherLimit != null && num <= higherLimit)) {
        return true;
      }
      if (treeSet.size() > indexDiff - 1)
        treeSet.remove((long) nums[i - indexDiff]);
      treeSet.add((long) num);
    }
    return false;
  }

  private static int getKey(int num, int diff) {
    return num / diff;
  }
}
