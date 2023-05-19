package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class All_Paths_From_Source_to_Target_797 {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new ArrayList();
    dfs(0, new ArrayList<>(), result, graph);
    return result;
  }

  private void dfs(int start, List<Integer> current, List<List<Integer>> result, int[][] graph) {
    int n = graph.length;
    current.add(start);
    if (start == n - 1) {
      result.add(new ArrayList<>(current));
      return;
    }

    int[] neighborNodeList = graph[start];
    if (neighborNodeList == null || neighborNodeList.length == 0) return;
    for (Integer neighbor : neighborNodeList) {
      dfs(neighbor, current, result, graph);
      current.remove(current.size() - 1);
    }
  }

  private void bfs(List<List<Integer>> result, int[][] graph) {
    int n = graph.length;
    Deque<List<Integer>> deque = new ArrayDeque<>();
    deque.add(List.of(0));
    while (deque.size() > 0) {
      List<Integer> parent_node_list = deque.poll();
      int last_inserted_node = parent_node_list.get(parent_node_list.size() - 1);
      if (last_inserted_node == n - 1) {
        result.add(parent_node_list);
        continue;
      }
      int[] neighborNodeList = graph[last_inserted_node];
      if (neighborNodeList == null || neighborNodeList.length == 0) continue;
      for (Integer neighbor : neighborNodeList) {
        ArrayList<Integer> newList = new ArrayList<>(parent_node_list);
        newList.add(neighbor);
        deque.add(newList);
      }
    }
  }


  public Map<Integer, List<Integer>> buildAdjMap(int[][] graph) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < graph.length; i++) {
      int[] to_list = graph[i];
      int from = i;
      if (!map.containsKey(from)) map.put(from, new ArrayList<>());
      if (to_list != null && to_list.length > 0) {
        for (int to : to_list)
          map.get(from).add(to);
      }
    }
    return map;
  }
}
