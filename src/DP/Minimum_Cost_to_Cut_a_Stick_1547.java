package DP;

import java.util.Arrays;

public class Minimum_Cost_to_Cut_a_Stick_1547 {


  public static void main(String[] rgrgbrhnbhtns) {
    int[] cuts = new int[]{5, 6, 1, 4, 2};//0,1,4.6.8
    int n = 9;

    System.err.println(minCost(n, cuts));
    System.err.println(minCost_lc_soln(n, cuts));
  }


  public static int minCost(int n, int[] cuts) {
    int cutsLength = cuts.length;
    int[] newCutArray = new int[cutsLength + 2];
    for (int i = 1; i <= cutsLength; i++) {
      newCutArray[i] = cuts[i - 1];
    }
    newCutArray[cutsLength + 1] = n;// Included 2 extra cut index. One at 0 and other at last
    int[][] memo = new int[cutsLength + 2][cutsLength + 2];
    for (int[] memo_i : memo) {
      Arrays.fill(memo_i, -1);
    }
    Arrays.sort(newCutArray);
    int ans = calculate(newCutArray, memo, 0, cutsLength + 1);
    System.out.println("My solutions ===========");
    for (int i = 0; i < memo.length; i++) {
      for (int j = 0; j < memo[0].length; j++) {
        System.out.println("Memo[" + i + "," + j + "]=" + memo[i][j]);

      }
    }
    System.err.println("minCost Final= " + ans);
    return ans;
  }

  private static int calculate(int[] newCutArray, int[][] memo, int leftCutIndex, int rightCutIndex) {
    if (memo[leftCutIndex][rightCutIndex] != -1) return memo[leftCutIndex][rightCutIndex];
    if (Math.abs(rightCutIndex - leftCutIndex) <= 1) return 0;
    int cost = Integer.MAX_VALUE;
    for (int i = leftCutIndex + 1; i < rightCutIndex; i++) {
      int leftPieceStartIndex = leftCutIndex;
      int leftPieceEndIndex = i;
      int rightPieceStartIndex = i;
      int rightPieceEndIndex = rightCutIndex;
      int leftCost = calculate(newCutArray, memo, leftPieceStartIndex, leftPieceEndIndex);
      int rightCost = calculate(newCutArray, memo, rightPieceStartIndex, rightPieceEndIndex);
      int length = newCutArray[rightCutIndex] - newCutArray[leftCutIndex];
      int totalCost = leftCost + rightCost + length;
      cost = Math.min(cost, totalCost);
    }
    memo[leftCutIndex][rightCutIndex] = cost;
    return cost;
  }

  public static int minCost_lc_soln(int n, int[] cuts) {
    int m = cuts.length;
    int[][] memo;
    int newCuts[];
    newCuts = new int[m + 2];
    System.arraycopy(cuts, 0, newCuts, 1, m);
    newCuts[m + 1] = n;
    Arrays.sort(newCuts);

    memo = new int[m + 2][m + 2];
    for (int r = 0; r < m + 2; ++r) {
      Arrays.fill(memo[r], -1);
    }

    int ans = cost_lc_soln(0, newCuts.length - 1, memo, newCuts);
    System.out.println("LCs solutions ===============");
    for (int i = 0; i < memo.length; i++) {
      for (int j = 0; j < memo[0].length; j++) {
        System.out.println("Memo[" + i + "," + j + "]=" + memo[i][j]);

      }
    }
    System.err.println("Final Ans (minCost_lc_soln) = " + ans);
    return ans;
  }

  private static int cost_lc_soln(int left, int right, int[][] memo, int[] newCuts) {

    if (memo[left][right] != -1) {
      return memo[left][right];
    }
    if (right - left == 1) {
      return 0;
    }
    int ans = Integer.MAX_VALUE;
    for (int mid = left + 1; mid < right; mid++) {
      int cost = cost_lc_soln(left, mid, memo, newCuts) + cost_lc_soln(mid, right, memo, newCuts) + newCuts[right] - newCuts[left];
      ans = Math.min(ans, cost);
    }
    memo[left][right] = ans;
    return ans;
  }

  public static int minCost_bottom_up(int n, int[] cuts) {
    System.out.println("Bottom UP started..............");
    int m = cuts.length;
    int[] newCuts = new int[m + 2];
    System.arraycopy(cuts, 0, newCuts, 1, m);
    newCuts[m + 1] = n;
    Arrays.sort(newCuts);

    int[][] dp = new int[m + 2][m + 2];

    for (int diff = 2; diff < m + 2; ++diff) {
      for (int left = 0; left < m + 2 - diff; ++left) {
        int right = left + diff;
        int ans = Integer.MAX_VALUE;
        for (int mid = left + 1; mid < right; ++mid) {
          ans = Math.min(ans, dp[left][mid] + dp[mid][right] + newCuts[right] - newCuts[left]);
        }
        dp[left][right] = ans;
      }
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.println("i=" + i + ", j=" + j + ", dp=" + dp[i][j]);
      }
    }
    System.out.println("Bottom UP Ended..............");

    return dp[0][m + 1];
  }

}
