package maths;

import java.util.LinkedList;

public class Dot_Product_of_Two_Sparse_Vectors_1570 {
}

class SparseVector {
  LinkedList<int[]> linkedList;

  SparseVector(int[] nums) {
    linkedList = new LinkedList();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        linkedList.add(new int[]{i, nums[i]});
      }
    }
  }

  // Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector vec) {
    LinkedList<int[]> linkedList2 = vec.linkedList;
    int l1 = linkedList.size();
    int l2 = linkedList2.size();
    int i2 = 0;
    int ans = 0;
    for (int i1 = 0; i1 < l1; ) {
      if (i2 >= l2 || i1 >= l1) break;
      int[] arry1 = linkedList.get(i1);
      int[] arry2 = linkedList2.get(i2);
      int arry1_index = arry1[0];
      int arry2_index = arry2[0];

      if (arry1_index == arry2_index) {
        i1++;
        i2++;
        ans = ans + arry1[1] * arry2[1];
      } else if (arry1_index > arry2_index) {
        i2++;
      } else {
        i1++;
      }
    }
    return ans;
  }
}
