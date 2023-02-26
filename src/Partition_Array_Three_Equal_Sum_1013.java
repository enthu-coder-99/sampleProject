import java.util.Arrays;

public class Partition_Array_Three_Equal_Sum_1013 {

  public static void main(String[] args) {
    int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};

    int[][] ints = {{1, 2, 3, 9}, {5, 6, 7, 8}};
    System.err.println(ints.length);
    System.err.println(ints[0].length);

    System.err.println(canThreePartsEqualSum(arr));
  }

  public static boolean canThreePartsEqualSum(int[] nums) {
    if (nums == null || nums.length == 0) return false;

    int sum = Arrays.stream(nums).sum();

    if (sum % 3 != 0) return false;

    System.out.println(sum);
    sum = sum / 3;

    int i = 0;
    int partSum = 0;
    int sumCounter = 0;
    for (; i < nums.length; i++) {
      partSum += nums[i];
      if (partSum == sum) {
        sumCounter++;
        partSum = 0;
      }
      if (sumCounter == 3)
        break;
    }
    int residualSum = 0;
    for (i++; i < nums.length; i++)
      residualSum += nums[i];
    return (sumCounter == 3 && residualSum == 0);
  }
}
