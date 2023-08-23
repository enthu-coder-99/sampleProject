package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Common_Characters_1002 {

  public static void main(String[] args) {
    String[] strs = {"cool", "lock", "cook"};
    System.err.println(commonChars(strs));
    System.err.println(commonChars_1(strs));

  }


  public static List<String> commonChars(String[] words) {
    String word_0 = words[0];
    int[] commonCount = new int[26];

    for (char c : word_0.toCharArray()) {
      commonCount[c - 'a']++;
    }

    for (int j = 1; j < words.length; j++) {
      String word = words[j];
      char[] chars = word.toCharArray();
      int[] localCount = new int[26];

      for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        int index = c - 'a';
        if (commonCount[index] > localCount[index]) {
          localCount[index]++;
        }
      }
      commonCount = localCount;
    }

    List<String> result = new ArrayList();
    for (int i : commonCount) {
      if (i > 0) {
        char c = (char) (i + 'a');
        result.add(String.valueOf(c));
      }
    }
    return result;
  }

  public static List<String> commonChars_1(String[] words) {
    Map<Character, Integer> commonMap = null;
    for (String word : words) {
      Map<Character, Integer> currentMap = new HashMap();
      for (int i = 0; i < word.toCharArray().length; i++) {
        char currentChar = word.charAt(i);
        if (commonMap == null) {
          currentMap.put(currentChar, currentMap.getOrDefault(currentChar, 0) + 1);
        } else if (commonMap.containsKey(currentChar) &&
          commonMap.get(currentChar) > currentMap.getOrDefault(currentChar, 0)) {
          currentMap.put(currentChar, currentMap.getOrDefault(currentChar, 0) + 1);
        }
      }
      commonMap = currentMap;
    }
    List<String> resultList = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : commonMap.entrySet()) {
      Character key = entry.getKey();
      Integer value = entry.getValue();
      while (value-- > 0) {
        resultList.add(key.toString());
      }
    }
    return resultList;
  }
}
