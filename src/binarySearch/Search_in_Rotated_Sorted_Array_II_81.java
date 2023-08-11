package binarySearch;

public class Search_in_Rotated_Sorted_Array_II_81 {

  public static void main(String[] args) {
    int by2 = (100+199  ) >>2;
    System.err.println("Heelo and ="+by2);
  }

  public boolean search(int[] nums, int target) {
    int l = nums.length;
    int left = 0;
    int right = l - 1;
    int num_0 = nums[0];
    int num_l = nums[l - 1];
    while (right >= left) {
      while (right > left && nums[right] == nums[right - 1]) right--;
      while (right > left && nums[left] == nums[left + 1]) left++;

      int mid = left + (right - left) / 2;

      int r_num = nums[right];
      int l_num = nums[left];
      int mid_num = nums[mid];
      if (mid_num == target) return true;
      if (mid_num >= num_0) {
        // we are in first sorted portion between left and mid point.
        if (target < mid_num && target >= num_0) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        // mid_index is at second sorted array portion.
        if (target > mid_num && target <= num_l) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return false;
  }
}
