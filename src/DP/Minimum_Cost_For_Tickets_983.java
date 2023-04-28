package DP;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Cost_For_Tickets_983 {

  public int mincostTickets(int[] days, int[] costs) {
    int l = days.length;
    int cost_1 = costs[0];
    int cost_7 = costs[1];
    int cost_30 = costs[2];
    int min_cost = minOfThree(cost_1, cost_7, cost_30);
    int next_30th_day = days[l - 1];
    int next_7th_day = days[l - 1];
    int[] dp = new int[400];
    dp[l - 1] = min_cost;
    for (int i = l - 2; i >= 0; i--) {
      int today = days[i];
      int nextTravelDay = days[i + 1];
      fillDP(dp, today + 1, nextTravelDay - 1, dp[nextTravelDay]);
      dp[i] = minOfThree(dp[today + 1] + cost_1, dp[today + 6] + cost_7, dp[today + 29] + cost_30);
      System.out.println(i + ", today=" + today + ", dp[i]=" + dp[i]);
    }
    return dp[0];
  }

  // inclusive days
  public void fillDP(int[] dp, int startIndex, int endIndex, int val) {
    for (int i = startIndex; i <= endIndex; i++)
      dp[i] = val;

  }

  public int minOfThree(int num1, int num2, int num3) {
    return Math.min(Math.min(num1, num2), num3);
  }

  public static void main(String[] args) {
    String s1 = "great";
    String s2 = "rgeat";
    s1 = "eebaacbcbcadaaedceaaacadccd";
    s2 = "eadcaacabaddaceacbceaabeccd";
    s1 = "abc";
    s2 = "bac";
    System.out.println(isScramble(s1, s2));
  }

  static Map<String, Boolean> memo = new HashMap();

  //
  public static boolean isScramble(String s1, String s2) {
    String log = "s1= " + s1 + ", s2=" + s2;
    System.out.println(log);
    String memoKey = s1 + "_" + s2;
    if (memo.containsKey(memoKey))
      return memo.get(memoKey);
    if (!validate(s1, s2)) {
      memo.put(memoKey, false);
      System.out.println(log + " is not validate");
      return false;
    }

    if (isEqual(s1, s2)) {
      System.out.println(log + " is equal");
      memo.put(memoKey, true);
      return true;
    } else {
      memo.put(memoKey, false);
    }

    int l = s1.length();
    System.out.println(log + " and len=" + l);

    for (int i = 1; i < l; i++) {
      String s1_part1 = s1.substring(0, i);
      String s1_part2 = s1.substring(i, l);
      // Not swapped
      String s2_part1_not_swapped = s2.substring(0, i);
      String s2_part2_not_swapped = s2.substring(i, l);

      //Swapped
      String s2_part1_swapped = s2.substring(0, l - i);// s1_part2
      String s2_part2_swapped = s2.substring(l - i, l);// s1_part1

      if (isEqual(s1_part1, s2_part1_not_swapped) && isEqual(s1_part2, s2_part2_not_swapped)) {
        return true;
      } else {

      }
      if (isEqual(s1_part1, s2_part2_swapped) && isEqual(s1_part2, s2_part1_swapped)) {
        return true;
      } else {

      }

      boolean not_swapped_validated = validate(s1_part1, s2_part1_not_swapped) && validate(s1_part2, s2_part2_not_swapped);
      boolean swapped_validated = validate(s1_part1, s2_part2_swapped) && validate(s1_part2, (s2_part1_swapped));
      System.out.println(s1_part1 + "/" + s1_part2 + " # " + s2_part1_not_swapped + "/" + s2_part2_not_swapped + " # "
        + s2_part1_swapped + "/" + s2_part2_swapped + " # not_swapped_validated=" + not_swapped_validated + ", # swapped_validated=" + swapped_validated);

      if (not_swapped_validated && isScramble(s1_part1, s2_part1_not_swapped) && isScramble(s1_part2, s2_part2_not_swapped))
        return true;
      if (swapped_validated && isScramble(s1_part1, s2_part2_swapped) && isScramble(s1_part2, s2_part1_swapped))
        return true;
    }
    return false;
  }

  public static boolean isEqual(String s1, String s2) {
    if (s1 == null && s2 == null) return true;
    if (s1 == null || s2 == null) return false;
    if (s1.equals(s2)) return true;
    return false;
  }

  public static boolean validate(String s1, String s2) {
    if (s1 == null && s2 == null) return true;
    if (s1 == null || s2 == null) return false;
    if (s1.length() != s2.length()) return false;
    char[] count = new char[27];
    for (int i = 0; i < s1.length(); i++) {
      int c1 = s1.charAt(i);
      int c2 = s2.charAt(i);
      count[c1 - 'a']++;
      count[c2 - 'a']--;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] != 0) return false;
    }
    return true;
  }
}
