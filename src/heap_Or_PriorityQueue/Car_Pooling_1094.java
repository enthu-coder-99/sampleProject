package heap_Or_PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Car_Pooling_1094 {


  public static void main(String[] args) {
    Car_Pooling_1094 obj = new Car_Pooling_1094();
    int[][] input = new int[][]{{2, 1, 5}, {3, 3, 7}};

    input = new int[][]{{4, 3, 4}, {3, 2, 4}, {1, 8, 9}, {7, 2, 5}};

    int capacity = 14;
    boolean b = obj.carPooling(input, capacity);
    System.out.println("ANS = " + b);
  }

  /**
   * Easy and concise solution, Good for interview.
   */
  public boolean carPooling(int[][] trips, int capacity) {
    TreeMap<Integer, Integer> tripHistoryMap = new TreeMap<>();
    for (int[] trip : trips) {
      int pass = trip[0];
      int start = trip[1];
      int end = trip[2];
      tripHistoryMap.put(start, tripHistoryMap.getOrDefault(start, 0) + pass);
      tripHistoryMap.put(end, tripHistoryMap.getOrDefault(end, 0) - pass);
    }

    Set<Integer> keySet = tripHistoryMap.keySet();
    int totalPassengerBoarded = 0;
    for (int key : keySet) {
      totalPassengerBoarded = totalPassengerBoarded + tripHistoryMap.get(key);
      if (totalPassengerBoarded > capacity) return false;
    }
    return true;
  }

  /**
   * Solotion#1 an intuitive.
   */
  public boolean solution_with_priorityQueue(int[][] trips, int capacity) {
    int l = trips.length;

    Arrays.sort(trips,
      new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          if (o1[1] == o2[1])
            return o1[2] - o2[2];
          return o1[1] - o2[1];
        }
      }
    );

    PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];// Ending distance
      }
    });

    pq.add(new int[]{trips[0][0], trips[0][2]});
    int remainingCapacity = capacity - trips[0][0];

    for (int i = 1; i < l; i++) {
      int[] trip = trips[i];
      int trip_passengers = trip[0];
      int trip_Start = trip[1];
      int trip_end = trip[2];
      System.out.println("trip_passengers= " + trip_passengers + " : trip_Start=" + trip_Start + " : trip_end= " + trip_end + " : remainingCapacity = " + remainingCapacity + " : ");

      while (pq.size() > 0 && pq.peek()[1] <= trip_Start) {
        int[] endedTrip = pq.poll();
        remainingCapacity = remainingCapacity + endedTrip[0];
      }

      System.out.println("new remainingCapacity= " + remainingCapacity);
      remainingCapacity = remainingCapacity - trip_passengers;
      if (remainingCapacity < 0) return false;

      pq.add(new int[]{trip_passengers, trip_end});

    }
    return true;
  }
}
