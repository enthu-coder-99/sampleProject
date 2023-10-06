package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Insert_Delete_GetRandom_O1_380 {

  Map<Integer, Integer> index2ValMap = new HashMap();
  Map<Integer, Integer> val2IndexMap = new HashMap();
  Random random = new Random();


  public boolean insert(int val) {
    if (val2IndexMap.containsKey(val)) return false;
    int size = index2ValMap.size();
    index2ValMap.put(size, val);
    val2IndexMap.put(val, size);

    return true;
  }

  public boolean remove(int val) {
    if (!val2IndexMap.containsKey(val)) return false;

    int lastElementIndexKey = index2ValMap.size() - 1;

    // Delete element from both Maps.
    int indexOfDeletedElm = val2IndexMap.remove(val);
    index2ValMap.remove(indexOfDeletedElm);

    if (index2ValMap.size() > 0) {
      // Now reassign the last element to this indexOfDeletedElm to fill the gap in Indexes.
      int lastElement = index2ValMap.remove(lastElementIndexKey);
      index2ValMap.put(indexOfDeletedElm, lastElement);
      val2IndexMap.put(lastElement, indexOfDeletedElm);
    }
    return true;
  }

  public int getRandom() {
    int randon_index = random.nextInt(index2ValMap.size());
    return index2ValMap.get(randon_index);
  }
}
