package algo.graph.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class _Matrix_542 {

  public static void main(String[] args) {
    int[][] input = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int[][] res = new _Matrix_542().updateMatrix(input);
    for (int i = 0; i < res.length; i++)
      System.err.println(Arrays.toString(res[i]));

  }

  /**
   * https://leetcode.com/problems/01-matrix/discuss/1369741/C%2B%2BJavaPython-BFS-DP-solutions-with-Picture-Clean-and-Concise-O(1)-Space
   */
  public int[][] updateMatrix(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;
    int[][] result = new int[row][col];
    Deque<List<Integer>> deque = new ArrayDeque<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int cell = mat[i][j];
        if (cell == 0) {
          result[i][j] = 0;
          deque.offer(List.of(i, j));// Just add to queue so that we can process its neighbor first and then neighbour's neighbor and then neighbour's neighbor's neighbour and so on....
        } else {
          result[i][j] = -1;// To identify that is is not processed yet.
        }
      }
    }

    while (deque.size() > 0) {
      List<Integer> zeroValueElement = deque.poll();
      int r_0 = zeroValueElement.get(0);
      int c_0 = zeroValueElement.get(1);
      if (!isValidIndex(r_0, c_0, row, col) || result[r_0][c_0] == -1) continue;
      int cell_value = result[r_0][c_0];

      if (r_0 > 0 && r_0 <= row - 1) {
        int left_cell = result[r_0 - 1][c_0];
        if (left_cell == -1) {
          result[r_0 - 1][c_0] = cell_value + 1;
          deque.add(List.of(r_0 - 1, c_0));
        }
      }

      if (r_0 < row - 1) {
        int right_cell = result[r_0 + 1][c_0];
        if (right_cell == -1) {
          result[r_0 + 1][c_0] = cell_value + 1;
          deque.add(List.of(r_0 + 1, c_0));
        }
      }

      if (c_0 > 0 && c_0 <= col - 1) {
        int up_cell = result[r_0][c_0 - 1];
        if (up_cell == -1) {
          result[r_0][c_0 - 1] = cell_value + 1;
          deque.add(List.of(r_0, c_0 - 1));
        }
      }

      if (c_0 < col - 1) {
        int down_cell = result[r_0][c_0 + 1];
        if (down_cell == -1) {
          result[r_0][c_0 + 1] = cell_value + 1;
          deque.add(List.of(r_0, c_0 + 1));
        }
      }
    }
    return result;
  }


  private boolean isValidIndex(int i, int j, int row, int col) {
    System.err.println("isValidIndex and i=" + i + " and j=" + j);
    if (i < 0 || j < 0 || i >= row || j >= col) {
      return false;
    }
    return true;
  }
}
