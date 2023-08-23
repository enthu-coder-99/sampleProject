package bst;

import bst.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Path_Sum_II_113 {

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    dfs(root, new ArrayList<>(), targetSum, result);
    return result;
  }

  public void bfs(TreeNode node, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(node);
    while (deque.size() > 0) {

    }

  }


  public void dfs(TreeNode node, List<Integer> nodeValList, int targetSum, List<List<Integer>> result) {

    int node_val = node.val;
    TreeNode leftNode = node.left;
    TreeNode rightNode = node.right;
    if (leftNode == null && rightNode == null && node_val == targetSum) {
      // We found a combination.
      ArrayList<Integer> newResultList = new ArrayList<>(nodeValList);
      newResultList.add(node_val);
      result.add(newResultList);
      return;
    }

    if (leftNode != null) {
      nodeValList.add(node_val);
      dfs(leftNode, nodeValList, targetSum - node_val, result);
      nodeValList.remove(nodeValList.size() - 1);
    }

    if (rightNode != null) {
      nodeValList.add(node_val);
      dfs(rightNode, nodeValList, targetSum - node_val, result);
      nodeValList.remove(nodeValList.size() - 1);
    }
  }
}
