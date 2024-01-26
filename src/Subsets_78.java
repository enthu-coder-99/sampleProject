import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
  public static void main(String[] args) {
    System.err.println("Ans= " + subsets(new int[]{1, 2, 3}).size());
  }

  public static List<List<Integer>> subsets(int[] nums) {
    return bitwise_sol(nums);
  }

  public static List<List<Integer>> bitwise_sol(int[] nums) {
    List<List<Integer>> resultList = new ArrayList();
    int length = nums.length;

    String startBinaryNum = "1" + getPaddedString("0", length);
    String endBinaryNum = "1" + getPaddedString("1", length);

    int startNum = Integer.valueOf(startBinaryNum, 2);
    int endNum = Integer.valueOf(endBinaryNum, 2);
    System.out.println("startNum=" + startNum + ", endNum=" + endNum);
    for (int i = startNum; i <= endNum; i++) {
      String binaryCombi = Integer.toBinaryString(i).substring(1);
      System.out.println(i + "- binaryCombi=" + binaryCombi);
      char[] chars = binaryCombi.toCharArray();
      List<Integer> newList = new ArrayList<>();
      for (int j = 0; j < chars.length; j++) {
        char c = chars[j];
        if (c == '1') {
          newList.add(nums[j]);
        }
      }
      resultList.add(newList);
    }
    return resultList;
  }

  private static String getPaddedString(String digit, int count) {
    StringBuilder sb = new StringBuilder("");
    while (count > 0) {
      sb.append(digit);
      count--;
    }
    return sb.toString();
  }

  public static List<List<Integer>> generic_math(int[] nums) {
    List<List<Integer>> resultList = new ArrayList();
    resultList.add(new ArrayList<>());
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      int currentNum = nums[i];
      int size = resultList.size();
      for (int j = 0; j < size; j++) {
        List<Integer> oldListElement = resultList.get(j);
        ArrayList newListElement = new ArrayList(oldListElement);
        newListElement.add(currentNum);
        resultList.add(newListElement);
      }
    }
    return resultList;
  }
}