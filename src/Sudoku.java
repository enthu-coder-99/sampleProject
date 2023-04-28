import java.util.HashSet;
import java.util.Set;

public class Sudoku {
  private static int MAX_VALUE = 9;

  public static void main(String[] args) {

    char[][] board = {{'1', '.', '.', '.', '7', '.', '.', '3', '.'}, {'8', '3', '.', '6', '.', '.', '.', '.', '.'}, {'.', '.', '2', '9', '.', '.', '6', '.', '8'}, {'6', '.', '.', '.', '.', '4', '9', '.', '7'}, {'.', '9', '.', '.', '.', '.', '.', '5', '.'}, {'3', '.', '7', '5', '.', '.', '.', '.', '4'}, {'2', '.', '3', '.', '.', '9', '1', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '4', '3'}, {'.', '4', '.', '.', '8', '.', '.', '.', '9'}};
    boolean b = solveSudoku(board);
    System.err.println("Answer is=" + b);
    printSudoku(board);

  }

  public static boolean solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char cell = board[i][j];
        if (cell == '.') {
          for (char k = '1'; k <= '9'; k++) {
            if (valid(i, j, k, board)) {
              board[i][j] = k;
              if (!solveSudoku(board)) {
                board[i][j] = '.';
              } else {
                return true;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  public static boolean valid(int row, int col, char k, char[][] board) {
    //System.out.println("row= "+row+", col= "+col+", value= "+board[row][col]);
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 9; i++) {
      if (board[row][i] == k || board[i][col] == k) return false;
    }

    int x = (row / 3) * 3;//2
    int y = (col / 3) * 3;//2
    System.out.println("x= " + x + " , y=" + y);

    for (int i = x; i < x + 3; i++) {
      for (int j = y; j < y + 3; j++) {
        char cell = board[i][j];
        if (cell == k) return false;
      }
    }

    System.out.println("#4 returning true");
    return true;

  }


  public static boolean solveSudoku_old_working_fine_1(char[][] sudoku) {
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku[0].length; j++) {
        char value = sudoku[i][j];
        if (value == '.') {
          for (int matrixVal = 1; matrixVal <= MAX_VALUE; matrixVal++) {
            if (validValueForThisCell(sudoku, Character.forDigit(matrixVal, 10), i, j)) {
              sudoku[i][j] = Character.forDigit(matrixVal, 10);
              if (solveSudoku(sudoku)) {
                return true;
              } else {
                sudoku[i][j] = '.';
                System.err.println("Resetting value to .");
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private static boolean validValueForThisCell(char[][] sudoku, char matrixVal, int i, int j) {
    // Current row and col not having this value. And this subMatrix also not having this value before hand.
    printSudoku(sudoku);
    for (int index = 0; index < MAX_VALUE; index++) {
      if (sudoku[index][j] == matrixVal || sudoku[i][index] == matrixVal) {
        return false;
      }
    }
    // Check if this subMatrix already has this matrixVal.
    Set<Character> numbersInSubMatrix = getNumbersInSubMatrix(sudoku, i, j);
    if (numbersInSubMatrix.contains(matrixVal))
      return false;
    return true;
  }

  private static Set<Character> getNumbersInSubMatrix(char[][] sudoku, int i, int j) {
    Set<Character> numbersInSubMatrix = new HashSet<>();
    int rowNumberReminder = i / 3;
    int colNumberReminder = j / 3;
    int startRowIndexForSubMatrix = rowNumberReminder * 3;
    int startColIndexForSubMatrix = colNumberReminder * 3;
    int endRowIndexForSubMatrix = startRowIndexForSubMatrix + 3;
    int endColIndexForSubMatrix = startColIndexForSubMatrix + 3;
    for (int i1 = startRowIndexForSubMatrix; i1 < endRowIndexForSubMatrix; i1++) {
      for (int j1 = startColIndexForSubMatrix; j1 < endColIndexForSubMatrix; j1++) {
        //System.err.println("sudoku[i1][j1]=" + sudoku[i1][j1]);
        if (sudoku[i1][j1] != '.') {
          numbersInSubMatrix.add(sudoku[i1][j1]);
        }
      }
    }
    return numbersInSubMatrix;
  }


  private static void printSudoku(char[][] sudoku) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku[0].length; j++) {
        char value = sudoku[i][j];
        sb.append(value + "|");
        if (j % 3 == 2) {
          sb.append("\t");
        }
      }
      sb.append("\n");
    }
    System.err.println(sb);
  }
}
