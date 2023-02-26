import utils.CommonLogging;

public class Kth_Largest_Element_In_Array_215 {

  public static void main(String[] args) {
    System.err.println(findKthLargest(new int[]{4, 5, 7, 8, 9, 1, 2, 5}, 3));
  }

  public static int findKthLargest(int[] nums, int k) {
    quickSelect(nums, 0, nums.length - 1, k);
    return quickSelect(nums, 0, nums.length - 1, k);
  }

  static int quickSelect_myVersion(int[] nums, int low, int high, int k) {
    int pivot = low;
    for (int j = low; j < high; j++) {
      int num = nums[j];
      if (num <= nums[high]) {
        pivot++;
        System.err.println(nums[high] + " is greater than " + nums[j] + " hence swapping " + nums[j] + " with " + nums[pivot] + " and new pivot=" + (pivot + 1));
        swap(nums, j, pivot);
      }
    }
    swap(nums, pivot, high);
    int leftOverNumsCount = high - pivot + 1;
    if (leftOverNumsCount > k) {
    }
    return -1;
  }

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
