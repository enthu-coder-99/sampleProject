package DP;

import java.util.Arrays;

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
    return recursion(events);
  }

  public int recursion(int[][] events) {
    int l = events.length;
    int ans = 1;
    int lastMeetingAttendedDay = events[0][0];
    for (int i = 1; i < l; i++) {
      int[] currEvent_i = events[i];
      int currEvent_start = currEvent_i[0];
      int currEvent_end = currEvent_i[1];
      if (lastMeetingAttendedDay < currEvent_start) {
        lastMeetingAttendedDay = currEvent_start;
        ans++;
      } else if (lastMeetingAttendedDay + 1 <= currEvent_end) {
        lastMeetingAttendedDay++;
        ans++;
      }
    }
    return ans;
  }
}
