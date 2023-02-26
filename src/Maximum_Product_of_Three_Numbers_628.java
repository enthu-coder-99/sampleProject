public class Maximum_Product_of_Three_Numbers_628 {

  public static void main(String[] args) {
    int[] input1 = {1, 2, 3};
    int[] input = {-100, -98, -1, 2, 3, 4};

    System.err.println(maximumProduct(input));
  }

  public static int maximumProduct1(int[] nums) {
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    for (int n : nums) {
      if (n > max1) {
        max3 = max2;
        max2 = max1;
        max1 = n;
      } else if (n > max2) {
        max3 = max2;
        max2 = n;
      } else if (n > max3) {
        max3 = n;
      }

      if (n < min1) {
        min2 = min1;
        min1 = n;
      } else if (n < min2) {
        min2 = n;
      }
    }
    return Math.max(max1 * max2 * max3, max1 * min1 * min2);
  }

  public static int maximumProduct(int[] nums) {
    int l = nums.length;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int currentNum : nums) {
      if (currentNum > max1) {
        max3 = max2;
        max2 = max1;
        max1 = currentNum;
      } else if (currentNum > max2) {
        max3 = max2;
        max2 = currentNum;
      } else if (currentNum > max3) {
        max3 = currentNum;
      }
      if (min1 > currentNum) {
        min2 = min1;
        min1 = currentNum;
      } else if (min2 > currentNum) {
        min2 = currentNum;
      }
    }
    long leftMultiplication = max1 * max2 * max3;
    long rightMultiplication = max1 * min1 * min2;
    return Math.max((int) rightMultiplication, (int) leftMultiplication);
  }
}
