import utils.CommonLogging;

public class Remove_Element_27 {

  public static void main(String[] args) {
    int[] input = {2};
    System.err.println(removeElement(input, 3));
    CommonLogging.printArray("", input);
  }


  public static int removeElement(int[] nums, int excludeVal) {
    int begin = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != excludeVal)
        nums[begin++] = nums[i];

    }
    return begin;
  }

}
