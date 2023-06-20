package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Word_Break_II_140 {

  public static void main(String[] args) {
    System.err.println("abc".substring(0, 0));
    String s = "catsanddog";
    List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
    System.err.println("Ans= " + wordBreak(s, wordDict));

    s = "a";
    wordDict = List.of("a", "cats", "and", "sand", "dog");
  }

  public static List<String> wordBreak(String s, List<String> wordDict) {
    Map<String, List<String>> memo = new HashMap<>();
    System.out.println("memo = " + memo);
    return dfs(s, new HashSet<>(wordDict), memo);
  }

  public static List<String> dfs(String s, Set<String> wordsSet, Map<String, List<String>> memo) {

    System.out.println("s= " + s);
    if (memo.containsKey(s)) return memo.get(s);
    int l = s.length();
    List<String> combi = new ArrayList<>();
    for (int i = 1; i < l; i++) {
      String str1 = s.substring(0, i);
      if (wordsSet.contains(str1)) {
        String str2 = s.substring(i);
        if ((str2).length() == 0) {
          combi.add(str1);
          continue;
        }
        if (wordsSet.contains(str2)) {
          combi.add(str1 + " " + str2);
        }
        List<String> dfs_results = dfs(str2, wordsSet, memo);
        if (dfs_results == null || dfs_results.size() == 0) continue;
        for (String res : dfs_results) {
          combi.add(str1 + " " + res);
        }
      }
    }
    memo.put(s, combi);
    return combi;
  }
}
