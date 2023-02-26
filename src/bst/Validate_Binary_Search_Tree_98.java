package bst;

import bst.base.TreeNode;

public class Validate_Binary_Search_Tree_98 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(10);
    root.right = new TreeNode(30);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(15);
    root.right.left = new TreeNode(25);
    root.right.right = new TreeNode(40);


    System.err.println(isValidBST(root));

  }


  public static boolean isValidBST(TreeNode root) {
    Integer low = null;
    Integer high = null;
    if (root != null) {
      return checkTreeRange(root, low, high);
    }
    return true;
  }

  static boolean checkTreeRange(TreeNode node, Integer low, Integer high) {
    if (node != null) {
      if (!isValidNode(node, low, high)) {
        return false;
      } else if (!checkTreeRange(node.left, low, node.val)) {
        return false;
      } else if (!checkTreeRange(node.right, node.val, high)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isValidNode(TreeNode node, Integer low, Integer high) {
    System.err.println((node != null ? node.val : null) + ":" + low + ":" + high + ":");
    if (node != null) {
      if ((high != null && node.val >= high) || (low != null && node.val <= low))
        return false;
    }
    return true;
  }
}
