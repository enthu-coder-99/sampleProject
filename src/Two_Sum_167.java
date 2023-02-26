public class Two_Sum_167 {

  public static void main(String[] args) {
    System.err.println(twoSum(new int[]{2, 7, 11, 15}, 9));
  }

  public static int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    int length = numbers.length;
    int left = 0;
    int right = length - 1;

    while (right > left) {
      int rightNum = numbers[right];
      int leftNum = numbers[left];
      int rightLeftSum = rightNum + leftNum;
      if (target > rightLeftSum) {
        left++;
      } else if (rightLeftSum > target) {
        right--;
      } else {
        //Find the combination
        result[0] = left + 1;
        result[1] = right + 1;
        break;
      }
    }
    return result;
  }
}
