package algo.graph.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AdjListUtil {

  public static Map<Integer, Map<Integer, Integer>> getAdjWithWeight(int[][] edges, boolean undirected) {
    Map<Integer, Map<Integer, Integer>> adjListMap = new HashMap<>();
    for (int[] edge : edges) {
      if (!adjListMap.containsKey(edge[0])) adjListMap.put(edge[0], new HashMap<>());
      adjListMap.get(edge[0]).put(edge[1], edge[2]);
      if (undirected) {
        if (!adjListMap.containsKey(edge[1])) adjListMap.put(edge[1], new HashMap<>());
        adjListMap.get(edge[1]).put(edge[0], edge[2]);
      }
    }
    return adjListMap;
  }

  public static Map<Integer, List<Integer>> getAdjList(int[][] edges) {
    Map<Integer, List<Integer>> adjListMap = new HashMap<>();
    for (int[] edge : edges) {
      if (!adjListMap.containsKey(edge[0])) adjListMap.put(edge[0], new ArrayList<>());
      if (!adjListMap.containsKey(edge[1])) adjListMap.put(edge[1], new ArrayList<>());
      adjListMap.get(edge[0]).add(edge[1]);
      adjListMap.get(edge[1]).add(edge[0]);
    }
    return adjListMap;
  }

  public static PriorityQueue<int[]> getPQ(int indexToSort) {
    return new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[indexToSort] - o2[indexToSort];
      }
    });
  }
}
