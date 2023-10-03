package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Generate_Parentheses_22 {

  public static void main(String[] args) {
    System.err.println(generateParenthesis(5));
  }

  public static List<String> generateParenthesis(int n) {
    Set<String> set = new HashSet<>();
    bruteForce(new StringBuffer(), n, 0, 0, set);
    System.out.println(set);
    return new ArrayList<>(set);
  }

  static int i = 1;

  public static void bruteForce(StringBuffer sb, int n, int openingBracesCount,
                                int closingBracesCount, Set<String> result) {

    if (closingBracesCount > openingBracesCount) return;
    if (openingBracesCount == n && closingBracesCount == n) {
      result.add(sb.toString());
      return;
    }

    for (i = openingBracesCount; i < n; i++) {
      sb.append("(");
      bruteForce(sb, n, openingBracesCount + 1, closingBracesCount, result);
      sb.deleteCharAt(sb.length() - 1);
    }

    for (int i = closingBracesCount; i < n; i++) {
      sb.append(")");
      bruteForce(sb, n, openingBracesCount, closingBracesCount + 1, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public static void recursion(StringBuffer sb, int n, int openingBracesCount,
                               int closingBracesCount, Set<String> result) {

    if (closingBracesCount > openingBracesCount) return;
    if (openingBracesCount == n && closingBracesCount == n) {
      result.add(sb.toString());
      return;
    }

    if (openingBracesCount < n) {
      sb.append("(");
      recursion(sb, n, openingBracesCount + 1, closingBracesCount, result);
      sb.deleteCharAt(sb.length() - 1);
    }

    if (openingBracesCount > closingBracesCount) {
      sb.append(")");
      recursion(sb, n, openingBracesCount, closingBracesCount + 1, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
