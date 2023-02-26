package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Increasing_Subsequences_491 {

  public static void main(String[] args) {
    int[] input = {4, 6, 7, 7, 5, 8};
    System.err.println("Answer= " + findSubsequences(input));
  }

  public static List<List<Integer>> findSubsequences(int[] nums) {
    return solution_1(nums);
  }

  public static List<List<Integer>> solution_1(int[] nums) {
    int len = nums.length;
    Set<List<Integer>>[] memo = new HashSet[len];
    Set<List<Integer>> finalResult = new HashSet<>();

    for (int i = len - 2; i >= 0; i--) {
      int num_i = nums[i];
      System.err.println("num_i=" + num_i);
      Set<List<Integer>> result_num_i_set = new HashSet<>();
      memo[i] = result_num_i_set;
      for (int j = i + 1; j < len; j++) {
        int num_j = nums[j];
        if (num_i > num_j) continue;
        result_num_i_set.add(List.of(num_i, num_j));
        Set<List<Integer>> num_j_memo_sets = memo[j] != null ? memo[j] : new HashSet<>();
        for (List<Integer> num_j_memo_list : num_j_memo_sets) {
          List<Integer> list_num_i = new ArrayList();
          list_num_i.add(num_i);
          list_num_i.addAll(new ArrayList(num_j_memo_list));
          result_num_i_set.add(list_num_i);
        }

        if (num_i == num_j) {
          break;
        }
      }
      finalResult.addAll(result_num_i_set);
    }
    return new ArrayList(finalResult);
  }


  public static List<List<Integer>> sol_2(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    helper(new LinkedList<Integer>(), 0, nums, res);
    return res;
  }

  private static void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res) {
    if (list.size() > 1) res.add(new LinkedList<Integer>(list));
    System.err.println("Res=" + res);

    Set<Integer> used = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      System.err.println("nums[i] --> " + nums[i]);
      if (used.contains(nums[i])) continue;
      if (list.size() == 0 || nums[i] >= list.peekLast()) {
        used.add(nums[i]);
        list.add(nums[i]);
        helper(list, i + 1, nums, res);
        list.remove(list.size() - 1);
      }
    }
  }


  /**
   * 5 5 5 7 8 9 -- 5, 57, 58, 59, 578, 579, 5789
   * -- 55, 557, 558, 559,55789
   *
   * @param nums
   * @return
   */

}
