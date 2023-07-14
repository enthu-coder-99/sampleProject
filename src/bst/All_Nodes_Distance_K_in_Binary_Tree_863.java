package bst;

import bst.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class All_Nodes_Distance_K_in_Binary_Tree_863 {

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> nodeToParentMap = buildMap(root);
    return bfs(nodeToParentMap, target, k);
  }

  public List<Integer> bfs(Map<TreeNode, TreeNode> nodeToParentMap, TreeNode target, int k) {
    List<Integer> ans = new ArrayList<>();
    List<TreeNode> deque = new LinkedList<>();
    deque.add(target);
    Set<TreeNode> visited = new HashSet<>();
    while (deque.size() > 0 && k > 0) {
      k--;
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.remove(0);
        if (node == null || visited.contains(node)) continue;
        visited.add(node);

        TreeNode parent = nodeToParentMap.get(node);
        if (parent != null && !visited.contains(parent))
          deque.add(parent);
        if (node.left != null && !visited.contains(node.left))
          deque.add(node.left);
        if (node.right != null && !visited.contains(node.right))
          deque.add(node.right);
      }
    }
    return deque.stream().map(e -> e.val).collect(Collectors.toList());
  }

  private Map<TreeNode, TreeNode> buildMap(TreeNode root) {
    Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
    nodeToParentMap.put(root, null);
    childToParentMap(nodeToParentMap, root);
    return nodeToParentMap;
  }

  private void childToParentMap(Map<TreeNode, TreeNode> nodeToParentMap, TreeNode node) {
    if (node == null) return;

    if (node.left != null) {
      nodeToParentMap.put(node.left, node);
      childToParentMap(nodeToParentMap, node.left);
    }

    if (node.right != null) {
      nodeToParentMap.put(node.right, node);
      childToParentMap(nodeToParentMap, node.right);
    }
  }
}
