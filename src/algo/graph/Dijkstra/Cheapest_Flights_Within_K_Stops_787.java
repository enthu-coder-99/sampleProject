package algo.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import static algo.graph.util.AdjListUtil.getAdjWithWeight;

public class Cheapest_Flights_Within_K_Stops_787 {


  public static void main(String[] args) {
    int[][] flights = null;

    int src = 0, dst = 2, k = 1, n = 3;
    flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 400}};
    //System.out.println("Answer= " + findCheapestPrice(n, flights, src, dst, k));
    System.err.println("Final Ans= " + findCheapestPrice(n, flights, src, dst, k));

    src = 6;
    dst = 0;
    k = 7;
    n = 10;
    flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

    flights = new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6},
      {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6},
      {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}};
    src = 0;
    dst = 2;
    k = 1;
    n = 3;

    n = 13;
    flights = new int[][]{{11, 12, 74}, {1, 8, 91}, {4, 6, 13}, {7, 6, 39}, {5, 12, 8}, {0, 12, 54}, {8, 4, 32}, {0, 11, 4}, {4, 0, 91}, {11, 7, 64}, {6, 3, 88},
      {8, 5, 80}, {11, 10, 91}, {10, 0, 60}, {8, 7, 92}, {12, 6, 78}, {6, 2, 8}, {4, 3, 54}, {3, 11, 76}, {3, 12, 23}, {11, 6, 79}, {6, 12, 36}, {2, 11, 100},
      {2, 5, 49}, {7, 0, 17}, {5, 8, 95}, {3, 9, 98}, {8, 10, 61}, {2, 12, 38}, {5, 7, 58}, {9, 4, 37}, {8, 6, 79}, {9, 0, 1}, {2, 3, 12}, {7, 10, 7},
      {12, 10, 52}, {7, 2, 68}, {12, 2, 100}, {6, 9, 53}, {7, 4, 90}, {0, 5, 43}, {11, 2, 52}, {11, 8, 50}, {12, 4, 38}, {7, 9, 94}, {2, 7, 38}, {3, 7, 88},
      {9, 12, 20}, {12, 0, 26}, {10, 5, 38}, {12, 8, 50}, {0, 2, 77}, {11, 0, 13}, {9, 10, 76}, {2, 6, 67}, {5, 6, 34}, {9, 7, 62}, {5, 3, 67}};
    src = 10;
    dst = 1;
    k = 10;

    n = 11;
    flights = new int[][]{{0, 3, 3}, {3, 4, 3}, {4, 1, 3}, {0, 5, 1}, {5, 1, 100}, {0, 6, 2}, {6, 1, 100}, {0, 7, 1}, {7, 8, 1}, {8, 9, 1}, {9, 1, 1}, {1, 10, 1}, {10, 2, 1}, {1, 2, 100}};
    src = 0;
    dst = 2;
    k = 4;
  }

  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    Map<Integer, Map<Integer, Integer>> adjMap = getAdjWithWeight(flights, false);
    //return callBFS(adjMap, n, src, dst, k);
    return use_Bellman_ford_algo(n, adjMap, src, dst, k);
  }


  public static int use_Bellman_ford_algo(int n, Map<Integer, Map<Integer, Integer>> adjMap, int start, int dest, int k) {
    int[] dp_cost = new int[n];
    Arrays.fill(dp_cost, Integer.MAX_VALUE);
    dp_cost[start] = 0;

    for (int i = 0; i <= k; i++) {
      Set<Integer> fromAirportSet = adjMap.keySet();
      int[] dp_cost_copy = Arrays.copyOf(dp_cost, n);
      for (int fromAirport : fromAirportSet) {
        if (dp_cost[fromAirport] == Integer.MAX_VALUE)
          continue;// i.e. we did not reach to start airport yet so can not fly anywhere from this/current airport.
        Map<Integer, Integer> toAirportFlights = adjMap.get(fromAirport);
        Set<Integer> toAirportAndCostSet = toAirportFlights.keySet();
        for (int toAirport : toAirportAndCostSet) {
          int cost = toAirportFlights.get(toAirport);
          dp_cost_copy[toAirport] = Math.min(dp_cost_copy[toAirport], dp_cost[fromAirport] + cost);
        }
      }
      System.out.println(Arrays.toString(dp_cost_copy));
      dp_cost = dp_cost_copy;
    }
    return dp_cost[dest];
  }

  /**
   * https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/128776/5-ms-AC-Java-Solution-based-on-Dijkstra's-Algorithm
   * -- Good article to read why plain Dijkstra wont work.
   */
  public static int dijkstra_original(int n, Map<Integer, Map<Integer, Integer>> adjMap, int src, int dst, int k) {
    Map<Integer, List<int[]>> adj = new HashMap<>();
    int[] stops = new int[n];
    int[] cost = new int[n];
    Arrays.fill(stops, Integer.MAX_VALUE);
    Arrays.fill(cost, Integer.MAX_VALUE);
    cost[src] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    // {dist_from_src_node, node, number_of_stops_from_src_node}
    pq.offer(new int[]{0, src, 0});

    while (!pq.isEmpty()) {
      int[] node_details = pq.poll();
      int distance = node_details[0];
      int node = node_details[1];
      int stepsTaken = node_details[2];
      // We have already encountered a path with a lower cost and fewer stops,
      // or the number of stops exceeds the limit.
      if (node == dst)
        return distance;
      if (stepsTaken > stops[node] && cost[node] < distance) continue;
      stops[node] = stepsTaken;
      cost[node] = distance;
      if (stepsTaken > k)
        continue;

      if (!adjMap.containsKey(node))
        continue;
      for (Map.Entry<Integer, Integer> entry : adjMap.getOrDefault(node, new HashMap<Integer, Integer>()).entrySet()) {
        pq.offer(new int[]{distance + entry.getValue(), entry.getKey(), stepsTaken + 1});
      }
    }
    return -1;
  }

  public static int callBFS(Map<Integer, Map<Integer, Integer>> adjMap, int n, int src, int dst, int k) {
    System.out.println("Source= " + src + ", dest= " + dst + ", maxStopAllowed= " + k);

    int[] memo = new int[n];
    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[src] = 0;
    bfs_original(n, adjMap, src, dst, k, memo);
    for (int i = 0; i < n; i++) {
      System.out.print("memo_" + i + "= " + memo[i] + ", ");
    }
    System.out.println("\nans = " + memo[dst]);
    return memo[dst] == Integer.MAX_VALUE ? -1 : memo[dst];
  }

  // Working Fine.
  public static void bfs_original(int n, Map<Integer, Map<Integer, Integer>> adjMap, int source, int destination, int maxStopAllowed, int[] memo) {
    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(new int[]{source, 0, 0});// starting city, cost till this node from original Source.

    while (deque.size() > 0) {
      int[] stopDetails = deque.poll();
      int currentCity = stopDetails[0];
      int costTillCurentCityFromOrigStart = stopDetails[1];
      int stoppage = stopDetails[2];
      System.out.println("currentCity= " + currentCity + " , costTillCurentCityFromOrigStart= " + costTillCurentCityFromOrigStart + ", stoppage = " + stoppage);
      memo[currentCity] = Math.min(costTillCurentCityFromOrigStart, memo[currentCity]);
      if (source == destination || stoppage > maxStopAllowed + 1) {
        System.out.println("Continue...");
        continue;
      }

      Set<Map.Entry<Integer, Integer>> neighborFlightsMap = adjMap.getOrDefault(currentCity, new HashMap<>()).entrySet();
      for (Map.Entry<Integer, Integer> neighFlight : neighborFlightsMap) {
        int nextCity = neighFlight.getKey();
        int costToNextCityFromOrigStart = neighFlight.getValue();
        int totalCostFromOrigStartToNeigbourCity = costToNextCityFromOrigStart + costTillCurentCityFromOrigStart;
        if (memo[nextCity] < totalCostFromOrigStartToNeigbourCity) continue;
        System.err.println("Adding in PQ. nextCity= " + nextCity + ", totalCostFromOrigStartToNeigbourCity= " + totalCostFromOrigStartToNeigbourCity);
        deque.add(new int[]{nextCity, totalCostFromOrigStartToNeigbourCity, stoppage + 1});
      }
    }
  }

  //Not working fine
  public static int dfs(int src, int target, int costTillSrc, int stopTillHere, int maxStopAllowed,
                        boolean[] visited, int[] memo,
                        Map<Integer, Map<Integer, Integer>> adjMap) {
    System.out.println("src= " + src);
    if (!adjMap.containsKey(src) || adjMap.get(src).size() == 0 || stopTillHere > maxStopAllowed) {
      System.out.println("returning -1, src= " + src + ", target= " + target + ", stopTillHere= " + stopTillHere + ", maxStopAllowed= " + maxStopAllowed);
      return -1;
    }

    //if (src == target) return costTillHere;
    Map<Integer, Integer> neighborsMap = adjMap.get(src);
    Set<Map.Entry<Integer, Integer>> neighoursEntries = neighborsMap.entrySet();

    for (Map.Entry<Integer, Integer> neighCost : neighoursEntries) {
      int neighbor = neighCost.getKey();
      int costToNeigh = neighCost.getValue();
      int totalCost = costTillSrc + costToNeigh;
      if (memo[neighbor] <= totalCost) continue;
      if (neighbor == target) {
        if (memo[target] > totalCost) {
          System.out.println(src + "= Setting memo[src]= " + totalCost);
          memo[target] = totalCost;
        }
      }
      if (visited[neighbor]) continue;
      visited[neighbor] = true;
      if (memo[neighbor] <= totalCost) continue;

      int totalCostWIthNeighour = dfs(neighbor, target, totalCost, stopTillHere + 1, maxStopAllowed, visited, memo, adjMap);
      visited[neighbor] = false;
      System.out.println(src + "- totalCostWIthNeighour = " + totalCostWIthNeighour);
      if (memo[neighbor] > totalCostWIthNeighour) {
        System.out.println(src + "- Setting neighor memo[src]= " + totalCost);
        memo[neighbor] = totalCostWIthNeighour;
      }
    }
    return -1;
  }
}
