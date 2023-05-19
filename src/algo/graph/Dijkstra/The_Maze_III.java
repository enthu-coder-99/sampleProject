package algo.graph.Dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class The_Maze_III {
  static String ans = null;

  public static void main(String[] args) {
    int[][] maze = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
    int[] ball = {4, 3};
    int[] hole = {0, 1};
    System.err.println(findShortestWay(maze, ball, hole));
  }

  public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
    return dijkstra(maze, ball, hole);
  }

  public static String dijkstra(int[][] maze, int[] start, int[] hole) {
    int row = maze.length;
    int col = maze[0].length;
    boolean[][] visited = new boolean[row][col];
    PriorityQueue<MazeCell> pq = new PriorityQueue<MazeCell>();
    pq.add(new MazeCell(start[0], start[1], "", 0));

    while (pq.size() > 0) {
      MazeCell mazeCell = pq.poll();
      int x = mazeCell.x;
      int y = mazeCell.y;
      System.err.println("x=" + x + ", y=" + y + ", dist=" + mazeCell.dist + ", direction=" + mazeCell.direction);
      if (visited[x][y]) continue;
      visited[x][y] = true;
      if (mazeCell.x == hole[0] && mazeCell.y == hole[1]) {
        return mazeCell.direction;
      }

      List<MazeCell> nextMoves = getNextMoves(maze, mazeCell, hole, row, col);
      if (ans != null) return ans;
      for (MazeCell nextMove : nextMoves) {
        pq.add(nextMove);
      }
    }
    return "impossible";
  }

  public static List<MazeCell> getNextMoves(int[][] maze, MazeCell mazeCell, int[] hole, int row, int col) {
    List<MazeCell> list = new ArrayList();
    int[][] directions = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    String[] dir_str = new String[]{"d", "l", "r", "u"};
    int i = mazeCell.x;
    int j = mazeCell.y;
    String directionStr = mazeCell.direction;
    int distanceFromStart = mazeCell.dist;
    for (int ind = 0; ind < directions.length; ind++) {
      int[] dir = directions[ind];
      int i1 = dir[0];
      int j1 = dir[1];
      int new_i = i;
      int new_j = j;
      while (isValid(new_i + i1, new_j + j1, row, col) && maze[new_i + i1][new_j + j1] == 0) {
        new_i = new_i + i1;
        new_j = new_j + j1;
        if (new_i == hole[0] && new_j == hole[1]) {
          list.add(new MazeCell(new_i,   new_j, directionStr + dir_str[ind], distanceFromStart + getDist(i, j, new_i, new_j)));
          System.err.println("hole = " + list.get(list.size() - 1));
          return list;
        }
      }
      if (new_i != i || new_j != j)
        list.add(new MazeCell(new_i, new_j, directionStr + dir_str[ind], distanceFromStart + getDist(i, j, new_i, new_j)));
    }
    return list;
  }

  public static int getDist(int i, int j, int new_i, int new_j) {
    return (Math.abs(i - new_i) + Math.abs(j - new_j));
  }

  public static boolean isValid(int i, int j, int row, int col) {
    if (i < 0 || j < 0 || i >= row || j >= col) return false;
    return true;
  }

  public static class MazeCell implements Comparable<MazeCell> {
    public int x;
    public int y;
    public String direction;
    public int dist;

    public MazeCell(int x, int y, String direction, int dist) {
      this.x = x;
      this.y = y;
      this.direction = direction;
      this.dist = dist;
    }

    @Override
    public int compareTo(MazeCell that) {
      // System.err.println("this.dist=" + dist + ", that.dist= " + that.dist + ", this.direction=" + direction + ", that.direction= " + that.direction);
      return dist != that.dist ? dist - that.dist : direction.compareTo(that.direction);
    }

    @Override
    public String toString() {
      return "MazeCell{" +
        "x=" + x +
        ", y=" + y +
        ", direction='" + direction + '\'' +
        ", dist=" + dist +
        '}';
    }
  }
}