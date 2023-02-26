public class Is_Subsequence_392 {
  public static void main(String[] args) {
    System.err.println(isSubsequence("abc", "a2bbdd"));
  }

  public static boolean isSubsequence(String s, String t) {

    int i = 0;
    for (int j = 0; j < t.length(); j++) {
      char charT = t.charAt(j);
      if (s.charAt(i) == charT) {
        if (i + 1 == s.length())
          return true;
        i++;
      }
    }
    return false;
  }
}
