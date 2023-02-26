import java.util.HashSet;
import java.util.Set;

public class Naming_a_Company_2306 {

  public static void main(String[] args) {
    String[] ideas = {"coffee", "donuts", "time", "toffee"};//6
    ideas = new String[]{"coffee", "donuts", "time", "toffee"};//6

    System.err.println(ideas + " and result=" + distinctNames(ideas));

    ideas = new String[]{"lack", "back"};//0
    System.err.println(ideas + " and result=" + distinctNames(ideas));

    ideas = new String[]{"bzklqtbdr", "kaqvdlp", "r", "dk"};//12
    System.err.println(ideas + " and result=" + distinctNames(ideas));
  }

  public static long distinctNames(String[] ideas) {
    int l = ideas.length;
    long count = 0;
    Set<String>[] suffixArray = new Set[26];
    for (String idea : ideas) {
      char c = idea.charAt(0);
      String suffix = idea.substring(1);
      if (suffixArray[c - 'a'] == null) suffixArray[c - 'a'] = new HashSet<String>();
      suffixArray[c - 'a'].add(suffix);
    }
    for (int i = 0; i < 26; i++) {
      Set<String> suffixSet_is = suffixArray[i];
      if (suffixSet_is != null && suffixSet_is.size() > 0) {
        for (int j = i + 1; j < 26; j++) {
          Set<String> suffixSet_js = suffixArray[j];
          long validCount = getvalidaCombinationCount(i, suffixSet_is, j, suffixSet_js);
          count += validCount * 2;
        }
      }
    }
    return count;
  }

  private static long getvalidaCombinationCount(int i, Set<String> suffixSet_is, int j, Set<String> suffixSet_js) {
    char char_i = ((char) (i + 'a'));
    char char_j = ((char) (j + 'a'));

    if (suffixSet_is == null || suffixSet_js == null || suffixSet_is.size() == 0 || suffixSet_js.size() == 0) return 0;
    System.err.println(char_i + "- suffixSet_is=" + suffixSet_is);
    System.err.println(char_j + "- suffixSet_js=" + suffixSet_js);

    long validCombi = 0;
    int commonSuffixCount = 0;
    for (String suffix_j : suffixSet_js) {
      if (suffixSet_is.contains(suffix_j)) commonSuffixCount++;
    }
   /* for (String suffixSet_j : suffixSet_js) {
      for (String suffixSet_i : suffixSet_is) {
        if (suffixSet_js.contains(suffixSet_i) || suffixSet_is.contains(suffixSet_j)) continue;
        System.err.println(char_i + suffixSet_i + "_" + char_j + suffixSet_j);
        maxCombi++;
      }
    }*/
    validCombi = (suffixSet_is.size() - commonSuffixCount) * (suffixSet_js.size() - commonSuffixCount);
    return validCombi;
  }
}


/**
 * "coffee", "donuts", "time", "toffee" ,"ponuts" , "cat" //Expected = 18
 * <p>
 * <p>
 * l=5
 * <p>
 * "offer" - 'c','t' -- 4 - 1
 * "onuts" - 'd', 'p'
 * "ime" - "t
 * "at" - "c
 * <p>
 * 'c' - "offee", "at"
 * 'd' - "onuts
 * 't' - "offer", "ime"
 * 'p' - "onuts"
 */