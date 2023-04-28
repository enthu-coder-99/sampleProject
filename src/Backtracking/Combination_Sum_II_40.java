package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination_Sum_II_40 {

  public static void main(String[] args) {
    int[] candidates = new int[]{1, 2, 2, 2};
    combinationSum2(candidates, 4);
  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList();
    Arrays.sort(candidates);
    dfs(0, target, new LinkedList(), candidates, result, 0);
    System.err.println("result= " + result);
    return result;
  }

  public static void dfs(int startingIndex, int remainingSum, LinkedList<Integer> combi, int[] candidates,
                         List<List<Integer>> result, int loopNum) {
    int l = candidates.length;
    System.err.println("\nstartingIndex=" + startingIndex + ", combi=" + combi + ", remainingSum=" + remainingSum + ", loopNum= " + loopNum);

    if (remainingSum <= 0) {
      if (remainingSum == 0) {
        System.err.println("Adding ..combi=" + combi);
        result.add(new ArrayList(combi));
      }
      System.err.println("returning ..combi=" + combi);
      return;
    }
    for (int i = startingIndex; i < l; i++) {
      System.err.println("#37 i= " + i + ", startingIndex= " + startingIndex + ", loopNum= " + loopNum + ", combi= " + combi + ", result= " + result);
      if (i != startingIndex && candidates[i] == candidates[i - 1]) {
        // Element from startingIndex to (i-1) are not included in combination(combi)
        // We already processed all combi starting with "startingIndex" so if will consider anything with startingIndex+ and num is same, it will createa a duplicate result.
        System.err.println(" and skip..");
        continue;
      }

      int num = candidates[i];
      combi.add(num);
      System.err.println("#46 i= " + i + ", startingIndex= " + startingIndex + ", loopNum= " + loopNum + ", combi= " + combi + ", result= " + result);

      System.err.println("calling dfs again and populated_combi=" + combi + " and new_i= " + (i + 1) + " and remainingSum= " + (remainingSum - num));
      dfs(i + 1, remainingSum - num, combi, candidates, result, loopNum + 1);
      Integer removed = combi.removeLast();
      System.err.println("i= " + i + ", startingIndex= " + startingIndex + ", loopNum= " + loopNum + ", removed = " + removed + ".................\n");
    }
  }
}
