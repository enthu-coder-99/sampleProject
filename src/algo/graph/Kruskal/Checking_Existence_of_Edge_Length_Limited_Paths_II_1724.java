package algo.graph.Kruskal;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Checking_Existence_of_Edge_Length_Limited_Paths_II_1724 {
  TreeMap<Integer, int[]> edgeWeigthToUnionMergeParentMap = new TreeMap<>();

  public Checking_Existence_of_Edge_Length_Limited_Paths_II_1724(int n, int[][] edgeList) {
    PriorityQueue<int[]> pq = UnionMerge.getPQ(2);
    UnionMerge unionMerge = new UnionMerge(n + 1);
    for (int[] edge : edgeList) {
      int from = edge[0];
      int to = edge[1];
      int weight = edge[2];
      boolean merged = unionMerge.merge(from + 1, to + 1);
      if (merged)
        edgeWeigthToUnionMergeParentMap.put(weight, unionMerge.parent.clone());
    }
  }

  public boolean query(int p, int q, int limit) {
    Map.Entry<Integer, int[]> justLowerEntry = edgeWeigthToUnionMergeParentMap.floorEntry(limit);
    if (justLowerEntry == null) return false;

    return (UnionMerge.findParentByParentArray(p, justLowerEntry.getValue()) == UnionMerge.findParentByParentArray(p,
      justLowerEntry.getValue()));
  }
}
