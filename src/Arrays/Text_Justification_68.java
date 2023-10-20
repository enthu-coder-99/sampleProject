package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Text_Justification_68 {

  public static void main(String[] args) {
    Text_Justification_68 obj = new Text_Justification_68();
    String[] words = new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."};
    List<String> ans = obj.fullJustify(words, 6);
    System.out.println(ans);
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int l = words.length;
    int startWordInsertion = 0;
    int lengthLeft = maxWidth;
    int wordLengths = 0;
    int i = 0;
    while (i < l) {
      String word = words[i];
      int word_l = word.length();
      int lengthNeeded = wordLengths == 0 ? word_l : word_l + 1;// To Accommodate the space.
      if (lengthNeeded <= lengthLeft) {
        //We can include this word
        wordLengths = wordLengths + word_l;
        lengthLeft = lengthLeft - lengthNeeded;
        i++;
      } else {
        //We can NOT include this word. So adjust the words
        String ansStr = getAnsStr(words, startWordInsertion, i - 1, wordLengths, maxWidth);
        result.add(ansStr);
        startWordInsertion = i;
        lengthLeft = maxWidth;
        wordLengths = 0;
      }
    }

    String ansStr = getAnsStr(words, startWordInsertion, l - 1, wordLengths, maxWidth);
    if (!ansStr.isBlank()) result.add(ansStr);
    return result;
  }

  private String getAnsStr(String[] words, int left, int right, int wordsLength, int maxWidth) {
    int extraSpace = maxWidth - wordsLength;
    int l = words.length;
    int wordSize = right - left + 1;// right is including

    if (wordSize == 0) return "";

    if (right >= l - 1) {
      StringBuffer resultStr = new StringBuffer(words[left]);
      for (int i = left; i < right; i++) {
        resultStr.append(words[i]);
        if (extraSpace > 0) {
          resultStr.append(" ");
          extraSpace--;
        }
      }

      while (extraSpace > 0) {
        resultStr.append(" ");
        extraSpace--;
      }
      return resultStr.toString();
    }

    if (wordSize == 1) {
      StringBuffer resultStr = new StringBuffer(words[left]);
      for (int i = 0; i < extraSpace; i++) {
        resultStr.append(" ");
      }
      return resultStr.toString();
    }

    List<StringBuilder> list = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      list.add(new StringBuilder(words[i]));
    }

    int word_i = 0;
    for (int i = 1; i <= extraSpace; i++) {
      if (word_i >= list.size() - 1)
        word_i = 0;
      list.get(word_i).append(" ");
      word_i++;
    }
    StringBuffer resultStr = new StringBuffer();
    list.forEach(e -> resultStr.append(e));
    return resultStr.toString();

  }

}
