package recusrion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maximum_Length_of_a_Concatenated_String_1239 {
  int ans = 0;

  public int maxLength(List<String> arr) {
    List<Set<Character>> charsArrayList = getSet(arr);
    int len = charsArrayList.size();
    recursion(0, new HashSet<>(), charsArrayList);
    return ans;
  }


  private void recursion(int startIndx, Set<Character> charsIncludedTillHere, List<Set<Character>> charsArrayList) {
    int len = charsArrayList.size();
    ans = Math.max(ans, charsIncludedTillHere.size());

    for (int i = startIndx; i < len; i++) {
      Set<Character> candidateChars = charsArrayList.get(i);
      if (canInclude(candidateChars, charsIncludedTillHere)) {
        charsIncludedTillHere.addAll(candidateChars);
        recursion(i + 1, charsIncludedTillHere, charsArrayList);
        charsIncludedTillHere.removeAll(candidateChars);
      }
    }
  }

  private boolean canInclude(Set<Character> candidateChars, Set<Character> charsIncludedTillHere) {

    for (char c : candidateChars) {
      if (charsIncludedTillHere.contains(c)) return false;
    }
    return true;
  }

  private List<Set<Character>> getSet(List<String> arr) {

    List<Set<Character>> strArrayList = new ArrayList();

    for (String str : arr) {
      int len = str.length();
      Set<Character> charsSet = new HashSet<>();
      boolean include = true;
      for (char c : str.toCharArray()) {
        if (charsSet.contains(c)) {
          include = false;
          break;
        }
        charsSet.add(c);
      }
      if (include) {
        strArrayList.add(charsSet);
      }
    }
    return strArrayList;
  }
}
