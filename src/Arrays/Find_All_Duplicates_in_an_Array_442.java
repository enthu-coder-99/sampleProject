package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_All_Duplicates_in_an_Array_442 {

  public static void main(String[] args) {
    System.err.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
  }


  public static List<Integer> findDuplicates(int[] nums) {
    List<Integer> list = new ArrayList();
    for (int i = 0; i < nums.length; i++) {
      System.err.println(i + " and nums[i]=" + nums[i]);
      int currentNumAbs = Math.abs(nums[i]);
      if (nums[currentNumAbs - 1] > 0) {
        nums[currentNumAbs - 1] = nums[currentNumAbs - 1] * -1;
      } else {
        list.add(nums[i]);
      }
    }
    return list;
  }
}
