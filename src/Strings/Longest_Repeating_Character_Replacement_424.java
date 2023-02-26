package Strings;

public class Longest_Repeating_Character_Replacement_424 {

  public static void main(String[] args) {
    System.err.println(characterReplacement("BAAA", 0));
  }

  /**
   * https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
   */
  public static int characterReplacement(String s, int k) {
    int[] charCount = new int[26];
    int result = 0;
    int charMaxFrequency = 0;
    int leftPointer = 0;
    for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
      int indexRightOfChar = s.charAt(rightPointer) - 'A';
      charCount[indexRightOfChar]++;
      charMaxFrequency = Math.max(charMaxFrequency, charCount[indexRightOfChar]);
      int windowSize = (rightPointer - leftPointer) + 1;
      int charsLengthExceptMaxCharFreq = windowSize - charMaxFrequency;
      if (charsLengthExceptMaxCharFreq > k) {
        charCount[s.charAt(leftPointer) - 'A']--;
        leftPointer++;
        continue;
      }
      result = Math.max(result, windowSize);
    }
    return result;
  }
}
