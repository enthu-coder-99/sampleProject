package algo.graph.Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Path_With_Minimum_Effort_1631 {

  static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


  public static void main(String[] args) {
    int[][] grid = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    System.err.println(minimumEffortPath(grid));
  }


  public static int minimumEffortPath(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] visited = new boolean[row][col];
    PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[2] - o2[2];
      }
    }
    );
    pq.offer(new int[]{0, 0, 0});
    while (pq.size() > 0) {
      int[] cell = pq.poll();
      int x = cell[0];
      int y = cell[1];
      int cells_diff = cell[2];
      System.err.println("x=" + x + ", y=" + y + " cells_diff=" + cells_diff);
      visited[x][y] = true;
      if (x == row - 1 && y == col - 1) {
        return cells_diff;
      }
      int cell_val = grid[x][y];

      for (int[] dir : directions) {
        int new_x = x + dir[0];
        int new_y = y + dir[1];
        if (new_x < 0 || new_y < 0 || new_x >= row || new_y >= col || visited[new_x][new_y]) continue;
        pq.offer(new int[]{new_x, new_y,
          Math.max(cells_diff, Math.abs(cell_val - grid[new_x][new_y]))});
        System.err.println("Adding - " + new_x + ", " + new_y + ", " + Math.max(cells_diff, Math.abs(cell_val - grid[new_x][new_y])));
      }
    }
    return -1;
  }
}
