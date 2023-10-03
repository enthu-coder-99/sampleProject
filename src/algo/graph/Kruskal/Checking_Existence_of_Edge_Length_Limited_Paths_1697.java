package algo.graph.Kruskal;

import algo.graph.util.AdjListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Checking_Existence_of_Edge_Length_Limited_Paths_1697 {

  public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
    int l_queries = queries.length;
    boolean[] ans = new boolean[l_queries];
    int[][] queries_with_index = new int[l_queries][];
    for (int i = 0; i < l_queries; i++) {
      int[] query = queries[i];
      queries_with_index[i] = new int[]{query[0], query[1], query[2], i};
    }

    //Sort Queries
    Arrays.sort(queries_with_index, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return i1[2] - i2[2];
      }
    });

    PriorityQueue<int[]> pq = AdjListUtil.getPQ(2);
    // Sort Edges
    for (int i = 0; i < edgeList.length; i++) {
      int[] edge = edgeList[i];
      pq.add(edge);
    }

    UnionMerge um = new UnionMerge(n + 1);
    for (int i = 0; i < l_queries; i++) {

      int query_from = queries_with_index[i][0];
      int query_to = queries_with_index[i][1];
      int query_weight = queries_with_index[i][2];
      int query_index = queries_with_index[i][3];
      while (pq.size()>0 && pq.peek()[2] < query_weight) {
        int[] edge = pq.poll();
        int from = edge[0];
        int to = edge[1];
        um.merge(from, to);
      }
      if (um.isAlreadyConnected(query_from, query_to)) {
        ans[query_index] = true;
      }else
      ans[query_index] = false;

    }
    return ans;
  }

}
