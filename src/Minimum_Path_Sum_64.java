public class Minimum_Path_Sum_64 {

  public static void main(String[] args) {
    int[][] grid = {{2, 3, 4, 11}, {5, 6, 7, 13}};
    System.err.println(grid.length);
    System.err.println(grid[0].length);

  }

  public int minPathSum(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int[][] gridRes = new int[row][col];
    gridRes[row - 1][col - 1] = grid[row - 1][col - 1];
    for (int i = row - 2; i >= 0; i--) {
      gridRes[i][col - 1] = gridRes[i + 1][col - 1] + grid[i][col - 1];
    }

    for (int j = col - 2; j >= 0; j--) {
      gridRes[row - 1][j] = gridRes[row - 1][j + 1] + grid[row - 1][j];
    }

    for (int i = row - 2; i >= 0; i--) {
      for (int j = col - 2; j >= 0; j--) {
        gridRes[i][j] = grid[i][j] + Math.min(gridRes[i + 1][j], gridRes[i][j + 1]);
      }
    }

    return gridRes[0][0];
  }
}
