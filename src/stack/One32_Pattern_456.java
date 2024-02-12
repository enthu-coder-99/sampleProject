package stack;

import java.util.LinkedList;

public class One32_Pattern_456 {

  public boolean find132pattern(int[] nums) {

    int l = nums.length;
    int[] lowestNumFromLeft = new int[l];

    lowestNumFromLeft[0] = Integer.MAX_VALUE;
    int minNum = nums[0];
    for (int i = 1; i < l; i++) {
      int num = nums[i];
      lowestNumFromLeft[i] = minNum;
      minNum = Math.min(num, minNum);
    }

    LinkedList<Integer> deque = new LinkedList();
    deque.add(nums[l - 1]);
    for (int i = l - 2; i > 0; i--) {
      int num_i = nums[i];//Potential j
      int minNumOnLeftSide_i = lowestNumFromLeft[i];//potential i

    }
    return false;
  }
}
