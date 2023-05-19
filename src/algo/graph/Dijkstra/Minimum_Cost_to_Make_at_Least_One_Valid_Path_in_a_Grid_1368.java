package algo.graph.Dijkstra;

import java.util.PriorityQueue;

public class Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid_1368 {

  public static void main(String[] args) {

  }

  public static int minCost(int[][] grid) {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row = grid.length;
    int col = grid[0].length;
    int[][] dist = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; i < col; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>();
    pq.add(new int[]{0, 0, 0}); // x, y, cost to reach (from 0,0) to this x,y
    while (pq.size() > 0) {
      int[] cell_info = pq.poll();
      int x = cell_info[0];
      int y = cell_info[1];
      int cost_to_reach_this_cell = cell_info[2];
      int parent_sign = grid[x][y];

      if (x == row - 1 && y == col - 1) return cost_to_reach_this_cell;

      if (dist[x][y] <= cost_to_reach_this_cell) continue;
      for (int[] dir : directions) {
        int child_x = x + dir[0];
        int child_y = y + dir[1];
        if (child_x < 0 || child_y < 0 || child_x >= row || child_y >= col) continue;
        int child_sign = grid[child_x][child_y];
        if (parent_sign == child_sign) {
          pq.add(new int[]{child_x, child_y, cost_to_reach_this_cell});
        } else {
          pq.add(new int[]{child_x, child_y, cost_to_reach_this_cell + 1});

        }
      }
    }
    return -1;
  }
}
