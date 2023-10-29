package interval_merging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Points_That_Intersect_With_Cars_2848 {

  public static void main(String[] args) {
    Points_That_Intersect_With_Cars_2848 obj = new Points_That_Intersect_With_Cars_2848();
    List<List<Integer>> nums = new ArrayList<>();
    nums.addAll(List.of(List.of(2, 3), List.of(3, 9), List.of(5, 7), List.of(4, 10), List.of(9, 10)));
    int ans = obj.numberOfPoints(nums);
    System.out.println("Ans= " + ans);

  }

  public int numberOfPoints(List<List<Integer>> nums) {

    Collections.sort(nums, new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> lhs, List<Integer> rhs) {
        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
        if (lhs.get(0) == rhs.get(0)) return lhs.get(1) - rhs.get(1);
        return lhs.get(0) - rhs.get(0);
      }
    });

    int ans = 0;
    int l = nums.size();
    int endPoint = -1;

    for (int i = 0; i < l; i++) {
      List<Integer> numList = nums.get(i);
      int start = numList.get(0);
      int end = numList.get(1);
      System.out.print(i + "- start= " + start + " : end=" + end);
      if (start > endPoint) {
        endPoint = end;
        ans = ans + (end - start + 1);
      } else {
        int newEndPoint = Math.max(endPoint, end);
        if (newEndPoint > endPoint) {
          ans = ans + (newEndPoint - endPoint);
          endPoint = Math.max(endPoint, newEndPoint);
        }
      }
      System.out.println(", Ans= " + ans);
    }
    return ans;
  }
}
