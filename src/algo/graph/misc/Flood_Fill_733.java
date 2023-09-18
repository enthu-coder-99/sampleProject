package algo.graph.misc;

public class Flood_Fill_733 {

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int startingColor = image[sr][sc];
    perform(image, sr, sc, startingColor, color);
    return image;
  }


  public void perform(int[][] image, int sr, int sc, int startingColor, int newColor) {

    int row = image.length;
    int col = image[0].length;
    if (sr < 0 || sr >= row || sc < 0 || sc >= col) return;
    int currentCOlor = image[sr][sc];
    if (currentCOlor == newColor || currentCOlor != startingColor) return;
    image[sr][sc] = newColor;
    perform(image, sr + 1, sc, startingColor, newColor);
    perform(image, sr - 1, sc, startingColor, newColor);
    perform(image, sr, sc + 1, startingColor, newColor);
    perform(image, sr, sc - 1, startingColor, newColor);
  }
}
