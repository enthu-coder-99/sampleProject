package bfs_dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Bus_Routes_815 {

  Map<Integer, List<Integer>> stopToRouteIndxMap = new HashMap();

  public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) return 0;
    buildAdjList(routes);
    return bfs(source, target, routes);
  }

  //BFS

  public int bfs(int source, int target, int[][] routes) {
    if (!stopToRouteIndxMap.containsKey(source)) return -1;

    Queue<List<Integer>> queue = new ArrayDeque();
    queue.add(getNextStopInfo(source, routes));
    int ans = 0;
    Set<Integer> visited = new HashSet<>();
    while (queue.size() > 0) {
      int size = queue.size();
      ans++;

      for (int i = 0; i < size; i++) {
        List<Integer> stopList = queue.poll();
        for (int stop : stopList) {
          if (stop == target) return ans;
          if (!stopToRouteIndxMap.containsKey(stop)) continue;
          List<Integer> nextRoutesIndexes = stopToRouteIndxMap.remove(stop);
          for (int nextRouteIndex : nextRoutesIndexes) {
            if (visited.contains(nextRouteIndex)) continue;
            visited.add(nextRouteIndex);
            int[] nextStops = routes[nextRouteIndex];
            queue.add(Arrays.stream(nextStops).boxed().toList());
          }
        }
      }
    }
    return -1;
  }

  private List<Integer> getNextStopInfo(int start, int[][] routes) {
    List<Integer> routesIndexes = stopToRouteIndxMap.remove(start);
    List<Integer> nextStopList = new ArrayList<>();
    for (int routesIndex : routesIndexes) {
      int[] route_i = routes[routesIndex];
      for (int stop : route_i) {
        if (stop == start) continue;
        nextStopList.add(stop);
      }
    }
    return nextStopList;
  }

  public void buildAdjList(int[][] routes) {

    int l = routes.length;
    for (int i = 0; i < l; i++) {
      int[] route_i = routes[i];
      int route_len = route_i.length;
      for (int j = 0; j < route_len; j++) {
        int stop = route_i[j];
        if (!stopToRouteIndxMap.containsKey(stop)) stopToRouteIndxMap.put(stop, new ArrayList());
        stopToRouteIndxMap.get(stop).add(i);
      }
    }
  }
}
