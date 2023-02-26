import java.util.HashMap;
import java.util.Map;

public class Word_Pattern_290 {

  public static void main(String[] args) {

  }
  public static boolean wordPattern(String pattern, String s) {
    String[] splitStr = s.split(" ");
    if (splitStr.length != pattern.length())
      return false;

    Map<Character, String> map1 = new HashMap<>();
    Map<String, Character> map2 = new HashMap<>();
    for (int i = 0; i < splitStr.length; i++) {
      char p1 = pattern.charAt(i);
      String workSplitStr = splitStr[i];
      if (!map1.getOrDefault(p1, workSplitStr).equals(p1) || !map2.getOrDefault(workSplitStr, p1).equals(p1))
        return false;
      map1.put(p1, workSplitStr);
      map2.put(workSplitStr, p1);
    }
    return true;
  }
}
