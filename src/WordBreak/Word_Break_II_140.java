package WordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Word_Break_II_140 {
  // abcd (0,4
  // APPLEBANANA (APPLE, BANANA)

  /**
   * A->B->C->D->E
   * A->B B->A
   * B->C A->C C->A
   * C->D D->C
   */
  public static void main(String[] args) {
    String str = null;
    List wordList = null;

/*    str = "catsanddog";
    wordList = List.of("cat", "cats", "and", "sand", "dog", "andd", "og");*/

    str = "aaaaaaa";
    wordList = List.of("aaaa", "aa", "a");
    List<String> list = wordBreak(str, wordList);
    System.err.println("list= " + list);
    System.err.println("cacheMap= " + memoMap);

   /* str = "pineapplepenapple";
    wordList = List.of("apple", "pen", "applepen", "pine", "pineapple");
    list = wordBreak(str, wordList);
    System.err.println(list);*/
  }

  static Map<String, List<String>> memoMap = new HashMap<>();

  public static List<String> wordBreak(String s, List<String> w) {
    wordBreak(s, new HashSet(w));
    return memoMap.get(s);
  }


  public static List<String> wordBreak(String s, Set<String> dict) {

    if (memoMap.containsKey(s))
      return memoMap.get(s);

    List<String> resultList = new ArrayList<>();
    if (dict.contains(s))
      resultList.add(s);
    int s_len = s.length();
    for (int i = 1; i < s_len; i++) {
      String firstHalfSubStr = s.substring(0, i);
      if (dict.contains(firstHalfSubStr)) {
        System.err.println("Dist list contains= " + firstHalfSubStr);
        String residualSubStr = s.substring(i);
        if (residualSubStr.length() > 0) {
          System.err.println("residualSubStr= " + residualSubStr);
          List<String> wordBreakResultList = wordBreak(residualSubStr, dict);
          System.err.println("wordBreakResultList= " + wordBreakResultList);
          for (String wordBreakResult : wordBreakResultList) {
            resultList.add(firstHalfSubStr + " " + wordBreakResult);
            memoMap.put(s, resultList);
          }
        }
      }
    }
    return resultList;
  }

  private static boolean containsSuffix(Set<String> dict, String str) {

    return false;
  }


  /*
  -------Solution#1 Started----
  public static List<String> wordBreak(String s, List<String> wordList) {
    Map<String, List<String>> cacheMap = new HashMap<String, List<String>>();
    wordBreak_dfs(s, "", new HashSet<>(wordList), cacheMap);
    return cacheMap.get(s) != null ? cacheMap.get(s) : new ArrayList<>();
  }

  public static void wordBreak_dfs(String residualInputStr, String intermediateResultStr, Set<String> wordDictList,
                                   Map<String, List<String>> cacheMap) {

    if (residualInputStr == null || residualInputStr.length() == 0) {
      String strWithNoSpace = getInputStrWithNoSpace(intermediateResultStr);
      if (cacheMap.containsKey(strWithNoSpace)) {
        cacheMap.get(strWithNoSpace).add(intermediateResultStr.trim());
      } else {
        cacheMap.put(strWithNoSpace, new ArrayList<>(List.of(intermediateResultStr.trim())));
      }
      return;
    }

    for (String wordDict : wordDictList) {
      if (residualInputStr.startsWith(wordDict)) {
        wordBreak_dfs(residualInputStr.substring(wordDict.length()),
          intermediateResultStr + " " + wordDict, wordDictList, cacheMap);
      }
    }
  }

  public static String getInputStrWithNoSpace(String str) {
    return str.replaceAll(" ", "").trim();
  }
    -------Solution#1 Ended----

  */
}