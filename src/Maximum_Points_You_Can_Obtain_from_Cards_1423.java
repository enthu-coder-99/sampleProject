import java.util.Arrays;

public class Maximum_Points_You_Can_Obtain_from_Cards_1423 {

  public static void main(String[] args) {
    System.err.println(maxScore(new int[]{11, 49, 100, 20, 86, 29, 72}, 4));
  }

  public static int maxScore(int[] cardPoints, int k) {
    if (cardPoints == null || k <= 0 || k > cardPoints.length) return 0;

    if (k == cardPoints.length)
      return Arrays.stream(cardPoints).sum();

    int max = 0;
    int l_start = cardPoints.length - k;
    int l_end = cardPoints.length - 1;
    int r_start = 0;
    int r_end = k - 1;
    int rightSum = 0;
    int leftSum = 0;

    for (int i = l_start; i <= l_end; i++)
      rightSum += cardPoints[i];
    max = rightSum;
    for (int i = r_start; i <= r_end; i++) {
      rightSum -= cardPoints[l_start++];
      leftSum += cardPoints[i];
      int newMaxCandidate = rightSum + leftSum;
      max = Math.max(max, newMaxCandidate);
    }
    return max;
  }
}
