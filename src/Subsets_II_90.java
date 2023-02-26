import java.util.*;
import java.util.stream.Collectors;

public class Subsets_II_90 {

  public static void main(String[] args) {
    Integer[] integers = new Integer[5];
    integers[2] = 123;
    List<Integer> ints = Arrays.stream(integers).collect(Collectors.toList());
    System.err.println(subsetsWithDup(new int[]{1, 2, 3, 4, 4}));
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<>();
    int length = nums.length;
    resultList.add(List.of(nums[0]));
    for (int i = 1; i < length; i++) {
      int size = resultList.size();
      for (int j = 0; j < size; j++) {
        List<Integer> oldListCopy = new ArrayList<>(resultList.get(j));
        oldListCopy.add(nums[i]);
        resultList.add(oldListCopy);
      }
      resultList.add(List.of(nums[i]));
    }
    resultList.add(new ArrayList<>());
    return resultList;
  }
}
