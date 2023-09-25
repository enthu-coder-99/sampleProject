package lcs;

import java.util.Arrays;
import java.util.Comparator;

public class Longest_String_Chain_1048 {

  public static void main(String[] args) {

    int[] values = new int[5];
    int arry_val = 700;
    for (int i = 0; i < values.length; i++) {
      values[i] = arry_val++;
    }

    for (int value_of_array_element : values) {
      System.out.println("value_of_array_element is = " + value_of_array_element);
    }

    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i]);
    }



   /* int[] intArray;
    intArray = new int[11];
    System.out.println("length of array for shikha is= " + intArray.length);
    int array_length = intArray.length;
    int value = 200;

    for (int i = 0; i < array_length; i++) {
      System.out.println(intArray[i]);
    }

    for (int i = 0; i < array_length; i++) {
      intArray[i] = value++;
    }

    System.out.println(intArray[11]);*/
  }

  public int longestStrChain(String[] words) {
    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.length() - o2.length();
      }
    });

    int l = words.length;
    int[] dp = new int[l];
    int ans = 0;
    for (int i = 0; i < l; i++) {
      dp[i] = 1;
      char[] word_i = words[i].toCharArray();
      int len_i = word_i.length;
      for (int j = i - 1; j >= 0; j--) {
        String word_j = words[j];
        int len_j = word_j.length();
        if (len_i == len_j) continue;
        if (len_i - len_j > 1) break;
        if (considerThisWord(word_i, word_j.toCharArray())) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      ans = Math.max(ans, dp[i]);
    }

    return ans;
  }

  public boolean considerThisWord(char[] word_i, char[] word_j) {//word_i length is word_j+1
    int diff = 0;
    int i = 0;
    int j = 0;
    int min_len = word_j.length;
    for (int k = 0; k < min_len; k++) {
      i++;
      if (word_i[i] == word_j[j]) {
        j++;
      } else {
        diff++;
      }
      if (diff > 1) return false;
    }
    return diff <= 1;
  }
}
