package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Common_Characters_1002 {

  public static void main(String[] args) {
    String[] strs = {"cool", "lock", "cook"};
    System.err.println(commonChars(strs));
  }

  public static List<String> commonChars(String[] words) {
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
