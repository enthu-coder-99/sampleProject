package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Largest_Rectangle_in_Histogram_84 {

  public static void main(String[] args) {
    int[] heights = {2, 1, 5, 6, 2, 3};
    // heights = new int[]{4, 2};
    System.err.println(largestRectangleArea_priorityQueue(heights));
  }

  public static int largestRectangleArea_priorityQueue(int[] heights) {
    int l = heights.length;
    int[] leftToRight = new int[l];
    int[] rightToLeft = new int[l];
    PriorityQueue<int[]> pq = new PriorityQueue(
      (v1, v2) -> ((int[]) v2)[0] - ((int[]) v1)[0]
    );
    pq.offer(new int[]{heights[0], 0});
    for (int i = 1; i < l; i++) {
      int ht_i = heights[i];
      System.err.println("ht_i= " + ht_i + " and peek= " + (pq.size() > 0 ? ((int[]) pq.peek())[0] : "NULL"));
      while (pq.size() > 0 && ht_i < ((int[]) pq.peek())[0]) {
        System.err.println("pq.peek())[0] = " + ((int[]) pq.peek())[0]);
        int[] pastBiggerHt = pq.poll();
        int biggerHt = pastBiggerHt[0];
        int biggerHtIndex = pastBiggerHt[1];
        leftToRight[biggerHtIndex] = i - 1;
        System.err.println("leftToRight biggerHtIndex= " + biggerHtIndex + " and i=" + i);
      }
      pq.offer(new int[]{ht_i, i});
    }

    while (pq.size() > 0)
      leftToRight[((int[]) pq.poll())[1]] = l - 1;

    pq.offer(new int[]{heights[l - 1], l - 1});
    for (int j = l - 2; j >= 0; j--) {
      int ht_j = heights[j];
      System.err.println("ht_j= " + ht_j + " and peek= " + (pq.size() > 0 ? ((int[]) pq.peek())[0] : "NULL"));
      while (pq.size() > 0 && ht_j < pq.peek()[0]) {
        System.err.println("pq.peek())[0] = " + ((int[]) pq.peek())[0]);
        int[] pastBiggerHt = pq.poll();
        int biggerHt = pastBiggerHt[0];
        int biggerHtIndex = pastBiggerHt[1];
        rightToLeft[biggerHtIndex] = j + 1;
        System.err.println("rightToLeft biggerHtIndex= " + biggerHtIndex + " and =" + j);
      }
      pq.offer(new int[]{ht_j, j});

    }

    while (pq.size() > 0)
      rightToLeft[pq.poll()[1]] = 0;

    int largestRectArea = 0;
    for (int i = 0; i < heights.length; i++) {
      int ht_i = heights[i];
      int width_i = Math.abs(rightToLeft[i] - leftToRight[i]) + 1;
      System.out.println(i + "- height= " + ht_i + ",  leftToRight[i]= " + leftToRight[i] + ",   rightToLeft[i]= " + rightToLeft[i] + ", area= " + (ht_i * width_i));
      largestRectArea = Math.max(largestRectArea, ht_i * width_i);

    }
    return largestRectArea;
  }

  public static int largestRectangleArea_arrayDeque(int[] heights) {
    if (heights.length == 0)
      return 0;
    if (heights.length == 1)
      return heights[0];

    Deque<Integer> increasingHeightStackTORight = new ArrayDeque<>();// All indexes in this stack will have increasing height order.
    // If any valie height is higher than current index height  than will pop that value because we can not extend that height anymore.
    int l = heights.length;
    int[] boundryWallIndexToRightSide = new int[l];
    boundryWallIndexToRightSide[l - 1] = l - 1;
    increasingHeightStackTORight.push(0);
    for (int i = 1; i < heights.length; i++) {
      int height = heights[i];
      while (increasingHeightStackTORight.size() > 0 && heights[increasingHeightStackTORight.peek()] > height) {
        int lastBiggerHeightIndex = increasingHeightStackTORight.pop();
        boundryWallIndexToRightSide[lastBiggerHeightIndex] = i - 1;
      }
      increasingHeightStackTORight.push(i);
    }
    System.err.println("0-" + Arrays.toString(boundryWallIndexToRightSide));

    while (increasingHeightStackTORight.size() > 0) {
      int lastBiggerHeightIndex = increasingHeightStackTORight.pop();
      boundryWallIndexToRightSide[lastBiggerHeightIndex] = l - 1;
    }
    System.err.println("1-" + Arrays.toString(boundryWallIndexToRightSide));

    Deque<Integer> increasingHeightStackTOLeft = new ArrayDeque<>();// All indexes in this stack will have increaing height order.
    int[] boundryWallIndexToLeftSide = new int[l];
    boundryWallIndexToLeftSide[0] = 0;
    increasingHeightStackTOLeft.push(l - 1);

    for (int j = l - 2; j >= 0; j--) {
      int height = heights[j];
      while (increasingHeightStackTOLeft.size() > 0 && heights[increasingHeightStackTOLeft.peek()] > height) {
        int lastBiggerHeightIndex = increasingHeightStackTOLeft.pop();
        boundryWallIndexToLeftSide[lastBiggerHeightIndex] = j + 1;
      }
      increasingHeightStackTOLeft.push(j);
    }

    System.err.println("2-" + Arrays.toString(boundryWallIndexToLeftSide));
    int maxRectArea = 0;
    for (int k = 0; k < l; k++) {
      int height = heights[k];
      maxRectArea = Math.max(maxRectArea, ((boundryWallIndexToRightSide[k] - boundryWallIndexToLeftSide[k]) + 1) * height);
    }
    return maxRectArea;
  }
}
