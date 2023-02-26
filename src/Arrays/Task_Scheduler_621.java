package Arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Task_Scheduler_621 {

  public static void main(String[] args) {
    System.err.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
  }

  /**
   * https://leetcode.com/problems/task-scheduler/discuss/104511/Java-Solution-PriorityQueue-and-HashMap
   *
   * @param tasks
   * @param n
   * @return
   */
  public static int leastInterval(char[] tasks, int n) {
    int length = tasks.length;
    if (length < 2 || n == 0) return length;
    int timeCycle = 0;
    Map<Integer, Integer> memoMap = new HashMap();
    for (int i = 0; i < length; i++) {
      int taskName = tasks[i];
      memoMap.put(taskName, memoMap.getOrDefault(taskName, 0) + 1);
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
      return (o2[0] - o1[0]);
    });
    for (int taskName : memoMap.keySet()) {
      priorityQueue.add(new int[]{memoMap.get(taskName), taskName});
    }

    LinkedHashMap<Integer, int[]> waitTaskMap = new LinkedHashMap();

    while (priorityQueue.size() > 0 || waitTaskMap.size() > 0) {
      if (waitTaskMap.containsKey(timeCycle)) {
        int[] taskInWaiting = waitTaskMap.remove(timeCycle);
        priorityQueue.add(new int[]{taskInWaiting[0], taskInWaiting[1]});
      }
      if (priorityQueue.size() > 0) {
        int[] task_pq = priorityQueue.poll();
        int task_count = task_pq[0];
        int task_name = task_pq[1];
        if (task_count > 1) {
          task_count--;
          waitTaskMap.put(timeCycle + n + 1, new int[]{task_count, task_name});
        }
      }
      timeCycle++;
    }

    return timeCycle;
  }
}
