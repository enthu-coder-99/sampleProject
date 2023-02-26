public class Excel_Sheet_Column_Title_168 {

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
