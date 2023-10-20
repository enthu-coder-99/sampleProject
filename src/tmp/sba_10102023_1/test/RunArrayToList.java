package tmp.sba_10102023_1.test;

import tmp.sba_10102023_1.ArrayToList;

import java.util.ArrayList;

public class RunArrayToList {

  public static void main(String[] args) {
    test1();
  }

  public static void test1() {
    ArrayToList arrayToList = new ArrayToList();
    String[] str_arry = new String[]{"Ram", "bharat", "lakshman", "shatrughan"};
    arrayToList.convert(str_arry);
    arrayToList.replace(3);
    arrayToList.replace(1);

    ArrayList<String> compactList = arrayToList.compact();
    System.out.println("compactList size= " + compactList.size());
    System.out.println("compactList= " + compactList);
  }

  public static void test2() {
    ArrayToList arrayToList = new ArrayToList();
    String[] str_arry = new String[]{"Ram", "bharat", "lakshman", "shatrughan"};
    arrayToList.convert(str_arry);
    arrayToList.replace(3);
    ArrayList<String> compactList = arrayToList.compact();
    System.out.println("compactList size= " + compactList.size());
    System.out.println("compactList= " + compactList);
  }


}
