package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class The_Maze_490 {

  public static void main(String[] args) {
    int[][] maze = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
    int[] start = new int[]{4, 3};
    int[] destination = new int[]{0, 1};
    maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
    start = new int[]{0, 4};
    destination = new int[]{4, 4};
    System.err.println(new The_Maze_490().hasPath(maze, start, destination));
  }

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int row = maze.length;
    int col = maze[0].length;
    return bfs(maze, start, destination, new boolean[row][col]);
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

  public boolean bfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
    int dest_r = destination[0];
    int dest_c = destination[1];

    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(start);
    while (deque.size() > 0) {
      int[] cell = deque.poll();
      int r1 = cell[0];
      int c1 = cell[1];
      if (dest_r == r1 && dest_c == c1) return true;
      visited[r1][c1] = true;
      System.err.println("From = [" + r1 + " , " + c1 + "]");

      List<int[]> nextMoves = getNextMove(r1, c1, maze);
      for (int i = 0; i < nextMoves.size(); i++) {
        int[] nextMove = nextMoves.get(i);
        int nextMove_r = nextMove[0];
        int nextMove_c = nextMove[1];

        if (!visited[nextMove_r][nextMove_c]) {
          System.err.println("Next move = [" + nextMove_r + " , " + nextMove_c + "]");
          deque.offer(new int[]{nextMove_r, nextMove_c});
          visited[nextMove_r][nextMove_c] = true;
        }
      }

    }
    return false;
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
