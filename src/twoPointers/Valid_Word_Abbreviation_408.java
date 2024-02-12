package twoPointers;

public class Valid_Word_Abbreviation_408 {

  public static void main(String[] args) {
    String word = "internationalization", abbr = "i12iz4n";
    boolean ans = validWordAbbreviation(word, abbr);
    System.out.println("Ans= " + ans);
  }

  public static boolean validWordAbbreviation(String word, String abbr) {

    char[] word_chars = word.toCharArray();
    char[] abbr_chars = abbr.toCharArray();
    int word_l = word_chars.length;
    int abbr_l = abbr_chars.length;
    if (abbr.equals(String.valueOf(word_l))) return true;

    if (abbr_l > word_l) return false;
    int j = 0;
    for (int i = 0; i < abbr_l; i++) {
      char abbr_c = abbr_chars[i];
      System.out.println(i + "- abbr_c=" + abbr_c + ", j=" + j);
      if (j >= word_l) return false;

      if (Character.isDigit(abbr_c)) {
        int num = abbr_c - '0';
        if (num == 0) return false;
        while (i < abbr_l - 1 && Character.isDigit(abbr_chars[i + 1])) {
          i++;
          num = num * 10 + (abbr_chars[i] - '0');
        }
        j = j + num ;
        System.out.println("num=" + num + ", j=" + j);
      } else {
        char word_c = word_chars[j++];
        if (word_c != abbr_c) return false;
      }

    }
    System.out.println("In Last-  j=" + j);
    if (j != word_l) return false;
    return true;

  }
}
