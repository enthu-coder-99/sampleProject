package interval_merging;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_of_Arrows_to_Burst_Balloons_452 {

  public static void main(String[] args) {
    Minimum_Number_of_Arrows_to_Burst_Balloons_452 obj = new Minimum_Number_of_Arrows_to_Burst_Balloons_452();
    int[][] points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
    int ans = obj.findMinArrowShots(points);
    System.out.println("ANS= " + ans);
  }

  public int findMinArrowShots(int[][] points) {
    int ans = 0;
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0])
          return o1[1] > o2[1] ? 1 : -1;
        return o1[0] > o2[0] ? 1 : -1;
      }
    });

    int l = points.length;
    int offset = points[0][0];

    for (int i = 0; i < l; i++) {
      int[] interval_i = points[i];
      int start_i = interval_i[0];
      int end_i = interval_i[1];
      for (int j = i + 1; j < l; j++) {
        int[] interval_j = points[j];
        int start_j = interval_j[0];
        int end_j = interval_j[1];
        if (start_j <= end_i) {
          i++;
          end_i =Math.min(end_i, end_j);
        } else {
          break;
        }
      }
      ans++;
    }
    return ans;
  }
}
