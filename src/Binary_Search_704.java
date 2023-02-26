public class Binary_Search_704 {

  public static void main(String[] args) {
    int[] input = {-1, 0, 3, 5, 9, 12, 14, 16, 18, 19, 23, 25};
    int[] input2 = {-1, 0, 3, 5, 5, 5, 5, 5, 5, 16, 18, 19, 23, 25};

    System.err.println(search(input2, 5));
    System.err.println("-------------------");
    System.err.println(search(input, 18));
    System.err.println(search(input, 23));
    System.err.println(search(input, 25));
    System.err.println(search(input, -1));
    System.err.println(search(input, -16));
  }

  // Sorted Array
  public static int search(int[] nums, int target) {
    int length = nums.length;
    int left = 0;
    int right = length - 1;
    int startIndex = -1;
    while (right >= left) {
      int midIndex = left + (right - left) / 2;
      if (nums[midIndex] > target) {
        right = midIndex - 1;
      } else if (nums[midIndex] < target) {
        left = midIndex + 1;
      } else {
        startIndex = midIndex;
        System.err.println("Find target=" + target + " at startIndex=" + startIndex);
        right = midIndex - 1;
      }
    }
    System.err.println("startIndex=" + startIndex);
    return -1;
  }
}