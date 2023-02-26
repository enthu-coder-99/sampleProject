import java.util.HashMap;
import java.util.Map;

public class Count_and_Say_38 {

  public static void main(String[] args) {
    System.err.println(countAndSay(4));
  }

  public static String countAndSay(int n) {
    Map<Integer, String> memo = new HashMap();
    memo.put(1, "1");
    memo.put(2, "11");

    for (int i = 3; i <= n; i++) {
      String pre = memo.get(i - 1);
      memo.put(i, convert(pre));
    }

    System.out.println(memo);
    return memo.get(n);
  }

  public static String convert(String str) {
    int len = str.length();
    StringBuffer sb = new StringBuffer();
    int startingIndex = 0;
    for (int i = 1; i < len; i++) {
      char c = str.charAt(i);
      System.out.println("c=" + c);
      if (c != (char) str.charAt(i - 1)) {
        System.out.println("c2=" + c + " and charAt(i-1)=" + str.charAt(i - 1));
        sb.append(i - startingIndex).append(str.charAt(i - 1));
        startingIndex = i;
      }
      if (i >= (len - 1)) {
        System.out.println("Another c2=" + c + " and charAt(i-1)=" + str.charAt(i - 1));
        sb.append(i - startingIndex + 1).append(str.charAt(i));
      }
    }
    return sb.toString();
  }
}
