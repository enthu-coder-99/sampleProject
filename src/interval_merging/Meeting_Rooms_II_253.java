package interval_merging;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Meeting_Rooms_II_253 {
  // Concise solution

  public int minMeetingRooms_sol2(int[][] intervals) {
    TreeMap<Integer, Integer> meetingHistMap = new TreeMap<>();


    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];
      meetingHistMap.put(start, meetingHistMap.getOrDefault(start, 0) + 1);
      meetingHistMap.put(end, meetingHistMap.getOrDefault(end, 0) - 1);
    }
    int maxMeetingRoomNeeded = 1;
    int meetingRoomsAreOccupied = 1;
    Set<Integer> keySet = meetingHistMap.keySet();
    for (int key : keySet) {
      meetingRoomsAreOccupied = meetingRoomsAreOccupied + meetingHistMap.get(key);
      maxMeetingRoomNeeded = Math.max(maxMeetingRoomNeeded, meetingRoomsAreOccupied);
    }
    return maxMeetingRoomNeeded;
  }


  /**
   * Intuitive solution
   */
  public int minMeetingRooms_sol1(int[][] intervals) {
    Arrays.sort(intervals, (o1, o2) -> {
      if (o1[0] == o2[0]) return o1[1] - o2[1];
      return o1[0] - o2[0];
    });
    int ans = 1;
    PriorityQueue<Integer> pq = new PriorityQueue();//Min Heap
    pq.add(intervals[0][1]); //Enter first meeting end time.

    for (int i = 1; i < intervals.length; i++) {
      int start_i = intervals[i][0];
      int end_i = intervals[i][1];
      while (pq.size() > 0 && pq.peek() <= start_i) pq.poll();
      pq.add(end_i);
      ans = Math.max(ans, pq.size());
    }
    return ans;
  }
}
