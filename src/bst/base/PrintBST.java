package bst.base;

public class PrintBST {

  static int PowerOf2(int power) {
    return (1 << power);
  }

  static void PrintTreeArray(Integer array[], int arrayLength) {
    int currentLevel = 0;
    int maxPerLevel = PowerOf2(currentLevel);
    for (int i = 0; i < arrayLength; i++) {
      if (i == maxPerLevel - 1) {
        System.out.println("\n");
        currentLevel++;
        maxPerLevel = PowerOf2(currentLevel);
      }
      System.out.print(" " + array[i]);
    }
  }

  public static void main(String[] args) {
    Integer[] array = new Integer[]{12795, 1982, null, 3798, null, 430, null, 5481, null, 15224, null, 12970, null, 18652, null, 5137, null, 13230, null, 8433, null, 19989, null, 6921};
    PrintTreeArray(array, 15);
  }
}
