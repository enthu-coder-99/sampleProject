import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

  public static void main(String[] args) {
    System.err.println(isAnagram("anagram", "nagaram"));
  }

  public static boolean isAnagram(String s, String t) {

    if (s.length() != t.length())
      return false;
    Map<Integer, Integer> map = new HashMap();
    char[] sCharArrays = s.toCharArray();
    for (int i = 0; i < sCharArrays.length; i++) {
      int sChar = (int) sCharArrays[i];
      if (map.containsKey(sChar)) {
        map.put(sChar, map.get(sChar) + 1);
      } else {
        map.put((int) sChar, 1);
      }
    }

    char[] tCharArrays = t.toCharArray();
    for (int i = 0; i < tCharArrays.length; i++) {
      int tChar = (int) tCharArrays[i];
      if (map.containsKey(tChar)) {
        Integer integer = map.get(tChar);
        if (integer != null && integer > 1) {
          map.put(tChar, map.get(tChar) - 1);
        } else {
          map.remove(tChar);
        }
      } else {
        return false;
      }
    }
    return map.size() == 0;
  }
}
