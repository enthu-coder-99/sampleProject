import utils.CommonLogging;

public class Remove_Duplicates_From_Sorted_Array_26 {

  public static void main(String[] args) {
    int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.err.println(removeDuplicates(input));
    CommonLogging.printArray("", input);
  }


  public static int removeDuplicates(int[] nums) {

    int currentNumberSeries = Integer.MIN_VALUE;
    int totalDifferentNumbers = 0;
    for (int i = 0; i < nums.length; i++) {
      int currentNum = nums[i];
      if (currentNumberSeries != currentNum) {
        currentNumberSeries = currentNum;
        nums[totalDifferentNumbers] = currentNum;
        ++totalDifferentNumbers;
      }
    }
    System.err.println(totalDifferentNumbers);

    return totalDifferentNumbers;
  }
}
