public class ContainerWithMostWater_11 {

  public static void main(String[] args) {
    int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.err.println(maxArea(input));
    input = new int[]{4, 3, 2, 1, 4};
    System.err.println(maxArea(input));
    input = new int[]{1, 2, 1};
    System.err.println(maxArea(input));

  }

  public static int maxArea(int[] height) {
    if (height.length <= 1)
      return 0;

    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;
    while (right > left) {
      maxArea = Math.max(maxArea, (Math.min(height[left], height[right]) * (right - left)));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }
}
