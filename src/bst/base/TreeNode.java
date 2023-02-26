package bst.base;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
    ;
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode insert(Integer[] value) {
    TreeNode root = null;
    if (value.length > 0) {
      System.err.println("Root is " + value[0]);
      root = new TreeNode(value[0]);
    }
    for (Integer i = 1; i < value.length; i++) {
      if (value[i] != null) {
        insertIntoBST(root, value[i]);
      }
    }
    return root;
  }

  private static TreeNode insertIntoBST(TreeNode node, int givenValue) {
    if (node == null)
      return new TreeNode(givenValue);
    if (node.val > givenValue) {
      //Goto left child of node.
      if (node.left == null) {
        System.err.println("Inserting " + givenValue + " in left of " + node.val);
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

  /**
   * 50
   * 30                           70
   * 20         40                60           80
   * 10   25    35    55          55    65      75    90
   *
   * @return {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 55, 55, 65, 75, 90}
   */
  public static TreeNode getTree1() {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(70);

    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(40);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(80);

    root.left.left.left = new TreeNode(10);
    root.left.left.right = new TreeNode(25);
    root.left.right.left = new TreeNode(35);
    root.left.right.right = new TreeNode(45);
    root.right.left.left = new TreeNode(55);
    root.right.left.right = new TreeNode(65);
    root.right.right.left = new TreeNode(75);
    root.right.right.right = new TreeNode(90);

    return root;
  }

  public static TreeNode getTree2() {
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(70);

    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(40);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(80);
    return root;
  }

  public int getVal() {
    return val;
  }

  public int getValue() {
    return val;
  }


  public void setVal(int val) {
    this.val = val;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public static void inOrderTraversal(TreeNode root) {
    if (root == null)
      return;
    inOrderTraversal(root.left);
    System.err.print(root.val + ",, ");
    inOrderTraversal(root.right);
  }

  public void inOrderTraversal() {
    inOrderTraversal(this);
  }

  @Override
  public String toString() {
    return "TreeNode(" +
      "" + val +
      "), left=" + (left != null ? left.val : null) +
      ", right=" + (right != null ? right.val : null) +
      '}';
  }
}