package algo.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Reach_Nodes_In_Subdivided_Graph_882 {

  public int reachableNodes(int[][] edges, int maxMoves, int n) {
    int ans = 0;
    Map<Integer, Map<Integer, Integer>> adjMap = buildAdjMap(edges);
    Set<Integer> visited = new HashSet<>();
    Deque<int[]> deque = new ArrayDeque();
    deque.add(new int[]{0, maxMoves});
    while (deque.size() > 0) {
      int[] deque_elm = deque.poll();
      int node = deque_elm[0];
      if (visited.contains(node)) continue;
      visited.add(node);
      int distLeft = deque_elm[1];
      if (distLeft <= 0) continue;
      if (!adjMap.containsKey(node)) continue;
      Map<Integer, Integer> integerIntegerMap = adjMap.get(node);

    }
    return 0;
  }

  public Map<Integer, Map<Integer, Integer>> buildAdjMap(int[][] edges) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      int wt = edge[2];
      if (!map.containsKey(from)) map.put(from, new HashMap<>());
      if (!map.containsKey(to)) map.put(to, new HashMap<>());
      map.get(from).put(to, wt);
      map.get(to).put(from, wt);
    }
    return map;
  }
}
