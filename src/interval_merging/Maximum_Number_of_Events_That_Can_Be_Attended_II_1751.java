package interval_merging;

import java.util.Arrays;

public class Maximum_Number_of_Events_That_Can_Be_Attended_II_1751 {
  public static void main(String[] args) {
    Maximum_Number_of_Events_That_Can_Be_Attended_II_1751 obj = new Maximum_Number_of_Events_That_Can_Be_Attended_II_1751();
    int[][] events = new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
    System.out.println("Ans=" + obj.maxValue(events, 2));
  }

  public int maxValue(int[][] events, int k) {
    Arrays.sort(events, (e1, e2) -> {
      if (e1[0] == e2[0])
        return e1[1] - e2[1];
      return e1[0] - e2[0];
    });
    int[][] memo = new int[events.length][k + 1];
    for (int i = 0; i < memo.length; i++) Arrays.fill(memo[i], -1);
    int ans1 = recursion(events, k, 0, memo);
    int ans2 = dp_sol1(events, k);
    System.out.println("Ans1=" + ans1 + ", ans2=" + ans2);

    return ans1;
  }

  private int dp_sol1(int[][] events, int k) {

    int l = events.length;
    int[][] dp = new int[l + 1][k + 1];

    for (int i = l - 1; i >= 0; i--) {
      int[] event = events[i];
      int nextEventIndexWhichCanBeAttendedIfAttendsThisEvent = nextEventIndex(events, i);
      for (int j = 1; j <= k; j++) {
        int choice1 = event[2];//If we attend this event.
        if (nextEventIndexWhichCanBeAttendedIfAttendsThisEvent < l) {
          choice1 = choice1 + dp[nextEventIndexWhichCanBeAttendedIfAttendsThisEvent][j - 1];
        }

        int choice2 = dp[i + 1][j];
        dp[i][j] = Math.max(choice1, choice2);
      }
    }

    return dp[0][k];
  }

  private int recursion(int[][] events, int k, int startIndex, int[][] memo) {

    int l = events.length;
    if (k == 0 || startIndex >= l) {
      return 0;
    }
    System.out.println("startIndex=" + startIndex + ", k=" + k);
    if (memo[startIndex][k] != -1)
      return memo[startIndex][k];
    int[] startEvent = events[startIndex];

    int choice1 = startEvent[2] + recursion(events, k - 1, nextEventIndex(events, startIndex), memo); // Include this event is choice_1;
    int choice2 = recursion(events, k, startIndex + 1, memo);// Include this event is choice_1;
    System.out.println("startIndex=" + startIndex + ", k=" + k + ", choice1=" + choice1 + ", choice2=" + choice2);

    int maxPoint = Math.max(choice1, choice2);
    return memo[startIndex][k] = maxPoint;
  }

  private int nextEventIndex(int[][] events, int lastEventAttendedIndex) {
    int l = events.length;
    int[] lastEventAttended = events[lastEventAttendedIndex];

    int right = l - 1;
    int left = lastEventAttendedIndex + 1;
    int nextEventIndex = l;

    while (right >= left) {
      int mid = left + (right - left) / 2;
      int[] nextEvent = events[mid];
      if (nextEvent[0] > lastEventAttended[1]) {
        // We can attend this event.
        nextEventIndex = Math.min(nextEventIndex, mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return nextEventIndex;
  }
}
