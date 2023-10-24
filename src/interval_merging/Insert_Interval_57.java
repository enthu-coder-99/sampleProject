package interval_merging;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval_57 {
  public static void main(String[] args) {
    int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] newInterval = new int[]{4, 8};
    Insert_Interval_57 obj = new Insert_Interval_57();
    int[][] ans = obj.insert(intervals, newInterval);
    System.out.println(ans.length);
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> list = new ArrayList();
    int l = intervals.length;
    int newInterval_s = newInterval[0];
    int newInterval_e = newInterval[1];
    int i = 0;

    for (; i < l; i++) {
      int[] interval = intervals[i];
      int start_i = interval[0];
      int end_i = interval[1];
      if (end_i < newInterval_s) {
        list.add(interval);
      } else {
        int new_start = Math.min(newInterval_s, start_i);
        int new_end = Math.max(newInterval_e, end_i);
        list.add(new int[]{new_start, new_end});
        break;
      }
    }

    for (; i < l; i++) {
      int[] interval_arry_i = intervals[i];
      int start_arry_i = interval_arry_i[0];
      int end_arry_i = interval_arry_i[1];

      int[] interval_i_list = list.get(list.size() - 1);
      int start_list_i = interval_i_list[0];
      int end_list_i = interval_i_list[1];

      if (start_arry_i > end_list_i) {
        list.add(interval_arry_i);
      } else {
        interval_i_list[1] = Math.max(end_arry_i, end_list_i);
      }
    }

    return list.toArray(new int[list.size()][]);
  }
}
