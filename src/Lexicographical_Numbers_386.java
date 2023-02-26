import java.util.ArrayList;
import java.util.List;

public class Lexicographical_Numbers_386 {

  public static void main(String[] args) {

    System.err.println(lexicalOrder(100));
  }

  public static List<Integer> lexicalOrder(int n) {
    List<Integer> resultList = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      dfs(i, n, resultList);
    }
    return resultList;
  }

  private static void dfs(int i, int n, List<Integer> resultList) {
    if (i > n)
      return;
    resultList.add(i);
    System.err.print(i + ",");
    for (int j = 0; j < 9; j++) {
      dfs(i * 10 + j, n, resultList);
    }
  }
}
