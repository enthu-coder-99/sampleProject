package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Concatenated_Words_472 {

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    int l = words.length;
    List<String> ans = new ArrayList<>();
    Arrays.sort(words,
      new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          return o1.length() - o2.length();
        }
      }
    );
    Set<String> wordSet = new HashSet<>();
    wordSet.add(words[0]);

    for (int i = 1; i < l; i++) {
      String word = words[i];
      boolean canSplit = dfs(word, wordSet);
      if (canSplit)
        ans.add(word);
      wordSet.add(word);
    }
    return ans;
  }

  private boolean dfs(String word, Set<String> wordSet) {
    if (wordSet.contains(word) || word.length() == 0)
      return true;
    int l = word.length();
    for (int i = 1; i < l; i++) {
      String str1 = word.substring(0, i);
      if (wordSet.contains(str1)) {
        String str2 = word.substring(i);
        if (dfs(str2, wordSet))
          return true;
      }
    }
    return false;
  }

}
