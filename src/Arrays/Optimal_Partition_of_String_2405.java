package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Optimal_Partition_of_String_2405 {

  public static void main(String[] args) {
    System.err.println(partitionString("abacaba"));
  }


  public static int partitionString(String s) {
    int result = 1;
    Set<Character> set = new HashSet();
    for (int i = 0; i < s.length(); i++) {
      char c = (char) s.charAt(i);
      if (set.contains(c)) {
        set = new HashSet();
        set.add(c);
        result++;
      } else {
        set.add(c);
      }
    }
    return result;
  }
}
