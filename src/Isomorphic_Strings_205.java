import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings_205 {

  public static void main(String[] args) {
    System.err.println(Character.toChars(99));
    //System.err.println(isIsomorphic("egg", "add"));
    //System.err.println(isIsomorphic("foo", "bar"));
    Map<String, Integer> map = new HashMap();
    System.err.println(map.put("A", 1));
    System.err.println(map.put("B", 2));
    System.err.println(map.put("C", 3));
    System.err.println(map.put("A", null));

    System.err.println(map.put("A", 4));
    System.err.println(map.put("C", 5));

    System.err.println(isIsomorphic("badc", "baba"));

  }

  public static boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length())
      return false;
    Map<Character, Character> s2t = new HashMap<>();
    Map<Character, Character> t2s = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char s1 = s.charAt(i);
      char t1 = t.charAt(i);
      if (s2t.containsKey(s1) && !s2t.get(s1).equals(t1)) {
        return false;
      }
      s2t.put(s1, t1);
    }
    return true && isIsomorphic(t,s);
  }

  public static boolean isIsomorphic_sol1(String s, String t) {
    if (s.length() != t.length())
      return false;
    Map<Character, Character> s2t = new HashMap<>();
    Map<Character, Character> t2s = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char s1 = s.charAt(i);
      char t1 = t.charAt(i);
      if (s2t.containsKey(s1) && t1 != s2t.get(s1))
        return false;
      s2t.put(s1, t1);

      if (t2s.containsKey(t1) && s1 != t2s.get(t1))
        return false;
      t2s.put(t1, s1);
    }
    return true;
  }
}
