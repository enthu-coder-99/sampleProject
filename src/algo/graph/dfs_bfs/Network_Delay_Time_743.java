package algo.graph.dfs_bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Network_Delay_Time_743 {

  public static void main(String[] args) {
    int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    int n = 4, k = 2;
    System.err.println(new Network_Delay_Time_743().networkDelayTime(times, n, k));
  }

  /**
   * Dijkstra's algorithm
   * https://www.youtube.com/watch?v=EaphyqKU4PQ
   * https://www.youtube.com/watch?v=XB4MIexjvY0
   */
  public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, Map<Integer, Integer>> inputGraph = buildMap(times);
    int[] minTimeTakenFromKthNode = new int[n + 1];
    Arrays.fill(minTimeTakenFromKthNode, Integer.MAX_VALUE);
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
    pq.add(List.of(0, k));
    minTimeTakenFromKthNode[k] = 0;
    boolean[] visited = new boolean[n + 1];
    while (pq.size() > 0) {
      List<Integer> currentNode = pq.poll();
      //System.err.println("currentNode=" + currentNode);
      //System.err.println("pq=" + pq);
      int currentNodeIndex = currentNode.get(1);
      int currentNodeDist = currentNode.get(0);

      if (visited[currentNodeIndex] || !inputGraph.containsKey(currentNodeIndex)) continue;
      visited[currentNodeIndex] = true;

      Map<Integer, Integer> innerNodeMap = inputGraph.get(currentNodeIndex);
      for (Integer innerNodeMapElementIndex : innerNodeMap.keySet()) {
        int outwardNodeDist = innerNodeMap.get(innerNodeMapElementIndex);
        minTimeTakenFromKthNode[innerNodeMapElementIndex] = Math
          .min(currentNodeDist + outwardNodeDist, minTimeTakenFromKthNode[innerNodeMapElementIndex]);
        pq.offer(List.of(minTimeTakenFromKthNode[innerNodeMapElementIndex], innerNodeMapElementIndex));
      }
    }
    int totalDist = 0;
    for (int i = 1; i <= n; i++) {
      if (minTimeTakenFromKthNode[i] == Integer.MAX_VALUE) return -1;
      totalDist = Math.max(totalDist, minTimeTakenFromKthNode[i]);
    }
    return totalDist;
  }

  public Map<Integer, Map<Integer, Integer>> buildMap(int[][] times) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap();
    for (int i = 0; i < times.length; i++) {
      int from = times[i][0];
      int to = times[i][1];
      int timeTaken = times[i][2];
      if (!graph.containsKey(from)) graph.put(from, new HashMap<>());
      graph.get(from).put(to, timeTaken);
    }
    return graph;
  }

}
