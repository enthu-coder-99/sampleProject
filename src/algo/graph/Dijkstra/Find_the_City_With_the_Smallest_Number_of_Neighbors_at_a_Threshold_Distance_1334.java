package algo.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import static algo.graph.util.AdjListUtil.getAdjWithWeight;

public class Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance_1334 {

  public static void main(String[] args) {
    int[][] edges = new int[][]{{0, 1, 10}, {0, 2, 1}, {2, 3, 1}, {1, 3, 1}, {1, 4, 1}, {4, 5, 10}};
    int distanceThreshold = 20;
    int n = 6;
    System.err.println(findTheCity(n, edges, distanceThreshold));
  }


  public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int ans = -1;
    int countOfClosestCity = Integer.MAX_VALUE;
    Map<Integer, Map<Integer, Integer>> adjWithWeight = getAdjWithWeight(edges, true);
    // int closetCitiesWithinThreshold1 = dijkstra(1, adjWithWeight, distanceThreshold);

    for (int i = 0; i < 1; i++) {
      int start = i;
      int closetCitiesWithinThreshold = dijkstra(start, adjWithWeight, distanceThreshold);
      if (countOfClosestCity >= closetCitiesWithinThreshold) {
        countOfClosestCity = closetCitiesWithinThreshold;
        ans = start;
      }
    }
    return ans;
  }

  private static int bfs(int start, Map<Integer, Map<Integer, Integer>> adjWithWeight, int distanceThreshold, int n) {

    Set<Integer> visited = new HashSet<>();
    int[] distance = new int[n];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[start] = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(start);
    while (deque.size() > 0) {
      int city = deque.poll();
      visited.add(city);
      //System.out.println
      // ("city=" + city + ", city_distance=" + city_distance);
      Map<Integer, Integer> neighborCities = adjWithWeight.getOrDefault(city, new HashMap<>());
      for (int neighbor : neighborCities.keySet()) {
        int neighbourDistanceFromSource = distance[city] + neighborCities.get(neighbor);
        if (distance[neighbor] > neighbourDistanceFromSource && neighbourDistanceFromSource <= distanceThreshold) {
          // System.out.println("Skip.. neighbor=" + neighbor + ", neighbourDistanceFromSource=" + neighbourDistanceFromSource + ", distanceThreshold=" + distanceThreshold);
          distance[neighbor] = neighbourDistanceFromSource;
          deque.add(neighbor);
        }
      }
    }
    //.out.println("start= " + start + ", citiesVisited= " + citiesVisited);
    return visited.size();
  }

  private static int dijkstra(int start, Map<Integer, Map<Integer, Integer>> adjWithWeight, int distanceThreshold) {

    Set<Integer> citiesVisited = new HashSet<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });

    pq.add(new int[]{start, 0});
    while (pq.size() > 0) {
      int[] city_details = pq.poll();
      int city = city_details[0];
      int city_distance = city_details[1];
      //System.out.println("city=" + city + ", city_distance=" + city_distance);
      citiesVisited.add(city);
      Map<Integer, Integer> neighborCities = adjWithWeight.getOrDefault(city, new HashMap<>());
      for (int neighbor : neighborCities.keySet()) {
        int neighbourDistanceFromSource = city_distance + neighborCities.get(neighbor);
        if (neighbourDistanceFromSource > distanceThreshold || citiesVisited.contains(neighbor)) {
          // System.out.println("Skip.. neighbor=" + neighbor + ", neighbourDistanceFromSource=" + neighbourDistanceFromSource + ", distanceThreshold=" + distanceThreshold);
          continue;
        }
        pq.add(new int[]{neighbor, neighbourDistanceFromSource});
      }
    }
    //.out.println("start= " + start + ", citiesVisited= " + citiesVisited);
    return citiesVisited.size() - 1;
  }
}
