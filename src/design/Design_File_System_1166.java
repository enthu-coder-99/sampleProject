package design;

import java.util.HashMap;
import java.util.Map;

public class Design_File_System_1166 {
  Map<String, Integer> map = new HashMap<>();

  public boolean createPath(String path, int value) {
    if (path.equals("") || path.equals("/")) return false;
    if (map.containsKey(path)) return false;
    int lastIndexOfSlash = path.lastIndexOf("/");
    if (lastIndexOfSlash > 0) {
      String parentPath = path.substring(0, lastIndexOfSlash);
      if (!map.containsKey(parentPath)) return false;
    }
    map.put(path, value);
    return true;
  }

  public int get(String path) {
    if (map.containsKey(path)) return map.get(path);
    return -1;
  }
}
