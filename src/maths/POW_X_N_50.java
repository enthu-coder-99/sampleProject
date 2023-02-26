package maths;

public class POW_X_N_50 {
  public static void main(String[] args) {
    System.err.println(myPow(2.00000, -2147483648));
  }

  public static double myPow(double x, long n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    if (x == 1) return x;
    if (x == -1) return isOdd(n) ? -1 : 1;
    if (n < 0) {
      System.out.println(" N is negative n=" + n);
      x = 1 / x;
      n = -n;
      System.err.println(" N again n =" + n);
    }
    return calculatePow(x, (long) n);
  }

  public static double calculatePow(double x, long n) {
    System.out.println("n= " + n + " and  x=" + x);

    if (n == 0) return 1.0;
    double tmp = calculatePow(x, n / 2);
    if (n % 2 == 1) {
      System.out.println(n + " and 1- tmp=" + tmp);
      return tmp * tmp * x;
    } else {
      System.out.println(n + " and 2- tmp=" + tmp);
      return tmp * tmp;
    }
  }

  public static boolean isOdd(long n) {
    return n % 2 == 1;
  }
}
