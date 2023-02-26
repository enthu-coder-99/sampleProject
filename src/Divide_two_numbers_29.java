public class Divide_two_numbers_29 {

  public static void main(String[] args) {
    System.err.println(divide(-2147483648, -1));
  }

  public static int divide(int dividend, int divisor) {
    long dividendL = dividend;
    long divisorL = divisor;


    if (dividendL == divisorL) {
      return 1;
    }
    if (dividendL == divisorL * -1) {
      return -1;
    }
    if (Math.abs(divisorL) > Math.abs(dividendL))
      return 0;

    boolean dividendPositive = true;
    boolean divisorPositive = true;

    if (dividendL < 1) {
      dividendPositive = false;
      dividendL = dividendL * -1;
    }
    if (divisorL < 1) {
      divisorPositive = false;
      divisorL = divisorL * -1;
    }

    long answer = 1;
    long reminder = dividendL - divisorL;
    while (reminder >= divisorL) {
      reminder = reminder - divisorL;
      answer++;
    }

    if ((dividendPositive && divisorPositive) || (!dividendPositive && !divisorPositive))
      return (int) answer;
    return (int) answer * -1;
  }
}
