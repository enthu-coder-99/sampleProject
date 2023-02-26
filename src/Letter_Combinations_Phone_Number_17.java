import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_Phone_Number_17 {

  private static String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  static Map<String, String> phone = new HashMap<String, String>() {{
    put("1", "1");
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};

  public static void main(String[] args) {
    System.err.println(letterCombinations("234"));
  }

  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    backtrack("", digits, result);
    return result;
  }

  public static void backtrack(String currComb, String remainingDigits, List<String> result) {
    System.err.println("currComb="+currComb);
    if (remainingDigits.length() == 0) {
      result.add(currComb);
      return;
    }
    String currDigit = remainingDigits.substring(0, 1);
    String lettersForCurrDigit = phone.get(currDigit);
    for (int i = 0; i < lettersForCurrDigit.length(); i++) {
      String letter = lettersForCurrDigit.substring(i, i + 1);
      backtrack(currComb + letter, remainingDigits.substring(1), result);
    }
  }

  public static List<String> letterCombinations_Vinit(String digits) {
    char[] chars = digits.toCharArray();
    List<String> resultStr = new ArrayList<String>();
    int[] indexTracker = new int[chars.length];
    Arrays.fill(indexTracker, 0);
    loopOver(indexTracker, resultStr, 0);
    return null;
  }

  public static List<String> loopOver(int[] indexTracker, List<String> resultStr, int loopIndex) {
return null;

  }

  public static boolean setNextIndex(int[] indexTracker) {
    for (int i = indexTracker.length - 1; i >= 0; i--) {
      int indexOfDigit = indexTracker[i];
      if (indexOfDigit < mapping[i].length()) {
        indexOfDigit++;

        break;
      }
    }
    return false;
  }
}
