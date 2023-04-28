package algo.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Time_to_Collect_All_Apples_in_a_Tree_1443 {

  public static void main(String[] args) {
    int n = 7;
    int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    List<Boolean> hasApple = List.of(false, false, true, false, true, true, false);
    minTime(n, edges, hasApple);

    n = 4;
    edges = new int[][]{{0, 2}, {0, 3}, {1, 2}};
    hasApple = List.of(false, true, false, false);
    //minTime(n, edges, hasApple);
  }

  public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, List<Integer>> childrenAndHasAppleMap = getChildAndHasAppleGraph(edges, hasApple);
    System.out.println("Map= " + childrenAndHasAppleMap);
    boolean[] visited = new boolean[n];
    int ans = bfs(childrenAndHasAppleMap, hasApple, 0, visited);
    System.out.println("Answer = " + ans);
    return ans;
  }

  public static int bfs(Map<Integer, List<Integer>> map, List<Boolean> hasApple, int current, boolean[] visited) {
    System.out.println("current=" + current);
    if (!map.containsKey(current) || visited[current]) return 0;//parent = current
    visited[current] = true;

    int ans = 0;
    List<Integer> childrenList = map.get(current);

    for (int children : childrenList) {
      int dist = bfs(map, hasApple, children, visited);
      System.out.println("children=" + children + ", dist=" + dist);

      if (hasApple.get(children) || dist > 0) {
        ans = ans + dist + 2;
      }
      System.out.println("children= " + children + ", current= " + current + ", dist= " + dist + ", ans1= " + ans);
    }
    System.out.println("---Node= " + current + ", ans2= " + ans);
    return ans;
  }

  public static Map<Integer, List<Integer>> getChildAndHasAppleGraph(int[][] edges, List<Boolean> hasApple) {
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