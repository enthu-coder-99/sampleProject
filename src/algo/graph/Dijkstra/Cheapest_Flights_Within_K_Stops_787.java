package algo.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import static algo.graph.util.AdjListUtil.getAdjWithWeight;
import static algo.graph.util.AdjListUtil.getPQ;

public class Cheapest_Flights_Within_K_Stops_787 {


  public static void main(String[] args) {
    int[][] flights = null;

    int src = 0, dst = 3, k = 1, n = 4;
    flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
    System.out.println("Answer= " + findCheapestPrice(n, flights, src, dst, k));

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
  }

  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    Map<Integer, Map<Integer, Integer>> adjMap = getAdjWithWeight(flights, false);
    return callBFS(adjMap, n, src, dst, k);
    // return dijkstra(src, dst, k, adjMap, n);
  }

  public static int dijkstra(int start, int destination, int maxStopAllowed, Map<Integer, Map<Integer, Integer>> adjMap, int n) {
    System.out.println("\nstart= " + start + ", destination= " + destination + ", maxStopAllowed= " + maxStopAllowed + ", n= " + n);
    PriorityQueue<int[]> pq = getPQ(0);// sort on based on cost from current source to  original source.
    pq.add(new int[]{0, start, 0});// cost, starting city, no_of_stop_taken
    boolean[] visited = new boolean[n];
    visited[start] = true;

    int[] memo = new int[n];
    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[start] = 0;
    while (pq.size() > 0) {
      int[] node = pq.poll();
      int totalCostTillHereFromOrigStart = node[0];
      int from_city = node[1];
      int no_of_stoppage_taken = node[2];
      System.out.println("from_city= " + from_city + " , totalCostTillHereFromOrigStart= " + totalCostTillHereFromOrigStart + " , no_of_stoppage_taken= " + no_of_stoppage_taken);
      if (no_of_stoppage_taken > (maxStopAllowed + 1)) {
        System.out.println(from_city + " and Continue and no_of_stoppage_taken = " + no_of_stoppage_taken + " , visited= " + visited[from_city]);
        continue;
      }
      if (from_city == destination) return totalCostTillHereFromOrigStart;
      Set<Map.Entry<Integer, Integer>> neighFlightsMap = adjMap.getOrDefault(from_city, new HashMap<>()).entrySet();
      for (Map.Entry<Integer, Integer> neighFlight : neighFlightsMap) {
        Integer neighbor_city = neighFlight.getKey();
        Integer cost_from_start_to_neighbor = neighFlight.getValue();
        int totalCostTillNeigh = totalCostTillHereFromOrigStart + cost_from_start_to_neighbor;
        System.out.println("PQ adding- neighbor_city=" + neighbor_city + ", totalCostTillNeigh= " + totalCostTillNeigh + ", ");
        pq.add(new int[]{totalCostTillNeigh, neighbor_city, no_of_stoppage_taken + 1});
      }
    }
    return -1;
  }

  public static int callBFS(Map<Integer, Map<Integer, Integer>> adjMap, int n, int src, int dst, int k) {
    System.out.println("Source= " + src + ", dest= " + dst + ", maxStopAllowed= " + k);

    int[] memo = new int[n];
    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[src] = 0;
    bfs(src, dst, k, n, memo, adjMap);
    for (int i = 0; i < n; i++) {
      System.out.print("memo_" + i + "= " + memo[i] + ", ");
    }
    System.out.println("\nans = " + memo[dst]);
    return memo[dst] == Integer.MAX_VALUE ? -1 : memo[dst];
  }

  // Working Fine.
  public static void bfs(int source, int destination, int k, int n, int[] memo, Map<Integer, Map<Integer, Integer>> adjMap) {
    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(new int[]{source, 0});// starting city, cost till this node from original Source.

    int stoppage = 0;
    while (deque.size() > 0 && stoppage <= k + 1) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        int[] stopDetails = deque.poll();
        int city = stopDetails[0];
        int costTillCity = stopDetails[1];
        System.out.println("city= " + city + " , costTillCity= " + costTillCity);
        memo[city] = Math.min(costTillCity, memo[city]);
        if (source == destination || !adjMap.containsKey(city) || adjMap.get(city).size() == 0) continue;

        Set<Map.Entry<Integer, Integer>> neighborFlightsMap = adjMap.get(city).entrySet();
        for (Map.Entry<Integer, Integer> neighFlight : neighborFlightsMap) {
          int neighborCity = neighFlight.getKey();
          int costToNeighborCity = neighFlight.getValue();
          int totalCostFromOrigStartToNeigbourCity = costToNeighborCity + costTillCity;
          if (memo[neighborCity] < totalCostFromOrigStartToNeigbourCity) continue;
          System.err.println("Adding in PQ. neighborCity= " + neighborCity + ", totalCostFromOrigStartToNeigbourCity= " + totalCostFromOrigStartToNeigbourCity);
          deque.add(new int[]{neighborCity, totalCostFromOrigStartToNeigbourCity});
        }
      }
      stoppage++;

    }
  }

  //Not working fine
  public static int dfs(int src, int target, int costTillSrc, int stopTillHere, int maxStopAllowed, boolean[] visited, int[] memo,
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
