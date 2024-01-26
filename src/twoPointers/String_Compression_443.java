package twoPointers;

public class String_Compression_443 {


  public int compress(char[] chars) {
    int l = chars.length;
    int writeAtIndex = 0;
    for (int i = 0; i < l; i++) {
      char c_i = chars[i];
      chars[writeAtIndex++] = c_i;

      System.out.println(i + "- " + c_i);
      int j = i + 1;

      for (; j <= l; j++) {
        if (j == l) break;
        char c_j = chars[j];
        if (c_i != c_j) {
          break;
        }
        i++;
      }

      int count = j - i;
      if (count > 1) {
        char[] count_chars = String.valueOf(count).toCharArray();
        for (int k = 0; k< count_chars.length; k++) {
          chars[writeAtIndex++] = count_chars[k];
        }
      }
      System.out.println(j + "- writeAtIndex = " + writeAtIndex);

    }
    System.out.println("Final writeAtIndex = " + writeAtIndex);
    return writeAtIndex;
  }
}
