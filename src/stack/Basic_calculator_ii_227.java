package stack;

import java.util.LinkedList;
import java.util.List;

public class Basic_calculator_ii_227 {

  public int calculate(String s) {


    List<Integer> list = new LinkedList<>();
    char[] chars = s.toCharArray();
    int len = chars.length;

    for (int i = 0; i < len; i++) {
      char c = chars[i];
      if (c == ' ') {
        continue;
      }
      int sign = 1;
      switch (c) {
        case '-':
          sign = -1;

        default:
          while (i < len - 1 && chars[i + 1] == ' ') {
            i++;
          }
          int digit = Integer.valueOf(chars[i]);
          while (i < len - 1 && Character.isDigit(i + 1)) {
            i++;
            digit = digit * 10 + Integer.valueOf(chars[i]);
          }
          list.add(digit * sign);

          if (c == '*') {
            int num1 = list.remove(list.size() - 1);
            int num2 = list.remove(list.size() - 1);
            list.add(num2 * num1);
          } else if (c == '/') {
            int num1 = list.remove(list.size() - 1);
            int num2 = list.remove(list.size() - 1);
            list.add(num1 / num2);
          }
      }
    }

    int ans = 0;
    while (list.size() > 0) {
      ans = ans + list.remove(0);
    }
    return ans;
  }
}
