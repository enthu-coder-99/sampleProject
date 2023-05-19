package algo.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class The_Maze_II_505 {

  public static void main(String[] args) {
    int[][] maze = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
    int[] start = new int[]{4, 3};
    int[] destination = new int[]{0, 1};
    maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
    start = new int[]{0, 4};
    destination = new int[]{4, 4};
    System.err.println(new The_Maze_II_505().shortestDistance(maze, start, destination));
  }

  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    int[][] dist = bfs(maze, start);
    return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
  }

  /**
   * dijkstra and working fine. It can be a typical Dijkstra problem.
   */
  public int dijkstra(int[][] maze, int[] start, int[] destination) {
    int row = maze.length;
    int col = maze[0].length;
    boolean[][] visited = new boolean[row][col];
    PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    }
    );

    pq.add(new int[]{0, start[0], start[1]});
    while (pq.size() > 0) {
      int[] cell = pq.poll();
      int distFromStart = cell[0];
      int x = cell[1];
      int y = cell[2];
      if (visited[x][y]) continue;
      visited[x][y] = true;
      if (x == destination[0] && y == destination[0]) return distFromStart;
      List<int[]> nextMoves = getNextMoves(maze, x, y, row, col, distFromStart);
      for (int[] nextMove : nextMoves) {
        int nextMove_dist = nextMove[2];
        int nextMove_x = nextMove[0];
        int nextMove_y = nextMove[1];
        pq.add(new int[]{nextMove_dist, nextMove_x, nextMove_y});
      }
    }

    return -1;
  }

  /**
   * BFS and workig fine.
   */
  public int[][] bfs(int[][] maze, int[] start) {
    int row = maze.length;
    int col = maze[0].length;
    int[][] dist = new int[row][col];
    for (int i = 0; i < row; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    dist[start[0]][start[1]] = 0;

    Deque<int[]> deque = new ArrayDeque();
    deque.offer(new int[]{start[0], start[1], 0});
    while (deque.size() > 0) {
      int[] cell = deque.poll();
      int x = cell[0];
      int y = cell[1];
      int distanceFromStart = cell[2];
      List<int[]> nextCellsList = getNextMoves(maze, x, y, row, col, distanceFromStart);
      System.out.println("x=" + x + ", y=" + y + ", nextCellsList=" + nextCellsList.size());

      for (int[] nextCell : nextCellsList) {
        int next_i = nextCell[0];
        int next_j = nextCell[1];
        int next_cell_dist_from_start = nextCell[2];
        if (dist[next_i][next_j] > next_cell_dist_from_start) {
          dist[next_i][next_j] = next_cell_dist_from_start;
          deque.add(new int[]{next_i, next_j, next_cell_dist_from_start});
        }
      }
    }
    return dist;
  }

  public List<int[]> getNextMoves(int[][] maze, int i, int j, int row, int col,
                                  int distanceFromStart) {
    List<int[]> list = new ArrayList();
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int[] dir : directions) {
      int i1 = dir[0];
      int j1 = dir[1];
      int new_i = i;
      int new_j = j;
      while (isValid(new_i + i1, new_j + j1, row, col) && maze[new_i + i1][new_j + j1] == 0) {
        new_i = new_i + i1;
        new_j = new_j + j1;
      }
      if (new_i != i || new_j != j)
        list.add(new int[]{new_i, new_j, distanceFromStart + getDist(i, j, new_i, new_j)});
    }
    return list;
  }

  public int getDist(int i, int j, int new_i, int new_j) {
    return (Math.abs(i - new_i) + Math.abs(j - new_j));
  }

  public boolean isValid(int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i >= row || j >= col) return false;
    return true;
  }


  public boolean dfs_working_fine(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
    int dest_r = destination[0];
    int dest_c = destination[1];

    int start_r = start[0];
    int start_c = start[1];
    if (dest_r == start_r && dest_c == start_c) return true;
    visited[start_r][start_r] = true;
    System.err.println("From = [" + start_r + " , " + start_c + "]");

    List<int[]> nextMoves = getNextMoves(maze, start_r, start_c, maze.length, maze[0].length, start[2]);
    for (int i = 0; i < nextMoves.size(); i++) {
      int[] nextMove = nextMoves.get(i);
      int nextMove_r = nextMove[0];
      int nextMove_c = nextMove[1];

      if (!visited[nextMove_r][nextMove_c]) {
        System.err.println("Next move = [" + nextMove_r + " , " + nextMove_c + "]");
        if (dfs_working_fine(maze, new int[]{nextMove_r, nextMove_c}, destination, visited)) return true;
        visited[nextMove_r][nextMove_c] = true;
      }
    }
    return false;
  }
}
