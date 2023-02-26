package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Intersection_of_Multiple_Arrays_2248 {

  public static void main(String[] args) {
    System.err.println(intersection(new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}}));
  }

  public static List<Integer> intersection(int[][] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        int currentNum = nums[i][j];
        map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);
      }
    }
    List<Integer> resultList = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() >= nums.length)
        resultList.add(entry.getKey());
    }
    return resultList.stream().sorted().collect(Collectors.toList());
  }
}
