package interval_merging;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals_435 {
  //https://www.youtube.com/watch?v=BTObFnHbD4U
  public int eraseOverlapIntervals(int[][] intervals) {
    int l = intervals.length;
    if (l <= 1) return 0;

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) return o1[1] - o2[1];
        return o1[0] - o2[0];
      }
    });

    int nonOverlappingCount = 0;
    int previousMatchingInterval = 0;
    for (int i = 1; i < l; i++) {
      int[] interval = intervals[i];
      int interval_start = interval[0];
      int interval_end = interval[1];
      int prev_end = intervals[previousMatchingInterval][1];
      if (interval_start >= prev_end) {
        // That means this interval will be part of Non-overlapping intervals.
        previousMatchingInterval = i;
      } else {
        nonOverlappingCount++;
        // So this interval is part of overlapping intervals. So we can either choose i_th interval or leftIndex_th interval. (whichever will end first so that chances are better for future interval to match/overlap)
        if (interval_end < prev_end) {
          previousMatchingInterval = i;
        }
      }
    }
    return nonOverlappingCount;
  }

/**
 * 10------20
 * 5--8
 * 15-25
 * 15-------35
 * 5----------------35
 * 25>10 && 20>15
 */
}
