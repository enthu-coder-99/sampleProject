package Strings;

import java.util.ArrayList;
import java.util.List;

public class Longest_Word_Dictionary_through_Deleting_524 {

  public static void main(String[] args) {
    System.err.println(findLongestWord("abpcplea", new ArrayList<>(List.of("apple", "ale", "monkey", "plea", "abple"))));
  }

  public static String findLongestWord(String s, List<String> dictionary) {
    String result = "";
    List[] counts_s = new ArrayList[26];
    for (int i = 0; i < s.length(); i++) {
      if (counts_s[s.charAt(i) - 'a'] == null) counts_s[s.charAt(i) - 'a'] = new ArrayList<Integer>();
      counts_s[s.charAt(i) - 'a'].add(i);
      System.out.println((char) s.charAt(i) + ":" + counts_s[s.charAt(i) - 'a']);
    }
    int[] counts_t = new int[26];
    for (int i = 0; i < dictionary.size(); i++) {
      String dict = dictionary.get(i);
      int sourceLastIndex = -1;
      for (int j = 0; j < dict.length(); j++) {
        int dist_char_index = (dict.charAt(j) - 'a');
        int last_index_Of_target_str = counts_t[dist_char_index];

        // counts_t[dist_char_index] = counts_t[dist_char_index] + 1;
        List<Integer> counts_s_index_List = counts_s[dist_char_index];
        if (counts_s_index_List == null || counts_s_index_List.size() <= last_index_Of_target_str) {
          System.err.println(dict + " is not a result candidate.");
          System.out.println(((char) dict.charAt(j)) + " ::: " + counts_t[dist_char_index] + " : " + counts_s[dist_char_index]);
          counts_t = new int[26];
          dict = null;
          break;
        } else {
          try{
            while (counts_s_index_List.get(last_index_Of_target_str) < sourceLastIndex) {
              last_index_Of_target_str++;
            }
          }catch (Exception e){
            counts_t = new int[26];
            dict = null;
            break;
          }

          if (last_index_Of_target_str == 0) {
            counts_t[dist_char_index] = 1;
            sourceLastIndex = counts_s_index_List.get(last_index_Of_target_str);
          }else{
            counts_t[dist_char_index] = last_index_Of_target_str;
            sourceLastIndex = counts_s_index_List.get(last_index_Of_target_str);
          }
        }
      }
      System.out.println("dict=" + dict);
      if (dict != null && dict.length() > result.length()) {
        result = dict;
      } else if (dict != null && dict.length() == result.length()) {
        for (int j = 0; j < dict.length(); j++) {
          if (result.charAt(j) > dict.charAt(j)) {
            result = dict;
            break;
          } else if (result.charAt(j) < dict.charAt(j)) {
            break;
          }
        }
      }
    }
    return result;
  }
}
