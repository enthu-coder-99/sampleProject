package algo.graph.dfs_bfs;

import java.util.HashSet;
import java.util.Set;

public class Circular_Array_Loop_457 {


  public static void main(String[] args) {

    int[] nums = {2, -1, 1, 2, 2};//true

    nums = new int[]{-1, -2, -3, -4, -5, 6};//false

    nums = new int[]{-2, 1, -1, -2, -2};//false

    nums = new int[]{1, -1, 5, 1, 4};//true
    System.err.println(circularArrayLoop(nums));

  }

  public static boolean circularArrayLoop(int[] nums) {
    int len = nums.length;

    boolean[] visited = new boolean[len];
    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        boolean circular = isCircular(nums, i, visited);
        if (circular)
          return true;
        else
          System.err.println();
      }
    }
    return false;
  }

  public static boolean isCircular(int[] nums, int startingIndex, boolean[] visited) {
    int len = nums.length;

    Set<Integer> set = new HashSet();
    boolean negativeNums = false;
    boolean positiveNums = false;

    int index = startingIndex;

    while (true) {
      if (set.contains(index)) return true;
      set.add(index);
      int jumpToNextIndex = getAbsIndex(index, nums[index], len);
      if (jumpToNextIndex == index) return false;
      if (nums[index] > 0) positiveNums = true;
      if (nums[index] < 0) negativeNums = true;
      if (negativeNums && positiveNums) return false;
      index = jumpToNextIndex;
      visited[index] = true;

    }
  }

  public static int getAbsIndex(int currentIndex, int relativeIndex, int len) {

    int new_index = relativeIndex + currentIndex;
    if (new_index < 0) {
      return new_index / len + len;
    } else if (new_index >= len) {
      return new_index % len;
    }
    return new_index;
  }
}
