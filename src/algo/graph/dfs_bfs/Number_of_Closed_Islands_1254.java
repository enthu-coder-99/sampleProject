package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Number_of_Closed_Islands_1254 {

  public int closedIsland(int[][] grid) {
    int result = 0;
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++)   {
      for (int j = 0; j < col; j++) {
        int cell = grid[i][j];
        if (cell == 0) {
          grid[i][j] = -1;
          boolean isClosedIsland = bfs(i, j, grid);
          if (isClosedIsland) result++;
        }
      }
    }
    return result;
  }

  private boolean bfs(int i, int j, int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(new int[]{i, j});
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while (deque.size() > 0) {
      int[] new_cell = deque.poll();
      int new_i = new_cell[0];
      int new_j = new_cell[1];

      for (int[] dir : directions) {
        int dir_i = new_i + dir[0];
        int dir_j = new_j + dir[1];
        if (dir_i < 0 || dir_j < 0 || dir_i > row - 1 || dir_j > col - 1) return false;// if it is out of boundary
        int dir_cell = grid[dir_i][dir_j];
        if (dir_cell == 0) {
          deque.offer(new int[]{dir_i, dir_j});
          grid[dir_i][dir_j] = -1;
        }
      }
    }

    return true;
  }
}
