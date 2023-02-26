package algo.graph.dfs_bfs;

public class Max_Area_of_Island_695 {

  public int maxAreaOfIsland(int[][] grid) {
    int maxIslandArea = 0;
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int cellVal = grid[i][j];
        if (cellVal == 1) {
          int[] count = new int[1];
          markIslandBlocks(grid, i, j, row, col, count);
          maxIslandArea = Math.max(maxIslandArea, count[0]);
        }
      }
    }


    return maxIslandArea;
  }

  public void markIslandBlocks(int[][] grid, int i, int j, int row, int col, int[] count) {
    if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) return;
    grid[i][j] = -1;
    count[0]++;
    markIslandBlocks(grid, i + 1, j, row, col, count);
    markIslandBlocks(grid, i - 1, j, row, col, count);
    markIslandBlocks(grid, i, j + 1, row, col, count);
    markIslandBlocks(grid, i, j - 1, row, col, count);
  }
}
