package interval_merging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partition_Labels_763 {

  public List<Integer> partitionLabels(String s) {

    List<Integer> ans = new ArrayList<>();
    int l = s.length();
    char[] chars = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < l; i++) {
      char c = chars[i];
      map.put(c, i);
    }

    int startIndex = -1;
    int lastIndex = 0;

    for (int i = 0; i < l; i++) {
      char c = chars[i];
      int lastIndexOfC = map.get(c);
      if (startIndex == -1) startIndex = i;

      lastIndex = Math.max(lastIndexOfC, lastIndex);
      if (i == lastIndex) {
        ans.add(lastIndex - startIndex + 1);
        startIndex = -1;
      }
    }
    return ans;
  }
}
