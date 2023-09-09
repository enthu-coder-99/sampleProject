package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Contiguous_Array_525 {


  public static void main(String[] args) {
    Contiguous_Array_525 ob = new Contiguous_Array_525();
    int[] nums = new int[]{0, 1, 0};
    int ans = ob.findMaxLength(nums);
    System.err.println("ANS= " + ans);
  }

  public int findMaxLength(int[] nums) {
    int l = nums.length;
    int count_1 = 0;
    int ans = 0;
    Map<Integer, Integer> map = new HashMap();

    for (int i = 0; i < l; i++) {
      int num = nums[i];
      if (num == 1) {
        count_1++;
      } else {
        count_1--;
      }

      if (count_1 == 0) {
        ans = Math.max(ans, i + 1);
      } else {
        if (map.containsKey(count_1)) {
          ans = Math.max(ans, i - map.get(count_1));
        } else {
          map.put(count_1, i);
        }
      }
    }

    return ans;
  }
}
