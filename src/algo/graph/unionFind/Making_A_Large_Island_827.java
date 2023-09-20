package algo.graph.unionFind;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Making_A_Large_Island_827 {

  //1- Land, 0- Water
  public int largestIsland(int[][] grid) {

    int n = grid.length;
    Map<Integer, Integer> map = new HashMap();
    int startingMarkupVal = 11;
    int ans = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int cell = grid[i][j];
        if (cell == 1) {
          int maxArea = markCells(grid, startingMarkupVal, i, j, n);
          ans = Math.max(ans, maxArea);
          map.put(startingMarkupVal, maxArea);
          startingMarkupVal++;
        }
      }
    }
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int cell = grid[i][j];
        if (cell == 0) {
          Set<Integer> set = new HashSet();
          for (int[] dir : dirs) {
            int next_i = i + dir[0];
            int next_j = j + dir[1];
            if (next_i < 0 || next_j < 0 || next_i >= n || next_j >= n) continue;
            set.add(grid[next_i][next_j]);
          }

          int new_ans_can_be = 1;
          for (int nextIslandNum : set)
            new_ans_can_be = new_ans_can_be + map.getOrDefault(nextIslandNum, 0);
          ans = Math.max(new_ans_can_be, ans);
        }
      }
    }
    return ans;
  }

  public int markCells(int[][] grid, int newVal, int i, int j, int n) {
    int maxCount = 0;
    Deque<int[]> deque = new ArrayDeque();
    deque.add(new int[]{i, j});
    while (deque.size() > 0) {
      int[] details = deque.poll();
      int i1 = details[0];
      int j1 = details[1];
      if (i1 < 0 || j1 < 0 || i1 >= n || j1 >= n) continue;
      int grid_val = grid[i1][j1];
      if (grid_val == 1) {
        maxCount++;
        grid[i1][j1] = newVal;
        deque.add(new int[]{i1 + 1, j1});
        deque.add(new int[]{i1 - 1, j1});
        deque.add(new int[]{i1, j1 + 1});
        deque.add(new int[]{i1, j1 - 1});

      }
    }
    return maxCount;
  }
}
