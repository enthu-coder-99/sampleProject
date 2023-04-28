package bst.binaryTree;

import bst.base.TreeNode;

public class Count_Good_Nodes_in_Binary_Tree_1448 {

  public int goodNodes(TreeNode root) {
    if (root == null) return 0;
    int[] result = new int[1];
    result[0]++;
    countGoodNodes(root.left, root.val, result);
    countGoodNodes(root.left, root.val, result);
    return result[0];
  }

  public void countGoodNodes(TreeNode node, int maxBeforeThisNode, int[] result) {
    if (node == null) return;
    int val = node.val;
    if (val >= maxBeforeThisNode) result[0]++;
    countGoodNodes(node.left, Math.max(val, maxBeforeThisNode), result);
    countGoodNodes(node.right, Math.max(val, maxBeforeThisNode), result);
  }
}
