package Strings;

public class Break_a_Palindrome_1328 {

  public String breakPalindrome(String palindrome) {
    int l = palindrome.length();
    if (l == 1) return "";
    char[] c_n = palindrome.toCharArray();
    replaceOneChar(c_n, 'a');
    return new String(c_n);
  }


  boolean replaceOneChar(char[] c_n, char replceWith) {
    int l = c_n.length;
    int l_2 = l / 2;

    for (int i = 0; i < l_2; i++) {
      char c1 = c_n[i];
      char c2 = c_n[l - 1 - i];
      if (c1 != 'a') {
        c_n[i] = 'a';// replace first letter which is not a
        return true;
      }
    }
    c_n[l - 1] = 'b';// If input string has all 'a'

    return true;
  }
}
