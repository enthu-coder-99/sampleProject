package palindrome;

public class Longest_prefix_which_is_also_suffix_NA {

  public static void main(String[] args) {
    String inputStr = "";
    inputStr = "aabcaaa";
    System.err.println(inputStr + " and answer=" + longestPrefixSuffix(inputStr));

    inputStr = "blablabla";
    System.err.println(inputStr + " and answer=" + longestPrefixSuffix(inputStr));
    inputStr = "aabcdaabc";
    System.err.println(inputStr + " and answer=" + longestPrefixSuffix(inputStr));
    inputStr = "abcab";
    System.err.println(inputStr + " and answer=" + longestPrefixSuffix(inputStr));
    inputStr = "aaaa";
    System.err.println(inputStr + " and answer=" + longestPrefixSuffix(inputStr));
    inputStr = "ababc";
    System.err.println(inputStr + " and answer=" + longestPrefixSuffix(inputStr));



  }

  static int longestPrefixSuffix(String s) {
    int length = s.length();
    int[] repeat = new int[length];
    int left = 0;
    for (int right = 1; right < length; ) {
      if (s.charAt(left) == s.charAt(right)) {
        repeat[right] = ++left;
        right++;
      } else {
        if (left > 0) {
          left = repeat[left - 1];
        } else {
          left = 0;
          right++;
        }
      }
    }
    return (repeat[length - 1]);
  }

}
