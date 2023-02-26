package Arrays;

public class Count_Number_of_Bad_Pairs_2364 {

  public static void main(String[] args) {

  }

  public static long countBadPairs(int[] nums) {
    int l = nums.length;
    int result = 0;
    for (int i = 0; i < l - 1; i++) {
      for (int j = i + 1; j < l; j++) {
        if ((j - i) != (nums[j] - nums[i]))
          result++;
      }
    }
    return result;
  }

}
