package DP;

import java.util.HashMap;
import java.util.Map;

public class Longest_Ideal_Subsequence_2370 {

  public static void main(String[] args) {
    System.err.println(longestIdealString("abcd", 2));
  }

  public static int longestIdealString(String s, int k) {
    int longestIdealStr = 0;
    int strLength = s.length();
    int[] memoArray = new int[26];
    for (int i = strLength - 1; i >= 0; i--) {
      int c = s.charAt(i) - 'a';
      int maxLengthWithThisChar = 0;
      for (int j = Math.max(0, c - k); j <= Math.min(25, c + k); j++) {
        maxLengthWithThisChar = Math.max(maxLengthWithThisChar, memoArray[j]);
      }
      memoArray[c] = maxLengthWithThisChar + 1;
      longestIdealStr = Math.max(longestIdealStr, maxLengthWithThisChar + 1);
    }
    return longestIdealStr;
  }

  public static int longestIdealString_hashMap(String s, int k) {
    int longestIdealStr = 0;
    int strLength = s.length();
    Map<Integer, Integer> memoMap = new HashMap<>();
    for (int i = strLength - 1; i >= 0; i--) {
      char c = s.charAt(i);
      int maxLengthWithThisChar = 0;
      for (int j = c - k; j <= c + k; j++) {
        maxLengthWithThisChar = Math.max(maxLengthWithThisChar, memoMap.getOrDefault(j, 0));
      }
      memoMap.put((int) c, maxLengthWithThisChar + 1);
      longestIdealStr = Math.max(longestIdealStr, maxLengthWithThisChar + 1);
    }
    return longestIdealStr;
  }
}
