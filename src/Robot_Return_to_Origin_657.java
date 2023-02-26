public class Robot_Return_to_Origin_657 {

  public static void main(String[] args) {

  }

  public static boolean judgeCircle(String moves) {
    if (moves.length() == 0)
      return true;
    if (moves.length() % 2 == 1)
      return false;

    char[] movesChars = moves.toCharArray();
    int horizontalMove = 0;
    int verticalMove = 0;
    for (int i = 0; i < movesChars.length; i++) {
      switch (movesChars[i]) {
        case 'R':
          horizontalMove++;
        case 'L':
          horizontalMove--;
        case 'U':
          verticalMove++;
        case 'D':
          verticalMove--;
      }
    }
    return (horizontalMove == 0 && verticalMove == 0);
  }
}
