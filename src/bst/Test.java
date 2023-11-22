package bst;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("K10", "K20");
    map.put("K11", "K21");
    map.put("K1", "K2");
    map.put("K2", "K3");
    map.put("K4", "K10");
    System.err.println(hasLookp(map));
  }

  public static boolean hasLookp(HashMap<String, String> map) {
    Set<String> keySet = map.keySet();
    for (String key : keySet) {
      if (isLoopKey(key, map))
        return true;
    }
    return false;
  }

  /**
   * K10 -K20
   * K11 - K21
   */
  public static boolean isLoopKey(String key, HashMap<String, String> map) {
    // key = K11
    String localKey = key;//K1
    while (map.containsKey(localKey)) {//K10
      String value = map.get(localKey);//K20
      if (value.equals(key)) {
        return true;
      }
      localKey = value; //K20
    }
    return false;
  }

  public static void print(Map<Character, Integer> map) {
    map.entrySet().forEach(e -> System.err.print(e.getKey() + ":" + e.getValue() + ", "));
  }

  public static void print1(Map<String, Integer> map) {
    map.entrySet().forEach(e -> System.err.print(e.getKey() + ":" + e.getValue() + ", "));
  }
}
