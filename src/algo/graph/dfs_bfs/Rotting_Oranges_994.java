package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Rotting_Oranges_994 {

  public static void main(String[] args) {
    int[][] input = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.err.println(new Rotting_Oranges_994().orangesRotting(input));
  }

  public int orangesRotting(int[][] grid) {
    int freshOrangeCount = 0;
    Deque<int[]> rottenOrangeIndexes = new ArrayDeque();
    int timeElapsedAllOrangesWillRotten = 0;
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int orange = grid[i][j];
        if (orange == 1) {
          //Fresh Orange
          freshOrangeCount++;
        } else if (orange == 2) {
          rottenOrangeIndexes.offer(new int[]{i, j});
        }
      }
    }

    while (freshOrangeCount > 0) {
      int size = rottenOrangeIndexes.size();
      if (size == 0) return -1;
      while (size-- > 0) {
        int[] rottenIndexes = rottenOrangeIndexes.poll();
        int r1 = rottenIndexes[0];
        int c1 = rottenIndexes[1];
        if (r1 < 0 || c1 < 0 || r1 >= row || c1 >= col || grid[r1][c1] != 2) continue;

        int[][] neighbourIndexes = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//row+1, row-1, col+1, col-1
        for (int[] neighbourInd : neighbourIndexes) {
          int neighbour_i = r1 + neighbourInd[0];
          int neighbour_j = c1 + neighbourInd[1];
          if (neighbour_i < 0 || neighbour_j < 0 || neighbour_i >= row || neighbour_j >= col) continue;
          int neighbourMango = grid[neighbour_i][neighbour_j];
          if (neighbourMango == 1) {
            grid[neighbour_i][neighbour_j] = 2;
            freshOrangeCount--;
            rottenOrangeIndexes.offer(new int[]{neighbour_i, neighbour_j});
          }
        }
      }
      timeElapsedAllOrangesWillRotten++;
    }
    return timeElapsedAllOrangesWillRotten;
  }
}
