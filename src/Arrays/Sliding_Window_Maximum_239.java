package Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class Sliding_Window_Maximum_239 {

  public static void main(String[] args) {
    int[] resultInts = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    Arrays.stream(resultInts).forEach(e -> System.out.print(e + ","));
  }

  public static int[] maxSlidingWindow(int[] nums, int k) {
    int length = nums.length;
    int leftIndex = 0;
    // Make a PrioryQueue manually and maintain it... If any number is
    Deque<Integer> queue = new ArrayDeque();
    int[] resultList = new int[length - k + 1];
    for (; leftIndex < k - 1; leftIndex++) {
      addInQueue(nums, queue, leftIndex, k);
    }
    int j = 0;
    for (; leftIndex < length; leftIndex++) {
      // 0 1 2 3 4
      while (queue.size() > 0 && (leftIndex - k) >= 0 && queue.peek() <= (leftIndex - k)) {
        queue.poll();
      }
      addInQueue(nums, queue, leftIndex, k);
      resultList[j++] = (nums[queue.peek()]);
    }
    return resultList;
  }

  private static void addInQueue(int[] nums, Deque<Integer> queue, int index, int k) {

    while (queue.size() > 0 && nums[queue.peekLast()] < nums[index])
      queue.pollLast();
    queue.add(index);
  }

  private static String getQueueElements(Queue q) {
    StringBuilder sb = new StringBuilder();
    Iterator iterator = q.iterator();
    while (iterator.hasNext())
      sb.append(iterator.next() + ",");
    return sb.toString();
  }
}
