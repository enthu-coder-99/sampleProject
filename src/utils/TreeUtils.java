package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeUtils {

  public static void main(String[] args) {
    String treeArrayStr = "[1,3,3]";
    TreeNode root = TreeUtils.deserialize(treeArrayStr);
    System.out.println(TreeUtils.serialize(root));
  }

  public static TreeNode deserialize(String list) {
    final String[] stringNodes = list.replaceAll("\\[", "").replaceAll("]", "")
      .split(",");
    // when [] is passed
    if (stringNodes.length > 0 && stringNodes[0].equals("")) {
      return null;
    }
    List<TreeNode> nodes = new ArrayList<>();
    for (String stringNode : stringNodes) {
      stringNode = stringNode.trim();
      if (stringNode.equals("null")) {
        nodes.add(null);
      } else {
        nodes.add(new TreeNode(Integer.parseInt(stringNode)));
      }
    }
    // Both nodes and kids has reference to same TreeNodes
    // changes done in kids are maintained thus so
    Stack<TreeNode> kids = new Stack<>();
    kids.addAll(nodes);
    Collections.reverse(kids);
    TreeNode root = kids.pop();
    for (TreeNode node : nodes) {
      if (node != null) {
        if (!kids.isEmpty()) {
          node.left = kids.pop();
        }
        if (!kids.isEmpty()) {
          node.right = kids.pop();
        }
      }
    }
    return root;
  }

  public static String serialize(TreeNode root) {
        /*
        when root is null list = ["null"]
        then null is removed at last and return []
         */

    List<String> list = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      final TreeNode node = q.poll();
      if (node != null) {
        list.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
          continue;
        } else {
          q.offer(node.left);
          q.offer(node.right);
        }
      } else {
        list.add("null");
      }
    }
    // ending null values can be ignored
    while (!list.isEmpty() && list.get(list.size() - 1).equals("null")) {
      list.remove(list.size() - 1);
    }
    return list.toString();
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}