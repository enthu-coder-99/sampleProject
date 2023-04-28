package algo.graph.unionFind;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Score_of_a_Path_Between_Two_Cities_2492 {

  public int minScore(int n, int[][] roads) {
    int result = Integer.MAX_VALUE;
    UnionFind1 unionFind1 = new UnionFind1(n);
    for (int i = 0; i < roads.length; i++) {
      int[] road = roads[i];
      int from = road[0];
      int to = road[1];
      unionFind1.merge(from, to);
    }

    for (int i = 0; i < roads.length; i++) {
      int[] road = roads[i];
      int from = road[0];
      int dist = road[2];
      if (unionFind1.findParent(from) == unionFind1.findParent(1)) {
        result = Math.min(result, dist);
      }
    }

    return result;
  }


  public Map<Integer, Map<Integer, Integer>> buildAdjMap(int[][] roads) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int i = 0; i < roads.length; i++) {
      int[] road = roads[i];
      int from = road[0];
      int to = road[1];
      int dis = road[2];
      if (!map.containsKey(from)) map.put(from, new HashMap<>());
      map.get(from).put(to, dis);
      if (!map.containsKey(to)) map.put(to, new HashMap<>());
      map.get(to).put(from, dis);
    }
    return map;
  }

}

class UnionFind1 {
  int n;
  int[] parent;
  int[] weight;

  public UnionFind1(int m) {
    this.n = m + 1;
    parent = new int[this.n];
    weight = new int[this.n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
      weight[i] = 1;
    }
  }


  int findParent(int cand) {
    if (parent[cand] == cand)
      return cand;
    return parent[cand] = findParent(parent[cand]);
  }

  boolean merge(int cand1, int cand2) {
    int parent_cand1 = findParent(cand1);
    int parent_cand2 = findParent(cand2);
    if (parent_cand1 == parent_cand2) return false;
    if (weight[parent_cand1] > weight[parent_cand2]) {
      weight[parent_cand1] += weight[parent_cand2];
      parent[parent_cand2] = parent_cand1;
    } else {
      weight[parent_cand2] += weight[parent_cand1];
      parent[parent_cand1] = parent_cand2;
    }
    return true;
  }
}
