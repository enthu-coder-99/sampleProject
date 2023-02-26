import java.util.LinkedHashMap;

public class Replace_Elements_In_An_Array_2295 {

  public static void main(String[] args) {

  }

  public static int[] arrayChange(int[] nums, int[][] operations) {

    LinkedHashMap<Integer, Integer> map = new LinkedHashMap();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < operations.length; i++) {
      int[] operation = operations[i];
      int originalVal = operation[0];
      int newVal = operation[1];
      map.put(newVal, map.get(originalVal));
      nums[map.get(originalVal)] = newVal;
      map.remove(originalVal);
    }
    return nums;
  }

}
