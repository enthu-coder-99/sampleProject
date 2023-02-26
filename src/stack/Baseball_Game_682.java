package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Baseball_Game_682 {

  public static void main(String[] args) {
    String[] input = new String[]{"5", "2", "C", "D", "+"};
    System.err.println(calPoints(input));
  }

  public static int calPoints(String[] operations) {

    Deque<Integer> deque = new ArrayDeque();
    for (String opr : operations) {
      switch (opr) {
        case "C":
          deque.pollFirst();
          break;
        case "D":
          int last = deque.peekFirst();
          deque.push(2 * last);
          break;
        case "+":
          int num1 = deque.pop();
          int sum = num1 + deque.peek();
          deque.push(num1);
          deque.push(sum);

          break;
        default:
          deque.push(Integer.valueOf(opr));
      }
      System.err.println(deque);
    }
    int sum = 0;
    while (deque.size() > 0) {
      System.err.println(deque.peek());
      sum += deque.pop();
    }
    return sum;
  }
}
