package utils;

public class Remove_All_Adjacent_Duplicates_In_String_1047 {

  public String removeDuplicates(String s) {

    int l = s.length();
    if (l == 0) return "";
    char[] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < l; i++) {
      int c = chars[i];
      int sb_l = sb.length();
      if (sb_l > 0 && sb.charAt(sb.length() - 1) == c)
        sb.deleteCharAt(sb.length() - 1);
      else
        sb.append((char) c);
    }
    return sb.toString();
  }
}
