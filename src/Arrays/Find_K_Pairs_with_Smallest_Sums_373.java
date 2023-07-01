package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Find_K_Pairs_with_Smallest_Sums_373 {

  public static void main(String[] args) {
  }

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    Set<String> memo = new HashSet();
    PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    List<List<Integer>> answer = new ArrayList();
    pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
    memo.add("0_0");

    while (pq.size() > 0 && answer.size() < k) {
      int[] elm = pq.poll();
      int index1 = elm[1];
      int index2 = elm[2];
      int new_index_1 = index1 + 1;
      int new_index_2 = index2 + 1;

      if (index2 < l2 - 1 && !memo.contains(index1 + "_" + new_index_2)) {
        pq.add(new int[]{nums1[index1] + nums2[index2 + 1], index1, index2 + 1});
        memo.add(index1 + "_" + new_index_2);
      }

      if (index1 < l1 - 1 && !memo.contains(new_index_1 + "_" + index2)) {
        pq.add(new int[]{nums1[index1 + 1] + nums2[index2], index1 + 1, index2});
        memo.add(new_index_1 + "_" + index2);
      }
      answer.add(List.of(nums1[index1], nums2[index2]));
    }
    return answer;
  }
}
