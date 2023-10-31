package interval_merging;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Number_of_Events_That_Can_Be_Attended_1353 {
  public static void main(String[] args) {
    Maximum_Number_of_Events_That_Can_Be_Attended_1353 obj = new Maximum_Number_of_Events_That_Can_Be_Attended_1353();
    int[][] input = new int[][]{{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}};
    System.out.println(obj.maxEvents(input));
  }

  public int maxEvents(int[][] events) {
    Arrays.sort(events, (e1, e2) -> {
      if (e1[0] == e2[0])
        return e1[1] - e2[1];
      return e1[0] - e2[0];
    });
    return calculate(events);
  }

  public int calculate(int[][] events) {
    int l = events.length;
    int ans = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int day = 0;
    int event_i = 0;

    while (true) {
      // remove the expired events.
      while (pq.size() > 0 && pq.peek() < day) {
        pq.poll();
      }

      while (event_i < l && events[event_i][0] == day) {
        pq.offer(events[event_i][1]);// Insert Event end date to PQ so that we can attend the event which is going to end sooner.
        event_i++;
      }

      if (pq.size() > 0) {
        // Attend this event today
        pq.poll();
        ans++;
      }
      day++;
      if (pq.size() == 0 && event_i >= l)
        break;
    }
    return ans;
  }
}
