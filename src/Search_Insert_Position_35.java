public class Search_Insert_Position_35 {

  public static void main(String[] args) {
    System.err.println(searchInsert(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 14));
  }

  public static int searchInsert(int[] nums, int target) {

    if (target < nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }
    int left = 0;
    int right = nums.length - 1;
    while (right >= left) {
      int mid = left + (right - left) / 2;
      if (target == nums[mid]) return mid;
      else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    System.out.println(left + " : " + right);
    return left;
  }
}
