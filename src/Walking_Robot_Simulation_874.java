import java.util.HashSet;
import java.util.Set;

public class Walking_Robot_Simulation_874 {
  private final static String NORTH = "N";
  private final static String EAST = "E";
  private final static String SOUTH = "S";
  private final static String WEST = "W";

  public static void main(String[] args) {
    int[][] obstacles = {{1, 11}, {2, 22}, {3, 44}, {5, 66}};
    for (int i = 0; i < obstacles.length; i++) {
      System.err.println(obstacles[i][0] + "_" + obstacles[i][1]);
    }
  }

  public int robotSim(int[] commands, int[][] obstacles) {
    int result = 0;
    String direction = NORTH;
    int x = 0;
    int y = 0;
    Set<String> obsSet = buildObstaclesSet(obstacles);
    for (int i = 0; i < commands.length; i++) {
      int command = commands[i];
      if (command < 0) {
        direction = getNextDirection(direction, command);
      } else {

        for (int j = 1; j <= command; j++) {
          int nextX = x;
          int nextY = y;
          switch (direction) {
            case NORTH:
              nextY = nextY + 1;
              break;
            case SOUTH:
              nextY = nextY - 1;
              break;
            case EAST:
              nextX = nextX + 1;
              break;
            case WEST:
              nextX = nextX - 1;
              break;
          }
          if (obsSet.contains(nextX + "_" + nextY)) {
            continue;
          }
          x = nextX;
          y = nextY;
          result = Math.max(result, ((x * x) + (y * y)));
        }
      }
    }
    return result;
  }

  public String getNextDirection(String currentDir, int turn) {
    switch (currentDir) {
      case NORTH:
        if (turn == -2) {
          return WEST;
        } else {
          return EAST;
        }
      case SOUTH:
        if (turn == -2) {
          return EAST;
        } else {
          return WEST;
        }
      case EAST:
        if (turn == -2) {
          return NORTH;
        } else {
          return SOUTH;
        }
      case WEST:
        if (turn == -2) {
          return SOUTH;
        } else {
          return NORTH;
        }
    }
    return null;
  }

  public Set<String> buildObstaclesSet(int[][] obstacles) {
    Set<String> obsSet = new HashSet<>();
    for (int i = 0; i < obstacles.length; i++) {
      obsSet.add(obstacles[i][0] + "_" + obstacles[i][1]);
    }
    return obsSet;
  }
}
