package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicateLetters_316 {

  public static void main(String[] args) {
    String s = "acacb";
    String ans = removeDuplicateLetters(s);
    System.out.println("'" + s + "' -  Ans=" + ans);
  }

  public static String removeDuplicateLetters(String s) {
    char[] chars = s.toCharArray();
    Map<Character, Integer> map = new HashMap();
    int l = chars.length;
    for (int i = 0; i < l; i++) {
      Character c = chars[i];
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    System.out.println("map= " + map);
    Deque<Character> list = new LinkedList();
    Set<Character> visited = new HashSet<>();
    for (int i = 0; i < l; i++) {
      char c = chars[i];
      if (visited.contains(c)) {
        map.put(c, map.get(c) - 1);
        continue;
      }
      System.out.println(i + "- " + " c= " + c + " list=" + list + " , map=" + map);
      while (list.size() > 0 && list.getLast() > c && map.get(list.getLast()) > 0) {
        Character popped = list.removeLast();
        visited.remove(popped);
      }
      list.add(c);
      visited.add(c);
      map.put(c, map.get(c) - 1);

    }

    StringBuilder sb = new StringBuilder();
    while (list.size() > 0) {
      sb.append(list.pop());
    }
    return sb.toString();
  }
}
