package algo.graph.unionFind;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Islands_II_305 {

  public static void main(String[] args) {
    Number_of_Islands_II_305 obj = new Number_of_Islands_II_305();
    int m = 8;
    int n = 4;
    int[][] positions = new int[][]{{0, 0}, {7, 1}, {6, 1}, {3, 3}, {4, 1}};
    List<Integer> ansList = obj.numIslands2(m, n, positions);
    System.out.println(ansList);
  }

  public List<Integer> numIslands2(int m, int n, int[][] positions) {

    int row = m;
    int col = n;
    int[][] grid = new int[row][col];
    int noOfCells = m * n;
    UnionFindTemplate um = new UnionFindTemplate(noOfCells);
    int l = positions.length;
    List<Integer> ansList = new ArrayList<>();
    int totalComponentsCount = 0;
    for (int i = 0; i < l; i++) {
      int[] position = positions[i];
      int x = position[0];
      int y = position[1];
      int compCountWithPosition = mergeCells(x, y, row, col, grid, um);
      System.out.println("x= " + x + ", y= " + y + ", compCountWithPosition= " + compCountWithPosition);
      totalComponentsCount = totalComponentsCount + compCountWithPosition;
      ansList.add(totalComponentsCount);
    }
    return ansList;
  }

  int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1},};

  private int mergeCells(int x, int y, int row, int col, int[][] grid, UnionFindTemplate um) {
    int compCount = 1;
    if (grid[x][y] == 1) return 0;
    grid[x][y] = 1;
    int cell_no = getCellNo(x, y, row, col);

    for (int[] dir : dirs) {
      int new_x = x + dir[0];
      int new_y = y + dir[1];
      if (!isValidIndex(new_x, new_y, row, col)) continue;
      if (grid[new_x][new_y] == 1) {
        // merge this.
        int new_cell_no = getCellNo(new_x, new_y, row, col);
        System.out.println("x= " + x + " , y= " + y + ", and thee new_x= " + new_x + ", new_y= " + new_y + ". new_cell_no=" + new_cell_no);

        if (um.merge(cell_no, new_cell_no)) {
          System.out.println("cell_no=" + cell_no + ", new_cell_no=" + new_cell_no + " and going to merge...");
          --compCount;
        } else {
          System.out.println("cell_no=" + cell_no + ", new_cell_no=" + new_cell_no + " and NOT Going to merge...");
        }
      }
    }
    return compCount;
  }


  private int getCellNo(int x, int y, int row, int col) {
    return (x * col) + y;
  }

  private static boolean isValidIndex(int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i >= row || j >= col) return false;
    return true;
  }


}


