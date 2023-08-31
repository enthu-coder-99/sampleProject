public class Excel_Sheet_Column_Title_168 {
  /**
   * A   1     AA    26+ 1     BA  2×26+ 1     ...     ZA  26×26+ 1     AAA  1×26²+1×26+ 1
   * B   2     AB    26+ 2     BB  2×26+ 2     ...     ZB  26×26+ 2     AAB  1×26²+1×26+ 2
   * .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
   * .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
   * .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
   * Z  26     AZ    26+26     BZ  2×26+26     ...     ZZ  26×26+26     AAZ  1×26²+1×26+26
   */

  /**
   * A-1    AA-1x26 +1   BA-2x26 +1  CA- 3x26 +1   ZA- 26x26 +1   AAA- 26x26 +26 +1
   * B-2    AB-1x26 +2   BB-2x26 +2  CB- 3x26 +2   ZB- 26x26 +2   AAB- 26x26 +26 +2
   * <p>
   * <p>
   * Z-26   AZ-1x26 +26  BZ-2x26 +26 CZ- 3x26 +26  ZZ- 26x26 +26  AAZ- 26x26 +26 +26
   */

  //https://leetcode.com/problems/excel-sheet-column-title/discuss/51404/Python-solution-with-explanation
  public static void main(String[] args) {
    // System.err.println(convertToTitle(3));
    //System.err.println(convertToTitle(28));
    // System.err.println(convertToTitle_leetcode(1000));//AAL
    // System.err.println(convertToTitle_leetcode(28));//AB
    System.err.println(convertToTitle(52));// 25 + 676 = ZY
    System.err.println(convertToTitle(26));// 25 + 676 = Z
    System.err.println(convertToTitle(1));// A

    //System.err.println(convertToTitle_leetcode(701));// 25 + 676 = ZY
    //25 - Y
    //26 - Z
    //27 - AA
    //52 - AZ
    //53 - BA
    //55 - BD
  }

  //ALL(1000) = L + L*26 + A*26*26 =  12+ 12*26 + 1*26*26 = 12 + 312+ 676
  public static String convertToTitle(int n) {
    StringBuilder result = new StringBuilder();

    while (n > 0) {
      n--;
      int remainder = n % 26;
      result.append((Character.valueOf((char) ('A' + remainder))));
      n = n / 26;
    }
    return result.reverse().toString();
  }
}
