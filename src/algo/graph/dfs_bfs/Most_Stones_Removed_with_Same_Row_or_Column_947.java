package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Most_Stones_Removed_with_Same_Row_or_Column_947 {

  public int removeStones(int[][] stones) {

    int row = stones.length;
    Map<Integer, List<int[]>> xToyMap = new HashMap<>();
    Map<Integer, List<int[]>> yToxMap = new HashMap<>();
    Set<String> visited = new HashSet<>();

    for (int i = 0; i < row; i++) {
      int[] stone = stones[i];
      int x = stone[0];
      int y = stone[1];
      if (!xToyMap.containsKey(x)) xToyMap.put(x, new ArrayList<>());
      if (!yToxMap.containsKey(y)) yToxMap.put(y, new ArrayList<>());
      xToyMap.get(x).add(stone);
      yToxMap.get(y).add(stone);
    }
    int comp = 0;
    for (int i = 0; i < row; i++) {
      int[] stone = stones[i];
      if (!visited.contains(stone[0] + "_" + stone[1])) {
        bfs(stone, visited, xToyMap, yToxMap);
        comp++;
      }
    }
    return row - comp;
  }

  private void bfs(int[] stone, Set<String> visited, Map<Integer, List<int[]>> xToyMap, Map<Integer, List<int[]>> yToxMap) {

    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(stone);
    while (deque.size() > 0) {
      int[] stone_q = deque.poll();
      if (visited.contains(stone_q[0] + "_" + stone_q[1])) continue;
      visited.add(stone_q[0] + "_" + stone_q[1]);
      deque.addAll(xToyMap.get(stone_q[0]));
      deque.addAll(yToxMap.get(stone_q[1]));
    }
  }
}
