package gfg.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Height_by_Stacking_Cuboids_1691 {

  public int maxHeight(int[][] cuboids) {
    int l = cuboids.length;
    for (int[] c : cuboids) Arrays.sort(c);
    Arrays.sort(cuboids, new Comparator<int[]>() {

      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] != o2[0])
          return o1[0] - o2[0];
        if (o1[1] != o2[1])
          return o1[1] - o2[1];
        return o1[2] - o2[2];
      }
    });

    int maxH = 0;
    int[] dp = new int[l];
    for (int i = l - 1; i >= 0; i--) {
      int[] cuboids_i = cuboids[i];
      int height_i = cuboids_i[2];
      dp[i] = height_i;//height

      for (int j = i + 1; j < l; j++) {
        int[] cuboids_j = cuboids[j];
        if (cuboids_i[0] <= cuboids_j[0] && cuboids_i[1] <= cuboids_j[1]
          && cuboids_i[2] <= cuboids_j[2]) {
          dp[i] = Math.max(dp[i], height_i + dp[j]);
        }
      }
      maxH = Math.max(dp[i], maxH);
    }
    return maxH;
  }
}
