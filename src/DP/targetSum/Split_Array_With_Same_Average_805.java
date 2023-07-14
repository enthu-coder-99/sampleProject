package DP.targetSum;

public class Split_Array_With_Same_Average_805 {

  public static void main(String[] args) {
    Split_Array_With_Same_Average_805 obj = new Split_Array_With_Same_Average_805();
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println(obj.splitArraySameAverage(nums));

  }

  public boolean splitArraySameAverage(int[] nums) {
    int l = nums.length;
    int sum = getSum(nums);
    System.out.println("sum=" + sum + ", l=" + l);
    for (int index = 1; index <= l / 2; index++) {
      int num = nums[index];
      Double exp = (double) index * sum % (l);
      System.out.println("index=" + index + ", num=" + num + ", sum=" + sum + ", exp= " + exp);
      if (exp == 0.0) {// AS per comment calculation in the last of this file.
        System.out.println("Testing with index= " + index + ", exp=" + (index * sum / (l)) + ", num=" + num);
        boolean b = isSubSetExist(index, index * sum / (l), nums);
        if (b) return true;
      }
    }
    return false;
  }

  private boolean isSubSetExist(int subSetLength, int targetSubSetSum, int[] nums) {
    int l = nums.length;
    System.out.println("subSetLength=" + subSetLength + ", targetSubSetSum=" + targetSubSetSum);
    boolean[][] dp = new boolean[subSetLength + 1][targetSubSetSum + 1];
    for (int i = 0; i < l; i++) {
      int num_i = nums[i];
      for (int j = targetSubSetSum; j >= num_i; j--) {
        for (int k = 1; k <= subSetLength; k++) {
          dp[k][j] = dp[k][j] || dp[k - 1][j - num_i];
        }
      }
      dp[1][num_i] = true;
    }
    return dp[subSetLength][targetSubSetSum];
  }

  public int getSum(int[] nums) {
    int l = nums.length;
    int sum = 0;
    for (int i = 0; i < l; i++) {
      int num = nums[i];
      sum += num;
    }
    return sum;
  }

  /**
   sum_1/k = (sum - sum_1)/(l-k)

   sum_1 * (l-k) = (sum - sum_1)(k)

   sum_1 * l - k * sum_1 = sum * k - sum_1 * k

   sum_1 * l = sum * k

   sum_1 = k * sum / l; where 1<=k<= n/2
   */
}
