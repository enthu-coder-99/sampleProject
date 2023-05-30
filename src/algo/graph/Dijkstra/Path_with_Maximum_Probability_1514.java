package algo.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Path_with_Maximum_Probability_1514 {

  public static void main(String[] args) {
    System.err.println(23.45d);
  }

  public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    return maxProbability_Dijkstra(n, edges, succProb, start, end);
  }

  // Dijkstra Algo. It is a modified Dijkstra where we will see each Node multiple time and keep relaxing as much as we can.
  public static double maxProbability_Dijkstra(int n, int[][] edges, double[] succProb, int start, int end) {

    double[] memo = new double[n];
    Arrays.fill(memo, -1);
    memo[start] = 1.0;
    Map<Integer, Map<Integer, Double>> adjWithWeight = getAdjWithWeight(edges, succProb);
    PriorityQueue<Double[]> pq = new PriorityQueue<Double[]>(new Comparator<Double[]>() {
      @Override
      public int compare(Double[] o1, Double[] o2) {
        return o2[0] - o1[0] > 0 ? 1 : -1;
      }// Max Heap
    });

    pq.add(new Double[]{1.0, Double.valueOf(start)});
    while (pq.size() > 0) {
      Double[] node_details = pq.poll();
      int node_index = node_details[1].intValue();
      Double node_prob = node_details[0];
      if (node_index == end) return node_prob;

      Set<Map.Entry<Integer, Double>> neighborsEntrySet = adjWithWeight.getOrDefault(node_index, new HashMap<>()).entrySet();
      for (Map.Entry<Integer, Double> neighborSet : neighborsEntrySet) {
        int neighbor_node = neighborSet.getKey();
        double neighbor_prob = neighborSet.getValue();
        double neighborTotalProb = memo[node_index] * neighbor_prob;
        if (memo[neighbor_node] < neighborTotalProb) {
          memo[neighbor_node] = neighborTotalProb;
          pq.add(new Double[]{neighborTotalProb, Double.valueOf(neighbor_node)});
        }
      }
    }
    return -1;
  }

  // With Probability is stored in separete Array.
  public static double maxProbability_BFS_sol2(int n, int[][] edges, double[] succProb, int start, int end) {

    double[] memo = new double[n];
    Arrays.fill(memo, -1);
    memo[start] = 1.0;
    Map<Integer, Map<Integer, Double>> adjWithWeight = getAdjWithWeight(edges, succProb);
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(start);
    while (deque.size() > 0) {
      int node_index = deque.poll();
      Set<Map.Entry<Integer, Double>> neighborsEntrySet = adjWithWeight.getOrDefault(node_index, new HashMap<>()).entrySet();
      for (Map.Entry<Integer, Double> neighborSet : neighborsEntrySet) {
        int neighbor_node = neighborSet.getKey();
        double neighbor_prob = neighborSet.getValue();
        double neighborTotalProb = memo[node_index] * neighbor_prob;
        if (memo[neighbor_node] < neighborTotalProb) {
          memo[neighbor_node] = neighborTotalProb;
          deque.add(neighbor_node);
        }
      }
    }

    if (memo[end] == -1) return 0;
    return memo[end];
  }


  // With probability value inside QUEUE element
  public static double maxProbability_BFS_sol1(int n, int[][] edges, double[] succProb, int start, int end) {

    double[] memo = new double[n];
    Arrays.fill(memo, -1);
    Map<Integer, Map<Integer, Double>> adjWithWeight = getAdjWithWeight(edges, succProb);
    Deque<double[]> deque = new ArrayDeque<>();
    deque.add(new double[]{(double) start, 1.0});
    while (deque.size() > 0) {
      double[] node_details = deque.poll();
      int node_index = (int) node_details[0];
      double prob_till_node = node_details[1];
      Set<Map.Entry<Integer, Double>> neighborsEntrySet = adjWithWeight.getOrDefault(node_index, new HashMap<>()).entrySet();
      for (Map.Entry<Integer, Double> neighborSet : neighborsEntrySet) {
        int neighbor_node = neighborSet.getKey();
        double neighbor_prob = neighborSet.getValue();
        double neighborProb = prob_till_node * neighbor_prob;

        if (memo[neighbor_node] < neighborProb) {
          memo[neighbor_node] = neighborProb;
          deque.add(new double[]{neighbor_node, neighborProb});
        }
      }
    }

    if (memo[end] == -1) return 0;
    return memo[end];
  }


  private static Map<Integer, Map<Integer, Double>> getAdjWithWeight(int[][] edges, double[] succProb) {

    Map<Integer, Map<Integer, Double>> adjListMap = new HashMap<>();
    int i = 0;
    for (int[] edge : edges) {
      if (!adjListMap.containsKey(edge[0])) adjListMap.put(edge[0], new HashMap<>());
      adjListMap.get(edge[0]).put(edge[1], succProb[i]);
      if (!adjListMap.containsKey(edge[1])) adjListMap.put(edge[1], new HashMap<>());
      adjListMap.get(edge[1]).put(edge[0], succProb[i]);
      i++;
    }
    return adjListMap;
  }
}
