package Arrays;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Numbers_Smaller_Than_current_Number_1365 {

  public static void main(String[] args) {

  }

  public static int[] smallerNumbersThanCurrent(int[] nums) {
    int[] result = new int[nums.length];
    Map<Integer, Integer> map = new TreeMap<>();

    for (int i = 0; i < nums.length; i++) {
      int currentNum = nums[i];
      map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);
    }
    Iterator<Integer> iterator = map.keySet().iterator();
    int totalSmallerNumbers = 0;
    int lastMapElementCount = 0;
    while (iterator.hasNext()) {
      int incrementedMapKey = iterator.next();
      totalSmallerNumbers = totalSmallerNumbers + lastMapElementCount;
      lastMapElementCount = map.get(incrementedMapKey);
      map.put(incrementedMapKey, totalSmallerNumbers);
    }
    for (int i = 0; i < nums.length; i++) {
      int currentNum = nums[i];
      result[i] = map.get(currentNum);
    }
    return result;
  }
}
