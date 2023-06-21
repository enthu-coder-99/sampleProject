package DP.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Length_of_Pair_Chain_646 {
  // https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/2639688/Greedy-oror-Recursive-oror-Iterative-oror-Easiest-and-Efficient-CPP-Solution

  public static void main(String[] args) {
    Maximum_Length_of_Pair_Chain_646 obj = new Maximum_Length_of_Pair_Chain_646();
    int[][] pairs = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
    int ans = obj.findLongestChain(pairs);
    System.out.println("Answer = " + ans);
  }

  public int findLongestChain(int[][] pairs) {
    return sol_dp_time_complexity_n(pairs);
  }

  public int sol_dp_time_complexity_n(int[][] pairs) {
    int l = pairs.length;
    Arrays.sort(pairs,
      new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          if (o1[0] == o2[0])
            return o1[1] - o2[1];
          return o1[0] - o2[0];
        }
      });

    for (int i = 0; i < l; i++) {
      System.out.print(pairs[i][0] + "," + pairs[i][1] + " | ");
    }
    System.out.println("");
    Arrays.sort(pairs,
      new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          if (o1[1] == o2[1])
            return o1[0] - o2[0];
          return o1[1] - o2[1];
        }
      });

    for (int i = 0; i < l; i++) {
      System.out.print(pairs[i][0] + "," + pairs[i][1] + " | ");
    }

    System.out.println("");
    int ans = 1;
    int[] lastPairSelected = pairs[0];
    for (int i = 1; i < l; i++) {
      int[] pair_i = pairs[i];
      int first_num = pair_i[0];
      if (first_num > lastPairSelected[1]) {
        ans++;
        lastPairSelected = pair_i;
        System.out.println("Adding index = " + i);
      }
    }
    return ans;
  }

  // Time Complexity = N*N
  public int sol_dp_nXn(int[][] pairs) {
    Arrays.sort(pairs,
      new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return o1[0] - o2[0];
        }
      });
    int l = pairs.length;
    int dp[] = new int[l];
    dp[l - 1] = 1;
    int ans = 1;
    for (int i = l - 1; i >= 0; i--) {
      dp[i] = 1;
      int[] pair_i = pairs[i];
      int first_num = pair_i[1];
      for (int j = 0; j < l; j++) {
        int[] pair_j = pairs[j];
        int second_num = pair_j[0];
        if (first_num < second_num)
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }
}
