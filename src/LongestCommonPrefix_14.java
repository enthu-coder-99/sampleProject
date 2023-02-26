import java.util.Arrays;

public class LongestCommonPrefix_14 {
  static char a;

  public static void main(String[] args) {
    System.err.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
  }

  public static String longestCommonPrefix(String[] strs) {
    System.err.println((int) a);
    System.err.println(Character.MIN_VALUE);

    if (strs == null || strs.length == 0)
      return "";
    if (strs.length == 1)
      return strs[0];

    char[] prefix = strs[0].toCharArray();
    for (int i = 1; i < strs.length; i++) {
      if (prefix.length == 0)
        return "";
      String str = strs[i];
      for (int j = 0; j < prefix.length; j++) {
        if (str.length() < j + 1 || prefix[j] != str.charAt(j)) {
          // If not equals.
          prefix = resetPrefix(prefix, j);
          break;
        }
      }
    }
    return String.valueOf(prefix);
  }

  private static char[] resetPrefix(char[] prefix, int length) {
    return Arrays.copyOf(prefix, length);
  }
}
