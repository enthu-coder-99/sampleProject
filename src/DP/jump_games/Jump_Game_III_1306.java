package DP.jump_games;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jump_Game_III_1306 {

  public static void main(String[] args) {
    //System.err.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
    System.err.println(canReach(new int[]{0, 3, 0, 6, 3, 3, 4}, 6));

  }

  public static boolean canReach(int[] arr, int start) {
    Deque<Integer> dq = new ArrayDeque();
    dq.add(start);
    return canReadToZeroValue(arr, dq, new int[arr.length]);
  }

  private static boolean canReadToZeroValue(int[] arr, Deque<Integer> dq, int[] memo) {
    int length = arr.length;
    while (dq.size() > 0) {
      Integer popIndex = dq.pop();
      int popIndexVal = arr[popIndex];
      if (popIndexVal < 0) continue;

      if (popIndexVal == 0)
        return true;
      if ((popIndex + popIndexVal) < length)
        dq.add(popIndex + popIndexVal);

      if ((popIndex - popIndexVal) >= 0)
        dq.add(popIndex - popIndexVal);
      arr[popIndex] = -1;

    }
    return false;
  }

}
