package palindrome;

public class Largest_Palindromic_Number_2384 {

  public static void main(String[] args) {
    System.err.println(largestPalindromic("97231404236749078329522372611037933"));
    System.err.println(largestPalindromic("444947137"));
    System.err.println(largestPalindromic("00009"));
    System.err.println(largestPalindromic("00001105"));
    System.err.println(largestPalindromic("0000"));



  }

  public static String largestPalindromic(String num) {
    StringBuilder front = new StringBuilder();
    StringBuilder back = new StringBuilder();
    StringBuilder singleMiddlePortion = new StringBuilder();
    int[] counts = new int[10];
    for (int i = 0; i < num.length(); i++) {
      counts[num.charAt(i) - '0']++;
    }

    for (int i = counts.length - 1; i > 0; i--) {
      int count = counts[i];
      if (count > 0) {
        if (count % 2 == 0) {
          // Even count
          for (int j = 0; j < (count / 2); j++) {
            front.append(i);
            back.insert(0, i);
          }
        } else {
          //Odd count
          if (count == 1) {
            if (singleMiddlePortion.length() == 0) {
              singleMiddlePortion.append(i);
            }
          } else {
            // count is odd like 3,5,7
            if (singleMiddlePortion.length() == 0) {
              singleMiddlePortion.append(i);
            }
            for (int j = 0; j < ((count) / 2); j++) {
              front.append(i);
              back.insert(0, i);
            }
          }
        }
      }
    }
    if (counts[0] > 0) {
      int count_0 = counts[0];
      if (front.length() > 0) {
        if (count_0 == 1 && singleMiddlePortion.length() == 0) {
          singleMiddlePortion.append(0);
        } else {
          if (count_0 % 2 == 0) {
            // Even count
            for (int j = 0; j < (count_0 / 2); j++) {
              front.append(0);
              back.insert(0, 0);
            }
          } else {
            // count is odd like 3,5,7
            if (singleMiddlePortion.length() == 0) {
              singleMiddlePortion.append(0);
            }
            for (int j = 0; j < ((count_0) / 2); j++) {
              front.append(0);
              back.insert(0, 0);
            }
          }
        }
      }else if(singleMiddlePortion.length()==0)
        singleMiddlePortion.append(0);
    }
    return front.toString() + singleMiddlePortion.toString() + back.toString();

  }
}
