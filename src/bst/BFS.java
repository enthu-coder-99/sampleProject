package bst;


import bst.base.TreeNode;

import java.util.List;

public class BFS {

  public static String rearrangeString(String str){
    StringBuffer result = new StringBuffer();
    int[] charsCount = new int[26];
    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      charsCount[c-'a']++;
    }
    for(int i=0;i<charsCount.length;i++){
      if(charsCount[i]>0)
        result.append(Character.valueOf((char) (i+'a'))).append(charsCount[i]);
    }
    return result.toString();
  }

  public static void main(String[] args) {

    // you can write to stdout for debugging purposes, e.g.
    System.out.println("This is a debug message");
    System.err.println(rearrangeString("abcbcad"));
  }

  public static void serializedTree(List<TreeNode> levelNodeList, List<Integer> resultList) {
    while (levelNodeList.size() > 0) {
      TreeNode currentNode = levelNodeList.remove(0);
      if (currentNode != null) {
        resultList.add(currentNode.getValue());
        levelNodeList.add(currentNode.getLeft());
        levelNodeList.add(currentNode.getRight());
      } else {
        resultList.add(null);
      }
    }
  }

  public static TreeNode getTree() {
    TreeNode root = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    root.left = t2;
    TreeNode t3 = new TreeNode(3);
    root.right = t3;
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    t3.left = t4;
    t3.right = t5;
    TreeNode t7 = new TreeNode(7);
    t5.right = t7;
    TreeNode t9 = new TreeNode(9);
    t7.right = t9;
    return root;
  }

}
