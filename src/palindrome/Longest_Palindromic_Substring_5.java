package palindrome;

public class Longest_Palindromic_Substring_5 {
  static int start = 0;
  static int pallingromLength = 0;

  public static void main(String[] args) {
    String input = "";
    input = "adam";
    System.err.println(input + " result = " + longestPalindrome(input));

    input = "babad";
    System.err.println(input + " result = " + longestPalindrome(input));
    input = "cbbd";
    System.err.println(input + " result = " + longestPalindrome(input));
    input = "dddddd";
    System.err.println(input + " result = " + longestPalindrome(input));
    input = "adam";
    System.err.println(input + " result = " + longestPalindrome(input));
  }

  //"abcba"
  // i = 2 , left = -1. right= 5
  public static String longestPalindrome(String s) {
    System.err.println("Input = " + s);
    if (s.length() < 2) {
      return s;
    }
    char[] s_chars = s.toCharArray();
    String maxPallindromeStr = "";
    char lastChar = ' ';
    for (int i = 0; i < s_chars.length; i++) {
      if (i > 0 && s_chars[i] == s_chars[i - 1]) continue;
      String palindromeString = processPalingDrome_2(s, s_chars, i);
      System.err.println("palindromeString=" + palindromeString);
      if (palindromeString != null && palindromeString.length() > maxPallindromeStr.length()) {
        maxPallindromeStr = palindromeString;
      }
    }
    return maxPallindromeStr;
  }

  static String processPalingDrome_2(String s, char[] s_chars, int midIndex) {
    int left = midIndex;
    int right = midIndex;
    char currentChar = s.charAt(midIndex);
    while (left > 0 && s_chars[left - 1] == currentChar) left--;
    while (right < (s.length() - 1) && s_chars[right + 1] == currentChar) right++;

    while (left > 0 && right < (s.length() - 1) && s_chars[right + 1] == s_chars[left - 1]) {
      left--;
      right++;
    }
    return s.substring(left, right + 1);
  }

  //Return max length of Palingdrome
  static String processPalingDrome_1(String s, char[] s_chars, int midIndex) {

    int left = midIndex;
    int right = midIndex;
    char currentChar = s.charAt(midIndex);
    while (left >= 0 && left - 1 >= 0 && s.charAt(left - 1) == currentChar) {
      left--;
    }
    while (right < s.length() && right + 1 < s.length() && s.charAt(right + 1) == currentChar) {
      right++;
    }
    while ((left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1))) {
      --left;
      ++right;
    }
    //2,2   1,3  0,4  -1 5
    //return the length of biggest palindrom string
    return s.substring(left, right + 1);
  }
}
