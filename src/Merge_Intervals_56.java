import utils.CommonLogging;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Merge_Intervals_56 {

  public static void main(String[] args) {
    Deque deque = new ArrayDeque();
    deque.add("1");
    deque.add("2");
    deque.add("3");
    System.err.println(deque.poll());
    System.err.println(deque.poll());
    System.err.println(deque.poll());
    System.err.println(deque.poll());
    System.err.println(deque.poll());

    int[][] intervals = new int[9][2];
    intervals[0] = new int[]{7, 89};
    intervals[1] = new int[]{4, 88};
    intervals[2] = new int[]{8, 87};
    intervals[4] = new int[]{5, 6};
    intervals[5] = new int[]{2, 6};
    intervals[6] = new int[]{1, 6};
    intervals[7] = new int[]{3, 6};
    intervals[8] = new int[]{4, 6};
    intervals[3] = new int[]{2, 5};
    Arrays.sort(intervals, (arr1, arr2) -> {
      return ((arr1[0] - arr2[0]) == 0 ? arr1[1] - arr2[1] : (arr1[0] - arr2[0]));
    });
    for (int i = 0; i < intervals.length; i++) {
      int[] singleInterval = intervals[i];
      //System.err.println(singleInterval[0] + " : " + singleInterval[1]);
    }
    CommonLogging.printArray(merge(intervals));
  }

  public static int[][] merge(int[][] intervals) {
    if (intervals.length < 2)
      return intervals;

    List<int[]> output = new ArrayList<int[]>();
    Arrays.sort(intervals, (arr1, arr2) -> ((arr1[0] - arr2[0]) == 0 ? arr1[1] - arr2[1] : (arr1[0] - arr2[0])));
    output.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] lastInterval = output.get(output.size() - 1);
      int lastIntervalEnd = lastInterval[1];
      int[] currentInterval = intervals[i];
      int currentIntervalStart = currentInterval[0];
      if (lastIntervalEnd >= currentIntervalStart) {
        // Merge interval
        if(currentInterval[1] > lastInterval[1])
        lastInterval[1] = currentInterval[1];
      } else {
        //Insert this new interval
        output.add(currentInterval);
      }
    }
    return (int[][]) output.toArray(int[][]::new);
  }
}
