package DP;

import bst.base.TreeNode;

public class House_Robber_III_337 {

  public static void main(String[] args) {

  }

  public static int rob(TreeNode root) {
    int[] memoResultWithMemo = robWithMemo(root);
    return Math.max(memoResultWithMemo[0], memoResultWithMemo[1]);
  }

  public static int[] robWithMemo(TreeNode node) {

    if (node == null) return null;
    int[] leftNodeResults = new int[2];
    int[] rightNodeResults = new int[2];
    if (node.left != null) {
      leftNodeResults = robWithMemo(node.left);
    }
    if (node.right != null) {
      rightNodeResults = robWithMemo(node.right);
    }

    int nodeValue = node.val;
    int[] result = new int[2];
    result[0] = nodeValue + leftNodeResults[1] + rightNodeResults[1];// Including this node
    result[1] = Math.max(leftNodeResults[1], leftNodeResults[0]) + Math.max(rightNodeResults[1], rightNodeResults[0]);// Excluding this node
    return result;
  }

}
