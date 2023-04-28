package heap_Or_PriorityQueue;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1322101/C%2B%2BJavaPython-MaxHeap-MinHeap-Binary-Search-Picture-Explain-Clean-and-Concise
public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {

  public static void main(String[] args) {
    System.out.println(10 / 3);
    System.out.println(10 % 3);

    int i = 20;
    int j = 6;
    System.out.println("i=" + i);
    System.out.println("j=" + j);

    System.out.println(i / j);
    System.out.println(i % j);

    int[][] matrix = new int[][]{
      {1, 5, 9},
      {10, 11, 13},
      {12, 13, 15}};
    //å System.err.println(kthSmallest(matrix, 6));
  }

  public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length;

    int left = matrix[0][0], right = matrix[m - 1][m - 1], ans = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (countLessOrEqual(matrix, mid) >= k) {
        ans = mid;
        right = mid - 1; // try to looking for a smaller value in the left side
      } else left = mid + 1; // try to looking for a bigger value in the right side
    }
    return ans;
  }

  int countLessOrEqual(int[][] matrix, int x) {
    int m = matrix.length;
    int cnt = 0, c = m - 1; // start with the rightmost column
    for (int r = 0; r < m; ++r) {
      while (c >= 0 && matrix[r][c] > x) --c;  // decrease column until matrix[r][c] <= x
      cnt += (c + 1);
    }
    return cnt;
  }

  public static int kthSmallest_priorityQueue(int[][] matrix, int k) {
    int l = matrix.length;
    if (k == 1) return matrix[0][0];
    if (k >= l * l) return matrix[l - 1][l - 1];

    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (o1, o2) -> o1[0] - o2[0]
    );
    // value, row, element_no/col

    for (int i = 0; i < l; i++) {
      pq.offer(new int[]{matrix[i][0], i, 0});// insert first column
    }

    for (int i = 0; i < k; i++) {
      int[] poll = pq.poll();
      int row_i = poll[1];
      int col_i = poll[2];
      if ((col_i + 1) >= l) continue;
      pq.offer(new int[]{matrix[row_i][col_i + 1], row_i, col_i + 1});// insert first column
    }
    return pq.peek()[0];
  }
  // 5X5 = 5th  --1,2
  //

}
