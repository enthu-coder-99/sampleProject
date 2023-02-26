package palindrome;

import utils.CommonLogging;

import java.util.Arrays;

public class Palindrome_Number_9 {

  public static void main(String[] args) {
    System.err.println(isPalindrome(1534236469));
    System.err.println("Amazing=" + reverse(1534236469));
    System.err.println(((int)' '));

  }

  public static boolean isPalindrome(int x) {

    if (x < 0)
      return false;
    if (x < 10)
      return true;
    int input = x;
    int reverse = 0;
    while (input > 0) {
      System.err.println(input + " : " + reverse);
      int reminder = input % 10;
      reverse = reverse * 10 + reminder;
      input = input / 10;
      System.err.println("reverse=" + reverse);
      System.err.println("input=" + input);
      if (input <= 9) {
        reverse = reverse * 10 + input;
        break;
      }
    }
    System.err.println("reverse Final=" + reverse);
    return x == reverse;
  }

  public static int reverse(int x) {
    int result = 0;
    while (x != 0) {
      int tail = x % 10;
      int newResult = result * 10 + tail;
      if ((newResult - tail) / 10 != result) {
        return 0;
      }
      result = newResult;
      x = x / 10;
    }
    return result;
  }
}
