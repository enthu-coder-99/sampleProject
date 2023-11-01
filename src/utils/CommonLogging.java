package utils;

import listNodes.ListNode;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CommonLogging {

  int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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
    System.out.println("------" + msg + "----------");
    for (int i = 0; i < strs.length; i++) {
      System.out.print(strs[i] + ",");
    }
    System.out.println("----------------");
  }

  public static void printArray(String[] strs) {
    printArray("", strs);
  }

  public static String printArray(int[][] ints) {
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[0].length; j++) {
        System.out.print(ints[i][j] + ", ");
      }
      System.out.println();
    }
    return "";
  }

  public static void printArray(char[][] chars) {
    System.out.println("-----Print started-----");
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[0].length; j++) {
        System.out.print(chars[i][j] + ", ");
      }
      System.out.println("");

    }
    System.out.println("----Print Ended-----");
  }


  public static void printArray(String msg, boolean[] booleans) {
    System.out.println("------" + msg + "----------");
    for (int i = 0; i < booleans.length; i++) {
      System.out.print(booleans[i] + ",");
    }
    System.out.println("----------------");
  }

  public static void printMap(Map map) {
    System.err.println(map);
  }

  public static String printList(List list) {
    StringBuffer sb = new StringBuffer();
    for (Object obj : list) {
      sb.append(obj + ", ");
    }
    System.out.println(sb);
    return sb.toString();
  }

  public static String printListOfIntArray(String str, List<int[]> list) {
    System.out.println("" + str);
    StringBuffer sb = new StringBuffer();
    for (int[] arry : list) {
      for (int i = 0; i < arry.length; i++) {
        sb.append(arry[i] + ", ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
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
    System.err.println("----------------------------------- row=" + ints.length + " and col=" + ints[0].length + " -----");
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[0].length; j++) {
        System.err.print("dp[" + i + "," + j + "]=" + ints[i][j] + ", ");
      }
      System.err.println("");
    }
    System.err.println("------------------------------------------------------------------------------");
  }

  public static String replaceArrayBracketStr(String arrayStrWithBracket) {
    String res = arrayStrWithBracket.replaceAll("\\[", "{").replaceAll("]", "}").replaceAll("},", "},");
    System.err.println(res);
    res = res.replaceAll("},", "},\n");
    return res;
  }

  public static void printListOfListInt(List<List<Integer>> listsints) {
    listsints.stream().forEach(list -> printList(list));
  }

  public static void printListOfListString(List<List<String>> listStrs) {
    listStrs.stream().forEach(list -> printList(list));
  }

  public static boolean isValidIndex(int new_x, int new_y, int row, int col) {
    if (new_x < 0 || new_y < 0 || new_x >= row || new_y >= col) return false;
    return true;
  }

  public void print(PriorityQueue<int[]> pq) {
    Integer[] ints = pq.toArray(new Integer[pq.size()]);
  }

  public static String sanitizeArray(String input) {
    String ans = input.replaceAll("\\[", "{").replaceAll("]", "}");
    System.out.println(ans);
    System.out.println("int[] input = new int[]" + ans + ";");
    System.out.println("int[][] input = new int[][]" + ans + ";");
    return ans;
  }

  public static void print(ListNode listNode) {
    while (listNode != null) {
      System.out.print(listNode.val + ", ");
      listNode = listNode.next;

    }
    System.out.println("");
  }


  public static void main(String[] args) {

    String str = "[[1,0,0,0,0,0],[0,1,0,0,0,0],[0,0,1,0,0,0],[0,0,0,1,1,0],[0,0,0,1,1,0],[0,0,0,0,0,1]]\n" +
      "[5,0]";

    sanitizeArray(str);

    int x = 10;
    System.out.println("x value is " + x);
    x = x + 5;
    System.out.println("Again x value is " + x);
    x = 122;
    System.out.println("Again again x value is " + x);
    x = x * 5;
    System.out.println("Again again again x value is " + x);

  }
}
