package palindrome;

import java.util.HashMap;
import java.util.Map;

public class Longest_Palindrome_by_Concatenating_Two_Letter_Words_2131 {

  public static void main(String[] args) {
    System.err.println((int)'A');
    System.err.println((int)'a');
    String[] input = null;
    input = new String[]{"lc", "cl", "gg"};
    System.err.println(input + " and answer=" + longestPalindrome(input));//Answer is = 6
    input = new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"};
    System.err.println(input + " and answer=" + longestPalindrome(input));//Answer is =22
  }

  public static int longestPalindrome(String[] words) {
    int[][] wordCountMap = new int[26][26];
    int result = 0;
    int symmateryCount = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      int char1 = word.charAt(0);
      int char2 = word.charAt(1);
      String reverseWord = new StringBuilder().append((char) char2).append((char) char1).toString();
      int reverseWordCount = wordCountMap[char2 - 'a'][char1 - 'a'];
      boolean isSymateryWord = char1 == char2;
      if (reverseWordCount > 0) {
        result = result + 4;
        wordCountMap[char2 - 'a'][char1 - 'a'] = --reverseWordCount;
        if (isSymateryWord) symmateryCount--;
      } else {
        wordCountMap[char1 - 'a'][char2 - 'a'] = wordCountMap[char1 - 'a'][char2 - 'a'] + 1;
        if (isSymateryWord) symmateryCount++;
      }
    }

    if (symmateryCount > 0)
      result = result + 2;
    return result;
  }

  public static Map<String, Integer> getWordToCountMap(String[] words) {
    Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
    }
    return wordCountMap;
  }
}
