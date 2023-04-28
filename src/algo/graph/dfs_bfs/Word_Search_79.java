package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word_Search_79 {

  public static void main(String[] args) {
    char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    String word = null;
    word = "ABCCED";
    // System.err.println(word + " and result = " + exist(board, word));
    word = "SEE";
    System.err.println("\n" + word + " and result = " + exist(board, word));
    word = "ABCB";
    // System.err.println(word + " and result = " + exist(board, word));
  }

  public static boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == word.charAt(0)) {
          System.out.println("\n-----board...................=" + Arrays.deepToString(board));
          if (search_dfs_sol2(row, col, 0, board, word.toCharArray()))
            return true;
        }
      }
    }
    return false;
  }

  public static boolean search_dfs_sol2(int row_i, int col_i, int word_chars_i, char[][] board,
                                        char[] word_chars) {
    int row = board.length;
    int col = board[0].length;
    System.out.print("\nrow_i= " + row_i + ", col_i= " + col_i + ", word_chars_i= " + word_chars_i + ".  ");
    if (!isValidBoardIndex(row_i, col_i, row, col)) {
      //System.out.println("Not valid. " + ", row_i =" + row_i + ", col_i= " + col_i);
      return false;
    }
    char board_c = board[row_i][col_i];
    if (board_c != word_chars[word_chars_i]) {
      System.out.print(" board_c= " + board_c + ", row_i= " + row_i + ", col_i= " + col_i + " not matched.");
      return false;
    }
    System.out.print(" board_c= " + board_c + " Character  Matched..");
    if (word_chars_i >= word_chars.length - 1) {
      return true;
    }
    System.out.print(" Setting value as 0");

    board[row_i][col_i] = '0';
    if (search_dfs_sol2(row_i + 1, col_i, word_chars_i + 1, board, word_chars)
      || search_dfs_sol2(row_i - 1, col_i, word_chars_i + 1, board, word_chars)
      || search_dfs_sol2(row_i, col_i + 1, word_chars_i + 1, board, word_chars)
      || search_dfs_sol2(row_i, col_i - 1, word_chars_i + 1, board, word_chars))
      return true;

    System.out.print(" Setting value back to- board_c = " + board_c + ", row_i= " + row_i + ", col_i= " + col_i);
    board[row_i][col_i] = board_c;
    return false;
  }

  public static boolean isValidBoardIndex(int row_i, int col_i, int row, int col) {
    if (row_i < 0 || col_i < 0 || row_i >= row || col_i >= col) return false;
    return true;
  }

  static boolean search_dfs_sol1(char[][] board, String word, int row, int col, int wordIndex, boolean[][] visited) {

    if (word.length() == wordIndex) return true;
    if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || board[row][col] != word.charAt(wordIndex) || visited[row][col] == true)
      return false;
    visited[row][col] = true;

    if (
      search_dfs_sol1(board, word, row - 1, col, wordIndex + 1, visited) ||//left
        search_dfs_sol1(board, word, row, col - 1, wordIndex + 1, visited) ||//top
        search_dfs_sol1(board, word, row + 1, col, wordIndex + 1, visited) || //right
        search_dfs_sol1(board, word, row, col + 1, wordIndex + 1, visited)  //bottom
    ) return true;

    visited[row][col] = false;
    return false;
  }

  public Node cloneGraph(Node node) {
    if (node == null) return null;
    Map<Node, MyNode> oldToNewNodeMap = new HashMap();
    Deque<Node> queue = new ArrayDeque();
    queue.offer(node);

    while (queue.size() > 0) {
      Node oldNode = queue.poll();
      MyNode myClonedNode = null;

      if (oldToNewNodeMap.containsKey(oldNode)) {
        myClonedNode = oldToNewNodeMap.get(oldNode);
        if (myClonedNode.processed) continue;
      } else {
        myClonedNode = new MyNode();
        myClonedNode.node = new Node(oldNode.val);
        oldToNewNodeMap.put(oldNode, myClonedNode);
      }

      if ((oldNode.neighbors != null && oldNode.neighbors.size() > 0)
        && (myClonedNode.node.neighbors == null || myClonedNode.node.neighbors.size() == 0)) {
        List<Node> newNeighborList = new ArrayList();
        for (Node origNeighborNode : oldNode.neighbors) {
          if (oldToNewNodeMap.containsKey(origNeighborNode)) {
            newNeighborList.add(oldToNewNodeMap.get(origNeighborNode).node);
          } else {
            Node clonedNeighborNode = new Node(origNeighborNode.val);
            newNeighborList.add(clonedNeighborNode);
            MyNode clonedNeighborMyNode = new MyNode();
            clonedNeighborMyNode.node = clonedNeighborNode;
            oldToNewNodeMap.put(origNeighborNode, clonedNeighborMyNode);

          }

          queue.add(origNeighborNode);

        }
        myClonedNode.node.neighbors = newNeighborList;
      }
      myClonedNode.processed = true;
    }
    return oldToNewNodeMap.get(node).node;
  }

  class MyNode {
    public Node node;
    public boolean processed;

  }

  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
