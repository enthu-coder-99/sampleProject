package utils;

public class Rough {

  public static void main(String[] args) {
    System.err.println(solution(5, 105, 3));
  }

  public static int solution(int X, int Y, int D) {
    // write your code in Java SE 8

    int jump = 0;
    int distance = Y - X;
    if (distance != 0) {
      int fullJump = distance / D;
      int remainder = distance % D;
      if (remainder == 0)
        return fullJump;
      return fullJump + 1;

    }

    return jump;

  }
}
