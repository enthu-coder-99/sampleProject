package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Time_Based_Key_Value_Store_981 {

  public static void main(String[] args) {
    Time_Based_Key_Value_Store_981 ts = new Time_Based_Key_Value_Store_981();
    ts.set("foo", "bar", 1);
    System.err.println(ts.get("foo", 1));
    System.err.println(ts.get("foo", 3));

  }

  public Map<String, List<String[]>> map = new HashMap();

  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) map.put(key, new ArrayList());
    map.get(key).add(new String[]{Integer.toString(timestamp), value});
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key)) return "";
    List<String[]> valueMap = map.get(key);
    return findTimeStamp(valueMap, timestamp);
  }

  public String findTimeStamp(List<String[]> valueMap, int timestamp) {
    int l = valueMap.size();
    System.err.println("timestamp= " + l + " and valueMap= " + valueMap.size());
    if (valueMap.size() == 0 || Integer.valueOf(valueMap.get(0)[0]) > timestamp) return "";
    if (Integer.valueOf(valueMap.get(l - 1)[0]) < timestamp) return valueMap.get(l - 1)[1];

    if (Integer.valueOf(valueMap.get(0)[0]) > timestamp)
      if (Integer.valueOf(valueMap.get(0)[0]) == timestamp) return valueMap.get(0)[1];
    int left = 0;
    int right = l - 1;
    while (right >= left) {
      int mid = left + (right - left) / 2;
      int midTS = Integer.valueOf(valueMap.get(mid)[0]);
      if (midTS == timestamp) return valueMap.get(mid)[1];
      if (midTS < timestamp) {
        if (mid != l - 1 && Integer.valueOf(valueMap.get(mid + 1)[0]) > timestamp) return valueMap.get(mid)[1];
        left = mid + 1;
      } else {
        if (mid != 0 && Integer.valueOf(valueMap.get(mid - 1)[0]) < timestamp) return valueMap.get(mid - 1)[1];
        right = mid - 1;
      }
    }
    System.err.println("left=" + left);
    return valueMap.get(left)[1];
  }
}
