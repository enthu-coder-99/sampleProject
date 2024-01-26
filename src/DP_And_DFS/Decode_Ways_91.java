package DP_And_DFS;

import java.util.HashMap;

public class Decode_Ways_91 {

  public static void main(String[] args) {


    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("Ram", "Mittal");
    // System.out.println(hashMap);
    hashMap.put("Ram", "Aggarwal");
    hashMap.put("Ram", "Goyal");
    //System.out.println(hashMap);
    //System.out.println(hashMap.size());
    Decode_Ways_91 obj = new Decode_Ways_91();
    int ans = 0;
    // ans = obj.numDecodings_sol_try2("207");//1
    //System.err.println("207- ans=" + ans);
    ans = obj.numDecodings_sol_try2("226");//3
    System.err.println("226- ans=" + ans);
  }

  public int numDecodings_sol_try2(String s) {
    char[] chars = s.toCharArray();
    int l = chars.length;
    int[] dp = new int[l + 1];
    if (chars[0] == '0') return 0;
    dp[1] = 1;
    for (int i = 2; i <= l; i++) {
      int char_i = i - 1;
      char c = (char) chars[char_i];
      char c_prev = (char) chars[char_i - 1];
      System.out.println(i + "- c=" + (char) c + ", c_prev=" + (char) (c_prev));

      if (c == '0') {
        if (c_prev == '0' || c_prev > '2') {
          return -1;
        } else {
          dp[i] = dp[i - 1];
        }
      } else {
        if (c_prev == '1' || (c_prev == '2' && c >= '6')) {
          dp[i] = Math.max(dp[i - 1] + dp[i - 2], dp[i - 2] + 2);
        } else {
          dp[i] = dp[i - 1];
        }
      }
      System.out.println("dp[i] = " + dp[i]);
    }
    return dp[l];
  }

  public int numDecodings_sol_try1(String s) {
    char[] chars = s.toCharArray();
    int l = chars.length;
    int[] dp = new int[l + 1];
    if (chars[0] == '0') return 0;
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i < l; i++) {
      char c = (char) chars[i];
      char c_1 = (char) chars[i - 1];
      System.out.println("c=" + c + ", c_1=" + (char) (c_1));
      if (c == '0') {
        if (c_1 == '1' || c_1 == '2') {
          dp[i + 1] = dp[i - 1];
        } else {
          return 0;
        }
      } else if (c_1 == '1' || (c_1 == '2' && c <= '6')) {
        dp[i + 1] = dp[i] + dp[i - 1];
      } else {
        dp[i + 1] = dp[i];
      }
      System.out.println("dp[i + 1] = " + dp[i + 1]);
    }
    return dp[l];
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