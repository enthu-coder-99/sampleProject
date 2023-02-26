package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> resultList = new ArrayList<>();
    int[] inputArrys = new int[n];
    for (int i = 1; i <= n; i++) {
      inputArrys[i - 1] = i;
    }

    for (int i = 0; i < inputArrys.length; i++) {
      int inputArry = inputArrys[i];
    }
    return resultList;
  }
}
