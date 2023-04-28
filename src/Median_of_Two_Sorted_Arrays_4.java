public class Median_of_Two_Sorted_Arrays_4 {

  public static void main(String[] args) {
    int[] nums1 = new int[]{7};
    int[] nums2 = new int[]{2, 3, 4, 6, 10};
    System.err.println(findMedianSortedArrays(nums1, nums2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    if (l1 == 0 && l2 == 0)
      return 0.0d;
    int total_l = l1 + l2;
    if (l1 == 0) {
      return (nums2[l2 / 2] + nums2[(l2 - 1) / 2]) / 2d;
    }
    if (l2 == 0) return findMedianSortedArrays(nums2, nums1);

    if (l2 > l1) return findMedianSortedArrays(nums2, nums1);  // l1  should be bigger length.

    int left = 0;
    int right = l1;
    System.err.println("l1= " + l1 + ", l2= " + l2);
    while (right >= left) {
      int cut1 = left + (right - left + 1) / 2;
      int cut2 = ((l1 + l2) / 2) - cut1;
      System.err.println("cut1= " + cut1 + " and cut2= " + cut2);
      int num11 = cut1 > 0 ? nums1[cut1 - 1] : Integer.MIN_VALUE;
      int num12 = cut1 < l1 ? nums1[cut1] : Integer.MAX_VALUE;
      int num21 = cut2 > 0 && cut2 <= (l2) ? nums2[cut2 - 1] : Integer.MIN_VALUE;
      int num22 = cut2 < (l2) && cut2 >= 0 ? nums2[cut2] : Integer.MAX_VALUE;

      System.err.println("num11= " + num11 + ", num12= " + num12 + ", num21= " + num21 + ", num22= " + num22);
      if (num12 >= num21 && num22 >= num11) {
        // it is a perfect cut and just return the result from this block.
        if (isEven(total_l)) {
          System.err.println("We find the perfect cut even.");
          return (Math.max(num11, num21) + Math.min(num12, num22)) / 2d;
        } else {
          System.err.println("We find the perfect cut Odd.");
          return Math.min(num12, num22);
        }
      } else if (num21 > num12) {
        left = cut1 + 1;
        System.err.println("changing left..");
      } else {
        right = cut1 - 1;
        System.err.println("changing right..");

      }
    }
    return -1;
  }

  public static boolean isEven(int num) {
    return num % 2 == 0;
  }
}
