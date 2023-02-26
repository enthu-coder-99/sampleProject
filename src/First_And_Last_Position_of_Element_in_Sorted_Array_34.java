public class First_And_Last_Position_of_Element_in_Sorted_Array_34 {
  public static void main(String[] args) {
    System.err.println(searchRange(new int[]{5,7,7,8,8,10}, 8));
  }

  public static int[] searchRange(int[] nums, int target) {
    int length = nums.length;
    int left = 0;
    int right = length - 1;
    int firstPosition = -1;
    int lastPosition = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target > nums[mid]) {
        left = mid + 1;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        firstPosition = mid;
        if (lastPosition == -1)
          lastPosition = mid;
        right = mid - 1;
      }
    }

    if (firstPosition == -1 || lastPosition == -1)
      return new int[]{-1, -1};


    left = lastPosition;
    right = length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target > nums[mid]) {
        left = mid + 1;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        lastPosition = mid;
        left = mid + 1;
      }
    }

    return new int[]{firstPosition, lastPosition};
  }


}
