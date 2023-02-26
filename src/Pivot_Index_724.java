public class Pivot_Index_724 {

  public static void main(String[] args) {
    System.err.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    System.err.println(pivotIndex(new int[]{-1, -1, -1, -1, -1, -1}));

  }

  public static int pivotIndex(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    int leftsum = 0;
    int rightsum = sum;
    for (int i = 0; i < nums.length; i++) {
      rightsum = rightsum - nums[i];
      if (leftsum == rightsum)
        return i;
      leftsum = leftsum + nums[i];
    }
    return -1;
  }

}
