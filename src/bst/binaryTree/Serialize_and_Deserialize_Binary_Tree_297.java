package bst.binaryTree;

import bst.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Serialize_and_Deserialize_Binary_Tree_297 {

  public static void main(String[] args) throws Exception {
    TreeNode tree1 = TreeNode.getTree2();
    Serialize_and_Deserialize_Binary_Tree_297 serialize_and_deserialize_binary_tree_297 = new Serialize_and_Deserialize_Binary_Tree_297();
    String str = serialize_and_deserialize_binary_tree_297.serialize(tree1);
    System.err.println("str= " + str);
    TreeNode treeNode = serialize_and_deserialize_binary_tree_297.deserialize(str);
    System.err.println("treeNode=" + treeNode);
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) throws InterruptedException {
    if (root == null) return null;
    String str = buildLevelTraversal(root);
    System.out.println("Str=" + str);
    return str;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null) return null;
    String[] nodeStrs = data.split(",");
    List<String> list = new ArrayList(Arrays.asList(nodeStrs));
    return buildTreeAfterBFS(list);
  }

  TreeNode buildTreeAfterBFS(List<String> list) {
    TreeNode root = new TreeNode(Integer.valueOf(list.remove(0)));
    Deque<TreeNode> deque = new LinkedList();
    deque.add(root);
    while (deque.size() > 0) {
      TreeNode node = deque.poll();
      if (node == null) continue;
      node.left = getNextElement(list);
      node.right = getNextElement(list);
      deque.offer(node.left);
      deque.offer(node.right);
    }
    return root;
  }

  public TreeNode getNextElement(List<String> list) {
    if (list.size() > 0) {
      String str = list.remove(0);
      if (!"B".equals(str))
        return new TreeNode(Integer.valueOf(str));
    }
    return null;
  }

  public String buildLevelTraversal(TreeNode root) {
    StringBuffer sb = new StringBuffer();
    Deque<TreeNode> deque = new LinkedList<>();
    deque.add(root);
    while (deque.size() > 0) {
      TreeNode node = deque.poll();
      if (node == null) {
        sb.append("B,");
      } else {
        sb.append(node.val).append(",");
        deque.offer(node.left);
        deque.offer(node.right);
      }
    }
    return sb.toString();
  }


  public TreeNode buildTreeDFS(List<String> list) {
    String nodeVal = list.remove(0);
    if (nodeVal.equals("B")) return null;
    TreeNode root = new TreeNode(Integer.valueOf(nodeVal));
    root.left = buildTreeDFS(list);
    root.right = buildTreeDFS(list);
    return root;

  }

  public void buildPreorderTraversal(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("B,");
      return;
    }
    sb.append(root.val).append(",");
    buildPreorderTraversal(root.left, sb);
    buildPreorderTraversal(root.right, sb);
  }
}
