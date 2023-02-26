public class BitWiseOperators {

  public static void main(String[] args) {
    System.err.println("Hellow");
    System.err.println(reverseLeetCode(1534236469));
  }

  public static int reverseLeetCode(int x) {
    String intStr = Integer.toString(x);
    String reversedString = new StringBuilder(intStr).reverse().toString();
    if (reversedString.endsWith("-")) {
      reversedString = "-" + reversedString.substring(0, reversedString.length() - 1);
    }
    return Integer.parseInt(reversedString);
  }

  private static void xorDemo() {
    System.err.println('a');
    System.err.println('A');
    char c = '_';
    System.err.println((int) c);
    char var = 'K';
    char key = 'Z';
    System.err.println(var);
    System.err.println(key);

    System.err.println("Res1:" + (var ^ key));
    System.err.println("Res1:" + (var ^ key ^ key));

    System.err.println("Res2:" + (char) (var ^ key));
    System.err.println("Res2:" + (char) (var ^ key ^ key));

    System.err.println("Res3:" + (char) (var ^ key ^ key ^ key));
    System.err.println("Res4:" + (char) (var ^ key ^ key ^ key ^ key));

    int i = 10;
    int j = 20;
    System.err.println(i + ":" + j);
    i = i ^ j;
    j = i ^ j;
    i = i ^ j;
    System.err.println(i + ":" + j);
  }
}