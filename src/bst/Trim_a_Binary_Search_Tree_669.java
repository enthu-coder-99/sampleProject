package bst;

import bst.base.TreeNode;

public class Trim_a_Binary_Search_Tree_669 {

  TreeNode newRoot = null;

  public TreeNode trimBST(TreeNode root, int low, int high) {
    newRoot = getNextNode(root, low, high);
    dfs(root, low, high);
    return newRoot;
  }

  public TreeNode dfs(TreeNode node, int low, int high) {
    if (node == null) return null;
    TreeNode left = node.left;
    if (left != null) {
      if (isValid(left, low, high)) {
        dfs(left, low, high);
      } else {
        TreeNode newLeftNode = getNextNode(left, low, high);
        node.left = newLeftNode;
        dfs(newLeftNode, low, high);
      }
    }

    TreeNode right = node.right;
    if (right != null) {
      if (isValid(right, low, high)) {
        dfs(right, low, high);
      } else {
        TreeNode newRightNode = getNextNode(right, low, high);
        node.right = newRightNode;
        dfs(newRightNode, low, high);
      }
    }
    return null;
  }

  private boolean isValid(TreeNode node, int low, int high) {
    return node.val >= low && node.val <= high;
  }

  public TreeNode getNextNode(TreeNode node, int low, int high) {
    if (node == null) return null;
    int val = node.val;
    if (val >= low && val <= high) {
      return node;
    }
    if (val < low) {
      return getNextNode(node.right, low, high);
    }
    return getNextNode(node.left, low, high);
  }
}