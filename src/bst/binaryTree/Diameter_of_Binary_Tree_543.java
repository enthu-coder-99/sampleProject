package bst.binaryTree;

import bst.base.TreeNode;

public class Diameter_of_Binary_Tree_543 {
  int maxDia = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    helper_maxDepth(root);
    return maxDia;
  }

  public int helper_maxDepth(TreeNode node) {
    int maxDepthLeft = 0;
    int maxDepthRight = 0;

    if (node.left != null)
      maxDepthLeft = helper_maxDepth(node.left);
    if (node.right != null)
      maxDepthRight = helper_maxDepth(node.right);
    maxDia = Math.max(maxDia, maxDepthLeft + maxDepthRight);
    return Math.max(maxDepthLeft, maxDepthRight) + 1;
  }
}
