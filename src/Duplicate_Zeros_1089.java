import utils.CommonLogging;

import java.util.LinkedList;
import java.util.List;

public class Duplicate_Zeros_1089 {

  public static void main(String[] args) {
    int[] input = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
    //{1, 0, 0, 2, 3, 0 ,0, 4 ,5, 0 , 0}
    duplicateZerosWithLinkedList(input);
    CommonLogging.printArray("", input);
  }

  public static void duplicateZeros(int[] arr) {
    int length = arr.length;
    int noOfZeros = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        ++noOfZeros;
      }
    }

    for (int i = length - 1; i >= 0; i--) {
      int realIndex = i + noOfZeros;
      if (realIndex < length) {
        //we can accomodate that element
        arr[realIndex] = arr[i];
      }

    }
  }


  public static void duplicateZerosWithLinkedList(int[] arr) {
    List<Integer> skippedElementList = new LinkedList<Integer>();
    for (int i = 0; i < arr.length; i++) {
      int currentElm = arr[i];
      skippedElementList.add(currentElm);
      if (currentElm == 0) {
        skippedElementList.add(0);
      }
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = skippedElementList.get(i);
    }
  }
}
