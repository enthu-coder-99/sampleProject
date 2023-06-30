package DP.LIS;

import java.util.HashMap;
import java.util.Map;

public class Longest_Arithmetic_Subsequence_1027 {
  public static void main(String[] args) {
    Longest_Arithmetic_Subsequence_1027 obj = new Longest_Arithmetic_Subsequence_1027();
    int[] nums = new int[]{3, 6, 9, 12};

    nums = new int[]{44, 46, 22, 68, 45, 66, 43, 9, 37, 30, 50, 67, 32, 47, 44, 11, 15, 4, 11, 6, 20, 64, 54, 54, 61, 63, 23, 43, 3,
      12, 51, 61, 16, 57, 14, 12, 55, 17, 18, 25, 19, 28, 45, 56, 29, 39, 52, 8, 1, 21, 17, 21, 23, 70, 51, 61, 21, 52, 25, 28};
    nums = new int[]{1, 1, 1, 1, 1};
    System.err.println(obj.longestArithSeqLength(nums));
  }

  public int longestArithSeqLength(int[] nums) {
    int l = nums.length;
    if (l < 2) return l;
    int ans = 1;
    Map<Integer, Integer>[] diffFreqCount = new HashMap[l];

    for (int i = l - 1; i >= 0; i--) {
      int num_i = nums[i];
      System.out.println("i=" + i + ", num[i]=" + num_i);
      diffFreqCount[i] = new HashMap<Integer, Integer>();
      for (int j = i + 1; j < l; j++) {
        int num_j = nums[j];
        int diff = num_j - num_i;
        diffFreqCount[i].put(diff,
          Math.max((diffFreqCount[j].getOrDefault(diff, 0) + 1), diffFreqCount[i].getOrDefault(diff, 0)));
        if (diffFreqCount[i].get(diff) > ans) {
          //System.out.println(i + "/" + j + "- num_i=" + num_i + ", num_j= " + num_j + ", diff=" + diff + ", ans=" + ans + ", new_ans=" + diffFreqCount[i].get(diff));
          ans = diffFreqCount[i].get(diff);
        }
      }
      // diffFreqCount = new HashMap();
      System.out.println("i=" + i + ", num_i=" + num_i + ", num_=" + ", diff_map[i]===" + diffFreqCount[i]);
    }

    //System.out.println(diffFreqCount);
    return ans + 1;
  }
}