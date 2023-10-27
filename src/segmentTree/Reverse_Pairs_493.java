package segmentTree;

import java.util.Set;
import java.util.TreeMap;

public class Reverse_Pairs_493 {

  TreeMap<Long, Integer> map = new TreeMap();

  public int reversePairs(int[] nums) {
    int ans = 0;
    int l = nums.length;

    for (int i = l - 1; i >= 0; i--) {
      long num = nums[i];
      Set<Long> keys = map.keySet();
      if (keys != null) {
        for (Long key : keys) {
          int cnt = map.get(key);
          if (num > 2 * key) {
            ans = ans + cnt;
          } else {
            break;
          }
        }
      }

      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    return ans;
  }
}
