package interval_merging;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Amount_of_New_Area_Painted_Each_Day_2158 {

  public static void main(String[] args) {
    Amount_of_New_Area_Painted_Each_Day_2158 obj = new Amount_of_New_Area_Painted_Each_Day_2158();
    int[][] paints = new int[][]{{1, 4}, {5, 8}, {4, 7}};

    int[] ans = obj.amountPainted(paints);
    System.out.println("Ans= " + Arrays.toString(ans));
  }

  public int[] amountPainted(int[][] paints) {
    int l = paints.length;
    TreeMap<Integer, Integer> treeMap = new TreeMap();
    int[] ans = new int[l];

    for (int i = 0; i < l; i++) {
      int[] paint = paints[i];
      int start = paint[0];
      int end = paint[1];

      Map.Entry<Integer, Integer> startFloorEntry = treeMap.floorEntry(start);
      Map.Entry<Integer, Integer> endFloorEntry   = treeMap.floorEntry(end);
      int newStart = start;
      int newEnd = end;

      if (startFloorEntry != null && startFloorEntry.getKey() < start && ) {
        newStart = startFloorEntry.getKey();
      }

      if (endFloorEntry != null && endFloorEntry.getValue() > end) {
        newEnd = endFloorEntry.getValue();
      }

      Map<Integer, Integer> subMap = treeMap.subMap(newStart, true, newEnd, true);
      Set<Integer> subMapkeys = subMap.keySet();
      System.out.println(i + "- start= " + start + ", end= " + end + ", newStart= " + newStart
        + ", newEnd= " + newEnd
        + ", subMap= " + subMap);

      int numsAlreadyPainter = 0;
      for (int subMapKey : subMapkeys) {
        int subMapVal = treeMap.get(subMapKey);
        // Add the numbers already painted
        if (start >= subMapKey) {
          subMapKey = start;
        }

        if (subMapVal > end) {
          subMapVal = end;
        }

        numsAlreadyPainter = numsAlreadyPainter + subMapVal - subMapKey;
      }
      ans[i] = end - start - numsAlreadyPainter;
      subMap.clear();
      treeMap.put(newStart, newEnd);
      System.out.println(i + "- numsAlreadyPainter= " + numsAlreadyPainter + ", TreeMap= " + treeMap);
    }
    return ans;
  }
}
