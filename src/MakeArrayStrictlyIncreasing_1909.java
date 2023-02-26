public class MakeArrayStrictlyIncreasing_1909 {
  public static void main(String[] args) {
    System.err.println(canBeIncreasing(new int[]{1, 2, 1, 2}));
  }

  public static boolean canBeIncreasing(int[] sequence) {
    boolean numberSkipped = false;

    for (int i = 0; i < sequence.length - 1; i++) {
      int currentElm = sequence[i];
      int nextElm = sequence[i + 1];
      //int nextToNextElm = sequence[i+2];
      if (nextElm > currentElm) {
        continue;
      } else if (!numberSkipped) {

        numberSkipped = true;
        if (i - 1 >= 0) {
          // if previous exists
          int previousElm = sequence[i - 1];
          if (nextElm > previousElm) {
            continue;
          } else {
            sequence[i + 1] = currentElm;
          }
        }
      } else if (numberSkipped) {
        return false;
      }
    }
    return true;
  }
}
