package interval_merging;

import java.util.Map;
import java.util.TreeMap;

/**
 * ----         -----    -----    ----
 * ---
 */
public class Range_Module_715 {

  public static void main(String[] args) {
    Range_Module_715 obj = new Range_Module_715();
    obj.addRange(10, 20);
    obj.removeRange(14, 16);
    obj.queryRange(10, 14);
    obj.queryRange(13, 15);
    obj.queryRange(16, 17);

  }

  TreeMap<Integer, Integer> treeMap = new TreeMap<>();

  public void addRange(int left, int right) {

    Map.Entry<Integer, Integer> leftFloorEntry = treeMap.floorEntry(left);
    Map.Entry<Integer, Integer> rightFloorEntry = treeMap.floorEntry(right);

    if (leftFloorEntry != null && leftFloorEntry.getValue() >= left) {
      left = leftFloorEntry.getKey();
    }

    if (rightFloorEntry != null && rightFloorEntry.getValue() >= right) {
      right = rightFloorEntry.getValue();
    }

    treeMap.subMap(left, true, right, true).keySet().clear();
    treeMap.put(left, right);
    System.out.println(left + ", " + right + "- Add Map= " + treeMap);

  }

  public boolean queryRange(int left, int right) {
    Integer floorStartKey = treeMap.floorKey(left);
    if (floorStartKey != null) {
      Integer floorEndVal = treeMap.get(floorStartKey);
      if (floorEndVal >= right) {
        System.out.println(left + ", " + right + "- Query Map1= " + treeMap);
        return true;
      }
    }
    System.out.println(left + ", " + right + "- Query Map2= " + treeMap);
    ;

    return false;
  }

  public void removeRange(int left, int right) {

    Map.Entry<Integer, Integer> leftFloorEntry = treeMap.floorEntry(left);
    Map.Entry<Integer, Integer> rightFloorEntry = treeMap.floorEntry(right);

    if (leftFloorEntry != null && leftFloorEntry.getValue() > left) {
      treeMap.put(leftFloorEntry.getKey(), left);
    }

    if (rightFloorEntry != null && rightFloorEntry.getValue() > right) {
      treeMap.put(right, rightFloorEntry.getValue());
    }

    treeMap.subMap(left, true, right - 1, true).keySet().clear();
  }
}
