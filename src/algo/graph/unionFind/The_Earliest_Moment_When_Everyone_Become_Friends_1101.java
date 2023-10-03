package algo.graph.unionFind;

import java.util.Arrays;
import java.util.Comparator;

public class The_Earliest_Moment_When_Everyone_Become_Friends_1101 {

  public static void main(String[] args) {

    Integer l = Integer.valueOf("0000434");
    System.err.println(l);
    int[] arry_ints = new int[10];
    int arry_ints_len = arry_ints.length;
    for (int i = 1; i < arry_ints_len; i++) {
      arry_ints[i] = arry_ints[i - 1] + 1;
    }
    int[] w = {1, 3, 4, 2, 5};
    Arrays.sort(w);

    for (int i = 1; i < arry_ints_len; i++) {
      arry_ints[i] = arry_ints[i - 1] + 1;
    }

    String arrayStr = Arrays.toString(arry_ints);
    System.out.println(arrayStr);
    System.out.println(arry_ints[1]);

  }

  public int earliestAcq(int[][] logs, int n) {
    UnionFindTemplate um = new UnionFindTemplate(n);
    int l = logs.length;
    Arrays.sort(logs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    int edgeConnected = 0;
    for (int i = 0; i < l; i++) {
      int[] log = logs[i];
      int time = log[0];
      int from = log[1];
      int to = log[2];
      if (um.merge(from, to)) {
        edgeConnected++;
        if (edgeConnected >= n - 1) return time;
      }
    }
    return -1;
  }
}
