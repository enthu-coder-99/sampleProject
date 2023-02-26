package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_II_219 {

  public static void main(String[] args) {

  }

  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && (i - map.get(nums[i]) >= k)) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }
}
