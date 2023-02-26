package heap_Or_PriorityQueue;

public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {

  public int kthSmallest(int[][] matrix, int k) {
    int l = matrix.length;
    int row = (k - 1) / l;
    int col = (k - 1) % l;


    for (int i = 0; i < l; ) {
      for (int j = 0; j < l; ) {
        int val = matrix[i][j];

      }
    }


    return matrix[row][col];
  }
  // 5X5 = 5th  --1,2
  //

}
