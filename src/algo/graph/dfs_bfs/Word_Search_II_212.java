package algo.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word_Search_II_212 {

  public static void main(String[] args) {
    char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
    String[] word = new String[]{"oath", "pea", "eat", "rain"};
    System.err.println("");
  }

  public static List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList();

    Trie trieHead = buildTrie(words);
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        char c = board[row][col];
      }
    }
    return res;
  }

  public static void search(char[][] board, Trie trie, int i, int j, List<String> res) {
    int row = board.length;
    int col = board[0].length;
    char c = board[i][j];//visited type of feature
    if (i < 0 || j < 0 || i >= row || j >= col || trie.children[c - 'a'] == null) return;
    board[i][j] = '#';
    if (trie.word != null) res.add(trie.word);
    if (trie.children != null) {
      for (Trie child : trie.children) {
        if (child != null) {
          search(board, trie, i + 1, j, res);
          search(board, trie, i - 1, j, res);
          search(board, trie, i, j - 1, res);
          search(board, trie, i, j = 1, res);
        }
      }
    }
    board[i][j] = c;
  }

  static Trie buildTrie(String[] words) {
    Trie trie = new Trie();
    Arrays.stream(words).forEach(e -> trie.insert(e));
    return trie;
  }
}

class Trie {
  char val;
  Trie[] children;// Only for Characters
  String word;

  public Trie() {
    children = new Trie[26];
  }

  public Trie(char _val) {
    children = new Trie[26];
    val = _val;
  }


  public void insert(String word) {
    if (word == null || word.length() == 0) return;
    Trie currentTail = this;
    int l = word.length();
    for (int i = 0; i < l; i++) {
      char c = word.charAt(i);
      int charIndex = getArrayIndex(c);
      if (currentTail.children[charIndex] == null) {
        Trie newT = new Trie(c);
        currentTail.children[charIndex] = newT;
      }
      currentTail = currentTail.children[charIndex];
    }
    currentTail.word = word;
  }

  boolean search(String word) {
    if (word == null || word.length() == 0) return false;
    Trie currentTail = this;
    int l = word.length();
    for (int i = 0; i < l; i++) {
      char c = word.charAt(i);
      int charIndex = getArrayIndex(c);
      if (currentTail.children[charIndex] == null) {
        return false;
      } else {
        currentTail = currentTail.children[charIndex];
      }
    }
    return (word.equals(currentTail.word));
  }

  public boolean startsWith(String word) {
    if (word == null || word.length() == 0) return false;
    Trie currentTail = this;
    int l = word.length();
    for (int i = 0; i < l; i++) {
      char c = word.charAt(i);
      int charIndex = getArrayIndex(c);
      if (currentTail.children[charIndex] == null) {
        return false;
      } else {
        currentTail = currentTail.children[charIndex];
      }
    }
    return true;
  }

  public boolean childStartsWith(char c) {
    return this.children[getArrayIndex(c)] != null;
  }

  private int getArrayIndex(char c) {
    return c - 'a';
  }
}
