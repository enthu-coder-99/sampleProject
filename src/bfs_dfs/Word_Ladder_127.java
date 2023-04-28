package bfs_dfs;

import bst.base.TreeNode;

import java.math.BigInteger;
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

      List<Object> l = new ArrayList<>();
      l.add("String122");
      l.add(22222);
      l.add(new Integer((45)));
      l.add(new BigInteger("56565"));
       l.add(new TreeNode(2));

    l.forEach(e-> System.err.println(e));


    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = List.of("hot", "dot", "tog", "cog");
    System.err.println(new Word_Ladder_127().ladderLength(beginWord, endWord, wordList));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0;

    Map<String, List<String>> map = adjacencyList(wordList, beginWord);
    List<List<String>> results = new ArrayList<>();
    List<String> startStrs = new ArrayList<>();
    startStrs.add(beginWord);
    return bfs(beginWord, endWord, map);

/*   Deque<String> deque = new ArrayDeque<>();
     deque.add(beginWord);
     while (deque.size() > 0) {
     String startingStr = deque.poll();
     if (!map.containsKey(startingStr)) continue;
    }*/
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
      if (changed)
        step++;
    }
    return 0;
  }

  // TLE
  public void dfs(List<String> startStrs, String
    endStr, Map<String, List<String>> map, Set<String> visited, List<List<String>> results) {
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

  public Map<String, List<String>> adjacencyList(List<String> wordList, String beginWord) {
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < wordList.size(); i++) {
      String word_i = wordList.get(i);

      if (!word_i.equals(beginWord) && canBeReplaced(word_i, beginWord)) {
        if (!map.containsKey(beginWord)) map.put(beginWord, new ArrayList<>());
        map.get(beginWord).add(word_i);
      }
      if (i >= wordList.size() - 1) continue;
      for (int j = i + 1; j < wordList.size(); j++) {
        String word_j = wordList.get(j);
        if (canBeReplaced(word_i, word_j)) {
          if (!map.containsKey(word_i)) map.put(word_i, new ArrayList<>());
          if (!map.containsKey(word_j)) map.put(word_j, new ArrayList<>());
          map.get(word_i).add(word_j);
          map.get(word_j).add(word_i);
        }
      }
    }
    return map;
  }

  public boolean canBeReplaced(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    int diff = 0;
    for (int i = 0; i < str1.length(); i++) {
      char c1 = str1.charAt(i);
      char c2 = str2.charAt(i);
      if (c1 != c2)
        ++diff;
      if (diff > 1) return false;
    }
    return true;
  }


}
