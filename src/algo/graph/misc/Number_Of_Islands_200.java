package algo.graph.misc;

public class Number_Of_Islands_200 {

  char HASH = '#';

  public int numIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int resultCount = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        char cell = grid[i][j];
        if (cell == '1') {
          resultCount++;
          flipTheValueToHash(grid, i, j, row, col);
        }
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        char cell = grid[i][j];
        if (cell == HASH) {
          grid[i][j] = '1';
        }
      }
    }
    return resultCount;
  }

  private void flipTheValueToHash(char[][] grid, int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i > row - 1 || j > col - 1 || grid[i][j] != '1')
      return;

    grid[i][j] = HASH;
    flipTheValueToHash(grid, i + 1, j, row, col);
    flipTheValueToHash(grid, i - 1, j, row, col);
    flipTheValueToHash(grid, i, j + 1, row, col);
    flipTheValueToHash(grid, i, j - 1, row, col);
  }
}
