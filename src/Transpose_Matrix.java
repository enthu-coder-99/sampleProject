public class Transpose_Matrix {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    print(matrix);
    print(transpose(matrix));
  }

  public static int[][] transpose(int[][] matrix) {
    int[][] transposed = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length ; i++) {
      for (int j = 0; j <matrix[0].length ; j++) {
        transposed[j][i] = matrix[i][j];
      }
    }
    return transposed;
  }

  public static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.err.print(matrix[i][j] + ",");
      }
      System.err.println();
    }
  }
}
