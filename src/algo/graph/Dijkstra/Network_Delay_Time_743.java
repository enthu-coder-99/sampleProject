package algo.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Network_Delay_Time_743 {

  public static void main(String[] args) {
    int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};// ans=2
    int n = 4, k = 2;
    System.err.println("Final Ans = " + new Network_Delay_Time_743().networkDelayTime(times, n, k));
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, Map<Integer, Integer>> graph = buildMap(times); //-------------E
    return dijkstra_with_bfs_style_check_if_we_can_lower_the_cost(graph, n, k);
  }

  /**
   * Simple BFS with no DIJKSTRA logic.
   *
   * @param graph
   * @param n
   * @param k
   * @return
   */
  public int bfs(Map<Integer, Map<Integer, Integer>> graph, int n, int k) {
    Deque<int[]> queue = new ArrayDeque<>();
    int[] minTimeTakenFromKthNode = new int[n + 1];
    Arrays.fill(minTimeTakenFromKthNode, Integer.MAX_VALUE);
    minTimeTakenFromKthNode[k] = 0;
    queue.add(new int[]{k, 0});
    while (queue.size() > 0) {
      int[] node = queue.poll();
      int from = node[0];
      int timeFromK = node[1];
      Map<Integer, Integer> nextLevelNodes = graph.getOrDefault(from, new HashMap<>());
      for (int nextNode : nextLevelNodes.keySet()) {
        int timeToReachToNextNode = nextLevelNodes.get(nextNode);
        int totalTimeToReachToNextNodeFromKth = timeFromK + timeToReachToNextNode;
        if (totalTimeToReachToNextNodeFromKth < minTimeTakenFromKthNode[nextNode]) {
          minTimeTakenFromKthNode[nextNode] = totalTimeToReachToNextNodeFromKth;
          queue.add(new int[]{nextNode, totalTimeToReachToNextNodeFromKth});
        }
      }
    }

    int totalDist = 0;
    for (int i = 1; i <= n; i++) {
      if (minTimeTakenFromKthNode[i] == Integer.MAX_VALUE) return -1;
      totalDist = Math.max(totalDist, minTimeTakenFromKthNode[i]);
    }
    return totalDist;
  }

  // Working fine and typical dijkstra
  public int dijkstra_with_bfs_style_check_if_we_can_lower_the_cost(Map<Integer, Map<Integer, Integer>> graph, int n, int k) {
    int[] minTimeTakenFromKthNode = new int[n + 1];
    Arrays.fill(minTimeTakenFromKthNode, Integer.MAX_VALUE);//------------V

    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return i1[0] - i2[0];
      }
    });
    pq.add(new int[]{0, k});
    while (pq.size() > 0) {
      int[] currentNode = pq.poll(); //----- E log v
      int timeTOReachCurrentNode = currentNode[0];
      int currentNodeIndex = currentNode[1];
      if (minTimeTakenFromKthNode[currentNodeIndex] < timeTOReachCurrentNode)
        continue;
      minTimeTakenFromKthNode[currentNodeIndex] = timeTOReachCurrentNode;
      Map<Integer, Integer> nextLevelNodes = graph.getOrDefault(currentNodeIndex, new HashMap<>());
      for (int nextNode : nextLevelNodes.keySet()) {
        int timeToReachFromCurrentNodeToNextNode = nextLevelNodes.get(nextNode);
        int totalTimeToReachFromKthtNodeToNextNode = timeToReachFromCurrentNodeToNextNode + timeTOReachCurrentNode;
        if (minTimeTakenFromKthNode[nextNode] > totalTimeToReachFromKthtNodeToNextNode)
          pq.add(new int[]{totalTimeToReachFromKthtNodeToNextNode, nextNode});

      }
    }
    int totalDist = 0;
    for (int i = 1; i <= n; i++) {
      if (minTimeTakenFromKthNode[i] == Integer.MAX_VALUE) return -1;
      totalDist = Math.max(totalDist, minTimeTakenFromKthNode[i]);
    }
    return totalDist;
  }


  // Working fine and typical dijkstra
  public int dijkstra_with_visited_array(Map<Integer, Map<Integer, Integer>> graph, int n, int k) {
    int[] minTimeTakenFromKthNode = new int[n + 1];
    Arrays.fill(minTimeTakenFromKthNode, Integer.MAX_VALUE);//------------V
    minTimeTakenFromKthNode[k] = 0;// Set source node value as 0

    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return i1[0] - i2[0];
      }
    });
    boolean[] visited = new boolean[n + 1];
    pq.add(new int[]{0, k});
    while (pq.size() > 0) {
      int[] currentNode = pq.poll(); //----- E log v
      int timeTOReachCurrentNode = currentNode[0];
      int currentNodeIndex = currentNode[1];
      if (visited[currentNodeIndex]) continue;
      visited[currentNodeIndex] = true;
      minTimeTakenFromKthNode[currentNodeIndex] = timeTOReachCurrentNode;
      Map<Integer, Integer> nextLevelNodes = graph.getOrDefault(currentNodeIndex, new HashMap<>());
      for (int nextNode : nextLevelNodes.keySet()) {
        int timeToReachFromCurrentNodeToNextNode = nextLevelNodes.get(nextNode);
        int totalTimeToReachFromKthtNodeToNextNode = timeToReachFromCurrentNodeToNextNode + timeTOReachCurrentNode;
        if (minTimeTakenFromKthNode[nextNode] < timeTOReachCurrentNode) continue;
        pq.add(new int[]{totalTimeToReachFromKthtNodeToNextNode, nextNode});

      }
    }
    int totalDist = 0;
    for (int i = 1; i <= n; i++) {
      if (minTimeTakenFromKthNode[i] == Integer.MAX_VALUE) return -1;
      totalDist = Math.max(totalDist, minTimeTakenFromKthNode[i]);
    }
    return totalDist;
  }

  /**
   * Dijkstra's algorithm
   * https://www.youtube.com/watch?v=EaphyqKU4PQ
   * https://www.youtube.com/watch?v=V6H1qAeB-l4
   * https://www.youtube.com/watch?v=XB4MIexjvY0
   */
  public int networkDelayTime_working_fine(int[][] times, int n, int k) {
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
