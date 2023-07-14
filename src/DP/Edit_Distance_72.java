package DP;

import java.util.Arrays;

public class Edit_Distance_72 {

  public static void main(String[] args) {
    Edit_Distance_72 obj = new Edit_Distance_72();
    String word1 = "nt";
    String word2 = "ut";
    int ans = obj.minDistance(word1, word2);
    System.out.println("Ans= " + ans);
  }

  public int minDistance(String word1, String word2) {
    char[] w1_chars = word1.toCharArray();
    char[] w2_chars = word2.toCharArray();
    int w1_len = w1_chars.length;
    int w2_len = w2_chars.length;
    int[][] memo = new int[w1_len][w2_len];
    for (int i = 0; i < memo.length; i++)
      Arrays.fill(memo[i], -1);
    recursion(w1_chars, w2_chars, 0, 0, memo);
    return by_dp(w1_chars, w2_chars);
  }

  private int by_dp(char[] w1_chars, char[] w2_chars) {
    int w1_len = w1_chars.length;
    int w2_len = w2_chars.length;

    int[][] memo = new int[w1_len + 1][w2_len + 1];

    for (int i = 0; i <= w1_len; i++) {
      memo[i][0] = i;
    }

    for (int j = 0; j <= w2_len; j++) {
      memo[0][j] = j;
    }

    for (int i = 1; i <= w1_len; i++) {
      char w1_char = w1_chars[i - 1];
      for (int j = 1; j <= w2_len; j++) {
        char w2_char = w2_chars[j - 1];
        if (w1_char == w2_char) {
          memo[i][i] = memo[i - 1][j - 1];
        } else {
          memo[i][i] = 1 + Math.min(memo[i - 1][j - 1], Math.min(memo[i - 1][j], memo[i][j - 1]));
        }
      }
    }
    return memo[w1_len][w2_len];
  }

  // Workig perfect
  private int recursion(char[] w1_chars, char[] w2_chars, int w1_index, int w2_index, int[][] memo) {
    int w1_len = w1_chars.length;
    int w2_len = w2_chars.length;
    if (w1_index == w1_len) return Math.abs(w2_len - w2_index);
    if (w2_index == w2_len) return Math.abs(w1_len - w1_index);

    if (memo[w1_index][w2_index] >= 0) return memo[w1_index][w2_index];
    char w1_char = w1_chars[w1_index];
    char w2_char = w2_chars[w2_index];

    int ans = 0;
    if (w1_char == w2_char) {
      System.out.println("w1_char=" + w1_char + ", w2_char=" + w2_char + " are same. w1_index=" + w1_index + ", w2_index=" + w2_index);
      ans = recursion(w1_chars, w2_chars, w1_index + 1, w2_index + 1, memo);
    } else {
      int edit_ops = recursion(w1_chars, w2_chars, w1_index + 1, w2_index + 1, memo);
      int add_ops = recursion(w1_chars, w2_chars, w1_index + 1, w2_index, memo);
      int delete_ops = recursion(w1_chars, w2_chars, w1_index, w2_index + 1, memo);
      System.out.println("w1_index=" + w1_index + ", w2_index=" + w2_index + ", edit_ops=" + edit_ops
        + ", add_ops=" + add_ops + ", delete_ops=" + delete_ops);
      ans = 1 + Math.min(edit_ops, Math.min(add_ops, delete_ops));
    }
    return memo[w1_index][w2_index] = ans;
  }
}
