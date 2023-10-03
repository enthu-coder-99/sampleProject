package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Synonymous_Sentences_1258 {

  public static void main(String[] args) {


    Double[] arry = new Double[10];
    Double d = Double.valueOf(12);

    // arry[0] = new Double(1);
    System.out.println(arry[0]);

  }

  public List<String> generateSentences(List<List<String>> synonyms, String text) {


    Map<String, Set<String>> graph = new HashMap<>();
    int l = synonyms.size();
    for (int i = 0; i < l; i++) {
      List<String> syn = synonyms.get(i);
      String from = syn.get(0);
      String to = syn.get(1);
      connect(graph, from, to);

    }
    return null;
  }

  public List<String> bfs(String source, Map<String, Set<String>> graph) {
    Set<String> visited = new HashSet<>();
    visited.add(source);
    Deque<String> deque = new ArrayDeque<>();
    deque.add(source);
    while (deque.size() > 0) {
      String sourceStr = deque.poll();
    }
    return null;
  }

  void connect(Map<String, Set<String>> graph, String v1, String v2) {
    graph.putIfAbsent(v1, new HashSet<>());
    graph.putIfAbsent(v2, new HashSet<>());

    graph.get(v1).add(v2);
    graph.get(v2).add(v1);

  }
}
