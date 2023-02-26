public class Greatest_English_Letter_In_Upper_And_Lower_Case_2309 {

  public static void main(String[] args) {
    System.err.println(greatestLetter("lEeTcOdE"));
  }

  public static String greatestLetter(String s) {
    int[] nums = new int[53];

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ((c >= 'a') && (c <= 'z')) {
        nums[c - 'a']++;
      } else if (c >= 'A' && c <= 'Z') {
        nums[c - 'A' + 26]++;
      }
    }

    for (int i = 26; i >= 0; i--) {
      if (nums[i] > 0 && nums[i + 26] > 0)
        return Character.toString(i + 'A' );
    }
    return "";
  }
}
