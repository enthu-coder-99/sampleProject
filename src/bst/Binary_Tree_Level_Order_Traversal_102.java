package bst;

import bst.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_102 {

  public static void main(String[] args) {
    TreeNode tree2 = TreeNode.getTree2();
    List<List<Integer>> lists = levelOrder(tree2);
    System.err.println(lists);
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levelSearchResultList = new ArrayList<>();

    if (root == null)
      return levelSearchResultList;

    //bfs_new(List.of(root), levelSearchResultList);
    bfs(root, levelSearchResultList);

    return levelSearchResultList;
  }

  private static void bfs_new(List<TreeNode> treeNodeList, List<List<Integer>> levelSearchResultList) {

    if (treeNodeList == null || treeNodeList.size() == 0)
      return;

    List<TreeNode> nextLevelTreeNode = new ArrayList<>();
    List<Integer> nextLevelResultList = new ArrayList<>();
    for (TreeNode treeNode : treeNodeList) {
      if (treeNode != null) {
        nextLevelTreeNode.add(treeNode.left);
        nextLevelTreeNode.add(treeNode.right);
        nextLevelResultList.add(treeNode.val);
      }
    }
    if (nextLevelResultList.size() > 0)
      levelSearchResultList.add(nextLevelResultList);
    bfs_new(nextLevelTreeNode, levelSearchResultList);
  }

  public static void bfs(TreeNode node, List<List<Integer>> levelSearchList) {
    if (node == null)
      return;

    List<TreeNode> dequeList = new ArrayList();
    dequeList.add(node);
    while (dequeList.size() > 0) {
      int size = dequeList.size();
      List<Integer> resultIntegerList = new ArrayList<>();
      while (size > 0) {
        size--;
        TreeNode levelNode = dequeList.remove(0);
        if (levelNode != null) {
          dequeList.add(levelNode.left);
          dequeList.add(levelNode.right);
          resultIntegerList.add(levelNode.val);
        }
      }
      if (resultIntegerList.size() > 0)
        levelSearchList.add(resultIntegerList);
    }
  }
}

