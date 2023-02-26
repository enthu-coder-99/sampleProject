package utils;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Equals_K_560 {

  public static void main(String[] args) {
    System.err.println(Character.toString(65));

    System.out.println(Math.pow(62, 7));
    int[] arr = new int[]{1, 1, 1};
    //System.err.println(subarraySum(arr, 2));

    arr = new int[]{3, 4, 7, -2, 2, 1, 4, 2};
    //System.err.println(subarraySum(arr, 7));
    arr = new int[]{1, 1, 1};
    System.err.println(subarraySum(arr, 2));


    //{1,2,3,4,5,6)
    //(3,7,14,12,14,15,19,21)
    //ai - aj = k where i>
    //-1,-1,1
    //-1, -2, -1

  }

  public static int subarraySum(int[] nums, int k) {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();//To store sum of all Array elements.
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (sum == k)
        count++;
      int preSum = sum - k;
      count = count + (map.containsKey(preSum) ? map.get(preSum) : 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static int subarraySum_old1(int[] nums, int k) {
    int count = 0; // To store the count
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    //Stores cumulative sum till point
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) count++;// Obviously, increment count if sum == k as that's what u r looking for
      //sum [i, j] = sum [0, j] + sum[0, i - 1];
      //k = sum + (map-key-that-we-looking-for-that-was-stored-in-the-past)
      //OR (mapkey) = sum - k
      if (map.containsKey(sum - k)) {
        count += map.get(sum - k); // to handle negative values that effectively adds up to zero between 2 sums of same vaue
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static int subarraySum_old2(int[] nums, int k) {
    // Edge cases
    if (nums.length == 0) return 0;

    // Sliding window -- No, contains negative number
    // hashmap + preSum
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
        */
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int result = 0;
    map.put(0, 1);
    for (int cur : nums) {
      sum += cur;
      if (map.containsKey(sum - k))  // there exist a key, that [hashmap-key  =  sum - k]
        result += map.get(sum - k);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
}

