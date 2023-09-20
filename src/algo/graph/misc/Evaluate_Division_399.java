package algo.graph.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Evaluate_Division_399 {


  public static void main(String[] args) {
    System.err.println("Hellow");
    List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
    double[] values = {2.0, 3.0};
    List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
    double[] doubles = new Evaluate_Division_399().calcEquation(equations, values, queries);
    Arrays.stream(doubles).forEach(e -> System.err.print(e + ", "));
    System.err.println();
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    double[] result = new double[queries.size()];
    Map<String, Map<String, Double>> memoMap = buildMemoMap(equations, values);
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String from = query.get(0);
      String to = query.get(1);
      Double value = dfs(from, to, new HashSet<String>(), memoMap);
      result[i] = value;
    }
    return result;
  }

  private double bfs(String fromQuery, String toQuery, Map<String, Map<String, Double>> graph) {

    Deque<String> deque = new ArrayDeque<>();
    deque.offer(fromQuery);
    while (deque.size() > 0) {
      String fromSubQuery = deque.poll();
      if (!graph.containsKey(fromSubQuery)) continue;
      if (graph.get(fromSubQuery).containsKey(toQuery))
        return graph.get(fromSubQuery).get(toQuery);
      deque.addAll(graph.get(fromSubQuery).keySet());
    }
    return 0;
  }


  private double dfs(String fromQuery, String toQuery, Set<String> visited, Map<String, Map<String, Double>> graph) {
    System.err.println(fromQuery + " : " + toQuery);
    /* easy case. */
    if (graph.containsKey(fromQuery) && graph.get(fromQuery).containsKey(toQuery)) {
      return graph.get(fromQuery).get(toQuery);
    }

    /* easy case. */
    if (fromQuery.equals(toQuery) && graph.containsKey(fromQuery)) {
      return 1.0;
    }
    // If we find the value
    if (!graph.containsKey(fromQuery) || !graph.containsKey(toQuery))
      return -1.0;

    visited.add(fromQuery);

    Double returnValue = -1.0;
    Set<String> toValuesMapKeySet = graph.get(fromQuery).keySet();
    for (String toValuesMapKey : toValuesMapKeySet) {
      if (visited.contains(toValuesMapKey)) continue;
      Double queryMultipler = graph.get(fromQuery).get(toValuesMapKey);
      Double subQueryResult = dfs(toValuesMapKey, toQuery, visited, graph);
      if (subQueryResult > 0) {
        returnValue = queryMultipler * subQueryResult;
        addValueMemoMap(fromQuery, toQuery, returnValue, graph);
        return returnValue;
      }
    }
    return returnValue;
  }

  static Map<String, Map<String, Double>> buildMemoMap(List<List<String>> equations, double[] values) {
    Map<String, Map<String, Double>> memoMap = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
      List<String> equation = equations.get(i);
      String from = equation.get(0);
      String to = equation.get(1);
      addValueMemoMap(from, to, values[i], memoMap);
    }
    return memoMap;
  }

  static void addValueMemoMap(String from, String to, double value, Map<String, Map<String, Double>> memoMap) {
    if (!memoMap.containsKey(from))
      memoMap.put(from, new HashMap<>());
    memoMap.get(from).put(to, value);

    if (!memoMap.containsKey(to))
      memoMap.put(to, new HashMap<>());
    memoMap.get(to).put(from, 1 / value);

  }

  /**
   * A--2B
   * A--3C
   * A--4D
   *
   * B--1/2A
   * C--1/3A
   * D--1/4A
   *
   * A--2B
   * B--3C
   */
}
