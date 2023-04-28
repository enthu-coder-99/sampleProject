package algo.graph.dfs_bfs;

import bst.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Amount_of_Time_for_Binary_Tree_to_Be_Infected_2385 {
  /**
   * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/discuss/2483972/Java-one-pass-DFS-(14-ms-beats-100)
   https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/discuss/2465369/BFS-vs.-DFS
   */
  public int amountOfTime(TreeNode root, int start) {
    Map<Integer, List<Integer>> graphMap = new HashMap<>();
    buildGraph(root, graphMap);
    Set<Integer> visited = new HashSet();
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(start);
    int minutes = 0;
    while (deque.size() > 0) {
      int length = deque.size();
      boolean infectedAnyNode = false;
      for (int i = 0; i < length; i++) {
        Integer nodeVal = deque.poll();
        if (visited.contains(nodeVal)) continue;
        visited.add(nodeVal);
        deque.addAll(graphMap.get(nodeVal));
        infectedAnyNode = true;
      }

      if (infectedAnyNode) minutes++;
    }
    return minutes;
  }

  public void buildGraph(TreeNode node, Map<Integer, List<Integer>> graphMap) {
    if (node == null) return;

    if (!graphMap.containsKey(node.val)) graphMap.put(node.val, new ArrayList());
    if (node.left != null) {
      TreeNode left = node.left;
      if (!graphMap.containsKey(left.val)) graphMap.put(left.val, new ArrayList());
      graphMap.get(node.val).add(left.val);
      graphMap.get(left.val).add(node.val);
      buildGraph(left, graphMap);
    }
    if (node.right != null) {
      TreeNode right = node.right;
      if (!graphMap.containsKey(right.val)) graphMap.put(right.val, new ArrayList());
      graphMap.get(node.val).add(right.val);
      graphMap.get(right.val).add(node.val);
      buildGraph(right, graphMap);
    }
  }
}
