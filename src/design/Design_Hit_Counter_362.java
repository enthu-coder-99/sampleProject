package design;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Design_Hit_Counter_362 {

  TreeMap<Integer, Integer> treeMap = new TreeMap();
  long totalHitCounter = 0;

  public Design_Hit_Counter_362() {

  }

  public void hit(int timestamp) {
    treeMap.put(timestamp, treeMap.getOrDefault(timestamp, 0) + 1);
    totalHitCounter++;

    Iterator<Integer> keys = treeMap.keySet().iterator();
    while (keys.hasNext()) {
      Integer key = keys.next();
      if (key < (timestamp - 300)) {
        Integer counterToBeDeleted = treeMap.get(key);
        totalHitCounter = totalHitCounter - counterToBeDeleted;
        keys.remove();
      } else
        break;
    }
  }

  public int getHits(int timestamp) {
    Map.Entry<Integer, Integer> firstEntry = treeMap.firstEntry();
    if (timestamp < firstEntry.getKey()) return 0;

    return treeMap.subMap(timestamp, timestamp + 300).size();
  }
}
