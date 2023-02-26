package bst.binaryTree;

import bst.base.TreeNode;

public class Maximum_Depth_of_Binary_Tree_104 {

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return helper_maxDepth(root);
  }

  public int helper_maxDepth(TreeNode node) {
    int maxDepthLeft = 0;
    int maxDepthRight = 0;

    if (node.left != null)
      maxDepthLeft = helper_maxDepth(node.left);
    if (node.right != null)
      maxDepthRight = helper_maxDepth(node.right);
    return Math.max(maxDepthLeft, maxDepthRight) + 1;
  }
}
