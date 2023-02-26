package heap_Or_PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Smallest_Range_Covering_Elements_from_K_Lists_632 {

  public static void main(String[] args) {
    List<List<Integer>> inputs = new ArrayList<>();
    inputs.add(List.of(4, 10, 15, 24, 26));
    inputs.add(List.of(0, 9, 12, 20));
    inputs.add(List.of(5, 18, 22, 30));

    System.err.println(smallestRange(inputs));
  }

  public static int[] smallestRange(List<List<Integer>> nums) {
    Integer lowLimit = null;
    Integer highLimit = null;

    int l = nums.size();
    PriorityQueue<int[]> pq = new PriorityQueue((o1, o2) -> ((int[]) o1)[0] - ((int[]) o2)[0]);

    int highest_num_in_pq = Integer.MIN_VALUE;
    for (int i = 0; i < l; i++) {
      int num = nums.get(i).get(0);
      highest_num_in_pq = Math.max(highest_num_in_pq, num);
      int[] pq_element = new int[]{num, i, 0};
      pq.offer((int[]) pq_element);
    }
    while (true) {
      int[] lowestCombi = pq.poll();
      int lowest_num_in_pq = lowestCombi[0];
      int listNo = lowestCombi[1];
      int itemIndex = lowestCombi[2];
      System.err.println("lowest_num_in_pq= " + lowest_num_in_pq + " , " + listNo + " , " + itemIndex);

      if (lowLimit == null || highLimit == null) {
        lowLimit = lowest_num_in_pq;
        highLimit = highest_num_in_pq;
      } else {
        int diff_prev = highLimit - lowLimit;
        int diff_current = highest_num_in_pq - lowest_num_in_pq;
        if (diff_current < diff_prev) {
          lowLimit = lowest_num_in_pq;
          highLimit = highest_num_in_pq;
        }
      }
      if (nums.get(listNo).size() - 1 <= itemIndex) break;// it is the last element in listNo.

      pq.offer(new int[]{nums.get(listNo).get(itemIndex + 1), listNo, itemIndex + 1});
      highest_num_in_pq = Math.max(highest_num_in_pq, nums.get(listNo).get(itemIndex + 1));
    }
    System.err.println("lowLimit=" + lowLimit);
    System.err.println("highLimit=" + highLimit);

    int[] result = new int[2];
    result[0] = lowLimit;
    result[1] = highLimit;

    return result;

  }
}
