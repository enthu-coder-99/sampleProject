import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class String_To_Integer_ATOI_8 {

  public static void main(String[] args) throws Exception{
  /*  System.err.println(myAtoi("42"));
    System.err.println(myAtoi("-42"));
    System.err.println(myAtoi("  -42"));*/
    System.err.println(myAtoi("  "));

    System.err.println(myAtoi("-91283472332"));
    Class<?> aClass = Class.forName("Median_of_Two_Sorted_Arrays_4");
    //System.err.println(myAtoi("4193 with words"));

    Map<String, Integer> map = new HashMap<String, Integer>();
  }

  private String_To_Integer_ATOI_8(){

  }

  public static int myAtoi(String s) {
    if (s == null || s.equals(""))
      return 0;
    char[] chars = s.toCharArray();
    int length = chars.length;
    int sign = 1;
    int i = 0;
    int result = 0;
    for (; i < chars.length; i++) {
      char currentChar = chars[i];
      if (currentChar != ' ')
        break;
    }

    if (i < length - 1) {
      char signCurrentChar = chars[i];
      if (signCurrentChar == '-') {
        sign = -1;
        i++;
      } else if (signCurrentChar == '+') {
        sign = 1;
        i++;
      }
    }
    for (; i < chars.length; i++) {
      char currentChar = chars[i];
      int currentCharInt = currentChar - '0';
      if (currentCharInt <= 9 && currentCharInt >= 0) {
        long l1 = (long) result * 10;
        long l = l1 + currentCharInt;
        if (l > Integer.MAX_VALUE) {
          if (sign > 0)
            return Integer.MAX_VALUE;
          return Integer.MIN_VALUE;
        }
        result = (int) l;

      } else {
        break;
      }

    }
    return result * sign;
  }
}
