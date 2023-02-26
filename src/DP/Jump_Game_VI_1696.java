package DP;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Jump_Game_VI_1696 {

  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    pq.offer(23);
    pq.offer(1);
    pq.offer(7);
    pq.offer(3);
    pq.offer(6);
    pq.offer(5);
    pq.offer(10);
    pq.offer(1);
    pq.offer(2);
    pq.offer(3);
    pq.offer(19);
    pq.offer(15);
    pq.offer(15);
    pq.offer(15);
    pq.offer(13);
    pq.offer(1);
    pq.remove(19);
    System.err.println(maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));//7,6,5,7,-4,3

  }

  public static int maxResult(int[] nums, int k) {
    Deque<Integer> queue = new ArrayDeque<>();
    int[] dp = new int[nums.length];
    dp[nums.length - 1] = nums[nums.length - 1];
    queue.add(nums.length - 1);
    for (int i = nums.length - 2; i >= 0; i--) {
      int num = nums[i];
      int maxJumpIndexFromI = i + k;// Including Kth index.
      while (queue.size() > 0 && queue.peekFirst() > maxJumpIndexFromI) {
        queue.removeFirst();
      }
      dp[i] = num + dp[queue.peek()];
      System.err.println(i + " dp[i]=" + dp[i] + " and dq.peek()=" + dp[queue.peek()]);
      while (queue.size() > 0 && dp[queue.peekLast()] < dp[i]) {
        // Keep on deleting from last until dp[i] can be eligible for any future processing.
        queue.pollLast();
      }
      queue.add(i);
    }
    return dp[0];
  }

}


