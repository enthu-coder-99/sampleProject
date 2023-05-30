package algo.graph.Dijkstra;

import algo.graph.util.AdjListUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import static algo.graph.util.AdjListUtil.getAdjWithWeight;

public class Reach_Nodes_In_Subdivided_Graph_882 {

  public static void main(String[] args) {
    int[][] edges = new int[][]{{0, 1, 4}, {1, 2, 6}, {0, 2, 8}, {1, 3, 1}};
    int maxMoves = 10, n = 4;
    System.err.println("Final Ans2 = " + reachableNodes(edges, maxMoves, n));
    reachableNodes_copied(edges, maxMoves, n);
  }

  /**
   * https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/discuss/156777/Java-Dijkstra-Solution
   */
  public static int reachableNodes(int[][] edges, int maxMoves, int n) {
    System.out.println("================================================");
    int ans = 0;
    Map<Integer, Map<Integer, Integer>> adjMap = getAdjWithWeight(edges, true);
    Set<Integer> visited = new HashSet<>();
    PriorityQueue<int[]> deque = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[0] - o1[0];
      }
    });// Max Heap
    deque.add(new int[]{maxMoves, 0});// Node, Distance left to travel
    while (deque.size() > 0) {
      int[] deque_elm = deque.poll();
      int distNeedsToCover = deque_elm[0];
      int node = deque_elm[1];
      if (visited.contains(node)) continue;
      visited.add(node);
      if (distNeedsToCover < 0 || !adjMap.containsKey(node)) continue;
      System.out.println("\nProcessing node = " + node + " , distNeedsToCover = " + distNeedsToCover);
      ans++;
      Map<Integer, Integer> neighborNodesMap = adjMap.getOrDefault(node, new HashMap<>());
      Set<Map.Entry<Integer, Integer>> entries = neighborNodesMap.entrySet();
      for (Map.Entry<Integer, Integer> entry : entries) {
        int nextNode = entry.getKey();
        int movesAvailableInNextNode = entry.getValue();
        int movedLeftBeyondNextNode = distNeedsToCover - movesAvailableInNextNode;
        if (movedLeftBeyondNextNode > 0 && !visited.contains(nextNode)) {
          System.out.println("Adding in PQ- node= " + nextNode + ", dist_further = " + (movedLeftBeyondNextNode - 1));
          deque.add(new int[]{movedLeftBeyondNextNode - 1, nextNode});
        }
        System.out.println("neighborNode= " + nextNode + ", Orig_distNeedsToCover = " + distNeedsToCover + " , movesAvailableInNextNode = " + movesAvailableInNextNode);
        ans = ans + Math.min(distNeedsToCover, movesAvailableInNextNode);
        setValueInMap(adjMap, nextNode, node, Math.max(0, (movesAvailableInNextNode - distNeedsToCover)));
        System.out.println("ans = " + ans);
      }
    }
    return ans;
  }

  public static int reachableNodes_copied(int[][] edges, int M, int N) {
    System.out.println("==========================================================");

    int[][] graph = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(graph[i], -10);
    }
    for (int[] edge : edges) {
      graph[edge[0]][edge[1]] = edge[2];
      graph[edge[1]][edge[0]] = edge[2];
    }
    int result = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
    boolean[] visited = new boolean[N];
    pq.offer(new int[]{0, M});
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int start = cur[0];
      int move = cur[1];
      if (visited[start]) {
        continue;
      }
      System.out.println("\nCopied Processing node = " + start + " , distNeedsToCover = " + move);

      visited[start] = true;
      result++;
      for (int i = 0; i < N; i++) {
        if (graph[start][i] > -10) {
          if (move > graph[start][i] && !visited[i]) {
            System.out.println("Adding in PQ- node= " + i + ", dist_further = " + (move - graph[start][i] - 1));
            pq.offer(new int[]{i, move - graph[start][i] - 1});
          }
          graph[i][start] -= Math.min(move, graph[start][i]);

          System.out.println("neighborNode= " + i + ", Orig_distNeedsToCover = " + move + " , movesAvailableInNextNode = " + graph[start][i]);
          System.out.println("Setting from=" + i + ", to= " + start + ", newDistance=" + Math.min(move, graph[start][i]));

          result += Math.min(move, graph[start][i]);
          System.out.println("ans= " + result);
        }
      }
    }
    System.err.println("Final Result = " + result);
    return result;
  }

  public static void setValueInMap(Map<Integer, Map<Integer, Integer>> adjMap, int from, int to, int newDistance) {
    if (!adjMap.containsKey(from) || !adjMap.get(from).containsKey(to)) return;
    System.out.println("Setting from=" + from + ", to= " + to + ", newDistance=" + newDistance);
    adjMap.get(from).put(to, newDistance);
  }


}
