package bst.binaryTree;

import bst.base.TreeNode;

public class Sum_Root_to_Leaf_Numbers_129 {
  int sum = 0;

  public int sumNumbers(TreeNode root) {
    calculate(root, 0);
    return sum;
  }

  public void calculate(TreeNode node, int precessorsSum) {

    if (node == null) return;
    if (node.left == null && node.right == null) {
      // It is a dead end node so calculate sum.
      sum = sum + precessorsSum * 10 + node.val;
      return;
    }
    calculate(node.left, precessorsSum * 10 + node.val);
    calculate(node.right, precessorsSum * 10 + node.val);
  }
}
