public class Robot_Bounded_In_Circle_1041 {
  final static String north = "N";
  final static String south = "S";
  final static String east = "E";
  final static String west = "W";

  public static void main(String[] args) {
    String s = "XYZ";
    char c = s.charAt(0);
    int i = c;
    System.err.println(c);
    System.err.println(i);

  }

  public boolean isRobotBounded(String instructions) throws IllegalAccessException {
    int x = 0, y = 0;
    String currentDir = north;

    for (int i = 0; i < instructions.length(); i++) {
      String instr = instructions.charAt(i) + "";
      if (instr.equals("L")) {
        currentDir = getNextDirection(currentDir, -90);
      } else if (instr.equals("R")) {
        currentDir = getNextDirection(currentDir, 90);
      } else {
        switch (currentDir) {
          case north:
            x++;
            break;
          case east:
            y++;
            break;
          case south:
            x--;
            break;
          case west:
            y--;
            break;
        }
      }
    }
    return (!currentDir.equals(north) || (x == 0 & y == 0));
  }

  String getNextDirection(String currentDir, int turnDegree) throws IllegalAccessException {
    switch (currentDir) {
      case north:
        if (turnDegree == 90) {
          return east;
        } else {
          return west;
        }
      case east:
        if (turnDegree == 90) {
          return south;
        } else {
          return north;
        }
      case south:
        if (turnDegree == 90) {
          return west;
        } else {
          return east;
        }
      case west:
        if (turnDegree == 90) {
          return north;
        } else {
          return south;
        }
      default:
        throw new IllegalAccessException("Illegal diection to go thru.");
    }
  }
}
