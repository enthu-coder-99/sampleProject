package stack;

import java.util.PriorityQueue;

public class ipo_502 {

  public static void main(String[] args) {

    PriorityQueue<int[]> pq = new PriorityQueue((o1, o2) -> ((int[])o1)[0] - ((int[])o2)[0]);
    int[] profits = new int[]{1, 2, 3};
    int[] capital = new int[]{0, 1, 1};
    int k = 2;
    int w = 0;
    System.err.println(findMaximizedCapital(k, w, profits, capital));
  }

  public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

    PriorityQueue<int[]> pq_caps = new PriorityQueue((o1, o2) -> ((int[]) o1)[0] - ((int[]) o2)[0]);

    for (int i = 0; i < capital.length; i++) {
      int cap = capital[i];
      pq_caps.offer(new int[]{cap, profits[i]});
    }
    PriorityQueue<int[]> pq_profits = new PriorityQueue((o1, o2) -> (((int[]) o2)[1] - ((int[]) o1)[1]));
    int totalProfit = 0;

    for (int i = 0; i < k; i++) {
      while (pq_caps.size() > 0 && pq_caps.peek()[0] <= w) {
        int[] cap_profit = pq_caps.poll();
        pq_profits.offer(cap_profit);
      }
      if (pq_profits.size() > 0) {
        int[] maxProfit = pq_profits.poll();
        totalProfit = totalProfit + maxProfit[1];
        System.err.println("totalProfit= " + totalProfit);
        w += maxProfit[1];
      }
    }

    return totalProfit;
  }
}
