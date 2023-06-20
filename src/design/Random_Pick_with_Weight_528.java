package design;

import java.util.Arrays;

public class Random_Pick_with_Weight_528 {

  int i = 0;
  int count = 0;
  int[] ws;

  public static void main(String[] args) {
    Random_Pick_with_Weight_528 obj = new Random_Pick_with_Weight_528(new int[]{1, 2, 3});
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());


  }

  public Random_Pick_with_Weight_528(int[] _ws) {
    int l = _ws.length;
    ws = new int[l];
    ws[0] = _ws[0];
    for (int j = 1; j < l; j++) {
      int w = _ws[j];
      ws[j] = ws[j - 1] + w;
    }
    System.err.println(Arrays.toString(ws));
  }

  public int pickIndex() {
    int l = ws.length;
    if (count >= ws[i]) {
      i++;
      if (i >= l) {
        i = 0;
        count = 0;
      }
    }
    count++;
    return i;
  }


}
