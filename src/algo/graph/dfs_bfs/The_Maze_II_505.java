package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    int row = maze.length;
    int col = maze[0].length;
    int dest_r = destination[0];
    int dest_c = destination[1];
    int[][] stepsTakenFromStartingPointTOReachThisPoint = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        stepsTakenFromStartingPointTOReachThisPoint[i][j] = Integer.MAX_VALUE;
      }
    }
    stepsTakenFromStartingPointTOReachThisPoint[start[0]][start[1]] = 0;
    bfs(maze, new int[]{start[0], start[1], 0}, destination, stepsTakenFromStartingPointTOReachThisPoint);
    System.err.println(stepsTakenFromStartingPointTOReachThisPoint[dest_r][dest_c]);
    return stepsTakenFromStartingPointTOReachThisPoint[dest_r][dest_c] == Integer.MAX_VALUE ? -1 : stepsTakenFromStartingPointTOReachThisPoint[dest_r][dest_c];
  }


  public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
    int dest_r = destination[0];
    int dest_c = destination[1];

    int start_r = start[0];
    int start_c = start[1];
    if (dest_r == start_r && dest_c == start_c) return true;
    visited[start_r][start_r] = true;
    System.err.println("From = [" + start_r + " , " + start_c + "]");

    List<int[]> nextMoves = getNextMove(start_r, start_c, maze);
    for (int i = 0; i < nextMoves.size(); i++) {
      int[] nextMove = nextMoves.get(i);
      int nextMove_r = nextMove[0];
      int nextMove_c = nextMove[1];

      if (!visited[nextMove_r][nextMove_c]) {
        System.err.println("Next move = [" + nextMove_r + " , " + nextMove_c + "]");
        if (dfs(maze, new int[]{nextMove_r, nextMove_c}, destination, visited)) return true;
        visited[nextMove_r][nextMove_c] = true;
      }
    }
    return false;
  }

  public void bfs(int[][] maze, int[] start, int[] destination, int[][] stepsTakenFromStartingPointTOReachThisPoint) {
    int dest_r = destination[0];
    int dest_c = destination[1];

    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(start);
    while (deque.size() > 0) {
      int[] cell = deque.poll();
      int deq_r = cell[0];
      int deq_c = cell[1];
      System.out.println("deq_r=" + deq_r + " and deq_c=" + deq_c);
      int distanceTraveledFromStartToThisPoint = cell[2];
      if (distanceTraveledFromStartToThisPoint > stepsTakenFromStartingPointTOReachThisPoint[deq_r][deq_c]) continue;
      stepsTakenFromStartingPointTOReachThisPoint[deq_r][deq_c] = distanceTraveledFromStartToThisPoint;
      System.err.println("From = [" + deq_r + " , " + deq_c + "]");
      List<int[]> nextMoves = getNextMove(deq_r, deq_c, maze);
      for (int i = 0; i < nextMoves.size(); i++) {
        int[] nextMove = nextMoves.get(i);
        int nextMove_r = nextMove[0];
        int nextMove_c = nextMove[1];
        int next_distance = distanceTraveledFromStartToThisPoint + calcDistance(deq_r, deq_c, nextMove_r, nextMove_c);
        if (next_distance < stepsTakenFromStartingPointTOReachThisPoint[nextMove_r][nextMove_c])
          stepsTakenFromStartingPointTOReachThisPoint[nextMove_r][nextMove_c] = next_distance;
        stepsTakenFromStartingPointTOReachThisPoint[deq_r][deq_c] = distanceTraveledFromStartToThisPoint;

        System.err.println("Next move = [" + nextMove_r + " , " + nextMove_c + "]");
        deque.offer(new int[]{nextMove_r, nextMove_c, next_distance});
      }
    }
  }

  public int calcDistance(int r1, int c1, int r2, int c2) {
    return Math.abs(r1 - r2) + Math.abs(c1 - c2);
  }

  public List<int[]> getNextMove(int r1, int c1, int[][] maze) {
    int row = maze.length;
    int col = maze[0].length;
    List<int[]> nextMoveList = new ArrayList<>();
    int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    for (int[] move : moves) {
      int next_x = r1;
      int next_y = c1;
      int move_x = move[0];
      int move_y = move[1];

      while (true) {
        next_x = next_x + move_x;
        next_y = next_y + move_y;
        if (next_x < 0 || next_y < 0 || next_x >= row || next_y >= col) {
          if ((next_x - move_x) != r1 || (next_y - move_y) != c1)
            nextMoveList.add(new int[]{next_x - move_x, next_y - move_y});
          break;
        } else if (maze[next_x][next_y] == 1) {
          if ((next_x - move_x) != r1 || (next_y - move_y) != c1)
            nextMoveList.add(new int[]{next_x - move_x, next_y - move_y});
          break;
        }
      }
    }
    return nextMoveList;
  }
}
