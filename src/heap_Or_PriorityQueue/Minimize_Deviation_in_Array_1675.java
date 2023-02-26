package heap_Or_PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Minimize_Deviation_in_Array_1675 {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4};
    System.err.println(minimumDeviation(nums));
  }

  public static int minimumDeviation(int[] nums) {
    return minimumDeviation_treeSet(nums);
  }

  public static int minimumDeviation_treeSet(int[] nums) {
    int l = nums.length;
    TreeSet<Integer> tree = new TreeSet(Comparator.reverseOrder());
    int deviation = Integer.MAX_VALUE;
    int lowest_val_in_nums = Integer.MAX_VALUE;
    int highest_val_in_nums = Integer.MIN_VALUE;
    int lowest_in_pq = Integer.MAX_VALUE;
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      lowest_val_in_nums = Math.min(lowest_val_in_nums, num);
      highest_val_in_nums = Math.max(highest_val_in_nums, num);
      if (num % 2 == 1) {
        //Odd
        tree.add(num * 2);
        lowest_in_pq = Math.min(lowest_in_pq, num * 2);
      } else {
        //Even
        tree.add(num);
        lowest_in_pq = Math.min(lowest_in_pq, num);
      }
    }
    // All number in PQ are Even now.
    while (tree.size() > 0) {
      int num = tree.pollFirst();
      deviation = Math.min(num - lowest_in_pq, deviation);
      if (num % 2 == 0) {
        // Even
        tree.add(num / 2);
        lowest_in_pq = Math.min(lowest_in_pq, num / 2);
      } else {
        return deviation;
      }
    }
    return deviation;
  }

  public static int minimumDeviation_pq(int[] nums) {
    int l = nums.length;
    PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
    int deviation = Integer.MAX_VALUE;
    int lowest_val_in_nums = Integer.MAX_VALUE;
    int highest_val_in_nums = Integer.MIN_VALUE;
    int lowest_in_pq = Integer.MAX_VALUE;
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      lowest_val_in_nums = Math.min(lowest_val_in_nums, num);
      highest_val_in_nums = Math.max(highest_val_in_nums, num);
      if (num % 2 == 1) {
        //Odd
        pq.offer(num * 2);
        lowest_in_pq = Math.min(lowest_in_pq, num * 2);
      } else {
        //Even
        pq.offer(num);
        lowest_in_pq = Math.min(lowest_in_pq, num);
      }
    }
    // All number in PQ are Even now.
    while (pq.size() > 0) {
      int num = pq.poll();
      deviation = Math.min(num - lowest_in_pq, deviation);
      if (num % 2 == 0) {
        // Even
        pq.offer(num / 2);
        lowest_in_pq = Math.min(lowest_in_pq, num / 2);
      } else {
        return deviation;
      }
    }
    return deviation;
  }
}
