package algo.graph.Dijkstra;

import algo.graph.util.AdjListUtil;
import utils.BfsNode;
import utils.BigDataPlayer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Number_of_Restricted_Paths_From_First_to_Last_Node_1786 {
  private final static int mod = 1_000_000_007;

  public static void main(String[] args) {
    int n = 0;
    int[][] edges = null;

    n = 9;
    edges = new int[][]
      {{6, 2, 35129}, {3, 4, 99499}, {2, 7, 43547}, {8, 1, 78671}, {2, 1, 66308}, {9, 6, 33462}, {5, 1, 48249},
        {2, 3, 44414}, {6, 7, 44602}, {1, 7, 14931}, {8, 9, 38171}, {4, 5, 30827}, {3, 9, 79166}, {4, 8, 93731},
        {5, 9, 64068}, {7, 5, 17741}, {6, 3, 76017}, {9, 4, 72244}};

    n = 5;
    edges = new int[][]
      {{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}};


    n = 312;
    edges = BigDataPlayer.getArrayInt("nodeFirst1768");
    Number_of_Restricted_Paths_From_First_to_Last_Node_1786 obj = new Number_of_Restricted_Paths_From_First_to_Last_Node_1786();
    System.err.println(obj.countRestrictedPaths(n, edges));
    System.err.println(new Solution_1786().countRestrictedPaths(n, edges));

  }

  public int countRestrictedPaths(int n, int[][] edges) {
    Map<Integer, Map<Integer, Integer>> adjMap = AdjListUtil.getAdjWithWeight(edges, true);
    for (int i = 1; i <= n; i++) {
      System.out.println("i=" + i + " , child= " + adjMap.get(i));
    }

    // calculate the Nth Node distance from any other node.
    int[] dist = calculateDist(n, adjMap);
    for (int i = 1; i <= n; i++)
      System.out.print(i + "-  dist[i]= " + dist[i] + " , ");
    System.out.println("");
    // int bfs_result = bfs(n, dist, adjMap);
    long[] memo = new long[n + 1];
    Arrays.fill(memo, -1);
    int dfs_result = (int) dfs(n, 1, dist, memo, adjMap);
    for (int i = 1; i <= n; i++)
      System.out.print(i + "- memo[i]= " + memo[i] + " , ");
    return dfs_result;
  }

  public long dfs(int n, int start, int[] dist, long[] memo, Map<Integer, Map<Integer, Integer>> adjMap) {
    if (start == n) return 1;// this condition can get covered in above line also
    if (memo[start] >= 0) return memo[start];
    // System.err.println("start = " + start);

    Map<Integer, Integer> neighboursMap = adjMap.get(start);
    long noOfRouteFromStartToNthNode = 0;
    //  System.err.println("neighbour = " + neighboursMap.keySet());

    for (int neighbourInd : neighboursMap.keySet()) {
      if (dist[neighbourInd] < dist[start]) {
        //     System.err.println(neighbourInd + " is not sattisfying restrictive path..");
        noOfRouteFromStartToNthNode += dfs(n, neighbourInd, dist, memo, adjMap) % mod;

      }
      //   System.err.println("localRouteVal ans = " + localRouteVal + ",  neighbourInd= " + neighbourInd + ", noOfRouteFromStartToNthNode= " + noOfRouteFromStartToNthNode);
    }
    memo[start] = noOfRouteFromStartToNthNode % mod;
    //   System.err.println("Setting memo[start] = " + start + " , noOfRouteFromStartToNthNode= " + noOfRouteFromStartToNthNode);
    return memo[start];
  }

  // Calculate min distance of "N" the node from each node. It will be same as ony other ith node min distance from Nth node.
  // i.e. Min distance from Nth node to 1st, 2ncd node is that same as min distance from 1st, 2nd node to Nth node.
  public int[] calculateDist(int n, Map<Integer, Map<Integer, Integer>> map) {
    int[] dist = new int[n + 1];
    Set<Integer> visited = new HashSet<>();
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    pq.offer(new int[]{0, n});
    while (pq.size() > 0) {
      int[] node = pq.poll();
      int from_node_number = node[1];
      int node_weight = node[0];
      if (visited.contains(from_node_number)) continue;
      visited.add(from_node_number);
      dist[from_node_number] = node_weight;
      Map<Integer, Integer> neighborNodes = map.get(from_node_number);
      if (neighborNodes == null || neighborNodes.size() < 1) continue;
      for (Map.Entry<Integer, Integer> entry : neighborNodes.entrySet()) {
        Integer to_node = entry.getKey();
        Integer neighbor_weight = entry.getValue();
        pq.offer(new int[]{node_weight + neighbor_weight, to_node});
      }
    }
    return dist;
  }


  //BFS is TLE-- because we did not Memonized the middle steps.. We should memorized the middle steps to use. BUt it works
  public int bfs(int n, int[] dist, Map<Integer, Map<Integer, Integer>> map) {
    int ans = 0;
    // Run BFS from Nth Node to 1st node to get the Answer
    Deque<BfsNode> deque = new ArrayDeque<>();
    deque.add(new BfsNode(n, new LinkedHashSet<>()));
    while (deque.size() > 0) {
      BfsNode node = deque.poll();
      int from_node = node.val;
      LinkedHashSet<Integer> visited = node.visited;
      System.out.println("from_node= " + from_node + " , visited=" + visited);
      if (from_node == 1) {
        ans++;
        continue;
      }
      visited.add(from_node);
      int distOf_nth_node_from_parent_node = dist[from_node];
      Map<Integer, Integer> neighborNodeMap = map.get(from_node);
      if (neighborNodeMap == null || neighborNodeMap.size() == 0) continue;
      for (Map.Entry<Integer, Integer> neighborNodes : neighborNodeMap.entrySet()) {
        Integer neighbor_node = neighborNodes.getKey();
        int distOf_nth_node_from_neighbor_node = dist[neighbor_node];
        if (distOf_nth_node_from_neighbor_node >= distOf_nth_node_from_parent_node || visited.contains(neighbor_node))
          continue;
        deque.add(new BfsNode(neighbor_node, visited));
      }
    }
    return ans;
  }


}
