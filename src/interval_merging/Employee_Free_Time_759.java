package interval_merging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee_Free_Time_759 {

  public static void main(String[] args) {
    int[][][] inputArry = new int[][][]
      {{{7, 24}, {29, 33}, {45, 57}, {66, 69}, {94, 99}}, {{6, 24}, {43, 49}, {56, 59}, {61, 75}, {80, 81}}, {{5, 16}, {18, 26}, {33, 36}, {39, 57}, {65, 74}}, {{9, 16}, {27, 35}, {40, 55}, {68, 71}, {78, 81}}, {{0, 25}, {29, 31}, {40, 47}, {57, 87}, {91, 94}}};
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<int[]> intervalSortedArry = new ArrayList<>();

    for (int i = 0; i < schedule.size(); i++) {
      List<Interval> intervals = schedule.get(i);
      for (int j = 0; j < intervals.size(); j++) {
        Interval interval = intervals.get(j);
        int start = interval.start;
        int end = interval.end;
        intervalSortedArry.add(new int[]{start, end});
      }
    }

    Collections.sort(intervalSortedArry, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) return o1[1] - o2[1];
        return o1[0] - o2[0];
      }
    });

    List<Interval> answer = new ArrayList<>();
    int busyUntil = intervalSortedArry.get(0)[1];
    for (int i = 1; i < intervalSortedArry.size(); i++) {
      int[] interval_1 = intervalSortedArry.get(i - 1);
      int start_1 = interval_1[0];
      int end_1 = interval_1[1];

      int[] interval = intervalSortedArry.get(i);
      int start = interval[0];
      int end = interval[1];

      if (start > busyUntil) {
        answer.add(new Interval(busyUntil, start));
      }
      busyUntil = Math.max(busyUntil, end);
    }
    return answer;

  }

  private class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  }
}


