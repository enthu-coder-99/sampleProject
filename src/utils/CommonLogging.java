package utils;

import java.util.List;
import java.util.Map;

public class CommonLogging {

  public static int solution(int N) {
    // write your code in Java SE 8\
    int result = 0;
    String binaryStr = Integer.toBinaryString(N);
    System.out.println("binaryStr=" + binaryStr);
    char[] bChars = binaryStr.toCharArray();
    int lastBinary1 = -1;
    for (int i = 0; i < bChars.length; i++) {
      int bChar = bChars[i];
      if (bChar == '1') {
        if (lastBinary1 == -1) {
          // First time we find a binary 1
          lastBinary1 = i;
        } else {
          int newBGap = i - lastBinary1 - 1;
          if (newBGap > result) {
            result = newBGap;
          }
          lastBinary1 = i;
        }
      }
    }
    System.out.println("result=" + result);

    return result;
  }

  public static int[] printArray(String msg, int[] ints) {
    System.err.print(msg + "= ");
    for (int i = 0; i < ints.length; i++) {
      System.err.print(ints[i] + ",");
    }
    System.err.println("\n");
    return ints;
  }

  public static void printArray(int[] ints) {
    printArray("", ints);
  }

  public static void printArray(boolean[] bs) {
    for (boolean b : bs)
      System.err.print(b + ",");
    System.err.println("");
  }


  public static void printArray(String msg, String[] strs) {
    System.err.println("------" + msg + "----------");
    for (int i = 0; i < strs.length; i++) {
      System.err.print(strs[i] + ",");
    }
    System.err.println("----------------");
  }

  public static void printArray(String[] strs) {
    printArray("", strs);
  }

  public static void printArray(int[][] ints) {
    System.err.println("-----Print started-----");
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[0].length; j++) {
        System.err.println("[" + i + "," + j + "]=" + ints[i][j]);
      }
    }
    System.err.println("----Print Ended-----");
  }

  public static void printArray(String msg, boolean[] booleans) {
    System.err.println("------" + msg + "----------");
    for (int i = 0; i < booleans.length; i++) {
      System.err.print(booleans[i] + ",");
    }
    System.err.println("----------------");
  }

  public static void printMap(Map map) {
    System.err.println(map);
  }

  public static String printList(List list) {
    StringBuffer sb = new StringBuffer();
    for (Object o : list) {
      sb.append(o + ", ");
    }
    System.err.println(sb);
    return sb.toString();
  }

  public static String printList(String msg, List list) {
    StringBuffer sb = new StringBuffer(msg);
    for (Object o : list) {
      sb.append(o + ", ");
    }
    System.err.println(sb);
    return sb.toString();
  }

  public static void print(int[][] ints) {
    System.err.println("row=" + ints.length + " and col=" + ints[0].length);
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[0].length; j++) {
        System.err.println("[" + i + "," + j + "]=" + ints[i][j]);
      }
    }
  }

  public static String replaceArrayBracketStr(String arrayStrWithBracket) {
    String res = arrayStrWithBracket.replaceAll("\\[", "{").replaceAll("]", "}").replaceAll("},", "},");
    System.err.println(res);
    res = res.replaceAll("},", "},\n");
    return res;
  }

  public static void main(String[] args) {
    String input =
      "";
    String res = replaceArrayBracketStr(input);
    System.err.println(res);
  }

  public static void printListOfList(List<List<Integer>> lists) {
    lists.stream().forEach(list -> printList(list));
  }

}
