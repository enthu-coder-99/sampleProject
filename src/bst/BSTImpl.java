package bst;

import bst.base.TreeNode;

public class BSTImpl {

  public static void main(String[] args) {
    //System.err.println("recursion Final Return=" + recursion(0, 0));
    //int[] inputArray = new int[]{50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 55, 55, 65, 75, 90};
    TreeNode treeRoot = TreeNode.insert(new Integer[]{5, 3, 6, 2, 4, 7});

    deleteNode(treeRoot, 3).inOrderTraversal();
    TreeNode.inOrderTraversal(treeRoot);
    //TreeNode.inOrderTraversal();
    //System.err.println("searchBST=" + searchBST(TreeNode.getTree1(), 70));
    //System.err.println("insertIntoBST=" + insertIntoBST(TreeNode.getTree1(), 5));

  }

  public static int recursion(int i, int j) {
    if (i < 5) {
      i++;
      System.err.println(++j + ". Before-increment the loop." + i);
      System.err.println("Recursion local return=" + recursion(i, j));
      System.err.println(++j + ". After-increment the loop." + i);
    }
    System.err.println(++j + ". Outside the loop.i=" + i);
    return (i);
  }

  public static TreeNode insert(int[] value) {
    TreeNode root = null;
    if (value.length > 0)
      root = new TreeNode(value[0]);
    for (int i = 1; i < value.length; i++)
      insertIntoBST(root, value[i]);
    return root;
  }

  private static TreeNode insertIntoBST(TreeNode node, int givenValue) {
    if (node == null)
      return new TreeNode(givenValue);
    if (node.val > givenValue) {
      //Goto left child of node.
      if (node.left == null) {
        System.err.println("Inserting in left of " + node.val);
        node.left = new TreeNode(givenValue);
      } else {
        insertIntoBST(node.left, givenValue);
      }
    } else if (node.val < givenValue) {
      if (node.right == null) {
        System.err.println("Inserting in right of " + node.val);
        node.right = new TreeNode(givenValue);
      } else {
        insertIntoBST(node.right, givenValue);
      }
    }
    return node;
  }

  public static TreeNode searchBST(TreeNode node, int givenValue) {
    if (node == null)
      return null;
    if (node.val > givenValue) {
      //Goto left child of node.
      node = searchBST(node.left, givenValue);
    } else if (node.val < givenValue) {
      node = searchBST(node.right, givenValue);
    }
    return node;
  }

  public static TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return root;
    if (root.val == key) {
      return deleteRootNode(root);
    }
    TreeNode node = root;
    while (node != null) {
      if (node.val > key) {
        if (node.left != null && node.left.val == key) {
          node.left = deleteRootNode(node.left);
        } else {
          node = node.left;
        }
      } else if (node.val < key) {
        if (node.right != null && node.right.val == key) {
          node.right = deleteRootNode(node.right);
        } else {
          node = node.right;
        }
      }
    }
    return root;
  }

  private static TreeNode deleteRootNode(TreeNode root) {
    if (root.left == null) {
      return root.right;
    }
    if (root.right == null) {
      return root.left;
    }
    //find min in right subtree.
    TreeNode minNode = root.right;
    TreeNode parentOfMinNode = null;
    while (minNode.left != null) {
      parentOfMinNode = minNode;
      minNode = minNode.left;
    }
    // Upto this time, minNode won't have any left node.

    if (parentOfMinNode != null) {
      parentOfMinNode.left = minNode.right;
      minNode.left = root.left;
      minNode.right = root.right;
    } else {
      // If root.right is the min node.
      minNode.left = root.left;
    }
    return minNode;
  }
}