package algo.graph.dfs_bfs;

import utils.CommonLogging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Find_Eventual_Safe_States_802 {

  public static void main(String[] args) {
    int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};//2,4,5,6]
    graph = new int[][]{{0}, {2, 3, 4}, {3, 4}, {0, 4}, {}};//[4]
    List<Integer> res = new Find_Eventual_Safe_States_802().eventualSafeNodes(graph);
    System.out.println("Res=" + res);
  }

  public List<Integer> eventualSafeNodes(int[][] graph) {

    List<Integer> res = new ArrayList<>();
    Map<Integer, Boolean> memo = new HashMap<>();// If key is a cyclic or not.
    int l = graph.length;
    for (int i = 0; i < l; i++) {
      Set<Integer> currentPath = new HashSet<>();
      currentPath.add(i);
      boolean isPartOfCycle = recursion(graph, i, currentPath, memo);
      System.out.println("Node=" + i + " is cyclic or not? Ans= " + isPartOfCycle);
      if (!isPartOfCycle)
        res.add(i);
    }
    return res;
  }


  private boolean recursion(int[][] graph, int start, Set<Integer> currentPath, Map<Integer, Boolean> memo) {
    if (memo.containsKey(start)) return memo.get(start);

    int[] neighs = graph[start];
    for (int neigh : neighs) {
      if (currentPath.contains(neigh)) {
        // It is a cyclic path
        return true;
      } else {
        currentPath.add(neigh);
        boolean isCyclic = recursion(graph, neigh, currentPath, memo);
        if (isCyclic) {
          memo.put(start, true);
        }
        currentPath.remove(neigh);
      }
    }

    if (!memo.containsKey(start))
      memo.put(start, false);
    return memo.get(start);
  }

  public List<Integer> eventualSafeNodes_workingfine_1(int[][] graph) {
    List<Integer> res = new ArrayList<>();
    int l = graph.length;
    int[] visited = new int[l];
    //+1 SAFE , -1-UNSAFE/Cycle 0-UnSeen
    for (int i = 0; i < l; i++) {
      boolean b = isCycle(graph, visited, i, i + "");
      System.err.println(i + " is cyclic = " + b);
      CommonLogging.printArray(visited);
      if (b) {
        visited[i] = -1;
      } else {
        visited[i] = 1;
        res.add(i);
      }
    }
    System.err.println("Result is--");
    CommonLogging.printList(res);
    return res;
  }

  private boolean isCycle(int[][] graph, int[] visited, int node, String trail) {
    System.err.println("node=" + node);
    CommonLogging.printArray("visited = ", visited);
    if (visited[node] != 0) return visited[node] == -1;
    visited[node] = -1;//Mark cyclic

    for (int child = 0; child < graph[node].length; child++) {
      String news = (trail + " > " + graph[node][child]);
      System.err.println(node + " and child = " + graph[node][child] + " and trail= " + news);
      if (isCycle(graph, visited, graph[node][child], news)) {
        visited[child] = -1;
        return true;
      }
    }
    System.err.println("Marking success and trail = " + trail + " and node=" + node);
    visited[node] = 1;
    return false;// Mark safe
  }
}
