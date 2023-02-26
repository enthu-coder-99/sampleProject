package algo.graph.misc;

public class Flood_Fill_733 {

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {

    int row = image.length;
    int col = image[0].length;
    for (int i = sr; i < row; i++) {
      for (int j = sc; j < col; j++) {
        int cellColor = image[i][j];
        flipColor(image, sr, sc, row, col, color, cellColor);
      }
    }
    return image;
  }

  public void flipColor(int[][] image, int i, int j, int row, int col, int newColor, int centerCellColor) {
    if (i < 0 || j < 0 || i >= row || j >= col || image[i][j] != centerCellColor) {
      return;
    }
    image[i][j] = newColor;
    flipColor(image, i - 1, j, row, col, newColor, centerCellColor);
    flipColor(image, i + 1, j, row, col, newColor, centerCellColor);
    flipColor(image, i, j - 1, row, col, newColor, centerCellColor);
    flipColor(image, i, j + 1, row, col, newColor, centerCellColor);
  }
}
