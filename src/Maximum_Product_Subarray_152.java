import java.util.Arrays;

public class Maximum_Product_Subarray_152 {

  public static void main(String[] args) {
    // System.err.println(maxProduct(new int[]{-2, 1}));
    //System.err.println(maxProduct(new int[]{-2, -2}));
    //System.err.println(maxProduct(new int[]{-2, 1, 9, 0, -4, 6, -9}));
    System.err.println(new Maximum_Product_Subarray_152().maxProduct(new int[]{2, 3, -2, 4, 3, 2, 0, 434}) + "\n");
    // System.err.println(new Maximum_Product_Subarray_152().maxProduct_1(new int[]{2, 3, -2, 4, -5, -6}) + "\n");
    //System.err.println(Arrays.toString(new int[]{2, 3, -2, 4, 3, 2,  434}));

  }


  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];

    int maxProduct = nums[0];
    int minProductTillThisIndex = nums[0];
    int maxProductTillThisIndex = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int currentNum = nums[i];

      int minMultipleByCurrentNum = minProductTillThisIndex * currentNum;
      int maxMultipleByCurrentNum = maxProductTillThisIndex * currentNum;

      minProductTillThisIndex = Math.min(currentNum, Math.min(minMultipleByCurrentNum, maxMultipleByCurrentNum));
      maxProductTillThisIndex = Math.max(currentNum, Math.max(minMultipleByCurrentNum, maxMultipleByCurrentNum));
      maxProduct = Math.max(maxProduct, maxProductTillThisIndex);
      System.err.println(minProductTillThisIndex + ":" + maxProductTillThisIndex + ":" + maxProduct);

    }
    return maxProduct;
  }

  public int maxProduct_1(int[] A) {
    if (A.length == 0) {
      return 0;
    }

    int maxherepre = A[0];
    int minherepre = A[0];
    int maxsofar = A[0];

    for (int i = 1; i < A.length; i++) {

      int maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
      int minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
      maxsofar = Math.max(maxhere, maxsofar);
      maxherepre = maxhere;
      minherepre = minhere;
      System.err.println(minhere + ":" + maxhere + ":" + minherepre + " : " + minherepre + "::" + maxsofar);

    }
    return maxsofar;
  }

  int maxProduct_swap(int A[]) {
    // store the result that is the max we have found so far
    int r = A[0];

    // imax/imin stores the max/min product of
    // subarray that ends with the current number A[i]
    for (int i = 1, imax = r, imin = r; i < A.length; i++) {
      // multiplied by a negative makes big number smaller, small number bigger
      // so we redefine the extremums by swapping them
      System.err.println(imin + ":" + imax + ":" + r);

      if (A[i] < 0) {
        int tmp = imin;
        imin = imax;
        imax = tmp;
      }

      // max/min product for the current number is either the current number itself
      // or the max/min by the previous number times the current one
      imax = Math.max(A[i], imax * A[i]);
      imin = Math.min(A[i], imin * A[i]);

      // the newly computed max value is a candidate for our global result
      r = Math.max(r, imax);

    }
    return r;
  }
}
