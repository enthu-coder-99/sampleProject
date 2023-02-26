package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Intersection_of_Two_Arrays_349 {

  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums2.length > nums1.length) {
      int[] tmp = nums1;
      nums1 = nums2;
      nums2 = tmp;
    }
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < nums1.length; i++) {
      set.add(nums1[i]);
    }
    List<Integer> resultList = new ArrayList<>();
    for (int i = 0; i < nums2.length; i++) {
      int num = nums2[i];
      if (set.contains(num)) {
        resultList.add(num);
        set.remove(num);
      }
    }
    int[] ret = new int[resultList.size()];
    Iterator<Integer> iterator = resultList.iterator();
    for (int i = 0; iterator.hasNext(); i++) {
      ret[i] = iterator.next();
    }

    return ret;
  }
}
