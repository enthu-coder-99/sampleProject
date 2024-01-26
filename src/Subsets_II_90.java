import java.util.ArrayList;
import java.util.List;

public class Subsets_II_90 {

  public static void main(String[] args) {
    System.err.println(subsetsWithDup(new int[]{1, 2, 3, 4, 4}));
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<>();
    int length = nums.length;
    resultList.add(new ArrayList<>());
    int lastSubSetSize = 0;

    for (int i = 0; i < length; i++) {
      int currentNum = nums[i];
      int startIndx = 0;
      if (i > 0 && currentNum == nums[i - 1])
        startIndx = lastSubSetSize;

      lastSubSetSize = resultList.size();
      for (int j = startIndx; j < lastSubSetSize; j++) {
        List<Integer> oldListElement = resultList.get(j);
        ArrayList newListElement = new ArrayList(oldListElement);
        newListElement.add(currentNum);
        resultList.add(newListElement);
      }
    }
    resultList.add(new ArrayList<>());
    return resultList;
  }
}
