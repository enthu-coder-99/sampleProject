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
    Map<Integer, List<int[]>> rowsToCols = new HashMap<>();
    Map<Integer, List<int[]>> colToRows = new HashMap<>();
    Set<String> visited = new HashSet<>();

    for (int i = 0; i < row; i++) {
      int[] stone = stones[i];
      int x = stone[0];
      int y = stone[1];
      if (!rowsToCols.containsKey(x)) rowsToCols.put(x, new ArrayList<>());
      if (!colToRows.containsKey(y)) colToRows.put(y, new ArrayList<>());
      rowsToCols.get(x).add(stone);
      colToRows.get(y).add(stone);
    }
    int comp = 0;
    for (int i = 0; i < row; i++) {
      int[] stone = stones[i];
      if (!visited.contains(stone[0] + "_" + stone[1])) {
        bfs( stone, visited, rowsToCols, colToRows);
        comp++;
      }
    }
    return row - comp;
  }

  private void bfs( int[] stone, Set<String> visited, Map<Integer, List<int[]>> rowsToCols, Map<Integer, List<int[]>> colToRows) {

    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(stone);
    while (deque.size() > 0) {
      int[] stone_q = deque.poll();
      if (visited.contains(stone_q[0] + "_" + stone_q[1])) continue;
      visited.add(stone_q[0] + "_" + stone_q[1]);
      deque.addAll(rowsToCols.get(stone_q[0]));
      deque.addAll(colToRows.get(stone_q[1]));
    }
  }
}
