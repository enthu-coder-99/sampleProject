package interval_merging;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Count_Integers_in_Intervals_2276 {
  TreeMap<Integer, Integer> treeMap = new TreeMap<>();
  int count = 0;

  public void add(int left, int right) {

    Map.Entry<Integer, Integer> leftFloorEntry = treeMap.floorEntry(left);
    Map.Entry<Integer, Integer> rightFloorEntry = treeMap.floorEntry(right);

    if (leftFloorEntry != null) {
      Integer leftEntryVal = leftFloorEntry.getValue();
      if (left <= leftEntryVal) {
        left = Math.min(left, leftFloorEntry.getKey());
      }
    }

    if (rightFloorEntry != null) {
      Integer rightEntryKey = rightFloorEntry.getKey();
      Integer rightEntryVal = rightFloorEntry.getValue();
      if (right <= rightEntryVal) {
        right = Math.max(right, rightEntryVal);
      }
    }

    Map<Integer, Integer> subMap = treeMap.subMap(left, true, right, true);
    Iterator<Integer> subMapKeysIter = subMap.keySet().iterator();
    while (subMapKeysIter.hasNext()) {
      int subMapKey = subMapKeysIter.next();
      int subMapVal = treeMap.get(subMapKey);
      count = count - (subMapVal - subMapKey + 1);
      subMapKeysIter.remove();
    }

    subMap.clear();
    treeMap.put(left, right);
    count = count + right - left + 1;
  }

  public int count() {
    return count;
  }
}
