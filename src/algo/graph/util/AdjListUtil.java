package algo.graph.util;

import algo.graph.unionFind.UnionFindTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AdjListUtil {

  int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public static boolean isValidIndex(int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i >= row || j >= col) return false;
    return true;
  }


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
    Map<Integer, List<Integer>> adjMap = new HashMap();
    for (int[] edge : edges) {
      int node1 = edge[0];
      int node2 = edge[1];
      if (!adjMap.containsKey(node1)) adjMap.put(node1, new ArrayList<>());
      if (!adjMap.containsKey(node2)) adjMap.put(node2, new ArrayList<>());
      adjMap.get(node1).add(node2);
      adjMap.get(node2).add(node1);
    }
    return adjMap;
  }

  public static PriorityQueue<int[]> getPQ(int indexToSort) {
    return new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[indexToSort] - o2[indexToSort];
      }
    });
  }

  public static void iterateOverUMParents(UnionFindTemplate um) {
    int[] parent = um.parent;
    for (int i = 0; i < parent.length; i++) {
      System.out.println("i= " + i + " , parent= " + parent[i]);
    }
  }
}
