package Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class Sliding_Window_Maximum_239 {

  public static void main(String[] args) {
    Sliding_Window_Maximum_239 obj = new Sliding_Window_Maximum_239();
    int[] resultInts = obj.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    Arrays.stream(resultInts).forEach(e -> System.out.print(e + ","));
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k == 1) return nums;

    int l = nums.length;

    Deque<Integer> deque = new ArrayDeque<Integer>();

    for (int i = 0; i < k - 1; i++) {
      int num = nums[i];
      while (deque.size() > 0 && nums[deque.peek()] < num)
        deque.pop();
      deque.push(i);
    }

    int[] ans = new int[l - k + 1];
    int ans_idx = 0;
    for (int i = k - 1; i < l; i++) {
      int num = nums[i];
      int lastStartingIndexToConsiderForNum = i - k + 1;

      System.out.println("1- " + getQueueElements(deque, nums));

      while (deque.size() > 0 && deque.peekLast() < lastStartingIndexToConsiderForNum)
        deque.pollLast();
      System.out.println("2- " + getQueueElements(deque, nums));

      while (deque.size() > 0 && nums[deque.peek()] < num)
        deque.pop();
      System.out.println("F- " + getQueueElements(deque, nums));
      deque.push(i);
      ans[ans_idx++] = nums[deque.peekLast()];
    }
    return ans;
  }


  private static void addInQueue(int[] nums, Deque<Integer> queue, int index, int k) {

    while (queue.size() > 0 && nums[queue.peekLast()] < nums[index])
      queue.pollLast();
    queue.add(index);
  }

  private static String getQueueElements(Queue<Integer> q, int[] nums) {
    StringBuilder sb = new StringBuilder();
    Iterator<Integer> iterator = q.iterator();
    while (iterator.hasNext())
      sb.append(nums[iterator.next()] + ",");
    return sb.toString();
  }
}
