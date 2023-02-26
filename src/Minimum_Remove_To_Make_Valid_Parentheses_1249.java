public class Minimum_Remove_To_Make_Valid_Parentheses_1249 {

  public static void main(String[] args) {
    System.err.println(minRemoveToMakeValid("())()((("));
  }

  public static String minRemoveToMakeValid(String s) {
    if (s == null || s.length() == 0)
      return s;
    int count = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '(') {
        count++;
      } else if (chars[i] == ')') {
        if (count > 0) {
          count--;
        } else {
          chars[i] = '#';
        }
      }
    }
    System.err.println(chars);
    StringBuilder sb = new StringBuilder();
    int totalOpenParenthesesRemoved = 0;
    for (int i = chars.length - 1; i >= 0; i--) {
      if ((chars[i] == '(' && count > totalOpenParenthesesRemoved)) {
        totalOpenParenthesesRemoved++;
        continue;
      } else if (chars[i] == '#') {
        continue;
      }
      sb.append(chars[i]);
    }
    System.err.println(new String(chars));
    return sb.reverse().toString();
  }
}
