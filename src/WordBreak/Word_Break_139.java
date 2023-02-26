package WordBreak;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public class Word_Break_139 {
  public static void main(String[] args) {
    String s = null;
    List<String> wordDict = null;
    s = "leetcode";
    wordDict = List.of("leet", "code");
    System.err.println(wordBreak(s, wordDict));

    s = "applepenapple";
    wordDict = List.of("apple", "pen");
    System.err.println(wordBreak(s, wordDict));

    s = "catsandog";
    wordDict = List.of("cats", "dog", "sand", "and", "cat");
    System.err.println(wordBreak(s, wordDict));
  }

  public static boolean wordBreak(String s, List<String> wordDict) {
    return wordBreak_bfs(s, new HashSet(wordDict));
  }

  private static boolean wordBreak_bfs(String str, HashSet<String> wordDictionarySet) {

    Deque<String> queue = new ArrayDeque<>();
    HashSet<String> visitedSet = new HashSet<>();
    queue.add(str);
    while (queue.size() > 0) {
      String inputString = queue.pop();
      if (wordDictionarySet.contains(inputString)) return true;
      for (String wordDict : wordDictionarySet) {
        if (inputString.startsWith(wordDict)) {
          String secondHalfSubString = inputString.substring(wordDict.length());
          if (!visitedSet.contains(secondHalfSubString)) {
            queue.add(secondHalfSubString);
            visitedSet.add(secondHalfSubString);
          }
        }
      }
    }
    return false;
  }

}
