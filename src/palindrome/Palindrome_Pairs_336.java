package palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Palindrome_Pairs_336 {

  public static void main(String[] args) {
    System.err.println("abc".substring(2));
  }

  //https://leetcode.com/problems/palindrome-pairs/discuss/79210/The-Easy-to-unserstand-JAVA-Solution
  //https://leetcode.com/problems/palindrome-pairs/discuss/79199/150-ms-45-lines-JAVA-solution
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (words == null || words.length == 0) {
      return res;
    }
    //build the map save the key-val pairs: String - idx
    HashMap<String, Integer> wordToIndexMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      wordToIndexMap.put(words[i], i);
    }

    //special cases: "" can be combine with any palindrome string
    if (wordToIndexMap.containsKey("")) {
      int blankIdx = wordToIndexMap.get("");
      for (int i = 0; i < words.length; i++) {
        if (isPalindrome(words[i])) {
          if (i == blankIdx) continue;
          res.add(List.of(blankIdx, i));
          res.add(List.of(i, blankIdx));
        }
      }
    }

    //find all string and reverse string pairs
    for (int i = 0; i < words.length; i++) {
      String cur_r = reverseStr(words[i]);
      if (wordToIndexMap.containsKey(cur_r)) {
        int found = wordToIndexMap.get(cur_r);
        if (found == i) continue;
        res.add(List.of(i, found));
      }
    }

    //find the pair s1, s2 that
    //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
    //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int cut = 1; cut < word.length(); cut++) {
        String prefix = word.substring(0, cut);
        String suffix = word.substring(cut);

        if (isPalindrome(prefix)) {
          String suffix_reverse = reverseStr(suffix);
          if (wordToIndexMap.containsKey(suffix_reverse) && wordToIndexMap.get(suffix_reverse) != i) {
            res.add(List.of(wordToIndexMap.get(suffix_reverse), i));
          }
        }

        if (isPalindrome(suffix)) {
          String prefix_reverse = reverseStr(prefix);
          if (wordToIndexMap.containsKey(prefix_reverse) && wordToIndexMap.get(prefix_reverse) != i && suffix.length() != 0) {
            res.add(List.of(i, wordToIndexMap.get(prefix_reverse)));
          }
        }
      }
    }
    return res;
  }

  public String reverseStr(String str) {
    StringBuilder sb = new StringBuilder(str);
    return sb.reverse().toString();
  }

  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}