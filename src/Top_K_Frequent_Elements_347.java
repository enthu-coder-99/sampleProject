import utils.CommonLogging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Top_K_Frequent_Elements_347 {

  public static void main(String[] args) {
    CommonLogging.printArray(topKFrequent(new int[]{1,2}, 2));
  }

  public static int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    int[] result = new int[k];
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    ArrayList<Integer>[] numCount = new ArrayList[nums.length + 1];
    for (int i : map.keySet()) {
      int frequency = map.get(i);
      if (numCount[frequency] == null)
        numCount[frequency] = new ArrayList<Integer>();
      numCount[frequency].add(i);
    }
    int resultCounter = 0;
    for (int j = nums.length; j >= 0 && resultCounter < k; j--) {
      if (numCount[j] != null) {
        for(int number:numCount[j])
        result[resultCounter++] = number;
      }
    }
    return result;
  }

  public static int[] topKFrequent_1(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    int[] result = new int[k];
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    List<Map.Entry<Integer, Integer>> orderByValueMapEntry = map.entrySet().stream().sorted((e1, e2) -> (e2.getValue() - e1.getValue())).collect(Collectors.toList());
    for (int i = 0; i < k; i++) {
      result[i] = orderByValueMapEntry.get(i).getKey();
    }
    return result;
  }
}
