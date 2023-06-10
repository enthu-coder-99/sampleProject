package algo.graph.Kruskal;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Min_Cost_to_Connect_All_Points_1584 {

  public static void main(String[] args) {
    int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    System.err.println(minCostConnectPoints(points));
  }

  // Revision 1
  public static int minCostConnectPoints_rev1(int[][] points) {
    int ans = 0;
    return ans;
  }

  // Working fine and first successful
  // Kruskal uses UnionMerge
  public static int minCostConnectPoints(int[][] points) {
    int ans = 0;
    int n = points.length;
    Comparator<int[]> adjacencyComparator = new Comparator<int[]>() {
      @Override
      public int compare(int[] left, int[] right) {
        return left[0] - right[0];
      }
    };

    PriorityQueue<int[]> edges_pq = new PriorityQueue(adjacencyComparator);
    for (int i = 0; i < n; i++) {
      int[] pt = points[i];
      int x = pt[0];
      int y = pt[1];
      for (int j = i + 1; j < n; j++) {
        int[] pt_neigh = points[j];
        int x_neigh = pt_neigh[0];
        int y_neigh = pt_neigh[1];
        int dist = Math.abs(x - x_neigh) + Math.abs(y - y_neigh);
        edges_pq.offer(new int[]{dist, i, j});
      }
    }

    System.err.println("edges_pq= " + edges_pq);
    UnionMerge unionM = new UnionMerge(n);
    int noOfEdgeRelaxed = 0;
    while (noOfEdgeRelaxed != n && edges_pq.size() > 0) {
      int[] edge = edges_pq.poll();
      int weight = edge[0];
      int fromPoint = edge[1];
      int toPoint = edge[2];
      if (unionM.merge(fromPoint, toPoint)) {
        ans = ans + weight;
        noOfEdgeRelaxed++;
      }
    }
    return ans;
  }
}
