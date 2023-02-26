package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Degree_of_an_Array_697 {

  public static void main(String[] args) {
    int[] ints = {1, 2, 2, 3, 1};
    System.err.println(findShortestSubArray(ints));
  }

  public static int findShortestSubArray(int[] nums) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int maxCnt = 0;
    int shortestSubArray = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (map.get(num) == null)
        map.put(num, new ArrayList<>());
      List<Integer> indexes = map.get(num);
      indexes.add(i);
      if (indexes.size() > maxCnt) {
        maxCnt = indexes.size();
        shortestSubArray = indexes.get(indexes.size() - 1) - indexes.get(0) + 1;
      }

      if (indexes.size() == maxCnt) {
        maxCnt = indexes.size();
        shortestSubArray = Math.min(shortestSubArray, indexes.get(indexes.size() - 1) - indexes.get(0));
      }
    }
    return shortestSubArray +1;
  }
}
