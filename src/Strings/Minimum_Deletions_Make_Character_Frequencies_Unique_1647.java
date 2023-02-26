package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Minimum_Deletions_Make_Character_Frequencies_Unique_1647 {

  public static void main(String[] args) {
    //System.err.println(minDeletions1("aab"));
    //System.err.println(minDeletions1("aaabbbcc"));
    System.err.println(minDeletions1("bbcebab"));

  }

  public static int minDeletions1(String s) {
    return solution2(s);
  }

  public static int solution2(String s) {
    int result = 0;
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a'] = Math.max(1, count[s.charAt(i) - 'a'] + 1);
    }
    Set<Integer> countSet = new HashSet<>();
    for (int i = 0; i < count.length; i++) {
      int currCnt = count[i];
      if (currCnt > 0) {
        while (countSet.contains(currCnt) && currCnt > 0) {
          currCnt--;
          result++;
        }
        countSet.add(currCnt);
      }
    }
    return result;
  }

  public static int solution1(String s) {
    int result = 0;
    int[] count = new int[26];
    Arrays.fill(count, -1);
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a'] = Math.max(1, count[s.charAt(i) - 'a'] + 1);
    }
    Set<Integer> countSet = new HashSet<>();
    for (int i = 0; i < count.length; i++) {
      int currCnt = count[i];
      while (countSet.contains(currCnt) && currCnt > 0) {
        currCnt--;
        result++;
      }
      if (currCnt == 0)
        break;
      countSet.add(currCnt);
    }
    return result;
  }
}
