import java.util.HashMap;
import java.util.Map;

public class Trie_Implementation_208 {
  static TrieNode root = new TrieNode('0', false);

  public static void main(String[] args) {
    insert("app");
    System.err.println(search("app"));

    insert("apple");
    insert("beer");

    insert("add");
    insert("jam");
    insert("rental");
    System.err.println(search("apps"));
    System.err.println(search("ad"));
    System.err.println(search("app"));


  }

  public static void insert(String word) {
    TrieNode currentNode = root;
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char currentChar = chars[i];
      Map<Character, TrieNode> charChildMap = currentNode.child;
      if (!charChildMap.containsKey(currentChar)) {
        TrieNode newTrieNode = createTrieNode(currentChar, chars.length, i);
        charChildMap.put(currentChar, newTrieNode);
        currentNode = newTrieNode;
      } else {
        currentNode = charChildMap.get(currentChar);
        currentNode.end = (chars.length - i) == 1 ? true : currentNode.end;
      }
    }
  }

  public static boolean search(String word) {
    TrieNode currentNode = root;
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char currentChar = chars[i];
      Map<Character, TrieNode> charChildMap = currentNode.child;
      if (!charChildMap.containsKey(currentChar)) {
        return false;
      } else {
        currentNode = charChildMap.get(currentChar);
      }
    }
    return currentNode.end;
  }

  public static boolean startsWith(String prefix) {
    TrieNode currentNode = root;
    char[] chars = prefix.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char currentChar = chars[i];
      Map<Character, TrieNode> charChildMap = currentNode.child;
      if (!charChildMap.containsKey(currentChar)) {
        return false;
      } else {
        currentNode = charChildMap.get(currentChar);
      }
    }
    return true;
  }

  public static TrieNode createTrieNode(char value, int wordLength, int index) {
    return new TrieNode(value, (wordLength - index) == 1 ? true : false);
  }

  public static class TrieNode {
    public char value;
    public Map<Character, TrieNode> child = new HashMap<>();
    public boolean end;

    public TrieNode(char value, boolean end) {
      this.value = value;
      this.end = end;
    }

    public TrieNode(char char1, TrieNode char1Node, boolean end) {
      this.child.put(char1, char1Node);
      this.end = end;
    }
  }
}
