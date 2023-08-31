package maths;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Max_Points_on_a_Line_149 {


  public static void main(String[] args) {
    Max_Points_on_a_Line_149 obj = new Max_Points_on_a_Line_149();
    ThreadLocalRandom random = ThreadLocalRandom.current();
    random.ints(1, 100);
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));

    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));

    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));

    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));

    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));

    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));
    System.out.println(random.nextInt(1, 100));

    int[][] points = {{5, 3}, {1, 1}, {3, 2}, {4, 1}, {2, 3}, {1, 4}};
    System.out.println(obj.maxPoints(points));
  }

  public int maxPoints(int[][] points) {

    int l = points.length;
    int ans = 0;
    for (int i = 0; i < l; i++) {
      int[] point_i = points[i];
      System.out.println("i=" + i + ", x_i=" + point_i[0] + ", y_i=" + point_i[1]);
      Map<Float, Integer> slopeToCount = new HashMap();
      for (int j = 0; j < l; j++) {
        if (i == j) continue;
        int[] point_j = points[j];
        System.out.println("j=" + j + ", x_j=" + point_j[0] + ", y_j=" + point_j[1]);

        float slope = (point_j[0] == point_i[0]) ? Float.MAX_VALUE : (float) (point_j[1] - point_i[1]) / (point_j[0] - point_i[0]);
        System.out.println("Slope = " + slope);
        slopeToCount.put(slope, slopeToCount.getOrDefault(slope, 0) + 1);
        ans = Math.max(ans, slopeToCount.get(slope));
      }
      System.out.println(i + "-> " + slopeToCount);
    }
    return ans + 1;
  }
}
