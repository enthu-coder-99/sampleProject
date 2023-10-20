package tmp.sba_10102023_1;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList implements MyList {
  String[] array = new String[10];

  List<String> arrayToList;// Declare the "arrayToList" (But didn't initialized.). Object has not been created on line# 8

  public ArrayToList() {// This is a constructor.
    arrayToList = new ArrayList<>();// Initialize or Creates a new Object of type ArrayList and assigned
    //System.out.println("arrayToList ka size= " + arrayToList.size());
    //System.out.println("Arrray length= " + array.length);

  }

  public void convert(String[] a) {
    int a_array_length = a.length;
    for (int i = 0; i < a_array_length; i++) {
      String array_element = a[i];
      arrayToList.add(array_element);
      //System.out.println("I have added the the string: " + array_element + " at index " + i);
    }
  }

  public void replace(int idx) {
    String emptyStr = "";
    System.out.println("before- " + arrayToList);
    String nameVal = arrayToList.get(idx);

    arrayToList.set(idx, emptyStr);
    System.out.println("I have replaced the String: " + nameVal + " with the null string: " + idx);
    System.out.println("after- " + arrayToList);

  }

  /**
   * This methid is removing all Empty String("")
   *
   * @return
   */
  public ArrayList<String> compact() {
    ArrayList<String> ansList = new ArrayList<>();
    int size = arrayToList.size();
    for (int i = 0; i < size; i++) {
      String element = arrayToList.get(i);
      if (!element.equals("")) {
        ansList.add(element);
      }
    }
    return ansList;
  }

  public static void main(String[] args) {
    ArrayToList arrayToList = new ArrayToList();
  }
}
