import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters_3 {
  static char c;

  public static void main(String[] args) {
    System.err.println("c=" + ((int) c));
    System.err.println('C' - 'A');
    int c1 = '\u0000';
    System.err.println("c1=" + c1);
    System.err.println(c1 == Character.MIN_VALUE);
    //System.err.println(lengthOfLongestSubstring_withArray("abcabcbb"));
    System.err.println(lengthOfLongestSubstring_with_hashMap("abba"));
    System.err.println(lengthOfLongestSubstring_with_hashSet("abba"));

    System.err.println(lengthOfLongestSubstring_with_hashSet("abcabcbb"));
    System.err.println(lengthOfLongestSubstring_with_hashMap("abcabcbb"));
    //System.err.println(lengthOfLongestSubstring_copied("pwwkew"));
    //System.err.println(lengthOfLongestSubstring_copied("abccccccdrf"));
  }


  public static int lengthOfLongestSubstring_with_hashSet(String s) {

    if (s.length() < 2)
      return s.length();
    int startingPoint = 0;
    char[] chars = s.toCharArray();
    int maxLength = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < chars.length; i++) {
      int currentCharInt = (int) chars[i];
      System.err.println("Set=" + set);
      while (set.contains(currentCharInt)) {
        set.remove((int) chars[startingPoint++]);
      }
      set.add(currentCharInt);
      maxLength = Math.max(maxLength, set.size());
    }
    return maxLength;
  }

  public static int lengthOfLongestSubstring_with_hashMap(String s) {

    if (s.length() < 2)
      return s.length();
    int startingPoint = 0;
    char[] chars = s.toCharArray();
    int maxLength = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < chars.length; i++) {
      int currentCharInt = (int) chars[i];
      System.err.println("map=" + map + " : " + startingPoint + " : " + maxLength);
      if (map.containsKey(currentCharInt) && map.get(currentCharInt) >= startingPoint) {
        startingPoint = map.get(currentCharInt) + 1;
      }
      map.put(currentCharInt, i);
      maxLength = Math.max(maxLength, (i - startingPoint) + 1);
    }
    return maxLength;
  }

  public static int lengthOfLongestSubstring_withArray(String s) {
    if (s == null || s.length() == 0)
      return 0;
    if (s.length() == 1)
      return 1;

    char[] chars = s.toCharArray();
    int[] charsTracking = new int[256];
    Arrays.fill(charsTracking, -1);
    int leftIndex = 0;
    int maxLength = 0;
    for (int j = 0; j < chars.length; j++) {
      int currentCharAscii = (int) chars[j];
      if (charsTracking[currentCharAscii] != -1) {
        //This char has been in String before.
        int oldIndexOfAsciiChar = charsTracking[currentCharAscii];
        if (oldIndexOfAsciiChar >= leftIndex) {
          //duplicate char
          leftIndex = oldIndexOfAsciiChar + 1;
          charsTracking[currentCharAscii] = j;
        }
        charsTracking[currentCharAscii] = j;
      } else {
        charsTracking[currentCharAscii] = j;
      }

      maxLength = Math.max(maxLength, (j - leftIndex + 1));
      chars[j] = Character.MIN_VALUE;
    }
    return maxLength;
  }


}
