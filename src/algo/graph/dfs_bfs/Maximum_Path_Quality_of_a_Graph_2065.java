package algo.graph.dfs_bfs;

import algo.graph.util.AdjListUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Maximum_Path_Quality_of_a_Graph_2065 {

  public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
    Map<Integer, Map<Integer, Integer>> adjListMap = AdjListUtil.getAdjWithWeight(edges, true);

    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(new int[]{0, 0, values[0]});
    int ans = 0;
    while (deque.size() > 0) {
      int[] nodeDetails = deque.poll();
      int node_i = nodeDetails[0];
      int localTimeTakenTillHere = nodeDetails[1];
      int localValueEarnedTillHere = nodeDetails[2];

      ans = Math.max(localValueEarnedTillHere, ans);

      if (!adjListMap.containsKey(node_i) || adjListMap.get(node_i).size() == 0) continue;
      Map<Integer, Integer> neighMap = adjListMap.get(node_i);
      for (int neigh_i : neighMap.keySet()) {
        Integer timeTakenFromSrcToNeigh = neighMap.get(neigh_i);
        int timeTakenTillHere = localTimeTakenTillHere + timeTakenFromSrcToNeigh;
        if (timeTakenTillHere > maxTime) continue;

        deque.add(new int[]{neigh_i, timeTakenTillHere, localValueEarnedTillHere + values[neigh_i]});
      }
    }
    return ans;
  }
}
