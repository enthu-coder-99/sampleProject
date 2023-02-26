package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Valid_Sudoku_36 {

  public static void main(String[] args) {
    char[][] board =
      {
        {'8', '3', '.', '.', '7', '.', '1', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '1'},
        {'.', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '.'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    System.err.println(isValidSudoku(board));


  }


  public static boolean isValidSudoku(char[][] board) {
    if (!isSudokuColsValid(board)) {
      System.err.println("Columns are invalid.");
      return false;
    }

    if (!isSudokuRowsValid(board)) {
      System.err.println("Rows are invalid.");
      return false;
    }
    for (int i = 0; i < 9; i = i + 3) {
      for (int j = 0; j < 9; j = j + 3) {
        if (!isSudokuBlocksValid(board, i, j)) return false;
      }
    }
    return true;
  }


  public static boolean isSudokuBlocksValid(char[][] board, int startRowIndex, int startColIndex) {
    System.err.println("startRowIndex=" + startRowIndex + " and startColIndex=" + startColIndex);
    Set<Character> set = new HashSet();
    for (int i = startRowIndex; i < startRowIndex + 3; i++) {
      for (int j = startColIndex; j < startColIndex + 3; j++) {
        char num = board[i][j];
        if (num != '.' && set.contains(num)) return false;
        set.add(num);
      }
    }
    return true;
  }


  public static boolean isSudokuRowsValid(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      Set<Character> set = new HashSet();
      for (int j = 0; j < board[0].length; j++) {
        char num = board[i][j];
        if (num != '.' && set.contains(num)) return false;
        set.add(num);
      }
    }
    return true;
  }

  public static boolean isSudokuColsValid(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      Set<Character> set = new HashSet();
      for (int j = 0; j < board[0].length; j++) {
        char num = board[j][i];
        if (num != '.' && set.contains(num)) {
          return false;
        }
        set.add(num);
      }
    }
    return true;
  }
}
