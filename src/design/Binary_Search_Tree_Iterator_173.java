package design;

import bst.base.TreeNode;

import java.util.LinkedList;

public class Binary_Search_Tree_Iterator_173 {

  LinkedList<TreeNode> linkedList = new LinkedList<>();

  public Binary_Search_Tree_Iterator_173(TreeNode root) {
    TreeNode treeNode = root;
    while (treeNode != null) {
      linkedList.add(0, treeNode);
      treeNode = treeNode.left;
    }
  }

  public int next() {
    TreeNode treeNode = linkedList.remove(0);
    TreeNode newNode = treeNode.right;
    if (newNode != null) {
      while (newNode != null) {
        linkedList.add(0, newNode);
        newNode = newNode.left;
      }
    }
    return treeNode.val;
  }

  public boolean hasNext() {
    return linkedList.size() > 0;
  }
}
