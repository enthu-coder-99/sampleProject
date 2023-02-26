package codelity.sample;

import utils.CommonLogging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrogJmp {

  public static void main(String[] args) {
    int[][] arr = new int[5][2];
    arr[0] = new int[]{1, 2, 3};
    arr[1] = new int[]{3, 4};
    arr[2] = new int[]{5, 6};
    arr[3] = new int[]{7, 8};
    arr[4] = new int[]{9, 10};

    for(int i=0;i< arr.length;i++){
      System.err.println(arr[i]);
      System.err.println(CommonLogging.printArray("", arr[i]));
    }


    double d1 = 1344d;
    double d2 = 345d;
    System.err.println("Array length=" + arr.length);

    ArrayList aList = new ArrayList(19);
    System.err.println("aList.size=" + aList.size());

    System.err.println(CommonLogging.printArray("", solution("AC", new int[]{0, 0, 1}, new int[]{0, 1, 1})));
  }

  static Map<Character, Integer> map = new HashMap<Character, Integer>();

  public static int[] solution(String S, int[] P, int[] Q) {
    // write your code in Java SE 8
    int length = P.length;
    int[] resultArr = new int[length];
    char[] sChars = S.toCharArray();
    ArrayList<int[]> initList = init(sChars);
    for (int i = 0; i < P.length; i++) {
      int pIndex = P[i];
      int qIndex = Q[i];
      if (pIndex == qIndex) {
        resultArr[i] = map.get(sChars[pIndex]);
        continue;
      }
      int[] pIndexCount = null;
      if (pIndex > 1) {
        pIndexCount = initList.get(pIndex - 1);
      }
      int[] qIndexCount = initList.get(qIndex);
      if (qIndexCount[0] > (pIndexCount != null ? pIndexCount[0] : 0)) {
        resultArr[i] = 1;
      } else if (qIndexCount[1] > (pIndexCount != null ? pIndexCount[1] : 0)) {
        resultArr[i] = 2;
      } else if (qIndexCount[2] > (pIndexCount != null ? pIndexCount[2] : 0)) {
        resultArr[i] = 3;
      } else if (qIndexCount[3] > (pIndexCount != null ? pIndexCount[3] : 0)) {
        resultArr[i] = 4;
      }
    }

    return resultArr;
  }

  public static ArrayList<int[]> init(char[] sChars) {

    map.put('A', 1);
    map.put('C', 2);
    map.put('G', 3);
    map.put('T', 4);

    ArrayList<int[]> initList = new ArrayList<int[]>();

    int aAcount = 0;
    int cAcount = 0;
    int gAcount = 0;
    int tAcount = 0;
    for (int i = 0; i < sChars.length; i++) {
      if ('A' == sChars[i]) {
        aAcount++;
      } else if ('C' == sChars[i]) {
        cAcount++;
      } else if ('G' == sChars[i]) {
        gAcount++;
      } else if ('T' == sChars[i]) {
        tAcount++;
      }
      int[] countArr = new int[4];
      countArr[0] = aAcount;
      countArr[1] = cAcount;
      countArr[2] = gAcount;
      countArr[3] = tAcount;
      initList.add(countArr);
    }
    return initList;
  }
}
