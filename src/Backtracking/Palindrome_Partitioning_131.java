package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 {

  public static void main(String[] args) {
    String str = "aabb";
    partition(str);
  }

  public static List<List<String>> partition(String s) {

    List<List<String>> resultList = new ArrayList();
    recursion(0, s, new ArrayList<>(), resultList);
    resultList.forEach(s1 ->
      System.err.println("S1=" + s1));
    return resultList;
  }

  public static void recursion(int startIndex, String str, List<String> list,
                               List<List<String>> resultList) {

    int l = str.length();
    if (isPalindrome(str)) {
      List newResult = new ArrayList(list);
      newResult.add(str);
      resultList.add(newResult);
    }
    if (startIndex >= l || l <= 0)
      return;

    for (int i = startIndex + 1; i < l; i++) {
      String str1 = str.substring(startIndex, i);
      System.err.println(i + "- startIndex=" + startIndex + " str1= " + str1);

      if (isPalindrome(str1)) {
        list.add(str1);
        String str2 = str.substring(i, l);
        System.err.println("Adding str1= " + str1 + ", str2= " + str2 + ", List= " + list);
        recursion(i-1, str2, list, resultList);
        list.remove(list.size() - 1);
      }
    }
  }

  public static boolean isPalindrome(String s) {
    if (s == null || s.length() < 2) return true;
    int l = s.length();
    for (int i = 0; i < l / 2; i++) {
      if (s.charAt(i) != s.charAt(l - 1 - i)) return false;
    }
    return true;
  }
}
