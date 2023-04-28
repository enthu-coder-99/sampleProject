package bst.binaryTree;

import bst.base.TreeNode;

public class Binary_Tree_Maximum_Path_Sum_124 {

  public static void main(String[] args) {
    Binary_Tree_Maximum_Path_Sum_124 o = new Binary_Tree_Maximum_Path_Sum_124();
    System.err.println();
  }

  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    if (root == null) return 0;
    max = root.val;
    pathSum(root);

    return max;
  }

  public int pathSum(TreeNode node) {
    if (node == null) return 0;
    int sum_left = pathSum(node.left);
    int sum_right = pathSum(node.right);
    int node_val = node.val;
    int path_sum = sum_left + sum_right;

    Integer max_sum_indi_seg = Math.max(node.val, Math.max(sum_left, sum_right));
    max = (Math.max(max, Math.max(path_sum, max_sum_indi_seg)));
    return path_sum;
  }
}
