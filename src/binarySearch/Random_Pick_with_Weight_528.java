package binarySearch;

import java.util.Random;

public class Random_Pick_with_Weight_528 {


  int[] w;
  int[] sum;

  public void Solution(int[] w) {
    this.w = w;
    int l = w.length;
    this.sum = new int[l];

    int totalSum = 0;
    for (int i = 0; i < l; i++) {
      int num = w[i];
      totalSum = totalSum + num;
      sum[i] = totalSum;
    }
  }

  Random rand = new Random();

  public int pickIndex() {

    int len = w.length;
    if (len == 1) return 0;
    int min = sum[0];
    int max = sum[len - 1];
    int nextRadomNum = rand.nextInt(1, max + 1);
    if (nextRadomNum <= min) return 0;
    if (nextRadomNum > sum[len - 2]) return (len - 1);
    int left = 0;
    int right = len - 1;
    while (right >= left) {
      int mid_i = left + (right - left) / 2;
      int mid_num = sum[mid_i];
      int left_num = sum[left];
      int right_num = sum[right];

      if (mid_i > 0) {
        int mid_prev_num = sum[mid_i - 1];
        if (nextRadomNum == mid_prev_num) {
          return (mid_i - 1);
        }
        if (nextRadomNum > mid_prev_num && nextRadomNum <= mid_num) return mid_i;
      }

      if (mid_i < len - 1) {
        int mid_next_num = sum[mid_i + 1];
        if (nextRadomNum == mid_next_num) {
          return (mid_i + 1);
        }
        if (nextRadomNum > mid_num && nextRadomNum <= mid_next_num) return (mid_i + 1);
      }

      if (mid_num > nextRadomNum) {
        right = mid_i - 1;

      } else {
        left = mid_i + 1;
      }
    }
    return 0;
  }
}
