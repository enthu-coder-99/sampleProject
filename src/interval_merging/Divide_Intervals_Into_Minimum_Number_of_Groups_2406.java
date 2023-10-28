package interval_merging;

import utils.CommonLogging;

import java.util.Arrays;
import java.util.Comparator;

public class Divide_Intervals_Into_Minimum_Number_of_Groups_2406 {

  public static void main(String[] args) {
    Divide_Intervals_Into_Minimum_Number_of_Groups_2406 obj = new Divide_Intervals_Into_Minimum_Number_of_Groups_2406();
    int[][] intervals = new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
    System.out.println(obj.minGroups(intervals));
  }

  public int minGroups(int[][] intervals) {
    int ans = 0;
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) return o1[1] - o2[1];
        return o1[0] - o2[0];
      }
    });

    int l = intervals.length;
    CommonLogging.printArray(intervals);

    for (int i = 0; i < l; i++) {
      int[] interval = intervals[i];
      int start_i = interval[0];
      int end_i = interval[1];
      int start_index = i;

      for (int j = i + 1; j < l; j++) {
        int[] interval_j = intervals[j];
        int start_j = interval_j[0];
        int end_j = interval_j[1];
        if (start_j >= end_i) {
          // Overlap interval
        } else {
          // if not overlap
          break;
        }
      }

      if (i > start_index) {
        ans = Math.max(ans, i - start_index + 1);
      }
    }
    return ans;
  }
}
