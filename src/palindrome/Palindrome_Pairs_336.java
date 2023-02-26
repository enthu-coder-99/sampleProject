package palindrome;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Pairs_336 {

  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> result = new ArrayList<>();
    return result;
  }

  public static boolean isPalindrom(String s, int left, int right) {
    while (right > left) {
      if (s.charAt(right--) != s.charAt(left++))
        return false;
    }
    return true;

  }
}
