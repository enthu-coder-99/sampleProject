package Arrays;

public class Largest_Rectangle_in_Histogram_84 {

  public static void main(String[] args) {
    int[] //heights = {2, 1, 5, 6, 2, 3};
    heights = new int[]{1, 1};
    System.err.println(largestRectangleArea_sol1(heights));
  }

  public static int largestRectangleArea_sol1(int[] heights) {
    int l = heights.length;
    int result = 0;

    int[] lowerValueIndexBeforeMe = new int[l];
    int[] lowerValueIndexAfterMe = new int[l];
    lowerValueIndexAfterMe[l - 1] = l;
    lowerValueIndexBeforeMe[0] = -1;

    for (int i = 1; i < l; i++) {
      int height = heights[i];
      int j = i - 1;
      while (j >= 0 && height <= heights[j]) {
        j = lowerValueIndexBeforeMe[j];
      }
      lowerValueIndexBeforeMe[i] = j;
    }

    for (int i = l - 2; i >= 0; i--) {
      int height = heights[i];
      int j = i + 1;
      while (j < l && height <= heights[j]) {
        j = lowerValueIndexAfterMe[j];
      }
      lowerValueIndexAfterMe[i] = j;
    }

    for (int i = 0; i < l; i++) {
      int height = heights[i];
      int minIndexOnLeft = lowerValueIndexBeforeMe[i] < 0 ? -1 : lowerValueIndexBeforeMe[i];
      int minIndexOnRight = lowerValueIndexAfterMe[i] > l - 1 ? (l) : lowerValueIndexAfterMe[i];
      int localMaxArea = (minIndexOnRight - minIndexOnLeft - 1) * height;
      result = Math.max(result, Math.max(height, localMaxArea));
      System.err.println(i + " and localMaxArea=" + localMaxArea + " final result=" + result);

    }
    return result;
  }
}
