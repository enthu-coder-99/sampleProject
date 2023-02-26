package palindrome;

public class Palindromic_Substrings_647 {

  public static void main(String[] args) {
    int n = 20;
      for (int i = 1; i < n; i++) {
        for (int j = 0; j < n; j = j + i) {
          System.err.print((j) + ",");
        }
        System.err.println("");
      }
  }

  public int countSubstrings(String s) {
    int length = s.length();
    int[][] dp = new int[length][length];

    for (int i = 1; i < length; i++) {
      for (int j = 0; j < length; j++) {


      }
    }
    return 0;
  }

}
