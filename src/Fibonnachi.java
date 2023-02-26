public class Fibonnachi {

  public static void main(String[] args) {
    System.err.println(printFibonnachi(33));
  }

  static int printFibonnachi(int totalNumbers) {
    if (totalNumbers <= 2)
      return 1;


    return printFibonnachi(totalNumbers - 1) + printFibonnachi(totalNumbers - 2);
    //System.err.println(Integer.MAX_VALUE);

  }
}
