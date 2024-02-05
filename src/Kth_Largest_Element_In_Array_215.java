import utils.CommonLogging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kth_Largest_Element_In_Array_215 {

  public static void main(String[] args) {
    System.err.println(findKthLargest(new int[]{4, 5, 7, 8, 9, 1, 2, 5}, 3));
  }

  public static int findKthLargest(int[] nums, int k) {
    List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
    return quickSelect_myVersion(numsList, k);
  }

  static int quickSelect_myVersion(List<Integer> nums, int k) {
    int pivotNum = nums.get(0);
    //Left to pivot all should be small or equal to pivot.
    //Right side of pivot all should be greater than pivot.
    List<Integer> higherThanPivot = new ArrayList<>();
    List<Integer> lowerThanPivot = new ArrayList<>();
    int l = nums.size();
    for (int i = 0; i < l; i++) {
      int num = nums.get(i);
      if (num > pivotNum) {
        higherThanPivot.add(num);
      } else if (num < pivotNum) {
        lowerThanPivot.add(num);
      }
    }

    if (k <= higherThanPivot.size()) {
      return quickSelect_myVersion(higherThanPivot, k);
    }

    int pivotNumSize = l - higherThanPivot.size() - lowerThanPivot.size();
    if (k <= (higherThanPivot.size() + pivotNumSize)) {
      return pivotNum;
    }
    return quickSelect_myVersion(lowerThanPivot, (k - pivotNumSize - higherThanPivot.size()));
  }

  //50
  //25, 10. 15 and k=40

  static int quickSelect(int[] nums, int low, int high, int k) {
    int pivot = low;

    // use quick sort's idea
    // put nums that are <= pivot to the left
    // put nums that are  > pivot to the right
    for (int j = low; j < high; j++) {
      if (nums[j] <= nums[high]) {
        System.err.println(nums[high] + " is greater than " + nums[j] + " hence swapping " + nums[j] + " with " + nums[pivot] + " and new pivot=" + (pivot + 1));
        swap(nums, pivot++, j);
      }
      CommonLogging.printArray("23=", nums);
    }
    swap(nums, pivot, high);
    CommonLogging.printArray("26=", nums);

    // count the nums that are > pivot from high
    int count = high - pivot + 1;
    // pivot is the one!
    if (count == k) return nums[pivot];
    // pivot is too small, so it must be on the right
    if (count > k) return quickSelect(nums, pivot + 1, high, k);
    // pivot is too big, so it must be on the left
    return quickSelect(nums, low, pivot - 1, k - count);
  }

  private static void swap(int[] nums, int i, int j) {
    if (i == j)
      return;
    int swap = nums[i];
    nums[i] = nums[j];
    nums[j] = swap;
  }
}
