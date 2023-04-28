package DP;

public class Longest_Palindromic_Subsequence_516 {

  public static void main(String[] args) {
    String s = "bbbab";
    System.err.println(longestPalindromeSubseq(s));
  }

  public static int longestPalindromeSubseq(String s) {
    return dp_solution(s, new StringBuffer(s).reverse().toString());
  }


  private static int dp_solution(String text1, String text2) {

    int l1 = text1.length();
    int l2 = text2.length();
    if (l1 == 0 || l2 == 0) return 0;
    if (l1 == l2 && text1.equals(text2)) return l1;
    int[][] dp = new int[l1 + 1][l2 + 1];
    char[] text1_c = text1.toCharArray();
    char[] text2_c = text2.toCharArray();

    for (int i = 1; i <= l1; i++) {
      char c1 = text1_c[i - 1];
      for (int j = 1; j <= l2; j++) {
        char c2 = text2_c[j - 1];
        if (c1 == c2) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[l1][l2];
  }
}
