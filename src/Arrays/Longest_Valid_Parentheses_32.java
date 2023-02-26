package Arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Longest_Valid_Parentheses_32 {

  public static void main(String[] args) {
    String inputStr = "";
    inputStr = "(()";
    System.err.println(inputStr + " and answer=" + longestValidParentheses(inputStr));

    inputStr = ")()())";
    System.err.println(inputStr + " and answer=" + longestValidParentheses(inputStr));
    /*  inputStr = "(()";
    System.err.println(inputStr + " and answer=" longestValidParentheses(inputStr));*/
  }

  public static int longestValidParentheses(String s) {
    return longestValidParentheses_sol2(s);
  }

  public static int longestValidParentheses_sol2(String s) {
    int maxValidParenthesesLength = 0;
    List<Integer> openBracketIndex = new LinkedList<>();
    int[] closingBracesIndexToValidParenthesesCountMap = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);
      if (c == '(') {
        openBracketIndex.add(0, i);
      } else if (c == ')' && openBracketIndex.size() > 0) {
        int lastMatchingOpenBracketIndex = openBracketIndex.remove(0);
        int longestValidParenthesesLengthLocal = i - lastMatchingOpenBracketIndex + 1 +
          (lastMatchingOpenBracketIndex > 0 ? closingBracesIndexToValidParenthesesCountMap[lastMatchingOpenBracketIndex - 1] : 0);
        maxValidParenthesesLength = Math.max(maxValidParenthesesLength, longestValidParenthesesLengthLocal);
        closingBracesIndexToValidParenthesesCountMap[i] = longestValidParenthesesLengthLocal;
      }
    }
    return maxValidParenthesesLength;
  }

  public static int longestValidParentheses_sol1(String s) {
    int maxValidParenthesesLength = 0;
    Map<Integer, Integer> openingBraceToClosingBraceMap = buildOpeningBracesAndCloseBracesMap(s);
    for (int i = 0; i < s.length(); i++) {
      int localMaxValidParenthesesLength = 0;
      while (openingBraceToClosingBraceMap.containsKey(i)) {
        // Check if we have any matching closing brace for this opening brace.
        int closingBraceIndex = openingBraceToClosingBraceMap.get(i);
        localMaxValidParenthesesLength += closingBraceIndex - i + 1;
        i = closingBraceIndex + 1;
      }
      maxValidParenthesesLength = Math.max(maxValidParenthesesLength, localMaxValidParenthesesLength);
    }
    return maxValidParenthesesLength;
  }


  static Map<Integer, Integer> buildOpeningBracesAndCloseBracesMap(String s) {
    Map<Integer, Integer> openingBraceToClosingBraceMap = new HashMap<>();
    List<Integer> openBracketIndex = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);
      if (c == '(') {
        openBracketIndex.add(0, i);
      } else if (c == ')' && openBracketIndex.size() > 0) {
        int lastMatchingOpenBracketIndex = openBracketIndex.remove(0);
        openingBraceToClosingBraceMap.put(lastMatchingOpenBracketIndex, i);
      }
    }
    return openingBraceToClosingBraceMap;
  }
}
