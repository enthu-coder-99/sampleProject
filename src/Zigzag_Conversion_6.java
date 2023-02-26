import utils.CommonLogging;

import java.util.ArrayList;
import java.util.List;

public class Zigzag_Conversion_6 extends CommonLogging {
  public static void main(String[] args) {
    System.err.println(convert("PAYPALISHIRING", 3));
  }

  public static String convert(String s, int numRows) {
    List<StringBuilder> list = new ArrayList<StringBuilder>(numRows);
    for (int i = 0; i < numRows; i++)
      list.add(i, new StringBuilder());
    boolean directionDown = true;
    int index = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char currentChar = chars[i];
      if (directionDown) {
        list.get(index).append(currentChar);
      } else {
        list.get(numRows - 1 - index).append(currentChar);
      }
      index++;
      if (index == numRows || index == 0) {
        directionDown = !directionDown;
        index = 1;
      }
    }
    return String.join("", list);
  }
}
