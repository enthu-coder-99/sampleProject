package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Shortest_Path_in_Binary_Matrix_1091 {

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
    int result[][] = new int[n][n];// distance travelled to reach this point.
    for (int i = 0; i < n; i++) {
      Arrays.fill(result[i], Integer.MAX_VALUE);
    }
    Deque<int[]> queue = new ArrayDeque();
    queue.offer(new int[]{0, 0, 0});
    int[][] directions = new int[][]{{1, 1}, {1, 0}, {0, 1}, {-1, 0}, {0, -1},
      {-1, 1}, {1, -1}, {-1, -1}};
    while (queue.size() > 0) {
      int[] cell = queue.poll();
      int row = cell[0];
      int col = cell[1];
      int distanceTravelledToReachThisPoint = cell[2];
      if (result[row][col] <= distanceTravelledToReachThisPoint) continue;
      result[row][col] = distanceTravelledToReachThisPoint;
      for (int[] dir : directions) {
        int new_r = row + dir[0];
        int new_c = col + dir[1];
        if (new_r < 0 || new_c < 0 || new_r > n - 1 || new_c > n - 1 || grid[new_r][new_c] == 1) continue;
        queue.offer(new int[]{new_r, new_c,  distanceTravelledToReachThisPoint + 1});
      }
    }
    return result[n - 1][n - 1]==Integer.MAX_VALUE? -1: result[n - 1][n - 1];
  }
}
