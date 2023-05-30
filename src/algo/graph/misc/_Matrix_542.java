package algo.graph.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class _Matrix_542 {

  public static void main(String[] args) throws InterruptedException {
    int[][] input = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
    input = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {0, 0, 0}};
    int[][] res = new _Matrix_542().updateMatrix(input);

    for (int i = 0; i < res.length; i++)
      System.err.println(Arrays.toString(res[i]));
  }

  public int[][] updateMatrix(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;
    int[][] ans = new int[row][col];
    Deque<int[]> queue = new ArrayDeque();
    int countOfOnes = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int cell = mat[i][j];
        if (cell == 0) {
          queue.add(new int[]{i, j});
        } else {
          countOfOnes++;
          ans[i][j] = -1;
        }
      }
    }
    int level = 1;
    OUTER:
    while (queue.size() > 0 && countOfOnes > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] zeroThCell = queue.poll();
        int x = zeroThCell[0];
        int y = zeroThCell[1];
        int[][] nextCells = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] nextCell : nextCells) {
          int next_x = x + nextCell[0];
          int next_y = y + nextCell[1];
          if (isValidIndex(next_x, next_y, row, col) && mat[next_x][next_y] == 1 && ans[next_x][next_y] == -1) {
            ans[next_x][next_y] = level;
            countOfOnes--;
            if (countOfOnes == 0) break OUTER;
            queue.add(new int[]{next_x, next_y});

          }
        }
      }
      level++;
    }
    return ans;
  }

  public int[][] updateMatrix_old2(int[][] mat) throws InterruptedException {
    int row = mat.length;
    int col = mat[0].length;
    int[][] ans = new int[row][col];
    Deque<int[]> queue = new ArrayDeque();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int cell = mat[i][j];
        if (cell == 1) {
          ans[i][j] = -1;
        }
        if (cell == 0) {
          queue.add(new int[]{i, j});//having all solved or whose distance is already calculated. These elements should help tot their neighbor.
        }
      }
    }
    bfs(ans, queue);
    return ans;
  }

  public void bfs(int[][] ans, Deque<int[]> queue) throws InterruptedException {
    int row = ans.length;
    int col = ans[0].length;
    int level = 0;
    int[][] nextCells = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    while (queue.size() > 0) {
      int size = queue.size();
      for (int l = 0; l < size; l++) {
        int[] elm = queue.poll();
        int i = elm[0];
        int j = elm[1];// This current cell is always solved one so it will help in solving its neighbour
        if (!isValidIndex(i, j, row, col)) continue;

        System.err.println("i= " + i + ", j= " + j);
        for (int[] next : nextCells) {
          int i1 = i + next[0];
          int j1 = j + next[1];
          if (isValidIndex(i1, j1, row, col) && ans[i1][j1] != 0) {
            System.err.println("Adding - i1= " + i1 + ", j1= " + j1);
            queue.add(new int[]{i1, j1});
          }
        }
      }
      level++;
      System.err.println("====================================================");
      // Thread.sleep(5000L);
    }
  }

  /**
   * https://leetcode.com/problems/01-matrix/discuss/1369741/C%2B%2BJavaPython-BFS-DP-solutions-with-Picture-Clean-and-Concise-O(1)-Space
   */
  public int[][] updateMatrix_old(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;
    int[][] result = new int[row][col];
    Deque<List<Integer>> deque = new ArrayDeque<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int cell = mat[i][j];
        if (cell == 0) {
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


  private static boolean isValidIndex(int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i >= row || j >= col) {
      return false;
    }
    return true;
  }
}
