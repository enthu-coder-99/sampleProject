package Strings;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring_76 {

  public static void main(String[] args) {
    String s = "ABCabc";
    char[] chars = s.toCharArray();
    System.err.println(chars[0]);
    System.err.println((char) 68);

    System.err.println(minWindow("ADOBECODEBANC", "ABC"));
    System.err.println(minWindow("ABAACBAB", "ABC"));
    System.err.println(minWindow("BBA", "AB"));
    //System.err.println(minWindow("ADOBECODEBANC", "ABC"));
  }

  public static String minWindow(String s, String t) {
    String result = "";

    char[] t_chars = t.toCharArray();
    int total_chars_length = t_chars.length;
    char[] s_chars = s.toCharArray();
    if (total_chars_length > s_chars.length) return result;

    Map<Character, Integer> chars_count_map = new HashMap();
    for (int i = 0; i < total_chars_length; i++) {
      chars_count_map.put(t_chars[i], chars_count_map.getOrDefault(t_chars[i], 0) + 1);
    }
    Map<Character, Integer> s_chars_matched_map = new HashMap();
    int chars_matched_count = 0;
    int leftStartingIndex = 0;
    for (int j = 0; j < s_chars.length; j++) {
      char current_char = s_chars[j];
      if (chars_count_map.containsKey(current_char)) {
        //  this current_char is a matching char in t and is of our interest char.
        int t_current_char_count = chars_count_map.get(current_char);
        s_chars_matched_map.put(current_char, s_chars_matched_map.getOrDefault(current_char, 0) + 1);

        if (s_chars_matched_map.get(current_char) <= t_current_char_count) {
          chars_matched_count++;
          //i.e. it is a possible answer and all chars from "t" has found in current "s" substring.
          while (chars_matched_count == total_chars_length) {
            if (result.equals("") || (j + 1 - leftStartingIndex) < result.length())
              result = s.substring(leftStartingIndex, j + 1);

            char firstMatchedChar = s_chars[leftStartingIndex];

            if (chars_count_map.containsKey(firstMatchedChar)) {
              s_chars_matched_map.put(firstMatchedChar, s_chars_matched_map.getOrDefault(firstMatchedChar, 1) - 1);
              if (s_chars_matched_map.getOrDefault(firstMatchedChar, 0) < chars_count_map.get(firstMatchedChar)) {
                chars_matched_count--;
              }
            }
            leftStartingIndex++;

          }
        }
      }
    }
    return result;
  }

  public static String minWindow_sol1(String s, String t) {
    if (s.length() < t.length()) return "";
    if (s.indexOf(t) > 0) return t;
    Map<Integer, Integer> targetCharsCountMap = build_target_character_count_map(t);
    String result = null;
    char[] source_chars = s.toCharArray();
    Map<Integer, Integer> sourceCharsCountMap = new HashMap<>();
    int sourceStringMatchingCharsCount = 0;
    int target_chars_length = t.length();
    int leftStartIndex = 0;
    for (int i = 0; i < source_chars.length; i++) {
      int sourceChar = (int) source_chars[i];
      //System.err.println(i + "- sourceChar=" + (char) sourceChar);
      if (targetCharsCountMap.containsKey(sourceChar)) {
        int targetCharCount = targetCharsCountMap.get(sourceChar);
        int sourceCharCount = sourceCharsCountMap.getOrDefault(sourceChar, 0);
        if (sourceCharCount < targetCharCount) {
          sourceStringMatchingCharsCount++;
        }
        sourceCharsCountMap.put((int) sourceChar, sourceCharCount + 1);
        if (target_chars_length == sourceStringMatchingCharsCount) {
          // System.err.println("sourceStringMatchingCharsCount=" + sourceStringMatchingCharsCount);
          // If target char counts are same as sourceStringMatchingCharsCount i.e. it is a match so may be a possible solution.
          String possibleResult = s.substring(leftStartIndex, i + 1);
          // System.err.println("possibleResult=" + possibleResult);
          result = (result == null || possibleResult.length() < result.length()) ? possibleResult : result;

          //Now, make string this result as non-matching by start deleting chars from start i.e leftStartIndex
          while (target_chars_length == sourceStringMatchingCharsCount) {
            int possibleResultChar = source_chars[leftStartIndex++];
            possibleResult = s.substring(leftStartIndex, i + 1);
            result = (possibleResult.length() < result.length()) ? possibleResult : result;
            if (targetCharsCountMap.containsKey(possibleResultChar)) {
              if (sourceCharsCountMap.get(possibleResultChar) == 1) {
                sourceCharsCountMap.remove(possibleResultChar);
                sourceStringMatchingCharsCount--;
              } else {
                sourceCharsCountMap.put((int) possibleResultChar, sourceCharsCountMap.get(possibleResultChar) - 1);
                if (sourceCharsCountMap.get(possibleResultChar) < targetCharsCountMap.get(possibleResultChar)) {
                  // Only decrease if string is not valid anymore.
                  sourceStringMatchingCharsCount--;
                }
              }
            }
          }
          if (result.length() == target_chars_length) return result;
        }
      }
    }

    //String validResultString = findValidSourceString(source_chars, sourceCharsCountMap, sourceStringMatchingCharsCount, targetCharsCountMap, t, 0);
    return result == null ? "" : result;
  }

  public static Map<Integer, Integer> build_target_character_count_map(String target) {
    Map<Integer, Integer> charCountMap = new HashMap<>();
    for (char c : target.toCharArray()) {
      charCountMap.put((int) c, charCountMap.getOrDefault((int) c, 0) + 1);
    }
    return charCountMap;
  }
}
