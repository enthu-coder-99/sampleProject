package Arrays;

public class Search_in_Rotated_Sorted_Array_33 {

  public static void main(String[] args) {
    int[] nums = {1, 3};
    System.err.println(search(nums, 3));
  }


  public static int search(int[] nums, int target) {
    if (nums.length == 1) return nums[0] == target ? 0 : -1;
    int l = nums.length;

    int num0 = nums[0];
    int numL = nums[l - 1];
    if (target == num0) return 0;

    if(numL>num0){
      // no pivot point and it is a straight increasing array.
      return binarySearch(nums, target, 0, l-1);

    }else{
      int minIndex = getMinIndex(nums);
      System.err.println("minIndex=" + minIndex);
      int minIndexVal = nums[minIndex];
      if (target == minIndexVal) return minIndex;

      if (target > num0) {
        int lo = 0;
        int hi = minIndex - 1;
        return binarySearch(nums, target, lo, hi);
      } else {
        int lo = minIndex + 1;
        int hi = l - 1;
        return binarySearch(nums, target, lo, hi);

      }
    }

  }

  public static int binarySearch(int[] nums, int target, int lo, int hi) {
    while (hi >= lo) {
      int mid = lo + (hi - lo) / 2;
      int midVal = nums[mid];
      if (midVal == target) return mid;
      if (midVal > target) hi = mid - 1;
      else lo = mid + 1;
    }
    return -1;
  }

  public static int getMinIndex(int[] nums) {
    int l = nums.length;
    if (l == 1) return nums[0];
    int lo = 0;
    int hi = l - 1;
    int num0 = nums[0];
    while (hi >= lo) {
      if (nums[hi] > nums[lo]) return lo;

      int mid = lo + (hi - lo) / 2;
      int midNum = nums[mid];
      if (mid == 0)
        return nums[0] > nums[1] ? 1 : 0;
      if (midNum <= nums[mid - 1]) return mid;
      if (num0 >= midNum) hi = mid - 1;
      else lo = mid + 1;

    }
    return lo;
  }
}
