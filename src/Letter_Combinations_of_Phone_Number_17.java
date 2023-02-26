import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class Letter_Combinations_of_Phone_Number_17 {
  static String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public static void main(String[] args) {
    System.err.println(letterCombinations("234"));
  }

  public static List<String> letterCombinations(String digits) {
    if (digits.length() == 0)
      return new ArrayList<>();

    List<String> finalList = new ArrayList<>();
    finalList.add("");
    char[] digitChars = digits.toCharArray();
    for (int i = digitChars.length - 1; i >= 0; i--) {
      char currentDigit = digitChars[i];
      finalList = appendNumbers(Character.getNumericValue(currentDigit), finalList);
      System.err.println(finalList);
    }
    return finalList;
  }


  static List appendNumbers(int currentDigit, List<String> digitCombList) {
    List<String> tempList = new ArrayList<String>();
    char[] currentDigitMappingChars = mapping[currentDigit].toCharArray();
    for (int i = 0; i < currentDigitMappingChars.length; i++) {
      for (int j = 0; j < digitCombList.size(); j++) {
        tempList.add(currentDigitMappingChars[i] + digitCombList.get(j));
      }
    }
    return tempList;
  }
}
