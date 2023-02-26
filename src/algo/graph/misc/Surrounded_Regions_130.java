package algo.graph.misc;

public class Surrounded_Regions_130 {

  private char HASH = '#';

  public void solve(char[][] board) {
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
