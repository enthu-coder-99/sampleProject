package bst;

import bst.base.TreeNode;


public class Balanced_Binary_Tree_110 {
  boolean result = true;

  public static void main(String[] args) {

  }

  public boolean isBalanced_sol2(TreeNode root) {
    helper_maxDepth(root);
    return result;
  }

  public int helper_maxDepth(TreeNode node) {
    int maxDepthLeft = 0;
    int maxDepthRight = 0;

    if (node.left != null)
      maxDepthLeft = helper_maxDepth(node.left);
    if (node.right != null)
      maxDepthRight = helper_maxDepth(node.right);
    if (Math.abs(maxDepthLeft - maxDepthRight) > 1) result = false;
    return Math.max(maxDepthLeft, maxDepthRight) + 1;
  }


  public boolean isBalanced_sol1(TreeNode root) {
    boolean b1 = isUnBalanced(root);
    boolean b2 = isUnBalanced(root.left);
    boolean b3 = isUnBalanced(root.right);
    if (!b1 || !b2 || !b3) {
      return false;
    }
    return true;
  }

  public boolean isUnBalanced(TreeNode node) {
    if (node != null) {
      int countLeft = 0;
      int countRight = 0;
      TreeNode leftNode = node.left;
      TreeNode rightNode = node.right;
      while (leftNode != null && countLeft < 3) {
        leftNode = leftNode.left;
        countLeft++;
      }
      while (rightNode != null && countLeft < 3) {
        rightNode = rightNode.right;
        countRight++;
      }
      return Math.abs(countRight - countLeft) > 1;
    }
    return false;
  }
}
