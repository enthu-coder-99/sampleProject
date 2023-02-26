import java.util.LinkedList;

public class Sort_Colors_75 {

  public static void main(String[] args) {
    int[] i = new int[5];
    System.err.println(i.length);
    System.err.println(i[4]);
    System.err.println(78 >> 1);

  }

  public static void sortColors(int[] nums) {
    int red = 0;
    int white = 1;
    int blue = 2;
    int redIndex = -1;
    int whiteIndex = -1;
    int blueIndex = -1;

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num == red) {
        if (redIndex == -1)
          redIndex = i;

      } else if (num == white) {
        whiteIndex = i;
        if (whiteIndex == -1)
          whiteIndex = i;

      } else if (num == blue) {
        if (blueIndex == -1)
          blueIndex = i;
      }
    }
  }
}
