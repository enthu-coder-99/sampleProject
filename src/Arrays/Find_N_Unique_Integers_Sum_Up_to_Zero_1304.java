package Arrays;

import java.util.PriorityQueue;

public class Find_N_Unique_Integers_Sum_Up_to_Zero_1304 {

  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue();
    pq.offer(19);
    pq.offer(29);
    pq.offer(25);
    pq.offer(27);
    pq.offer(26);
    pq.offer(28);
    pq.offer(19);
    pq.offer(5);
    pq.offer(16);
    pq.offer(10);
    pq.offer(13);
    pq.offer(13);
    pq.offer(13);
    pq.offer(3);
    pq.offer(100);
    pq.offer(2);
    pq.offer(80);

    System.err.println(pq);

  }
  // 7
  public int[] sumZero(int n) {


    int[] result = new int[n];
    if (n == 0 || n == 1) {
      return result;
    }
    // n=8 ,
    int counter = 1;
    int i = 0;
    for (; i < n && (i + 1) < n; i++) {
      result[i] = counter;
      result[++i] = counter * -1;
      counter++;
    }
    if (i<(n-1))
      result[n-1] = 0;
      return result;
  }
}
