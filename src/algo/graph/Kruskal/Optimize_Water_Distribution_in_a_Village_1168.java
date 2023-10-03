package algo.graph.Kruskal;

import algo.graph.util.AdjListUtil;

import java.util.PriorityQueue;

public class Optimize_Water_Distribution_in_a_Village_1168 {

  public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

    return sol1(n, wells, pipes);
  }

  public int sol1(int n, int[] wells, int[][] pipes) {
    PriorityQueue<int[]> pq = AdjListUtil.getPQ(0);
    for (int[] pipe : pipes) {
      pq.add(pipe);
    }
    int well_index = n + 1;
    int i = 1;
    for (int well : wells) {
      pq.add(new int[]{i, well_index, well});
      i++;
    }

    UnionMerge um = new UnionMerge(n + 2);
    int total_vertex_relaxed = 0;
    int ans = 0;
    while (total_vertex_relaxed < (n + 1) && pq.size() > 0) {
      int[] resource = pq.poll();
      int from = resource[0];
      int to = resource[1];
      int cost = resource[2];
      if (um.merge(from, to)) {
        ans = ans + cost;
        total_vertex_relaxed++;
      }
    }
    return ans;
  }

  public int sol2(int n, int[] wells, int[][] pipes) {
    PriorityQueue<int[]> pq = AdjListUtil.getPQ(0);
    for (int[] pipe : pipes) {
      pq.add(pipe);
    }
    int well_index = n + 1;
    int i = 1;
    for (int well : wells) {
      pq.add(new int[]{i, well_index, well});
      i++;
    }

    UnionMerge um = new UnionMerge(n + 2);
    int total_vertex_relaxed = 0;
    int ans = 0;
    while (total_vertex_relaxed < (n + 1) && pq.size() > 0) {
      int[] resource = pq.poll();
      int from = resource[0];
      int to = resource[1];
      int cost = resource[2];
      if (um.merge(from, to)) {
        ans = ans + cost;
        total_vertex_relaxed++;
      }
    }
    return ans;
  }
}