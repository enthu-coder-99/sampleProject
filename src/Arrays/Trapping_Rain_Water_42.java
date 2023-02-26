package Arrays;

public class Trapping_Rain_Water_42 {

  public static void main(String[] args) {
    System.err.println(trap_sol1(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
  }

  public static int trap_sol1(int[] height) {
    int length = height.length;
    int result = 0;
    int[] minArray = new int[length];
    int[] maxArray = new int[length];
    int minValue = height[0];
    for (int i = 1; i < length; i++) {
      minArray[i] = minValue;
      minValue = Math.max(minValue, height[i]);
    }

    int maxValue = height[length - 1];
    for (int i = length - 2; i >= 0; i--) {
      maxArray[i] = maxValue;
      maxValue = Math.max(maxValue, height[i]);
    }

    for (int i = 1; i < length; i++) {
      int waterTrap = (Math.min(maxArray[i], minArray[i])) - height[i];
      result += waterTrap > 0 ? waterTrap : 0;
    }
    return result;
  }
}
