package algo.graph.dfs_bfs;

import utils.CommonLogging;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Swim_in_Rising_Water_778 {

  public int swimInWater(int[][] grid) {
    int n = grid.length;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1},};
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int ans = 0;
    pq.add(new int[]{grid[0][0], 0, 0});
    while (pq.size() > 0) {
      int[] cell_details = pq.poll();
      int cell_value = cell_details[0];
      int x = cell_details[1];
      int y = cell_details[2];
      ans = Math.max(ans, cell_value);
      if (x == n - 1 && y == n - 1) return ans;
      for (int[] dir : dirs) {
        int new_x = x + dir[0];
        int new_y = y + dir[1];
        if (CommonLogging.isValidIndex(new_x, new_y, n, n)) {
          pq.add(new int[]{grid[new_x][new_y], new_x, new_y});
        }
      }
    }
    return ans;
  }

}
