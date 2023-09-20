package algo.graph.unionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Similar_String_Groups_839 {


  public int numSimilarGroups(String[] strs) {
    int l = strs.length;

    Map<Integer, List<Integer>> adjMap = buildAjdList(strs);
    UnionFindTemplate um = new UnionFindTemplate(l);
    Set<Integer> keys = adjMap.keySet();
    for (int key : keys) {
      List<Integer> similarList = adjMap.get(key);
      for (int similarItem : similarList) {
        um.merge(key, similarItem);
      }
    }
    int[] parent = um.parent;
    int ans = 0;
    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == -1) {
        ans++;
      }
    }

    return ans;
  }

  public Map<Integer, List<Integer>> buildAjdList(String[] strs) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    int l = strs.length;
    for (int i = 0; i < l; i++) {
      String str_i = strs[i];
      if (!adjMap.containsKey(i)) adjMap.put(i, new ArrayList<>());
      for (int j = i + 1; j < l; j++) {
        String str_j = strs[j];
        if (!adjMap.containsKey(j)) adjMap.put(j, new ArrayList<>());
        if (isSimilar(str_i, str_j)) {
          adjMap.get(i).add(j);
          adjMap.get(j).add(i);
        }
      }
    }
    return adjMap;
  }

  private boolean isSimilar(String str_i, String str_j) {
    char[] chars_i = str_i.toCharArray();
    char[] chars_j = str_j.toCharArray();
    int diff = 0;

    for (int i = 0; i < chars_i.length; i++) {
      if (chars_i[i] != chars_j[i])
        diff++;
    }

    return (diff == 0 || diff == 2);
  }
}
