package algo.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Minimum_Time_to_Collect_All_Apples_in_a_Tree_Copy_1443 {

  public static void main(String[] args) {
    int n = 7;
    int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    List<Boolean> hasApple = List.of(false, false, true, false, true, true, false);
    int result = minTime(n, edges, hasApple);
    System.err.println("1= Result= " + result);

    n = 4;
    edges = new int[][]{{0, 2}, {0, 3}, {1, 2}};
    hasApple = List.of(false, true, false, false);
    //result = minTime(n, edges, hasApple);
    System.err.println("2- Result= " + result);
  }

  public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {

    Map<Integer, List<Integer>> adjMap = getChildAndHasAppleGraph(edges);
    Set<Integer> visited = new HashSet();
    int dist = itert(adjMap, visited, hasApple, 0);
    return dist;
  }

  public static int itert(Map<Integer, List<Integer>> adjMap,
                          Set<Integer> visited, List<Boolean> hasApple, int parentNode) {

    if (visited.contains(parentNode)) return 0;
    visited.add(parentNode);//0, 1 , 4
    System.err.println("parentNode = " + parentNode);
    List<Integer> children = adjMap.get(parentNode);
    int totalDistance = 0;
    for (int child : children) {
      //1, 4 , 1
      if (visited.contains(child)) continue;

      int depth = itert(adjMap, visited, hasApple, child);
      boolean thisChildHasApple = hasApple.get(child);
      System.err.println("parentNode = " + parentNode + ", depth= " + depth + ", child= " + child + ", thisChildHasApple= " + thisChildHasApple);
      if (depth > 0 || thisChildHasApple) {
        totalDistance = totalDistance + 2 + depth;
        System.err.println("Adding 2 and totalDistance= " + totalDistance);
      }
    }
    System.err.println("parentNode = " + parentNode + ", totalDistance=" + totalDistance);
    return totalDistance;
  }


  public static Map<Integer, List<Integer>> getChildAndHasAppleGraph(int[][] edges) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      int from = edge[0];
      int to = edge[1];
      if (!map.containsKey(from)) map.put(from, new ArrayList<>());
      if (!map.containsKey(to)) map.put(to, new ArrayList<>());
      map.get(from).add(to);
      map.get(to).add(from);
    }
    return map;
  }
}