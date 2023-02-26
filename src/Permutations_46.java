import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
  static int loopCount = 0;

  public static void main(String[] args) {
    permute(new int[]{1, 2, 3});
  }

  static StringBuilder sb = new StringBuilder();

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    if (nums.length == 0) return resultList;
    //backtracking_old(nums, resultList, new ArrayList());
    backtracking__sol2(nums, resultList, new ArrayList(), new boolean[nums.length]);
    System.err.println(resultList);
    System.err.println(sb);
    return resultList;
  }

  private static void backtracking__sol2(int[] nums, List<List<Integer>> resultList, List tempList, boolean[] used) {

    if (tempList.size() == nums.length) {
      resultList.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        if (used[i]) continue;
        tempList.add(num);
        used[i] = true;
        backtracking__sol2(nums, resultList, tempList, new boolean[nums.length]);
        used[i] = false;
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static void backtracking_sol1(int[] nums, List<List<Integer>> resultList, List tempList) {
    if (tempList.size() == nums.length) {
      System.err.println("Adding new result = " + tempList);
      resultList.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        loopCount++;
        System.err.print(i + "- nums[i]=" + nums[i] + " and tempList=" + tempList + " and loopcount=" + loopCount);
        sb.append(i + ", ");
        //System.err.println((tempList));
        if (tempList.contains(nums[i])) {
          System.err.println(" and tempList already having the " + nums[i] + " so continue.");
          continue;
        } else {
          System.err.println(" Adding " + nums[i] + " in tempList.");
        }
        tempList.add(nums[i]);
        // System.err.println("loopCount1=" + loopCount);
        backtracking_sol1(nums, resultList, tempList);
        //System.err.println("loopCount2=" + loopCount);

        System.err.println(tempList + " and removing " + tempList.get(tempList.size() - 1));
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
