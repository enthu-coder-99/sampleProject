package codelity.sample;

public class MaxNonoverlappingSegments {

  public static void main(String[] args) {
    int A[] = {0, 2, 100};
    int B[] = {0, 50, 1000};
    System.err.println(solution(A, B));


  }

  public static int solution(int[] A, int[] B) {
    int length = A.length;
    if (length <= 1) {
      return length;
    }
    int count = 0;
    int previousEnd = 0;
    for (int i = 1; i < length; i++) {
      System.err.println(i + "= " + A[i] + " : " + B[i - 1]);
      if (A[i] > previousEnd) {
        // Not overlapping
        count++;
        previousEnd = B[i];
      }
    }
    return ++count;
  }
}
