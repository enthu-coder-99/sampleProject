package DP;

import java.util.Arrays;

public class Distinct_Subsequences_115 {


  public static void main(String[] args) {
    Distinct_Subsequences_115 obj = new Distinct_Subsequences_115();
    String s = "rabbbit", t = "rabbit";
    // s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
    // t = "bcddceeeebecbc";
    int final_ans = obj.recursion(s, t, 0, 0);
    System.out.println("final_ans= " + final_ans);
  }

  public int recursion(String s, String t, int s_start_index, int t_start_index) {
    int s_len = s.length();
    int t_len = t.length();
    if (t_start_index >= t_len) {
      return 1;
    }

    if (t_start_index > s_start_index) {
      return 0;
    }
    if (s_start_index >= s_len) {
      return 0;
    }
    if (t_len > s_len) {
      return 0;
    }
    int ans = 0;

    char t_char = t.charAt(t_start_index);
    for (int j = s_start_index; j < s_len; j++) {
      char s_char = s.charAt(j);
      if (s_char == t_char) {
        int tmpAns = recursion(s, t, j + 1, t_start_index + 1);
        ans = ans + tmpAns;
        System.out.println("j=" + j + ", s_char=" + s_char + ", t_char=" + t_char + ", s_start_index="
          + s_start_index + ", t_start_index=" + t_start_index + ", tmpAns=" + tmpAns + ", ans=" + ans);
      }
    }
    System.out.println("s_start_index=" + s_start_index + ", t_start_index=" + t_start_index + ", ans=" + ans);

    return ans;
  }

  public int numDistinct(String s, String t) {
    char[] s_chars = s.toCharArray();
    char[] t_chars = t.toCharArray();
    int s_len = s_chars.length;
    int t_len = t_chars.length;
    int[][] memo = new int[s_len][t_len];
    for (int i = 0; i < memo.length; i++)
      Arrays.fill(memo[i], -1);
    return recursion(s_chars, t_chars, 0, 0, memo);
  }

  public int recursion_dp(char[] s_chars, char[] t_chars) {
    int s_len = s_chars.length;
    int t_len = t_chars.length;
    if (t_len > s_len) return 0;

    int[][] dp = new int[s_len + 1][t_len + 1];//target,source - This order is must.

    for (int i = 0; i <= s_len; i++) {
      dp[i][0] = 1;// If target is empty or blank.
    }

    for (int i = 1; i <= s_len; i++) {
      for (int j = 1; j <= t_len; j++) {
        if (s_chars[i - 1] == t_chars[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1];
        }
        dp[i][j] += dp[i - 1][j];
      }
    }
    return dp[s_len][t_len];
  }


  public int recursion(char[] s_chars, char[] t_chars, int s_start_index, int t_start_index, int[][] memo) {
    int s_len = s_chars.length;
    int t_len = t_chars.length;
    if (t_start_index >= t_len) {
      memo[s_start_index][t_start_index] = 1;
      return 1;
    }

    if (s_start_index >= s_len) {
      memo[s_start_index][t_start_index] = 0;
      return 0;
    }
    if (memo[s_start_index][t_start_index] >= 0) return memo[s_start_index][t_start_index];
    int result = 0;
    for (int s_i = s_start_index; s_i < s_len; s_i++) {
      char s_char = s_chars[s_i];
      char t_char = t_chars[t_start_index];
      if (s_char == t_char) {
        result = result + recursion(s_chars, t_chars, s_i + 1, t_start_index + 1, memo);
      }
    }
    memo[s_start_index][t_start_index] = result;
    return result;
  }


}
