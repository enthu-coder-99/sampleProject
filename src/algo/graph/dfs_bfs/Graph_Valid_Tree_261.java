package algo.graph.dfs_bfs;

import algo.graph.Kruskal.UnionMerge;
import algo.graph.util.AdjListUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph_Valid_Tree_261 {


  public boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjList = AdjListUtil.getAdjList(edges);
    if (edges.length != (n - 1)) return false;
    boolean ans = bfs(adjList, n);
    return ans;
  }

  private boolean bfs(Map<Integer, List<Integer>> adjList, int n) {

    Deque<int[]> deque = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    deque.add(new int[]{0, -1});// node, parent
    visited.add(0);
    while (deque.size() > 0) {
      int[] node_i = deque.poll();
      int node = node_i[0];
      int parent = node_i[1];
      List<Integer> neighbors = adjList.get(node);
      for (int neighbor : neighbors) {
        if (neighbor == parent) continue;
        if (visited.contains(neighbor)) return false;
        visited.add(neighbor);
        deque.add(new int[]{neighbor, node});// node, parent
      }
    }
    return visited.size() == n;
  }


  public boolean unionMerge(int[][] edges, int n) {
    UnionMerge um = new UnionMerge(n);
    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      if (!um.merge(from, to)) return false;
    }
    return true;
  }
}
