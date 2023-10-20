package Arrays;

import java.util.HashMap;
import java.util.Map;

public class H_Index_274 {

  public static void main(String[] args) {
    int[] citations = new int[]{3, 0, 6, 1, 5};
    H_Index_274 obj = new H_Index_274();
    int ans = obj.hIndex(citations);
    System.out.println("Ans = " + ans);
  }

  public int hIndex(int[] citations) {

    int l = citations.length;
    Map<Integer, Integer> map = new HashMap();
    for (int i = 1; i <= l; i++) {
      int count = citations[i - 1];
      if (count > l) count = l;
      map.put(count, map.getOrDefault(count, 0) + 1);
    }

    int totalNoOfPapers = 0;
    for (int i = l; i > 0; i--) {
      int noOfPapers = map.getOrDefault(i, 0);
      totalNoOfPapers = totalNoOfPapers + noOfPapers;
      if (totalNoOfPapers >= i) return i;
    }
    return 0;
  }
}
