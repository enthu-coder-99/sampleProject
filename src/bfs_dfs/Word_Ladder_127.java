package bfs_dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Word_Ladder_127 {

  public static void main(String[] args) {
    System.err.println("abc".substring(0, 0));
    String beginWord = "aaaaa";
    String endWord = "ggggg";
    List<String> wordList = List.of("aaaaa", "caaaa", "cbaaa", "daaaa", "dbaaa", "eaaaa", "ebaaa", "faaaa", "fbaaa", "gaaaa", "gbaaa", "haaaa", "hbaaa", "iaaaa", "ibaaa", "jaaaa", "jbaaa", "kaaaa", "kbaaa",
      "laaaa", "lbaaa", "maaaa", "mbaaa", "naaaa", "nbaaa", "oaaaa", "obaaa", "paaaa", "pbaaa", "bbaaa", "bbcaa", "bbcba", "bbdaa", "bbdba", "bbeaa", "bbeba", "bbfaa", "bbfba", "bbgaa", "bbgba", "bbhaa",
      "bbhba", "bbiaa", "bbiba", "bbjaa", "bbjba", "bbkaa", "bbkba", "bblaa", "bblba", "bbmaa", "bbmba", "bbnaa", "bbnba", "bboaa", "bboba", "bbpaa", "bbpba", "bbbba", "abbba", "acbba", "dbbba", "dcbba",
      "ebbba", "ecbba", "fbbba", "fcbba", "gbbba", "gcbba", "hbbba", "hcbba", "ibbba", "icbba", "jbbba", "jcbba", "kbbba", "kcbba", "lbbba", "lcbba", "mbbba", "mcbba", "nbbba", "ncbba", "obbba", "ocbba",
      "pbbba", "pcbba", "ccbba", "ccaba", "ccaca", "ccdba", "ccdca", "cceba", "cceca", "ccfba", "ccfca", "ccgba", "ccgca", "cchba", "cchca", "cciba", "ccica", "ccjba", "ccjca", "cckba", "cckca", "cclba",
      "cclca", "ccmba", "ccmca", "ccnba", "ccnca", "ccoba", "ccoca", "ccpba", "ccpca", "cccca", "accca", "adcca", "bccca", "bdcca", "eccca", "edcca", "fccca", "fdcca", "gccca", "gdcca", "hccca", "hdcca",
      "iccca", "idcca", "jccca", "jdcca", "kccca", "kdcca", "lccca", "ldcca", "mccca", "mdcca", "nccca", "ndcca", "occca", "odcca", "pccca", "pdcca", "ddcca", "ddaca", "ddada", "ddbca", "ddbda", "ddeca",
      "ddeda", "ddfca", "ddfda", "ddgca", "ddgda", "ddhca", "ddhda", "ddica", "ddida", "ddjca", "ddjda", "ddkca", "ddkda", "ddlca", "ddlda", "ddmca", "ddmda", "ddnca", "ddnda", "ddoca", "ddoda", "ddpca",
      "ddpda", "dddda", "addda", "aedda", "bddda", "bedda", "cddda", "cedda", "fddda", "fedda", "gddda", "gedda", "hddda", "hedda", "iddda", "iedda", "jddda", "jedda", "kddda", "kedda", "lddda", "ledda",
      "mddda", "medda", "nddda", "nedda", "oddda", "oedda", "pddda", "pedda", "eedda", "eeada", "eeaea", "eebda", "eebea", "eecda", "eecea", "eefda", "eefea", "eegda", "eegea", "eehda", "eehea", "eeida",
      "eeiea", "eejda", "eejea", "eekda", "eekea", "eelda", "eelea", "eemda", "eemea", "eenda", "eenea", "eeoda", "eeoea", "eepda", "eepea", "eeeea", "ggggg", "agggg", "ahggg", "bgggg", "bhggg", "cgggg",
      "chggg", "dgggg", "dhggg", "egggg", "ehggg", "fgggg", "fhggg", "igggg", "ihggg", "jgggg", "jhggg", "kgggg", "khggg", "lgggg", "lhggg", "mgggg", "mhggg", "ngggg", "nhggg", "ogggg", "ohggg", "pgggg",
      "phggg", "hhggg", "hhagg", "hhahg", "hhbgg", "hhbhg", "hhcgg", "hhchg", "hhdgg", "hhdhg", "hhegg", "hhehg", "hhfgg", "hhfhg", "hhigg", "hhihg", "hhjgg", "hhjhg", "hhkgg", "hhkhg", "hhlgg", "hhlhg",
      "hhmgg", "hhmhg", "hhngg", "hhnhg", "hhogg", "hhohg", "hhpgg", "hhphg", "hhhhg", "ahhhg", "aihhg", "bhhhg", "bihhg", "chhhg", "cihhg", "dhhhg", "dihhg", "ehhhg", "eihhg", "fhhhg", "fihhg", "ghhhg",
      "gihhg", "jhhhg", "jihhg", "khhhg", "kihhg", "lhhhg", "lihhg", "mhhhg", "mihhg", "nhhhg", "nihhg", "ohhhg", "oihhg", "phhhg", "pihhg", "iihhg", "iiahg", "iiaig", "iibhg", "iibig", "iichg", "iicig",
      "iidhg", "iidig", "iiehg", "iieig", "iifhg", "iifig", "iighg", "iigig", "iijhg", "iijig", "iikhg", "iikig", "iilhg", "iilig", "iimhg", "iimig", "iinhg", "iinig", "iiohg", "iioig", "iiphg", "iipig",
      "iiiig", "aiiig", "ajiig", "biiig", "bjiig", "ciiig", "cjiig", "diiig", "djiig", "eiiig", "ejiig", "fiiig", "fjiig", "giiig", "gjiig", "hiiig", "hjiig", "kiiig", "kjiig", "liiig", "ljiig", "miiig",
      "mjiig", "niiig", "njiig", "oiiig", "ojiig", "piiig", "pjiig", "jjiig", "jjaig", "jjajg", "jjbig", "jjbjg", "jjcig", "jjcjg", "jjdig", "jjdjg", "jjeig", "jjejg", "jjfig", "jjfjg", "jjgig", "jjgjg",
      "jjhig", "jjhjg", "jjkig", "jjkjg", "jjlig", "jjljg", "jjmig", "jjmjg", "jjnig", "jjnjg", "jjoig", "jjojg", "jjpig", "jjpjg", "jjjjg", "ajjjg", "akjjg", "bjjjg", "bkjjg", "cjjjg", "ckjjg", "djjjg",
      "dkjjg", "ejjjg", "ekjjg", "fjjjg", "fkjjg", "gjjjg", "gkjjg", "hjjjg", "hkjjg", "ijjjg", "ikjjg", "ljjjg", "lkjjg", "mjjjg", "mkjjg", "njjjg", "nkjjg", "ojjjg", "okjjg", "pjjjg", "pkjjg", "kkjjg",
      "kkajg", "kkakg", "kkbjg", "kkbkg", "kkcjg", "kkckg", "kkdjg", "kkdkg", "kkejg", "kkekg", "kkfjg", "kkfkg", "kkgjg", "kkgkg", "kkhjg", "kkhkg", "kkijg", "kkikg", "kkljg", "kklkg", "kkmjg", "kkmkg",
      "kknjg", "kknkg", "kkojg", "kkokg", "kkpjg", "kkpkg", "kkkkg", "ggggx", "gggxx", "ggxxx", "gxxxx", "xxxxx", "xxxxy", "xxxyy", "xxyyy", "xyyyy", "yyyyy", "yyyyw", "yyyww", "yywww", "ywwww", "wwwww",
      "wwvww", "wvvww", "vvvww", "vvvwz", "avvwz", "aavwz", "aaawz", "aaaaz");
    System.err.println(new Word_Ladder_127().ladderLength(beginWord, endWord, wordList));
  }

  public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
    return optimized_BFS_With_processing_of_words_list_128(beginWord, endWord, wordList);
  }

  public List<List<String>> optimized_BFS_With_processing_of_words_list_128(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> resultList = new ArrayList<>();
    int l = beginWord.length();
    Map<String, List<String>> preMap = preprocessWords(wordList, beginWord);//MxN
    System.out.println("preMap=" + preMap);
    Set<String> visited = new HashSet();
    visited.add(beginWord);
    Deque<List<String>> deque = new ArrayDeque();
    deque.offer(List.of(beginWord));
    int depth = 1;
    while (deque.size() > 0) {
      int size = deque.size();
      Set<String> visitedAtThisBFSLevel = new HashSet<>();// We can reuse one word at same level multiple time. But, to next BFS level we will not use same WORD again as it will start the same word search and at level+1 which will cause not short3st path
      for (int i = 0; i < size; i++) {
        List<String> wordsList = deque.poll();
        String word = wordsList.get(wordsList.size() - 1);//Last Word in sequence
        System.out.println("wordsList=" + wordsList);
        for (int j = 0; j < l; j++) {
          String newStr = new StringBuffer(word.substring(0, j)).append("*").append(word.substring(j + 1)).toString();// After flipping once char -- TC - MxN
          if (!preMap.containsKey(newStr)) {
            // System.out.println("newStr = " + newStr + " is not available in map.");
            continue;
          }
          List<String> replaceableStrList = preMap.get(newStr);
          for (String replacableStr : replaceableStrList) {
            if (visited.contains(replacableStr)) {
              continue;
            }
            if (replacableStr.equals(endWord)) {
              System.out.println("Find the endWord visited replacableStr=" + replacableStr);
              List<String> localAnsList = new ArrayList<>(wordsList);
              localAnsList.add(endWord);
              resultList.add(localAnsList);
              continue;
            }
            List<String> newList = new ArrayList<>(wordsList);
            newList.add(replacableStr);
            deque.add(newList);
            visitedAtThisBFSLevel.add(replacableStr);
          }
        }
      }
      visited.addAll(visitedAtThisBFSLevel);
      if (resultList.size() > 0) return resultList;
    }
    return resultList;
  }

  public int optimized_BFS_With_processing_of_words_list_127(String beginWord, String endWord, List<String> wordList) {
    int l = beginWord.length();
    Map<String, List<String>> preMap = preprocessWords(wordList, beginWord);//MxN
    System.out.println("preMap=" + preMap);
    Set<String> visited = new HashSet();
    Deque<String> deque = new ArrayDeque();
    deque.offer(beginWord);
    visited.add(beginWord);
    int depth = 1;
    while (deque.size() > 0) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        String word = deque.poll();
        System.out.println("word=" + word);
        for (int j = 0; j < l; j++) {
          String newStr = new StringBuffer(word.substring(0, j)).append("*").append(word.substring(j + 1)).toString();// After flipping once char -- TC - MxN
          if (!preMap.containsKey(newStr)) {
            System.out.println("newStr = " + newStr + " is not available in map.");
            continue;
          }
          List<String> replacableStrList = preMap.get(newStr);
          for (String replacableStr : replacableStrList) {
            System.out.println("replacableStr=" + replacableStr);
            if (visited.contains(replacableStr)) {
              System.out.println("Already visited replacableStr=" + replacableStr);
              continue;
            }
            visited.add(replacableStr);
            if (replacableStr.equals(endWord)) {
              System.out.println("Find the endWord visited replacableStr=" + replacableStr);
              return depth + 1;
            }
            deque.add(replacableStr);
          }
        }
      }
      depth++;
    }
    return 0;
  }

  public Map<String, List<String>> preprocessWords(List<String> wordList, String beginWord) {
    int l = beginWord.length();
    Map<String, List<String>> preMap = new HashMap<>();

    for (int i = 0; i < wordList.size(); i++) {
      String word_i = wordList.get(i);
      for (int j = 0; j < l; j++) {
        String newStr = new StringBuffer(word_i.substring(0, j)).append("*").append(word_i.substring(j + 1)).toString();
        if (!preMap.containsKey(newStr)) preMap.put(newStr, new ArrayList<>());
        preMap.get(newStr).add(word_i);
      }
    }
    return preMap;
  }

  // Working fine. All test cases passed but slower as we are not preprocessing the Strings. So we should preprocess all Strings and make combinations before hand.
  public int plain_BFS(String beginWord, String endWord, List<String> wordList) {
    int l = beginWord.length();
    Set<String> visited = new HashSet();
    Deque<String> deque = new ArrayDeque();
    deque.offer(beginWord);
    visited.add(beginWord);
    int depth = 1;
    while (deque.size() > 0) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        String word = deque.poll();
        System.out.println("word=" + word);

        for (int j = 0; j < wordList.size(); j++) {
          String nxtWord = wordList.get(j);
          System.out.println("nxtWord=" + nxtWord);
          if (visited.contains(nxtWord)) {
            System.out.println("Already visited nxtWord=" + nxtWord);
            continue;
          }
          if (canBeReplaced(word, nxtWord, l)) {
            if (nxtWord.equals(endWord)) {
              System.out.println("Find the endWord visited nxtWord=" + nxtWord);
              return depth + 1;
            }
            deque.add(nxtWord);
          }
        }
      }
      depth++;
    }
    return 0;
  }


  public boolean canBeReplaced(String str1, String str2, int l) {
    int diff = 0;
    for (int i = 0; i < str1.length(); i++) {
      char c1 = str1.charAt(i);
      char c2 = str2.charAt(i);
      if (c1 != c2) ++diff;
      if (diff > 1) return false;
    }
    return true;
  }

  public int bfs(String start, String endStr, Map<String, List<String>> map) {
    Deque<String> deque = new ArrayDeque();
    Set<String> visited = new HashSet<>();
    deque.add(start);
    int step = 0;
    while (deque.size() > 0) {
      int size = deque.size();
      boolean changed = false;
      for (int i = 0; i < size; i++) {
        String midStr = deque.poll();
        System.err.println("midStr = " + midStr);
        if (!map.containsKey(midStr) || visited.contains(midStr)) continue;
        visited.add(midStr);
        changed = true;
        List<String> futureStrs = map.get(midStr);
        for (String futureStr : futureStrs) {
          if (futureStr.equals(endStr)) return step + 2;
          deque.add(futureStr);
        }
      }
      if (changed) step++;
    }
    return 0;
  }

  // TLE
  public void dfs(List<String> startStrs, String endStr, Map<String, List<String>> map, Set<String> visited, List<List<String>> results) {
    //System.err.println("startStrs = " + String.join(", " + startStrs));
    List<String> midStrs = map.get(startStrs.get(startStrs.size() - 1));
    for (String midStr : midStrs) {
      if (visited.contains(midStr)) continue;
      visited.add(midStr);
      startStrs.add(midStr);
      if (endStr.equals(midStr)) {
        results.add(new ArrayList<>(startStrs));
      }
      dfs(startStrs, endStr, map, visited, results);
      startStrs.remove(midStr);
      visited.remove(midStr);
    }
  }

}
