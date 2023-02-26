package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence_128 {

  public int longestConsecutive(int[] nums) {
    if (nums.length < 2) return nums.length;
    Set<Integer> set = new HashSet();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }

    int maxConsecutiveLength = 1;
    for (int num : set) {
      if (set.contains(num - 1)) continue;
      int rightNum = num;
      while (set.contains(rightNum + 1)) rightNum++;
      maxConsecutiveLength = Math.max(maxConsecutiveLength, rightNum - num + 1);
    }
    return maxConsecutiveLength;
  }
}
