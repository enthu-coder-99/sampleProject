package stack;

import java.util.LinkedList;
import java.util.List;

/**
 * s consists of digits, '+', '-', '(', ')', and ' '.
 */
public class Basic_Calculator_224 {


  public static void main(String[] args) {
    var calculate = calculate("1 + 1");
    System.out.println("ans= " + calculate);
  }


  public static void main1(String[] args) throws Exception {
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


  public static int calculate(String s) {
    LinkedList<Object> linkedList = new LinkedList<>();
    char[] chars = s.toCharArray();
    int l = chars.length;
    String PLUS = "+";
    String NEGATIVE = "-";
    String PLUS_BRACKET = "+(";
    String NEGATIVE_BRACKET = "-(";

    for (int i = 0; i < l; i++) {
      char c = chars[i];
      System.out.println(i + "- " + c + " and linkedList=" + linkedList);
      if (c == ' ') continue;

      if (Character.isDigit(c)) {
        int num = Integer.valueOf(String.valueOf(c));
        while (i < l - 1 && Character.isDigit(chars[i + 1])) {
          i++;
          int nxtDigit = Integer.valueOf(String.valueOf(chars[i]));
          num = num * 10 + nxtDigit;
        }

        if (linkedList.size() > 0) {
          // Adjust the sign before this num.
          Object lastElement = linkedList.get(linkedList.size() - 1);
          if (lastElement.equals(PLUS)) {
            linkedList.remove(linkedList.size() - 1);
          } else if (lastElement.equals(NEGATIVE)) {
            linkedList.remove(linkedList.size() - 1);
            num = num * -1;
          }
        }

        if (linkedList.size() > 0) {
          Object lastElement = linkedList.get(linkedList.size() - 1);
          if (lastElement instanceof Integer) {
            linkedList.add(num + (Integer) linkedList.remove(linkedList.size() - 1));
            continue;
          }
        }
        linkedList.add(Integer.valueOf(num));
      } else if (c == '+' || c == '-') {
        linkedList.add(String.valueOf(c));

      } else if (c == '(') {

        if (linkedList.size() > 0) {
          // Adjust the sign before this num.
          Object lastElement = linkedList.get(linkedList.size() - 1);
          if (lastElement.equals(PLUS)) {
            linkedList.remove(linkedList.size() - 1);
            linkedList.add(PLUS_BRACKET);
            continue;
          } else if (lastElement.equals(NEGATIVE)) {
            linkedList.remove(linkedList.size() - 1);
            linkedList.add(NEGATIVE_BRACKET);
            continue;
          }
        }
        linkedList.add(PLUS_BRACKET);
      } else if (c == ')') {
        int len = linkedList.size();
        for (int j = len - 1; j >= 0; j--) {
          Object lastElement = linkedList.remove(j);
          int numSumInsideBracket = 0;
          if (lastElement.equals(PLUS_BRACKET)) {
            linkedList.add(Integer.valueOf(numSumInsideBracket));
            break;
          } else if (lastElement.equals(NEGATIVE_BRACKET)) {
            linkedList.add(Integer.valueOf(numSumInsideBracket * -1));
            break;
          } else if (lastElement instanceof Integer) {
            numSumInsideBracket = numSumInsideBracket + (Integer) lastElement;
          }
        }
      }
      System.out.println("linkedList= " + linkedList);
    }
    return (linkedList.size() > 0 && (linkedList.get(0) instanceof Integer)) ? ((Integer) linkedList.get(0)) : -1;
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
