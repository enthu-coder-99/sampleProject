package algo.graph.dfs_bfs;

import utils.CommonLogging;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Pacific_Atlantic_Water_Flow_417 {

  public static void main(String[] args) {
    int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
    List<List<Integer>> lists = pacificAtlantic(heights);
    CommonLogging.printListOfListInt(lists);
  }

  public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> ans = new ArrayList<>();

    int row = heights.length;
    int col = heights[0].length;
    Deque<int[]> pac_queue = new ArrayDeque<>();
    boolean[][] pac_cells = new boolean[row][col];

    Deque<int[]> atlan_queue = new ArrayDeque<>();
    boolean[][] atlan_cells = new boolean[row][col];

    for (int j = 0; j < col; j++) {
      //First row iterator
      int i = 0;
      int cell_height = heights[i][j];
      pac_queue.add(new int[]{i, j});
      pac_cells[i][j] = true;
    }

    for (int j = 0; j < col; j++) {
      //Last row iterator
      int i = row - 1;
      int cell_height = heights[i][j];
      atlan_queue.add(new int[]{i, j});
      atlan_cells[i][j] = true;
    }

    for (int i = 0; i < row; i++) {
      //First col iterator
      int j = 0;
      int cell_height = heights[i][j];
      pac_queue.add(new int[]{i, j});
      pac_cells[i][j] = true;
    }

    for (int i = 0; i < row; i++) {
      //Last col iterator
      int j = col - 1;
      int cell_height = heights[i][j];
      atlan_queue.add(new int[]{i, j});
      atlan_cells[i][j] = true;
    }
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    bfs(heights, pac_queue, pac_cells, new boolean[row][col], row, col, directions);
    bfs(heights, atlan_queue, atlan_cells, new boolean[row][col], row, col, directions);

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (pac_cells[i][j] && atlan_cells[i][j]) {
          System.out.println("i= " + i + ", j=" + j + " is both in atlnatic and pacific side...");
          ans.add(List.of(i, j));
        }
      }
    }

    return ans;
  }

  private static void bfs(int[][] heights, Deque<int[]> deque, boolean[][] already_true_marked_cells,
                          boolean[][] visited,
                          int row, int col, int[][] directions) {
    while (deque.size() > 0) {
      int[] current_cell_loc = deque.poll();
      int x = current_cell_loc[0];
      int y = current_cell_loc[1];
      if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y]) continue;
      visited[x][y] = true;
      //check neighbour should be equal or bigger
      int current_cell = heights[x][y];

      for (int[] dir : directions) {
        int new_x = x + dir[0];
        int new_y = y + dir[1];
        if (new_x < 0 || new_y < 0 || new_x >= row || new_y >= col) continue;
        int neighbour_cell = heights[new_x][new_y];
        if (neighbour_cell >= current_cell) {
          already_true_marked_cells[new_x][new_y] = true;
          deque.add(new int[]{new_x, new_y});
        }
      }
    }
  }

}
