package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * <p>
 * 0-1 1-3 2-3 4-0 4-5 -- out
 * <p>
 * 1-0 3-1 3-2 0-4 5-4 - in
 */
public class Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero_1466 {

  public static void main(String[] args) {
    int[][] connections = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    int n = 6;
    System.err.println(minReorder(n, connections));
  }

  public static int minReorder(int n, int[][] connections) {
    int l = connections.length;
    int changed = 0;
    Map<Integer, Set<Integer>> from2ToMap = new HashMap();
    Map<Integer, Set<Integer>> to2FromMap = new HashMap();
    for (int i = 0; i < l; i++) {
      int[] conn = connections[i];
      int from = conn[0];
      int to = conn[1];
      if (!to2FromMap.containsKey(to))
        to2FromMap.put(to, new HashSet());
      if (!from2ToMap.containsKey(from))
        from2ToMap.put(from, new HashSet());
      to2FromMap.get(to).add(from);
      from2ToMap.get(from).add(to);
    }

    Deque<Integer> deque = new ArrayDeque();
    deque.add(0);
    Set<Integer> visited = new HashSet();
    while (deque.size() > 0) {
      int fromCity = deque.poll();
      System.out.println("#1- fromCity= " + fromCity);
      if (visited.contains(fromCity)) continue;
      visited.add(fromCity);
      if (from2ToMap.containsKey(fromCity)) {
        Set<Integer> toCitySet = from2ToMap.get(fromCity);
        for (int toCity : toCitySet) {
          System.out.println("#2- " + toCity);
          if (!visited.contains(toCity)) {
            deque.add(toCity);
            changed = changed + 1;
            System.out.println("changed=" + changed);
          }
        }
      }

      if (to2FromMap.containsKey(fromCity)) {
        Set<Integer> toCitiesSet = to2FromMap.get(fromCity);
        for (int toCity : toCitiesSet) {
          System.out.println("#3- " + toCity);
          if (!visited.contains(toCity))
            deque.add(toCity);
        }
      }
    }
    return changed;
  }
}
