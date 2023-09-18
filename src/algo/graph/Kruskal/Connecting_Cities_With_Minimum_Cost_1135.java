package algo.graph.Kruskal;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Connecting_Cities_With_Minimum_Cost_1135 {

  public int minimumCost(int n, int[][] connections) {


    int l = connections.length;
    if (l < n - 1) return -1;
    PriorityQueue<int[]> pq = new PriorityQueue(
      new Comparator<int[]>() {
        @Override
        public int compare(int[] e1, int[] e2) {
          return e1[0] - e2[0];
        }
      }
    );

    UnionMerge um = new UnionMerge(n + 1);
    for (int i = 0; i < l; i++) {
      pq.add(new int[]{connections[i][2], connections[i][0], connections[i][1]});

    }
    int ans = 0;
    int edgeRelaxed = 0;
    while (pq.size() > 0) {
      int[] edge = pq.poll();
      int dist = edge[0];
      int v1 = edge[1];
      int v2 = edge[2];
      //System.out.println("dist="+ dist+", v1="+v1+", v2="+v2);
      if (um.merge(v1, v2)) {
        ans += dist;
        edgeRelaxed++;
        if (edgeRelaxed == n - 1) return ans;
      }
    }
    return -1;
  }
}
