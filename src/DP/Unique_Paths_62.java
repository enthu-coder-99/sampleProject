package DP;

public class Unique_Paths_62 {
  public static void main(String[] args) {
    System.err.println(uniquePaths(3, 7));
  }

  public static int uniquePaths(int m, int n) {

    int[][] memo = new int[m][n];//3,7
    for (int i = m - 1; i >= 0; i--) {
      memo[i][n - 1] = 1;
    }

    for (int j = n - 1; j >= 0; j--) {
      memo[m - 1][j] = 1;
    }

    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
      }
    }
    return memo[0][0];
  }

}
