package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Daily_Temperatures_739 {

  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.push(1);
    deque.push(2);
    deque.push(3);
    deque.push(4);
    //System.err.println("poll="+deque.poll());System.err.println(deque.poll());System.err.println(deque.poll());System.err.println(deque.poll());
    //System.err.println("pop="+deque.pop());System.err.println(deque.pop());System.err.println(deque.pop());System.err.println(deque.pop());
    //System.err.println(deque.poll());

  }

  public int[] dailyTemperatures_fromIndex_0(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    result[n - 1] = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    deque.offer(0);
    for (int i = 1; i < n; i++) {
      while (temperatures[i] > temperatures[deque.peekLast()]) {
        int indexOfPreviousCoolerDay = deque.pollLast();
        result[indexOfPreviousCoolerDay] = i - indexOfPreviousCoolerDay;
      }
      deque.add(i);
    }

    while (deque.size() > 0)
      result[deque.pop()] = 0;
    return result;
  }

  public int[] dailyTemperatures_fromIndex_Last(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Deque<Integer> deque = new ArrayDeque<>();
    deque.offer(n - 1);
    for (int i = n - 2; i >= 0; i--) {
      while (temperatures[i] > temperatures[deque.peek()]) {
        deque.pop();
        if (temperatures[i] < temperatures[deque.peek()])
          result[i] = i - deque.peek();
      }
      deque.push(i);
    }

    return result;
  }
}
