package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * s consists of digits, '+', '-', '(', ')', and ' '.
 */
public class Basic_Calculator_224 {

  public static void main(String[] args) throws Exception {
    System.out.println("A= " + Integer.toBinaryString(Integer.MAX_VALUE));
    System.out.println("B= " + Integer.toBinaryString(Integer.MIN_VALUE));
    System.out.println("C= " + Integer.toBinaryString(Integer.MAX_VALUE + 1));
    System.out.println("D= " + Integer.toBinaryString(Integer.MIN_VALUE - 1));
    System.out.println("E= " + Integer.toBinaryString(1073741824));
    System.out.println(Integer.toBinaryString(2147483647));
    System.out.println(Integer.toBinaryString(2147483646 & 2147483647));
    int i = 2147483646;

    System.out.println(2147483646 & 2147483647);

    int ans = rangeBitwiseAnd(1073741824, 2147483647);
    System.out.println(ans);
  }

  public static int rangeBitwiseAnd(int left, int right) throws InterruptedException {
    int ans = left;
    System.out.println(Integer.toBinaryString(left) + " ||| " + Integer.toBinaryString(right));
    for (int i = left + 1; i <= right; i++) {
      System.out.println("i=" + i + ", ans=" + ans + ", " + Integer.toBinaryString(ans));
      Thread.sleep(200);
      ans = (ans & i);
      if (ans == 0) return ans;
    }
    return ans;
  }

  public int calculate(String s) {

    char[] chars = s.toCharArray();
    int l = chars.length;
    List<String> list = new ArrayList<>();

    for (int i = 0; i < l; i++) {
      char c = chars[i];
      if (c == ' ') continue;

      if (Character.isDigit(c)) {
        StringBuilder sb = new StringBuilder(c);
        while (i < l - 1 && Character.isDigit(chars[i + 1])) {
          i++;
          sb.append(chars[i]);
        }
        list.add(sb.toString());//Added a whole number digits
      } else if (c == ')') {

      } else {

      }

    }
    return -1;
  }

  public int process(List<String> list) {
    int len = list.size();
    int ans = 0;
    while (list.size() > 2) {
      String num1 = list.remove(0);
      String sign = list.remove(0);
      String num2 = list.remove(0);
      if (sign.equals("+")) {
        int result = Integer.valueOf(num1) + Integer.valueOf(num2);
        ans = ans + result;
      } else if (sign.equals("-")) {
        int result = Integer.valueOf(num1) - Integer.valueOf(num2);
        ans = ans + result;
      }

    }
    return ans;
  }

  private int trimSpaces(char[] chars, int start) {
    int l = chars.length;
    return -1;
  }
}
