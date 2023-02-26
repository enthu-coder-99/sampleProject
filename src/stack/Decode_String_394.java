package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Decode_String_394 {

  /**
   * 4[AA3[BB2[CC]]]
   */
  public static void main(String[] args) {
    String[] inputs = {"2[abc]3[cd]ef"
      //,"2[aa]", "2[aa]2[bc]", "4[AA3[BB2[CC]]]"
    };
    Arrays.stream(inputs).forEach(input -> System.err.println(input + " and ans=" + decodeString_Sol2(input)));
/*    input = "4[AA3[BB2[CC]]]";
    System.err.println(decodeString_Sol2(input));*/
  }


  public static String decodeString_Sol2(String s) {
    char[] chars = s.toCharArray();
    int l = chars.length;
    Deque<Integer> countDeq = new ArrayDeque<>();
    Deque<String> strDeq = new ArrayDeque<>();
    StringBuffer tmpStr = new StringBuffer();

    for (int i = 0; i < chars.length; i++) {
      char c1 = chars[i];
      // System.err.println(i + "- and c1=" + c1);
      if (Character.isDigit(c1)) {
        int freq = Integer.valueOf(c1 - '0');
        while (i < l - 1 && Character.isDigit(chars[i + 1])) {
          freq = freq * 10 + Character.getNumericValue(chars[++i]);
        }
        countDeq.push(freq);
      } else if (c1 == '[') {
        strDeq.push("");
      } else if (c1 == ']') {
        int count = countDeq.pop();
        String str = strDeq.pop();
        StringBuilder mergedSB = new StringBuilder();
        while (count-- > 0) {
          mergedSB.append(str);
        }
        System.err.println("mergedSB=" + mergedSB);
        if (strDeq.isEmpty())
          strDeq.push(mergedSB.toString());
        else
          strDeq.push(strDeq.pop() + mergedSB.toString());
        //  System.err.println("Final str = " + strDeq.peek());
      } else {
        strDeq.push(strDeq.pop() + c1);

      }
    }
    return strDeq.pop();

  }

  //3[a2[c]]
  //3[a]2[bc]
  public static String decodeString_Sol1(String s) {
    char[] chars = s.toCharArray();
    Deque<Character> deque = new ArrayDeque<>();
    for (int i = 0; i < chars.length; i++) {
      char c1 = chars[i];
      if (c1 == ']') {
        StringBuffer sbToMultiply = new StringBuffer();
        while (deque.size() > 0 && (c1 = deque.pop()) != '[') {
          sbToMultiply.insert(0, c1);
        }
        int timeToMultiple = 0;

        while (deque.size() > 0 && Character.isDigit(deque.peek())) {
          timeToMultiple = (timeToMultiple * 10) + (int) Integer.valueOf(deque.pop() - '0');
        }
        String multipliedStr = getMultipliedStr(sbToMultiply, timeToMultiple);
        for (int j = 0; j < multipliedStr.length(); j++) {
          deque.push(multipliedStr.charAt(j));
        }
      } else {
        deque.push(c1);
      }
    }
    StringBuilder resultSB = new StringBuilder();
    while (deque.size() > 0) {
      resultSB.insert(0, deque.pop());
    }
    return resultSB.toString();
  }

  private static String getMultipliedStr(StringBuffer sbToMultiply, int times) {

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < times; i++) {
      sb.append(sbToMultiply);
    }
    return sb.toString();
  }
}
