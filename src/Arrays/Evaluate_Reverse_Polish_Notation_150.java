package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class Evaluate_Reverse_Polish_Notation_150 {

  public static void main(String[] args) {

  }

  public static int evalRPN(String[] tokens) {
    Deque<Integer> deque = new ArrayDeque<>();
    for (String token : tokens) {
      switch (token) {
        case "+":
          deque.push(deque.pop() + deque.pop());
          break;
        case "-":
          int pop1 = deque.pop();
          int pop2 = deque.pop();
          deque.push(pop2 - pop1);
          break;
        case "*":
          deque.push(deque.pop() * deque.pop());
          break;
        case "/":
          int pop3 = deque.pop();
          int pop4 = deque.pop();
          deque.push(pop4 / pop3);
          break;
        default:
          deque.push(Integer.parseInt(token));
      }
    }
    return deque.poll();
  }
}
