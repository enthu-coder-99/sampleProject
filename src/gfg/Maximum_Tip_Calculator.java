package gfg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Maximum_Tip_Calculator {

  public static void main(String[] args) {
    // Rahul = x , a
    // Ankit - y , b
    int n = 7, x = 3, y = 4;
    int a[] = {8, 7, 5, 9, 6, 6, 8};
    int b[] = {1, 7, 5, 1, 2, 3, 9};
    System.err.println(maxTip(a, b, n, x, y));
  }

  static long maxTip(int[] a, int[] b, int n, int x, int y) {
    // code here

    int l = a.length;
    long maxTip = 0L;
    PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[0] - o1[0];
      }
    }

    );
    for (int i = 0; i < a.length; i++) {
      pq.add(new int[]{Math.abs(a[i] - b[i]), i});
    }

    while (pq.size() > 0) {
      int[] diff = pq.poll();
      int tipDiff = diff[0];
      int index = diff[1];
      int rahulTip = a[index];
      int ankitTip = b[index];
      if (rahulTip > ankitTip) {
        if (x > 0) {
          maxTip = rahulTip + maxTip;
          x--;
        } else {
          maxTip = ankitTip + maxTip;
          y--;
        }
      } else {
        if (y > 0) {
          maxTip = ankitTip + maxTip;
          y--;
        } else {
          maxTip = rahulTip + maxTip;
          x--;
        }
      }
    }
    return maxTip;
  }
}
