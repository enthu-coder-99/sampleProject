package binarySearch;

import bst.base.TreeNode;

public class Merge_Two_Binary_Trees_617 {

  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    node1.left = new TreeNode(3);
    node1.right = new TreeNode(2);
    node1.left.left = new TreeNode(5);

    TreeNode node2 = new TreeNode(2);
    node2.left = new TreeNode(1);
    node2.right = new TreeNode(3);
    node2.left.right = new TreeNode(4);
    node2.right.right = new TreeNode(7);

    TreeNode mergedNode = mergeTrees(node1, node2);
    System.err.println(mergedNode.fullTreeTraversal());

  }

  public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

    if (root1 == null) return root2;
    if (root2 == null) return root1;
    TreeNode mergedTree = new TreeNode(root1.val + root2.val);
    mergeNodes(mergedTree, root1.left, root2.left, true);
    mergeNodes(mergedTree, root1.right, root2.right, false);
    return mergedTree;

  }

  public static void mergeNodes(TreeNode mergedTree,
                                TreeNode node1, TreeNode node2, boolean addToLeft) {

    System.err.println("Node1= " + node1 + " || node2= " + node2 + " || mergedTree=" + mergedTree + " || addToLeft= " + addToLeft);
    if (node1 == null && node2 == null) return;
    if (node1 == null) {
      if (addToLeft) {
        mergedTree.left = node2;
        System.err.println("node1 is null-L and  MergedTree=" + mergedTree);
      } else {
        mergedTree.right = node2;
        System.err.println("node1 is null-R and  MergedTree=" + mergedTree);
      }
    } else if (node2 == null) {
      if (addToLeft) {
        mergedTree.left = node1;
        System.err.println("node2 is null-L and MergedTree=" + mergedTree);
      } else {
        mergedTree.right = node1;
        System.err.println("node2 is null-R and MergedTree=" + mergedTree);
      }
    } else {
      TreeNode newNode = new TreeNode(node1.val + node2.val);
      if (addToLeft) {
        mergedTree.left = newNode;
        System.err.println("Both node-L MergedTree=" + mergedTree);
        mergeNodes(newNode, node1.left, node2.left, true);
        mergeNodes(newNode, node1.right, node2.right, false);

      } else {
        mergedTree.right = newNode;
        System.err.println("Both node-R MergedTree=" + mergedTree);
        mergeNodes(newNode, node1.left, node2.left, true);
        mergeNodes(newNode, node1.right, node2.right, false);
      }
    }
  }
}
