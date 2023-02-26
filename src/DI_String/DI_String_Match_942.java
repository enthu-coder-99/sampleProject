package DI_String;

import java.util.Arrays;

public class DI_String_Match_942 {

  public static void main(String[] args) {
    int[] r1 = diStringMatch("III");
    System.err.println(Arrays.toString(r1));
  }

  public static int[] diStringMatch(String s) {
    int[] result = new int[s.length() + 1];
    int low = 0;
    int high = s.length();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'D') {
        result[i] = high--;
      } else {
        result[i] = low++;
      }
    }
    result[s.length() ] = low;
    System.err.println(low + " : " + high);
    return result;
  }
}
