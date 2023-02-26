import utils.CommonLogging;

public class Flood_Fill_733 {

  public static void main(String[] args) {
    int[][] input = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    CommonLogging.printArray(floodFill(input, 1, 1, 2));
  }

  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];
    flip(image, sr, sc, oldColor, newColor);
    return image;
  }

  public static void flip(int[][] image, int sr, int sc, int oldColor, int newColor) {
    System.err.println("sr=" + sr + " sc=" + sc + " ");
    if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) return;

    image[sr][sc] = newColor;
    flip(image, sr + 1, sc, oldColor, newColor);
    flip(image, sr - 1, sc, oldColor, newColor);
    flip(image, sr, sc + 1, oldColor, newColor);
    flip(image, sr, sc - 1, oldColor, newColor);
  }
}
