package Arrays;

public class Merge_Sorted_Array_88 {

  public static void main(String[] args) {

  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0)
      return;
    int lastCurrentIndex = m + n - 1;
    m--;
    n--;
    while (n >= 0) {
      if (m >= 0 && nums1[m] > nums2[n]) {
        nums1[lastCurrentIndex--] = nums1[m--];
      } else {
        nums1[lastCurrentIndex--] = nums2[n--];
      }
    }
  }
}
