package interval_merging;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Divide_Intervals_Into_Minimum_Number_of_Groups_2406 {

  public static void main(String[] args) {
    Divide_Intervals_Into_Minimum_Number_of_Groups_2406 obj = new Divide_Intervals_Into_Minimum_Number_of_Groups_2406();
    int[][] intervals = new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
    System.out.println(obj.minGroups(intervals));
  }

  // Exactly same as Meetings Room - II
  public int minGroups(int[][] intervals) {
    return minMeetingRooms(intervals);
  }

  public int minMeetingRooms(int[][] intervals) {
    PriorityQueue<Integer> pq = new PriorityQueue();

    Comparator<int[]> comp = new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0])
          return o1[1] - o2[1];
        return o1[0] - o2[0];
      }
    };
    Arrays.sort(intervals, comp);

    int ans = 0;
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];

      while (pq.size() > 0 && pq.peek() < interval[0]) pq.poll();
      pq.offer(interval[1]);
      ans = Math.max(pq.size(), ans);
    }
    return ans;

  }
}
