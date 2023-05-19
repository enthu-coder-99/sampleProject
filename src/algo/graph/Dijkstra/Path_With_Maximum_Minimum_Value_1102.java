package algo.graph.Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Path_With_Maximum_Minimum_Value_1102 {

  public static void main(String[] args) {
    int[][] grid = new int[][]{{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
    System.err.println(maximumMinimumPath(grid));
  }

  static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public static int maximumMinimumPath(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] visited = new boolean[row][col];
    PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[2] - o1[2];
      }
    }
    );
    pq.offer(new int[]{0, 0, grid[0][0], grid[0][0]});
    while (pq.size() > 0) {
      int[] cell = pq.poll();
      int x = cell[0];
      int y = cell[1];
      int cell_val = cell[2];
      int min_val = cell[3];
      visited[x][y] = true;
      System.err.println("x= " + x + ", y= " + y + ", min_val= " + min_val + ", cell_val= " + cell_val);
      if (x == row - 1 && y == col - 1) {
        return Math.min(min_val, cell_val);
      }
      for (int[] dir : directions) {
        int new_x = x + dir[0];
        int new_y = y + dir[1];
        if (new_x < 0 || new_y < 0 || new_x >= row || new_y >= col || visited[new_x][new_y]) continue;
        visited[new_x][new_x] = true;
        pq.offer(new int[]{new_x, new_y, grid[new_x][new_y], Math.min(min_val, grid[new_x][new_y])});
      }
    }
    return -1;
  }
}
