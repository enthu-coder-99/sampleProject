public class First_Bad_Version_278 {

  public static void main(String[] args) {
    System.err.println(new First_Bad_Version_278().firstBadVersion(5));
  }


  public int firstBadVersion(int n) {
    if (n <= 1)
      return 1;
    int maxCorrectVersion = -1;
    int minBadVersion = Integer.MAX_VALUE;
    int left = 1;
    int right = n;
    while (right > left) {
      int mid = (left + right + 1) / 2;
      System.out.println("mid="+mid);
      boolean b = isBadVersion(mid);
      if (b) {
        minBadVersion = Math.min(minBadVersion, mid);
        right = mid;
      } else {
        maxCorrectVersion = Math.max(maxCorrectVersion, mid);
        left = mid;
      }
      if ((minBadVersion - maxCorrectVersion) <= 1) {
        return minBadVersion;
      }
    }

    return -1;
  }


  private static boolean isBadVersion(int n) {
    if (n >= 4)
      return true;
    return false;
  }
}
