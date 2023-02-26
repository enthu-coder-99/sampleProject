import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Valid_Parentheses_20 {


  public static void main(String[] args) {
    // System.err.println(isValid("()"));
    Deque deque = new ArrayDeque();
    deque.add("1");
    deque.add("2");
    deque.add("3");
    System.err.println(deque.poll());
    System.err.println(deque.pop());
    System.err.println(deque.poll());
    System.err.println(deque.poll());

    //case#2-
    deque = new ArrayDeque();
    deque.offer("1");
    deque.offer("2");
    deque.offer("3");
    System.err.println(deque.poll());
    System.err.println(deque.pop());
    System.err.println(deque.poll());
    System.err.println(deque.poll());

    //case#3-
    deque = new ArrayDeque();
    deque.push("1");
    deque.push("2");
    deque.push("3");
    System.err.println(deque.poll());
    System.err.println(deque.pop());
    System.err.println(deque.poll());
    System.err.println(deque.poll());

  }


  public static boolean isValid(String str) {
    Map<Character, Character> close2OpenMapping = Map.of(')', '(',
      '}', '{',
      ']', '[');
    Deque<Character> queue = new ArrayDeque();

    for (int i = 0; i < str.length(); i++) {
      char c = (char) str.charAt(i);
      if (close2OpenMapping.containsKey(c)) {
        //Means it is a closing bracket.
        if (queue.size() < 1) return false;
        if (queue.poll() != close2OpenMapping.get(c)) return false;
      }
    }
    return queue.size() == 0;
  }
}
