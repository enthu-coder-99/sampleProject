package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Longest_Cycle_in_a_Graph_2360 {

  Map<Integer, Integer> map;
  int[] indegreeNode;

  public static void main(String[] args) {
    Longest_Cycle_in_a_Graph_2360 obj = new Longest_Cycle_in_a_Graph_2360();
    int[] input = new int[]{3, 3, 4, 2, 3};
    // input = new int[]{-1, 4, -1, 2, 0, 4};
    System.err.println(obj.longestCycle(input));
  }

  public int longestCycle(int[] edges) {
    int result = -1;
    int n = edges.length;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      int result_loc = dfs(edges, i, new HashMap(), visited, 0);
      System.out.println("i=" + i + ", result_loc=" + result_loc);
      result = Math.max(result, result_loc);
    }
    return result;
  }

  public int dfs(int[] edges, int start, Map<Integer, Integer> distance,
                 boolean[] visited, int dist) {

    System.out.println("start = " + start + ", dist= " + dist + ", distance= " + distance + " , visited=" + visited);
    if (distance.containsKey(start))// This check should come first before visited check otherwise this method will always return -1.
      return dist - distance.get(start);
    distance.put(start, dist);

    if (visited[start]) return -1;
    visited[start] = true;

    return dfs(edges, edges[start], distance, visited, dist + 1);

  }

  public int longestCycle1(int[] edges) {
    int n = edges.length;
    buildAdjList(edges);
    List<Integer> zeroInDegreeNodeList = getZeroInDegreeNodes();
    if (zeroInDegreeNodeList.size() == 0)
      return n;
    int result = -1;
    Deque<int[]> deque = new ArrayDeque();
    for (int node_index : zeroInDegreeNodeList)
      deque.add(new int[]{node_index, 0});
    boolean[] visited = new boolean[n];
    Map<Integer, Integer> nodeDistanceFromStarting = new HashMap();
    while (deque.size() > 0) {
      int[] nodesPoll = deque.poll();
      int nodeNum = nodesPoll[0];//
      int nodeDistance = nodesPoll[1];
      System.err.println("nodeNum=" + nodeNum + ", nodeDistance= " + nodeDistance);
      if (nodeDistanceFromStarting.containsKey(nodeNum)) {
        int duplicateNodeDistance = nodeDistanceFromStarting.get(nodeNum);
        int dist = nodeDistance - duplicateNodeDistance;
        if (dist != 0)
          result = Math.max(result, dist);
        System.err.println("result=" + result);
      } else {
        nodeDistanceFromStarting.put(nodeNum, nodeDistance);
        if (map.containsKey(nodeNum)) {
          deque.add(new int[]{map.get(nodeNum), nodeDistance + 1});
        }
      }
    }
    return result;
  }

  public Map<Integer, Integer> buildAdjList(int[] edges) {
    int n = edges.length;
    map = new HashMap();
    indegreeNode = new int[n];

    for (int i = 0; i < n; i++) {
      int to = edges[i];
      if (to < 0) continue;
      int from = i;
      map.put(from, to);
      indegreeNode[to]++;
    }
    return map;
  }

  public List<Integer> getZeroInDegreeNodes() {
    List<Integer> zeroInDegreeNodeList = new ArrayList();
    for (int i = 0; i < indegreeNode.length; i++) {
      if (indegreeNode[i] == 0)
        zeroInDegreeNodeList.add(i);
    }
    return zeroInDegreeNodeList;
  }
}
