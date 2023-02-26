import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

  public static void main(String[] args) {
    List list = new ArrayList(12);
    System.err.println(list.size());
    list.add(1);
    System.err.println(list.size());

    list.add(2);
    System.err.println(list.size());

    System.err.println(threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));

  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int length = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < length - 2; i++) {
      int num = nums[i];
      if (num > 0)
        break;// If current num positive all further(right side) numbers in sorted array  will be positive also, so we won't be able to make three numbers sun as ZERO.
      if (i > 0 && num == nums[i - 1])
        continue;// To Avoid duplicate result we avoided the previously processed numbers.
      List<List<Integer>> twoSumFromSortedArray = findTwoSumFromSortedArray(nums, 0 - num, i + 1);
      if (twoSumFromSortedArray != null && twoSumFromSortedArray.size() > 0) {
        for (List<Integer> twoSumList : twoSumFromSortedArray) {
          twoSumList.add(num);
          result.add(twoSumList);
        }
      }
    }

    return result;
  }

  private static List<List<Integer>> findTwoSumFromSortedArray(int[] nums, int targetSum, int leftStartingIndex) {
    List<List<Integer>> result = new ArrayList<>();
    int rightEndingIndex = nums.length - 1;
    while (rightEndingIndex > leftStartingIndex) {
      int leftStartingIndexNum = nums[leftStartingIndex];
      int rightEndingIndexNum = nums[rightEndingIndex];
      int indexSum = leftStartingIndexNum + rightEndingIndexNum;


      if (indexSum > targetSum) {
        rightEndingIndex--;
      } else if (targetSum > indexSum) {
        leftStartingIndex++;
      } else {
        List<Integer> twoSumSortedArrayNumbers = new ArrayList<>();
        twoSumSortedArrayNumbers.add(leftStartingIndexNum);
        twoSumSortedArrayNumbers.add(rightEndingIndexNum);
        result.add(twoSumSortedArrayNumbers);
        while (leftStartingIndex < (nums.length - 1) && leftStartingIndexNum == nums[leftStartingIndex + 1])
          leftStartingIndex++;
        while (rightEndingIndexNum > 1 && rightEndingIndexNum == nums[rightEndingIndex - 1]) rightEndingIndex--;
        rightEndingIndex--;
        leftStartingIndex++;
      }
    }
    return result;
  }
}
