package codelity.sample;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {

  public static void main(String[] args) {
    System.err.println(solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
  }

  public static int solution(int[] A) {
    // write your code in Java SE 8
    if (A.length == 1)
      return A[0];
    Map<Integer, Integer> map = new HashMap();
    long maxNumber = Long.MAX_VALUE;

    for (int i = 0; i < A.length; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
      if (map.getOrDefault(A[i], 0) > ((A.length / 2))) {
        maxNumber = A[i];
        break;

      }
    }
    System.out.print("maxNumber=" + maxNumber);
    if (maxNumber <= Integer.MAX_VALUE) {
      for (int i = 0; i < A.length; i++) {
        if ((int) maxNumber == A[i])
          return i;
      }
    }

    return -1;
  }
}
