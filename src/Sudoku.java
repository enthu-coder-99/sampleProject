import java.util.HashSet;
import java.util.Set;

public class Sudoku {
  private static int MAX_VALUE = 9;

  public static void main(String[] args) {

    char[][] sudoku = {{'1','.','.','.','7','.','.','3','.'},{'8','3','.','6','.','.','.','.','.'},{'.','.','2','9','.','.','6','.','8'},{'6','.','.','.','.','4','9','.','7'},{'.','9','.','.','.','.','.','5','.'},{'3','.','7','5','.','.','.','.','4'},{'2','.','3','.','.','9','1','.','.'},{'.','.','.','.','.','2','.','4','3'},{'.','4','.','.','8','.','.','.','9'}};
    solveSudoku(sudoku);
  }


  public static boolean solveSudoku(char[][] sudoku) {
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
    //System.err.println(sb);
  }
}
