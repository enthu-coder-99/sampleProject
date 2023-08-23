package Arrays;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array_II_80 {


  public static void main(String[] args) {
    Remove_Duplicates_from_Sorted_Array_II_80 obj = new Remove_Duplicates_from_Sorted_Array_II_80();
    int[] nums = {1, 1, 1, 2, 2, 3};
    int ans = obj.removeDuplicates_easyToUnderstand(nums);
    System.err.println("ANS= " + ans);

  }

  public int removeDuplicates_easyToUnderstand(int[] nums) {
    int l = nums.length;
    int writingIndex = 1;
    int count = 1;

    for (int i = 1; i < l; i++) {
      int num = nums[i];
      if (num == nums[i - 1]) {
        count++;
      } else {
        count = 1;
      }
      if (count <= 2) {
        nums[writingIndex++] = num;
      }
    }
    System.out.println("Last Array= " + Arrays.toString(nums));
    return writingIndex;
  }

  public int removeDuplicates(int[] nums) {
    System.out.println("Input Array= " + Arrays.toString(nums));

    int l = nums.length;
    int writingIndex = 2;

    for (int i = writingIndex; i < l; i++) {
      int num = nums[i];
      if (num == nums[writingIndex - 2] && num == nums[writingIndex - 1]) continue;
      nums[writingIndex++] = num;
    }

    System.out.println("Last Array= " + Arrays.toString(nums));
    return writingIndex;
  }
}
