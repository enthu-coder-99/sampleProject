import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters_1239 {
  public static void main(String[] args) {
    System.err.println(maxLength(List.of("a", "abc", "d", "de", "def")));
  }

  public static int maxLength(List<String> arr) {
    int answer = 0;
    List<String> nonRepeatingStringList = new ArrayList<>();
    nonRepeatingStringList.add("");
    for (String currentStr : arr) {
      int length = nonRepeatingStringList.size();
      for (int i = 0; i < length; i++) {
        String newString = nonRepeatingStringList.get(i) + currentStr;
        if (isUnique(newString)) {
          nonRepeatingStringList.add(newString);
          answer = Math.max(answer, newString.length());
        }
      }
    }
    return answer;
  }


  private static boolean isUnique(String str) {
    char[] strChars = str.toCharArray();
    Set<Character> set = new HashSet<>();
    for (char strChar : strChars) {
      if (set.contains(strChar))
        return false;
      set.add(strChar);
    }
    return true;
  }
}
