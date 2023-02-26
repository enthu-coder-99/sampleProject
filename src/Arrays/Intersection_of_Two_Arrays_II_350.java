package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection_of_Two_Arrays_II_350 {

  public static void main(String[] args) {
    System.err.println(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
  }

  public static int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    if (nums2.length > nums1.length) {
      int[] tmp = nums1;
      nums1 = nums2;
      nums2 = tmp;
    }

    for (int i = 0; i < nums1.length; i++) {
      int num = nums1[i];
      map.put(num, map.get(num) != null ? (map.get(num) + 1) : 1);
    }
    List<Integer> resultList = new ArrayList<>();
    for (int i = 0; i < nums2.length; i++) {
      int num = nums2[i];
      if (map.containsKey(num) && map.get(num) > 0) {
        resultList.add(num);
        map.put(num, map.get(num) - 1);
      }
    }
    int[] ret = new int[resultList.size()];
    for (int i = 0; i < resultList.size(); i++) {
      ret[i] = resultList.get(i);
    }
    return ret;
  }
}
