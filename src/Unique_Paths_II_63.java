public class Unique_Paths_II_63 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rows = obstacleGrid.length;
    int cols = obstacleGrid[0].length;
    int[][] result = new int[rows][cols];
    boolean obstracle = false;
    for (int i = rows - 2; i >= 0; i--) {
      if (obstacleGrid[i][cols - 1] == 1) {
        break;
      }
      result[i][cols - 1] = 1;
    }

    for (int j = cols - 1; j >= 0; j--) {
      if (obstacleGrid[rows - 1][j] == 1) {
        break;
      }
      result[rows - 1][j] = 1;
    }

    for (int i = rows - 2; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {
        if (obstacleGrid[i][j] != 1) {
          result[i][j] = result[i + 1][j] + result[i][j + 1];
        }
      }
    }
    return result[0][0];
  }
}
