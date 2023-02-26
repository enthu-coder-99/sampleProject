public class Reverse_Integer_7 {

  public static void main(String[] args) {
    System.err.println(reverse(1534236469));
  }

  public static int reverse(int x) {
    if (x >= 0 && x < 10)
      return x;

    int input = x;
    if (x < 0)
      input = input * -1;
    long reverse = 0;
    while (input > 0) {

      int reminder = input % 10;
      if (reverse < 0) {
        reverse = reminder;
      } else {
        reverse = reverse * 10 + reminder;
      }
      input = input / 10;
      System.err.println("reverse=" + reverse);
    }
    System.err.println("Final = "+reverse);
    if (x < 0)
      reverse = reverse * (-1);
    if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
      return 0;

    return new Long(reverse).intValue();
  }
}
