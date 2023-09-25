package algo.graph.dfs_bfs;

import utils.CommonLogging;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Swim_in_Rising_Water_778 {

  public static void main(String[] args) {

    int i = 11;
    do {
      System.out.println(i);
    }
    while (i < 10);
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Day number of the week- ");
    int dayOfTheWeek = scanner.nextInt();
    switch (dayOfTheWeek) {
      case 1:
        System.out.println("Monday.");
        break;
      case 2:
        System.out.println("Tuesday");
        break;
      case 3:
        System.out.println("Wed");
        break;

      case 4:
        System.out.println("Thur");
        break;

      case 5:
        System.out.println("Fri");
        break;

      case 6:
        System.out.println("Sat");
        break;

      case 7:
        System.out.println("Sun");
        break;

      default:
        System.out.println("Invalid.");
    }
  }

  public int swimInWater(int[][] grid) {
    int n = grid.length;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1},};
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int ans = 0;
    pq.add(new int[]{grid[0][0], 0, 0});
    while (pq.size() > 0) {
      int[] cell_details = pq.poll();
      int cell_value = cell_details[0];
      int x = cell_details[1];
      int y = cell_details[2];
      ans = Math.max(ans, cell_value);
      if (x == n - 1 && y == n - 1) return ans;
      for (int[] dir : dirs) {
        int new_x = x + dir[0];
        int new_y = y + dir[1];
        if (CommonLogging.isValidIndex(new_x, new_y, n, n)) {
          pq.add(new int[]{grid[new_x][new_y], new_x, new_y});
        }
      }
    }
    return ans;
  }

}
