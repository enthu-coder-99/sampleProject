package utils;

public class Trie {
  char val;
  Trie[] children;// Only for Characters
  boolean end;

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
    currentTail.end = true;

  }

  public boolean search(String word) {
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
    return (currentTail.end);
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

  private int getArrayIndex(char c) {
    return c - 'a';
  }
}
