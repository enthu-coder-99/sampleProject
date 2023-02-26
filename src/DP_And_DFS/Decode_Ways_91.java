package DP_And_DFS;

public class Decode_Ways_91 {

  public static void main(String[] args) {
    int ans = new Decode_Ways_91().numDecodings("207");
    System.err.println("ans=" + ans);
  }

  public int numDecodings(String s) {
    int l = s.length();
    if (s == null || s.equals("") || s.startsWith("0")) return 0;
    if (s.length() == 1) return 1;
    char[] chars = s.toCharArray();
    int[] dp = new int[l + 1];
    dp[0] = 1;
    if (chars[1] == '0') {
      if (chars[0] == '1' || chars[0] == '2')
        dp[1] = 1;
      else
        return 0;
    } else if (isValid(chars, 0)) {
      dp[1] = 2;
    } else {
      dp[1] = 1;
    }


    for (int i = 2; i < l; i++) {
      char c = chars[i];
      if (c == '0') {
        if (chars[i - 1] == '1' || chars[i - 1] == '2') {
          dp[i] = dp[i - 2];
        } else {
          return 0;
        }
      } else if (isValid(chars, i - 1)) {
        dp[i] = (dp[i - 2] * 1) + dp[i - 1];
      } else {
        dp[i] = dp[i - 1];
      }
    }
    System.err.println("Input= " + s + ", Ans = " + dp[l - 1]);
    return dp[l - 1];

  }

  public boolean isValid(char[] chars, int startIndex) {

    StringBuffer append = new StringBuffer().append(chars[startIndex]).append(chars[startIndex + 1]);
    int i = Integer.valueOf(append.toString());
    if (i >= 11 && i <= 26)
      return true;
    return false;
  }
}

//21 10&&