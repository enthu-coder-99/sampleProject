package DP.jump_games;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Jump_Game_VI_1696 {

  public static void main(String[] args) {

    String[] strArray = new String[]{"Ram", null, null, "Lux", "Bha", "Shat", null, null, null, null, null, "Drass"};
    int length = strArray.length;
    int nullCount = 0;
    int notNullCount = 0;

   /* for (int i = 0; i < length; i++) {
      String str = strArray[i];
      System.out.println("indx= " + i + ", str= " + str);
      if (str == null)
        nullCount++;

      if (str != null) {
        notNullCount++;
      }
    }

    System.out.println("nullCount= " + nullCount);
    System.out.println("notNullCount= " + notNullCount);*/

    int firstIndexValueIsNull = 0;
    for (int i = 0; i < length; i++) {
      String str = strArray[i];
      System.out.println("indx= " + i + ", str= " + str);
      if (str == null) {
        firstIndexValueIsNull = i;
        i = length;
      }
    }

    System.out.println("firstIndexValueIsNull= " + firstIndexValueIsNull);
  }

  // Working fine
  public int maxResult_With_priorityQueue(int[] nums, int k) {
    int l = nums.length;
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0])
          return o2[1] - o1[1];
        return o2[0] - o1[0];
      }
    });
    int[] dp = new int[l];
    dp[l - 1] = nums[l - 1];

    pq.offer(new int[]{nums[l - 1], l - 1});
    for (int i = l - 2; i >= 0; i--) {
      int num = nums[i];
      int atMostIndexReached = i + k;
      while (pq.size() > 0 && pq.peek()[1] > atMostIndexReached) {
        pq.poll();
      }
      if (pq.size() > 0)
        dp[i] = num + pq.peek()[0];
      pq.offer(new int[]{dp[i], i});
    }
    return dp[0];
  }

  // Working fine
  public int maxResult_With_SimpleQueue(int[] nums, int k) {
    int l = nums.length;
    Deque<Integer> deque = new ArrayDeque<>();// Push indexes of DP
    int[] dp = new int[l];
    dp[l - 1] = nums[l - 1];
    deque.offer(l - 1);

    for (int i = l - 2; i >= 0; i--) {
      int num = nums[i];
      int atMostIndexReached = i + k;
      dp[i] = num + dp[deque.peek()];
      while (deque.size() > 0 && deque.peek() > atMostIndexReached) {
        deque.poll();
      }

      while (deque.size() > 0 && dp[deque.peekLast()] <= dp[i]) {
        deque.pollLast();
      }
      deque.offer(i);
    }
    return dp[0];
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


