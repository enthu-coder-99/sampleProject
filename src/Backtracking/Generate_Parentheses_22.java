package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {

  public static void main(String[] args) {
    System.err.println(generateParenthesis(3));
  }

  public static List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<String>();
    backtrack(list, "", n, 0, 0);
    return list;
  }

  public static void backtrack(List<String> list, String str, int max, int open, int close) {
    System.err.println(str);
    if (str.length() == max * 2) {
      list.add(str);
      return;
    }
    if (open < max) {
      System.err.println("#25 and str=" + str + " and open=" + open + " and close=" + close);
      backtrack(list, str + "(", max, open + 1, close);
    }
    if (close < open) {
      System.err.println("#29 and str=" + str + " and open=" + open + " and close=" + close);
      backtrack(list, str + ")", max, open, close + 1);
    }
  }
}
