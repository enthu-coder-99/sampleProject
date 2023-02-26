import java.util.HashMap;
import java.util.Map;

public class Ransom_Note_383 {

  public static void main(String[] args) {

  }

  public static boolean canConstruct(String ransomNote, String magazine) {
    char[] mChars = magazine.toCharArray();
    char[] rChars = ransomNote.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < mChars.length; i++) {
      map.put(mChars[i], map.getOrDefault(mChars[i], 0) + 1);
    }
    for (int i = 0; i < rChars.length; i++) {
      map.put(rChars[i], map.getOrDefault(rChars[i], 0) - 1);
      if (map.get(rChars[i]) < 0)
        return false;
    }
    return true;
  }
}
