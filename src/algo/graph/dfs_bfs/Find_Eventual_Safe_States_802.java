package algo.graph.dfs_bfs;

import utils.CommonLogging;

import java.util.ArrayList;
import java.util.List;

public class Find_Eventual_Safe_States_802 {

  public static void main(String[] args) {
    int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};//2,4,5,6]
    new Find_Eventual_Safe_States_802().eventualSafeNodes(graph);
  }

  public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> res = new ArrayList<>();
    int l = graph.length;
    int[] visited = new int[l];
    //+1 SAFE , -1-UNSAFE/Cycle
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
