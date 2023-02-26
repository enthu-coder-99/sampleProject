package Arrays;

public class Search_A_2D_Matrix_74 {

  public static void main(String[] args) {
    int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};//0,4  1,4
    System.err.println("matrix.length=" + matrix.length);
    System.err.println("matrix[0].length=" + matrix[0].length);
    //System.err.println(searchMatrix(matrix, 3));
    System.err.println(searchMatrix(matrix, 10));

  }
  //00, 01, 02,
  //10, 11, 12,
  //20 21,  22
  //30 31,  32

  //row=4 col=3
  // 7/col
  // right = row -1 and constant = col (second arg)
  // right = col -1 and constant = row (1st arg)

  public static boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;//3
    int col = matrix[0].length;//4
    int leftPointRow = 0;
    int rightPointRow = row * col - 1;
    int midPointRow = 0;

    while (rightPointRow >= leftPointRow) {
      midPointRow = leftPointRow + (rightPointRow - leftPointRow) / 2;
      int matrixValue = matrix[midPointRow / col][midPointRow % col];
      if (matrixValue > target) {
        rightPointRow = midPointRow - 1;
      } else if (matrixValue < target) {
        leftPointRow = midPointRow + 1;
      } else {
        return true;
      }
    }
    System.err.println("midPointRow=" + midPointRow);

    return false;
  }
}
