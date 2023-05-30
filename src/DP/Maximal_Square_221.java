package DP;

public class Maximal_Square_221 {

  public static int maximalSquare(char[][] matrix) {
    return dp_solution(matrix);
  }


  public static int dp_solution(char[][] matrix) {
    int ans = 0;
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] dp = new int[row][col];

    for (int i = row - 1; i < row; i++) {
      for (int j = 0; j < col; j++) {
        char cell = matrix[i][j];
        if (cell == '1') {
          dp[i][j] = 1;
          ans = 1;
        }
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = col - 1; j < col; j++) {
        char cell = matrix[i][j];
        if (cell == '1') {
          dp[i][j] = 1;
          ans = 1;
        }
      }
    }

    for (int i = row - 2; i >= 0; i--) {
      for (int j = col - 2; j >= 0; j--) {
        char cell = matrix[i][j];
        if (cell == '1') {
          dp[i][j] = 1;
          if (matrix[i + 1][j + 1] == '1') {
            int max_sq_edge = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
            if (max_sq_edge > 0) {
              dp[i][j] = (int) ((Math.sqrt(max_sq_edge) + 1) * (Math.sqrt(max_sq_edge) + 1));
            }
          }
          ans = Math.max(ans, dp[i][j]);
        }
      }
    }
    return ans;
  }


  public static int bruteForce(char[][] matrix) {
    int ans = 0;
    int row = matrix.length;
    int col = matrix[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        char cell = matrix[i][j];
        if (cell == '1') {
          int local_i = i;
          int local_j = j;
          int next_i = local_i + 1;//next row
          int next_j = local_j + 1;//next col

          while (next_i < row && next_j < col && matrix[next_i][next_j] == '1'
            && nextRowAndColAreOnes(matrix, i, j, next_i, next_j)) {
            local_i++;
            local_j++;
            next_i++;
            next_j++;
          }
          int sq_len = local_i - i + 1;
          ans = Math.max(ans, sq_len * sq_len);
        }
      }
    }
    return ans;
  }
  //row = 4 col = 5
  // i =1 j = 2
  // next_i = 2 , next_j = 3
  //

  private static boolean nextRowAndColAreOnes(char[][] matrix, int i, int j, int next_i, int next_j) {
    for (int k = i; k < next_i; k++) {
      // check next row values
      if (matrix[k][next_j] != '1') return false;
    }
    for (int k = j; k < next_j; k++) {
      // check next row values
      if (matrix[next_i][k] != '1') return false;
    }
    return true;
  }
}
