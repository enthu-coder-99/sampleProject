import utils.CommonLogging;

public class Rotate_Array_109 {

  public static void main(String[] args) {
    int[] i = new int[]{1, 2, 3, 4, 5, 6, 7};
    rotate(i, 3);
    System.err.println(CommonLogging.printArray("", i));
  }

  public static void rotate(int[] nums, int k) {

    int length = nums.length;
    k = k % length;

    rotateByIndexes(nums, 0, length - 1);
    rotateByIndexes(nums, 0, k - 1);
    rotateByIndexes(nums, k, length - 1);

  }

  public static void rotateByIndexes(int[] nums, int start, int end) {
    int length = nums.length;
    while (end > start) {
      int tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }

  }
}
