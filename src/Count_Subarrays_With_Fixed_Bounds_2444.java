import utils.BigDataPlayer;

public class Count_Subarrays_With_Fixed_Bounds_2444 {

  public static void main(String[] args) {
    int[] input = BigDataPlayer.getIntData("Count_Subarrays_With_Fixed_Bounds_2444_input");

    long l = new Count_Subarrays_With_Fixed_Bounds_2444().countSubarrays(input, 1, 1);
    System.err.println("Res = " + l);
  }

  public long countSubarrays(int[] nums, int minK, int maxK) {
    countSubarrays_1(nums, minK, maxK);
    int startingGoodIndex = -1;
    int minKIndex = -1;
    int maxKIndex = -1;
    long result = 0;
    int l = nums.length;

    for (int i = 0; i < l; i++) {
      int num = nums[i];

      if (num == minK) {
        minKIndex = i;
      }
      if (num == maxK) {
        maxKIndex = i;
      }

      if (num < minK || num > maxK) {
        minKIndex = -1;
        maxKIndex = -1;
        startingGoodIndex = -1;
      }

      if (startingGoodIndex < 0) {
        startingGoodIndex = i;
      }

      if (minKIndex >= 0 && maxKIndex >= 0) {
        // Find combination ending at this index i.e.= 'i'
        String log = i + "- Adding_2 = " + (Math.min(minKIndex, maxKIndex) - startingGoodIndex + 1) + " answer=" + result;
        BigDataPlayer.writeToLogFile1(log + "\n");
        System.out.println(log);
        result += +(Math.min(minKIndex, maxKIndex) - startingGoodIndex + 1);
      }
    }

    return result;
  }

  public long countSubarrays_1(int[] nums, int minK, int maxK) {
    // minPosition, maxPosition: the MOST RECENT positions of minK and maxK.
    // leftBound: the MOST RECENT value outside the range [minK, maxK].
    long answer = 0;
    int minPosition = -1, maxPosition = -1, leftBound = -1;
    // Iterate over nums, for each number at index i:
    for (int i = 0; i < nums.length; ++i) {
      // If the number is outside the range [minK, maxK], update the most recent leftBound.
      if (nums[i] < minK || nums[i] > maxK)
        leftBound = i;

      // If the number is minK or maxK, update the most recent position.
      if (nums[i] == minK)
        minPosition = i;
      if (nums[i] == maxK)
        maxPosition = i;

      // The number of valid subarrays equals the number of elements between leftBound and
      // the smaller of the two most recent positions (minPosition and maxPosition).
      String log = i + "- Adding_1 = " + Math.max(0, Math.min(maxPosition, minPosition) - leftBound) + " answer=" + answer;
      BigDataPlayer.writeToLogFile2(log + "\n");
      System.out.println(log);

      answer += Math.max(0, Math.min(maxPosition, minPosition) - leftBound);
    }
    if (true) return 1;
    return answer;
  }

}
