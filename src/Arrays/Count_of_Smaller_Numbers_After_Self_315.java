package Arrays;

import utils.CommonLogging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Count_of_Smaller_Numbers_After_Self_315 {
  public static void main(String[] args) {

    CommonLogging.printList(countSmaller(new int[]{5, 2, 6, 1}));
    CommonLogging.printList(countSmaller(new int[]{-1, -1}));

  }

  public static List<Integer> countSmaller(int[] nums) {
    if (nums.length == 0 || nums.length == 1)
      return List.of(0);

    List<Integer> result = new ArrayList<>();
    List<Integer> sortList = new ArrayList<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      int currentNum = nums[i];
      int countSmallerNumber = countSmallerNumber(sortList, currentNum);
      result.add(countSmallerNumber);
    }

    Collections.reverse(result);
    return result;
  }

  static int countSmallerNumber(List<Integer> sortList, int currentNum) {

    int left = 0;
    int right = sortList.size() - 1;
    int lowestIndex = sortList.size() + 1;
    int midIndex = left + (right - left) / 2;

    while (right >= left) {
      int sortedNum = sortList.get(midIndex);
      if (sortedNum == currentNum) {
        lowestIndex = Math.min(lowestIndex, midIndex);
        right = midIndex - 1;
      } else if (sortedNum > currentNum) {
        right = midIndex - 1;
      } else {
        left = midIndex + 1;
      }
      midIndex = left + (right - left) / 2;
    }
    if (lowestIndex < sortList.size()) {
      // We find the number or duplicate number
      sortList.add(lowestIndex, currentNum);
      return lowestIndex;
    } else {
      // Numbre not find in Array.
      sortList.add(midIndex, currentNum);
      return midIndex;

    }
  }

}
