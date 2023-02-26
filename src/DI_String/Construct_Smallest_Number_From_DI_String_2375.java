package DI_String;

public class Construct_Smallest_Number_From_DI_String_2375 {

  public static void main(String[] args) {
    System.err.println(smallestNumber("IIIDIDDD"));
  }

  public static String smallestNumber(String pattern) {
    StringBuilder result = new StringBuilder();

    int low = 1;
    int high = pattern.length() + 1;

    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (c == 'D') {
        result.append(high++);
      } else {
        result.append(low++);
      }
    }
    return result.toString();
  }
}
