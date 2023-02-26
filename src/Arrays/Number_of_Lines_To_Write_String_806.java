package Arrays;

public class Number_of_Lines_To_Write_String_806 {


  public int[] numberOfLines(int[] widths, String s) {

    int totalLine = 0;
    int lastLineWidth = 0;
    for (char c : s.toCharArray()) {
      int currentCharPxl = widths[c - 'a'];
      if (lastLineWidth + currentCharPxl > 100) {
        // Goto next line
        totalLine++;
        lastLineWidth = currentCharPxl;
      } else {
        lastLineWidth += currentCharPxl;
      }
    }
    return new int[]{totalLine, lastLineWidth};
  }
}
