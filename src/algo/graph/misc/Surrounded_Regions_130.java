package algo.graph.misc;

import utils.CommonLogging;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Surrounded_Regions_130 {

  private char HASH = '#';

  public static void main(String[] args) {
    Surrounded_Regions_130 obj = new Surrounded_Regions_130();
    char[][] board = new char[][]{{'X', 'O', 'X', 'O', 'O', 'O', 'O'}, {'X', 'O', 'O', 'O', 'O', 'O', 'O'}, {'X', 'O', 'O', 'O', 'O', 'X', 'O'},
      {'O', 'O', 'O', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'X', 'O', 'O', 'O', 'O', 'O'}};
    CommonLogging.printArray(board);
    obj.solve(board);
    CommonLogging.printArray(board);
  }

  public void solve(char[][] board) {

    int row = board.length;
    int col = board[0].length;
    boolean[][] visited = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        char cell = board[i][j];
        if (cell == 'O' && !visited[i][j]) {
          process(board, visited, i, j, row, col);
        }
      }
    }
  }

  int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public void process(char[][] board, boolean[][] visited, int i, int j, int row, int col) {

    List<int[]> cellToChange = new ArrayList();
    visited[i][j] = true;
    boolean flip = true;
    Deque<int[]> deque = new ArrayDeque();
    deque.add(new int[]{i, j});
    while (deque.size() > 0) {
      int[] cell_info = deque.poll();
      int row_i = cell_info[0];
      int col_i = cell_info[1];
      cellToChange.add(new int[]{row_i, col_i});
      for (int[] dir : dirs) {
        int new_row_i = row_i + dir[0];
        int new_col_i = col_i + dir[1];
        if (new_row_i < 0 || new_row_i >= row || new_col_i < 0 || new_col_i >= col) return;
        if (visited[new_row_i][new_col_i]) continue;
        visited[new_row_i][new_col_i] = true;

        if (board[new_row_i][new_col_i] == 'O') {
          deque.add(new int[]{new_row_i, new_col_i});
        }
      }
    }
    for (int[] indexToFlip : cellToChange)
      board[indexToFlip[0]][indexToFlip[1]] = 'X';
  }

  public void solve_sol1(char[][] board) {
    int row = board.length;
    int col = board[0].length;

    for (int i = 0; i <= 0; i++) {
      for (int j = 0; j < col; j++) {
        char c = board[i][j];
        if (c == 'O') {
          markNeighbourCellAsO(board, i, j, row, col);
        }
      }
    }

    for (int i = row - 1; i <= row - 1; i++) {
      for (int j = 0; j < col; j++) {
        char c = board[i][j];
        if (c == 'O') {
          markNeighbourCellAsO(board, i, j, row, col);
        }
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j <= 0; j++) {
        char c = board[i][j];
        if (c == 'O') {
          markNeighbourCellAsO(board, i, j, row, col);
        }
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = col - 1; j <= col - 1; j++) {
        char c = board[i][j];
        if (c == 'O') {
          markNeighbourCellAsO(board, i, j, row, col);
        }
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j <= col - 1; j++) {
        char c = board[i][j];
        if (c == 'O') {
          board[i][j] = 'X';
        } else if (c == HASH) {
          board[i][j] = 'O';
        }
      }
    }

  }

  private void markNeighbourCellAsO(char[][] board, int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i > row - 1 || j > col - 1 || board[i][j] != 'O')
      return;
    board[i][j] = HASH;
    markNeighbourCellAsO(board, i - 1, j, row, col);
    markNeighbourCellAsO(board, i + 1, j, row, col);
    markNeighbourCellAsO(board, i, j - 1, row, col);
    markNeighbourCellAsO(board, i, j + 1, row, col);
  }
}
