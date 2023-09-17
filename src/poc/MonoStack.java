package poc;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonoStack {

  public static void main(String[] args) {
    MonoStack monoStack = new MonoStack();
    int[] nums = new int[]{5, 19, 11, 3, 23, 15, 8, 2, 7,};
  }


  public void increasingMonoStack(int[] nums) {
    int l = nums.length;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < l; i++) {
      int num = nums[i];
    }
  }

  public void decreasingMonoStack(int[] nums) {

  }
}
