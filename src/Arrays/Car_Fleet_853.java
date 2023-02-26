package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Car_Fleet_853 {

  public static void main(String[] args) {
    int target = 10;
    int[] positions = {6, 8};
    int[] speeds = {3, 2};

    System.err.println(carFleet_heap_priorityQueue(target, positions, speeds));
  }

  public static int carFleet_heap_priorityQueue(int target, int[] position, int[] speed) {
    int l = position.length;
    PriorityQueue<double[]> pq = new PriorityQueue(
      (o1, o2) -> ((double[]) o2)[0] - ((double[]) o1)[0] > 0 ? 1 : -1
    );
    for (int i = 0; i < l; i++) {
      pq.offer(new double[]{position[i], (double)(target - position[i]) / speed[i]});
    }
    double lastCarTookTimeToReach = -1.0d;
    int fleetSize = 1;
    while (pq.size() > 0) {
      double[] car_pq = pq.poll();
      double position_Pq = car_pq[0];
      double timeTakenToReachDestination = car_pq[1];

      System.err.println(position_Pq + ": lastCarTookTimeToReach= " + lastCarTookTimeToReach);
      System.err.println(position_Pq + ": timeTakenToReachDestination= " + timeTakenToReachDestination);
      if (lastCarTookTimeToReach == -1.00d) {
        lastCarTookTimeToReach = timeTakenToReachDestination;
      } else {
        if (timeTakenToReachDestination > lastCarTookTimeToReach) {
          fleetSize++;
          lastCarTookTimeToReach = timeTakenToReachDestination;
        }
      }

    }
    return fleetSize;
  }

  public static int carFleet_treeSet(int target, int[] position, int[] speed) {
    if (position.length < 2) return position.length;

    int result = 0;
    //Sort positions in descending orders
    TreeMap<Integer, Integer> treeMap = new TreeMap(Comparator.reverseOrder());
    for (int i = 0; i < position.length; i++) {
      treeMap.put(position[i], speed[i]);
    }
    double timeToReachToTargetForCurrentFleet = 0.0d;
    Set<Integer> positonsSorted = treeMap.keySet();
    for (int pos : positonsSorted) {
      double timeToReachToTarget = (double) (target - pos) / treeMap.get(pos);
      System.err.println(pos + ": timeToReachToTarget= " + timeToReachToTarget);
      System.err.println(pos + ": timeToReachToTargetForCurrentFleet= " + timeToReachToTargetForCurrentFleet);

      if (timeToReachToTarget > timeToReachToTargetForCurrentFleet) {
        // i.e This "pos" has missed that current fleet  and will be part of next fleet.
        result++;
        timeToReachToTargetForCurrentFleet = timeToReachToTarget;
      }
    }
    return result;
  }
}
