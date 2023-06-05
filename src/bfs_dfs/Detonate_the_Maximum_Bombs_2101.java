package bfs_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Detonate_the_Maximum_Bombs_2101 {

  public static void main(String[] args) {
    int[][] maxDetonate = new int[][]{{2, 1, 3}, {6, 1, 4}};
    System.out.println("maxDetonate = " + maximumDetonation(maxDetonate));
  }

  public static int maximumDetonation(int[][] bombs) {
    int l = bombs.length;
    Map<Integer, Set<Integer>> memo = new HashMap();
    for (int i = 0; i < l; i++) {
      dfs(i, memo, bombs, new HashSet<>());
    }
    System.err.println("memo = " + memo);
    int max = 0;
    for (int bomb : memo.keySet()) {
      max = Math.max(max, memo.getOrDefault(bomb, new HashSet<>()).size());
    }
    return max + 1;
  }

  private static Set<Integer> dfs(int start_i, Map<Integer, Set<Integer>> memo, int[][] bombs, Set<Integer> visited) {

    if (memo.containsKey(start_i)) return new HashSet<>(memo.get(start_i));
    if (visited.contains(start_i)) return new HashSet<>();
    visited.add(start_i);

    List<Integer> neighborsList = neighborDetonateList(start_i, bombs);
    Set<Integer> totalBombsCanGetDetonated = new HashSet<>();
    for (int neighbor : neighborsList) {
      totalBombsCanGetDetonated.addAll(dfs(neighbor, memo, bombs, visited));
    }
    memo.put(start_i, totalBombsCanGetDetonated);
    return totalBombsCanGetDetonated;
  }

  private static List<Integer> neighborDetonateList(int start_i, int[][] bombs) {
    int l = bombs.length;
    int[] bomb_s = bombs[start_i];
    int bomb_s_x = bomb_s[0];
    int bomb_s_y = bomb_s[1];
    int bomb_s_radius = bomb_s[2];
    List<Integer> neighborList = new ArrayList<>();
    for (int i = 0; i < l; i++) {
      if (i == start_i) continue;
      int[] bomb2 = bombs[i];
      int bomb_2_x = bomb2[0];
      int bomb_2_y = bomb2[1];
      double center_dist = Math.sqrt(Math.pow(bomb_s_x - bomb_2_x, 2) + Math.pow(bomb_s_y - bomb_2_y, 2));
      if (center_dist <= bomb_s_radius)
        neighborList.add(i);
    }
    System.out.println("start_i=" + start_i + " , neighborList=" + neighborList);
    return neighborList;
  }
}
