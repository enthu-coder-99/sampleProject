package interval_merging;

import java.util.ArrayList;
import java.util.List;

/**
 * start1---------end1
 * start2----------e2
 */
public class Interval_List_Intersections_986 {

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

    int l1 = firstList.length;
    int l2 = secondList.length;
    int i1 = 0;
    int i2 = 0;
    List<int[]> ans = new ArrayList<>();

    while (true) {
      if (i1 >= l1 || i2 >= l2) break;
      int[] interval1 = firstList[i1];
      int start1 = interval1[0];
      int end1 = interval1[1];

      int[] interval2 = secondList[i2];
      int start2 = interval2[0];
      int end2 = interval2[1];

      if ((start1 <= end2 && start2 <= start1) || (start2 <= end1 && start1 <= start2)) {
        ans.add(new int[]{Math.max(start1, start2), Math.min(end1, end2)});
      }

      if (end1 > end2) {
        i2++;
      } else if (end2 > end1) {
        i1++;
      } else {
        i1++;
        i2++;
      }
    }

    return ans.toArray(new int[ans.size()][]);
  }
}
