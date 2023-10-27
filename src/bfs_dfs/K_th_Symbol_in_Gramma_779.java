package bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class K_th_Symbol_in_Gramma_779 {

  public int dfs(int start, int n, int k) {
    // if start=1
    int firstDigit = 1;
    int secondDigit = 0;
    if (start == 0) {
      firstDigit = 0;
      secondDigit = 1;
    }
    if (n == 1) {
      if (k == 1) {
        return firstDigit;
      } else {
        return secondDigit;
      }
    }

    int totalNodesAt_nth_row = (int) Math.pow(2, n - 1);
    if (k <= totalNodesAt_nth_row) {
      return dfs(firstDigit, n - 1, k);
    }
    return dfs(secondDigit, n - 1, k - totalNodesAt_nth_row / 2);

  }


  // Time Limit OUt of memory
  public int kthGrammar_tle(int n, int k) {

    List<Integer> list = new ArrayList();
    if (n == 1 && k == 1) return 0;
    list.add(0);
    for (int i = 2; i <= n; i++) {
      int size = list.size();
      List<Integer> newList = new ArrayList();
      for (int j = 0; j < size; j++) {
        int elm = list.get(j);
        if (elm == 0) {
          newList.add(0);
          newList.add(1);
        } else {
          newList.add(1);
          newList.add(0);
        }
      }
      list = newList;
    }
    return list.get(k - 1);
  }

}
