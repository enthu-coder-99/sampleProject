package algo.graph.topoSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Alien_Dictionary_269 {

  public static void main(String[] args) {
    String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
    words = new String[]{"abc", "ab"};
    System.err.println("Ans = " + alienOrder(words));
  }

  // Topological Sort is the algo
  public static String alienOrder(String[] words) {

    int l = words.length;
    Map<Integer, List<Integer>> preToPostMap = new HashMap();
    Map<Integer, Integer> inOrderCountMap = new HashMap();

    for (int i = 0; i < l; i++) {
      char[] word_i = words[i].toCharArray();
      for (char c : word_i) {
        preToPostMap.put(c - 'a', new ArrayList<>());
        inOrderCountMap.put(c - 'a', 0);
      }
    }

    for (int i = 0; i < l - 1; i++) {
      char[] word_i = words[i].toCharArray();
      for (int j = i + 1; j < l; j++) {
        char[] word_j = words[j].toCharArray();
        if (!processFirstDiff(word_i, word_j, preToPostMap, inOrderCountMap))
          return "";
      }
    }
    System.out.println("preToPostMap= " + preToPostMap);
    for (int key : preToPostMap.keySet()) {
      List<Integer> val = preToPostMap.get(key);
      System.out.print(getChar(key));
      System.out.print("=");
      val.forEach(e -> System.out.print(getChar(e) + ", "));
      System.out.println("");
    }

    System.out.println("inOrderCountMap= " + inOrderCountMap);
    for (int key : inOrderCountMap.keySet()) {
      int val = inOrderCountMap.get(key);
      System.out.println(getChar(key) + " = " + val + ", ");
    }

    StringBuilder answer = new StringBuilder();
    runBFS(preToPostMap, inOrderCountMap, answer);
    return answer.toString();
  }

  public static boolean processFirstDiff(char[] word_i, char[] word_j, Map<Integer, List<Integer>> preToPostMap, Map<Integer, Integer> inOrderCountMap) {
    int l1 = word_i.length;
    int l2 = word_j.length;
    for (int i = 0; i < l1; i++) {
      int word_i_index = word_i[i] - 'a';// it will come first
      if (i >= l2) return false;
      int word_j_index = word_j[i] - 'a';// it will come second or after i

      if (word_i_index != word_j_index) {
        preToPostMap.get(word_i_index).add(word_j_index);
        inOrderCountMap.put(word_j_index, inOrderCountMap.getOrDefault(word_j_index, 0) + 1);
        return true;
      }
    }
    return false;
  }

  public static char getChar(int i) {
    return (char) (i + 'a');
  }

  public static void runBFS(Map<Integer, List<Integer>> preToPostMap, Map<Integer, Integer> inOrderCountMap, StringBuilder answer) {
    Deque<Integer> deque = new ArrayDeque<>();
    Set<Integer> inorderCountKeys = inOrderCountMap.keySet();
    for (int inOrderChar : inorderCountKeys) {
      if (inOrderCountMap.get(inOrderChar) == 0) {// That char is there and no dependecy
        deque.add(inOrderChar);
      }
    }
    while (deque.size() > 0) {
      int prefix = deque.poll();
      System.out.println("preffix= " + getChar(prefix) + " size=" + deque.size());
      answer.append(getChar(prefix));

      if (preToPostMap.containsKey(prefix)) {
        List<Integer> suffixList = preToPostMap.get(prefix);
        for (int suffix : suffixList) {
          Integer dependencyCount = inOrderCountMap.get(suffix);
          if (dependencyCount > 0) {
            dependencyCount--;
            inOrderCountMap.put(suffix, dependencyCount);
            if (dependencyCount == 0) {
              deque.add(suffix);
            }
          }
        }
      }
    }
  }
}
