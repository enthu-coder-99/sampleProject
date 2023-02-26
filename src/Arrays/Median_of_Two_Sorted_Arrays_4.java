package Arrays;

public class Median_of_Two_Sorted_Arrays_4 {
  public static void main(String[] args) {
    System.err.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    System.err.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // Let us have nums1 as having least number of element count/length.
    if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
    // nums1 will have less count of elements.
    int num1_len = nums1.length; //5
    int num2_len = nums2.length;//6
    int total_len = num1_len + num2_len;
    System.err.println("total length=" + total_len);
    int left = 0;
    int right = num1_len;
    while (right >= left) {
      int cut1 = left + (right - left) / 2;//it can be mid point also. //2
      int cut2 = (total_len / 2) - cut1; //3
      System.err.println("cut1=" + cut1 + " and cut2=" + cut2);
      int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
      int r1 = cut1 >= num1_len ? Integer.MAX_VALUE : nums1[cut1];

      int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
      int r2 = cut2 >= num2_len ? Integer.MAX_VALUE : nums2[cut2];

      if (r1 >= l2 && r2 >= l1) {
        // That means it is the exact point of partition to make divide into 2 after merging both arrays.
        System.err.println("cut1=" + cut1 + " l1=" + l1 + " and l2=" + l2 + " r1=" + r1 + " and r2=" + r2);
        double result = total_len % 2 == 0 ? (((Math.max(l1, l2) + Math.min(r1, r2))) / 2d) : Math.min(r1, r2);
        return result;
      } else if (l2 > r1) {
        left = cut1 + 1;
      } else if (l1 > r2) {
        right = cut1 - 1;
      }
    }
    return 0.0d;
  }
}
