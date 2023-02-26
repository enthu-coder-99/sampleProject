import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsets_78 {
  public static void main(String[] args) {
    Integer[] integers = new Integer[5];
    integers[2] = 123;
    System.err.println(subsets(new int[]{1, 2, 3, 4, 5}).size());
  }

  public static List<List<Integer>> subsets(int[] nums) {
    Map<Integer, List<List<Integer>>> resultMap = new HashMap();
    int length = nums.length;
    resultMap.put(nums[0], new ArrayList(List.of(nums[0])));
    for (int i = 1; i < length; i++) {
      int currentNum = nums[i];
      if (resultMap.containsKey(currentNum)) {
        //Duplicate number
      } else {
        Collection<List<List<Integer>>> oldElmList = resultMap.values();
        for (int j = 0; j < oldElmList.size(); j++) {

        }
      }

    }
    return (List) resultMap.values();
  }

}
