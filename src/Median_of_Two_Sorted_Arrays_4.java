public class Median_of_Two_Sorted_Arrays_4 {

  public static void main(String[] args) {

  }

  private Median_of_Two_Sorted_Arrays_4(){}

  public static void findMedianSortedArrays(int[] nums1, int[] nums2) {

    int length1 = nums1.length;//6
    int length2 = nums2.length;//5
    int totalLength = length1 + length2;//11
    int left2StartIndex = 0;
    int left2EndIndex = length2 - 1;//4
    int realmidinmergedarray = (length1 + length2 + 1) / 2;


    while (left2EndIndex > left2StartIndex) {
      int leftPart2EndIndex = (left2StartIndex + left2EndIndex) / 2;//2
      int rightPart1StartIndex = realmidinmergedarray - leftPart2EndIndex;//

      int aLeft = nums2[leftPart2EndIndex];
      int aRight = nums2[leftPart2EndIndex + 1];
      int bLeft = nums1[rightPart1StartIndex];
      int bRight = nums1[rightPart1StartIndex + 1];
      if (bRight >= aLeft && aRight >= bLeft) {


      } else if (bRight < aLeft) {

      } else if (bLeft > aRight) {

      }
    }

    int medianIndex1 = -1;
    int medianIndex2 = -1;
    if (totalLength % 2 == 1) {
      //Total Odd length array
      medianIndex1 = (totalLength / 2) + 1;
    } else {
      medianIndex1 = totalLength / 2;
      medianIndex2 = medianIndex1 + 1;
    }


  }
}
