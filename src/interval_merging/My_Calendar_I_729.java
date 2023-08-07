package interval_merging;

import java.util.Map;
import java.util.TreeMap;

public class My_Calendar_I_729 {


  public static void main(String[] args) {
    My_Calendar_I_729 obj = new My_Calendar_I_729();
    System.out.println(obj.book(10, 50));
  }

  private TreeMap<Integer, Integer> memoMap = new TreeMap<>();

  //https://www.youtube.com/watch?v=_7B_HzJUE6E&t=36s
  public boolean book(int start, int end) {
    return solution1(start, end);
  }

  public boolean solution1(int start, int end) {
    Map.Entry<Integer, Integer> ceilingEntry = memoMap.ceilingEntry(start);
    Map.Entry<Integer, Integer> floorEntry = memoMap.floorEntry(start);

    if (floorEntry != null && floorEntry.getValue() > start) return false;
    if (ceilingEntry != null && ceilingEntry.getKey() > end) return false;
    memoMap.put(start, end);
    return true;
  }

}
