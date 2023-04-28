package Backtracking;

import utils.CommonLogging;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_51 {

  public static void main(String[] args) {
    N_Queens_51 nQueens = new N_Queens_51();
    // new N_Queens_51().solveNQueens(4);
    List<List<String>> lists = nQueens.solveNQueens(4);
    CommonLogging.printListOfListString(lists);
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList();
    findPlaceForQ(0, n, new ArrayList(), result);
    return result;
  }

  public static void findPlaceForQ(int rowPosition, int n, List<int[]> currentQPositions,
                                   List<List<String>> result) {
    if (rowPosition >= n) {
      result.add(prepareAnswer(currentQPositions, n));
      return;
    }
    for (int columnPosition = 0; columnPosition < n; columnPosition++) {
      if (isValidQPosition(rowPosition, columnPosition, n, currentQPositions)) {
        System.out.println("adding- rowPosition=" + rowPosition + ", columnPosition=" + columnPosition);
        currentQPositions.add(new int[]{rowPosition, columnPosition});
        findPlaceForQ(rowPosition + 1, n, currentQPositions, result);
        System.out.println("Removing- rowPosition=" + rowPosition + ", columnPosition=" + columnPosition);
        currentQPositions.remove(currentQPositions.size() - 1);
      }
    }
  }

  public static boolean isValidQPosition(int rowPosition, int columnPosition, int n,
                                         List<int[]> currentQPositions) {
    for (int[] position : currentQPositions) {
      int prevQRow = position[0];
      int prevQCol = position[1];
      if (rowPosition == prevQRow || columnPosition == prevQCol) return false;
      if (
        (rowPosition + columnPosition) == (prevQRow + prevQCol)
          || (rowPosition - columnPosition) == (prevQRow - prevQCol)
      )
        return false;
    }
    return true;
  }

  // ------------------------ First Working Solution------------------------------------
  public static List<List<String>> solveNQueens_1st_working_fin(int n) {
    List<List<int[]>> queenPositionsResult = new ArrayList<>();
    recursion(1, n, new ArrayList<>(), queenPositionsResult);
    List<List<String>> answer = new ArrayList<>();

    for (int i = 0; i < queenPositionsResult.size(); i++) {
      List<int[]> list_i = queenPositionsResult.get(i);
      answer.add(prepareAnswer(list_i, n));
    }
    return answer;
  }

  public static void recursion(int row, int n, List<int[]> currentList, List<List<int[]>> queenPositionsResult) {

    if (currentList.size() >= n) {
      queenPositionsResult.add(new ArrayList(currentList));
      return;
    }
    if (row > n) {
      return;
    }

    for (int col = 1; col <= n; col++) {
      if (!isValidPlaceForThisQueen(row, col, currentList)) continue;
      currentList.add(new int[]{row, col});
      recursion(row + 1, n, currentList, queenPositionsResult);
      currentList.remove(currentList.size() - 1);
    }
  }

  private static boolean isValidPlaceForThisQueen(int r, int c, List<int[]> currentList) {
    for (int[] currentListElm : currentList) {
      int list_r = currentListElm[0];
      int list_c = currentListElm[1];
      if (list_r == r || list_c == c || (r + c) == (list_r + list_c) || (r - c) == (list_r - list_c))
        return false;
    }
    return true;
  }

  private static List<String> prepareAnswer(List<int[]> currentQPositions, int n) {
    CommonLogging.printListOfIntArray("currentQPositions size=  " + currentQPositions.size(), currentQPositions);
    List<String> resList = new ArrayList<>();
    int currentIndex = 0;
    for (int i = 0; i < currentQPositions.size(); i++) {
      StringBuilder sb = new StringBuilder();
      int row_i = currentQPositions.get(currentIndex)[0];
      int col_i = currentQPositions.get(currentIndex)[1];
      for (int j = 0; j < n; j++) {
        if (i == row_i && j == col_i) sb.append("Q");
        else sb.append(".");
      }
      resList.add(sb.toString());
      currentIndex++;
    }
    return resList;
  }
}
