package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Next_Greater_Element_I_496 {

  public static void main(String[] args) {

  }

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;
    int[] result = new int[nums1.length];
    Deque<Integer> queue = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = n2 - 1; i >= 0; i--) {
      int num2 = nums2[i];
      while (queue.size() > 0 && num2 > nums2[queue.peek()])
        queue.pop();
      if (queue.size() > 0)
        map.put(num2, queue.peek());
      queue.push(i);
    }

    for (int i = 0; i < n1; i++) {
      result[i] = map.containsKey(nums1[i]) ? nums2[map.get(nums1[i])] : -1;
    }
    return result;
  }
}
