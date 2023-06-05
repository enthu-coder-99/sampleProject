package gfg.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class Box_Stacking {

  public static void main(String[] args) {
    int[] in = new int[]{3, 5, 11, 19, 24, 29};
    int a1 = Arrays.binarySearch(in, 1);
    System.out.println("a1= " + Arrays.binarySearch(in, 1));
    System.out.println("a1= " + Arrays.binarySearch(in, 4));
    System.out.println("a1= " + Arrays.binarySearch(in, 34));
    System.out.println("a1= " + Arrays.binarySearch(in, -1));
    System.out.println("a1= " + Arrays.binarySearch(in, 10));
    System.out.println("a1= " + Arrays.binarySearch(in, 20));
    System.out.println("a1= " + Arrays.binarySearch(in, 3));
    System.out.println("a1= " + Arrays.binarySearch(in, 11));
    System.out.println("a1= " + Arrays.binarySearch(in, 29));


    int height[] = {4, 1, 4, 10};
    int width[] = {6, 2, 5, 12};
    int length[] = {7, 3, 6, 32};
    System.err.println(maxHeight(height, width, length, 4));
  }

  public static int maxHeight(int[] height, int[] width, int[] length, int n) {
    Box[] boxes = new Box[3 * n];
    int j = 0;
    for (int i = 0; i < n; i++) {
      /* New Array of boxes is created -
        considering all 3 possible rotations,
        with width always greater than equal
        to width */
      /* Original Box*/
      boxes[j++] = new Box(height[i], Math.max(width[i], length[i]), Math.min(width[i], length[i]));
      /* First rotation of box*/
      boxes[j++] = new Box(width[i], Math.max(length[i], height[i]), Math.min(length[i], height[i]));
      /* Second rotation of box*/
      boxes[j++] = new Box(length[i], Math.max(height[i], width[i]), Math.min(height[i], width[i]));
    }

    System.out.println("Before sorting ==  " + Arrays.toString(boxes));

    Arrays.sort(boxes, new Comparator<Box>() {
      @Override
      public int compare(Box b1, Box b2) {
        if (b1.w == b2.w) {
          return b1.d - b2.d;
        }
        return b1.w - b2.w;
      }
    });
    return maxStackHeight(boxes, n);
  }

  /* Returns the height of the tallest
  stack that can be formed with give
  type of boxes */
  static int maxStackHeight(Box boxes[], int n) {

    System.out.println("After sorting ==  " + Arrays.toString(boxes));
    int count = 3 * n;

        /* Initialize msh values for all
        indexes
        msh[i] --> Maximum possible Stack Height
                   with box i on top */
    int[] dp = new int[count];

         /*
         for (int i = 0; i < count; i++ )
            msh[i] = rot[i].h;

        Computing optimized msh[]
        values in bottom up manner */
    int max = -1;

    for (int i = count - 1; i >= 0; i--) {
      Box box = boxes[i];
      dp[i] = box.h;
      int val = 0;

      for (int j = i + 1; j < count; j++) {
        Box Box_j = boxes[j];
        if ((Box_j.w > box.w && Box_j.d > box.d)) {
          val = Math.max(val, dp[j]);
        } else {
        }
      }
      dp[i] = val + box.h;
      max = Math.max(max, dp[i]);
      System.out.println(i + "--  dp[i] = " + dp[i] + " , max = " + max);
    }
    System.err.println(Arrays.toString(dp));
    return max;
  }


  /* Representation of a box */
  static class Box {

    // h --> height, w --> width,
    // d --> depth
    int h, w, d;

    // for simplicity of solution,
    // always keep w <= d

    /*Constructor to initialise object*/
    public Box(int h, int w, int d) {
      this.h = h;
      this.w = w;
      this.d = d;
    }

    @Override
    public String toString() {
      String st = "Box{" +
        "h=" + h +
        ", w=" + w +
        ", d=" + d +
        "}, ";
      return st;
    }
  }
}
