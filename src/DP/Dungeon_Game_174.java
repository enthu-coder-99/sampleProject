package DP;

import utils.CommonLogging;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Dungeon_Game_174 {

  public static void main(String[] args) {
    int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
    System.err.println(calculateMinimumHP(dungeon));
  }

  private static int calculateMinimumHP(int[][] dungeon) {

    int row = dungeon.length;
    int col = dungeon[0].length;
    int[][] dp = new int[row][col];//Power needed to enter [i ,j] cell to reach to princess.
    for (int[] dp_row : dp)
      Arrays.fill(dp_row, Integer.MAX_VALUE);
    int dungeonLastCell = dp[row - 1][col - 1];
    dp[row - 1][col - 1] = powerNeededToEnterThisCell(row - 1, col - 1, dungeon);
    for (int j = row - 2; j >= 0; j--) {
      int dungeonCell = dungeon[j][col - 1];

    }
    return 0;
  }

  private static int powerNeededToEnterThisCell(int i, int j, int[][] dungeon) {
    int dungeonCell = dungeon[i][j];
    return dungeonCell < 0 ? dungeonCell * -1 + 1 : 1;
  }

  public static int calculateMinimumHP_not_well_coded(int[][] dungeon) {
    int ans = 0;
    int row = dungeon.length;
    int col = dungeon[0].length;
    int[][] dp = new int[row][col];
    for (int[] dp_row : dp)
      Arrays.fill(dp_row, Integer.MAX_VALUE);
    dp[0][0] = dungeon[0][0];
    Deque<int[]> deque = new ArrayDeque();
    deque.add(new int[]{0, 0, 0, 0});

    while (deque.size() > 0) {
      int size = deque.size();
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int index = 0; index < size; index++) {
        int[] position = deque.poll();
        int i = position[0];
        int j = position[1];
        int extra_points_taken_in_past = position[2];
        int previous_point = position[3];//3

        int current_cell_point = dungeon[i][j]; // -5

        if ((previous_point + current_cell_point) <= 0) {
          extra_points_taken_in_past = extra_points_taken_in_past + 1 + ((previous_point + current_cell_point) * (-1));
          previous_point = 1;
        } else {
          previous_point = previous_point + current_cell_point;
        }
        System.err.println("#2- i=" + i + ", j=" + j + ", extra_points_taken_in_past=" + extra_points_taken_in_past + ", previous_point=" + previous_point + ", current_cell_point=" + current_cell_point);

        if (isValidIndex(i + 1, j, row, col))
          deque.add(new int[]{i + 1, j, extra_points_taken_in_past, previous_point});

        if (isValidIndex(i, j + 1, row, col))
          deque.add(new int[]{i, j + 1, extra_points_taken_in_past, previous_point});
      }
    }
    CommonLogging.print(dp);
    return dp[row - 1][col - 1];
  }

  public static boolean isValidIndex(int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i >= row || j >= col) return false;
    return true;
  }

}
