package algo.graph.dfs_bfs;

import algo.graph.util.AdjListUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Find_if_Path_Exists_in_Graph_1971 {

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    Map<Integer, List<Integer>> adjList = AdjListUtil.getAdjList(edges);
    Set<Integer> visited = new HashSet<>();
    visited.add(source);
    return dfs(source, destination, visited, adjList);
  }

  public boolean dfs(int source, int target, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {

    if (source == target) return true;
    if (!adjList.containsKey(source) || adjList.get(source).size() == 0) return false;
    List<Integer> neighs = adjList.get(source);
    for (int neigh : neighs) {
      visited.add(neigh);
      if (dfs(neigh, target, visited, adjList)) return true;
      visited.remove(neigh);
    }

    return false;

  }


}
