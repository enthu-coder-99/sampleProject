package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

  public static void main(String[] args) {
    int[] array = new int[10];
    int length = array.length;
    System.out.println("Array length = " + length);
    for (int i = 0; i < 10; i++) {
      array[i] = i * i;
    }

    array = new int[11];


    for (int i = 0; i < length; i++) {
      //System.out.println("array[" + i + "] = " + array[i]);
    }

    List<Integer> list = new ArrayList<>();
    list.add(1565);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(4);
    list.add(4);
    list.add(4);
    list.add(5);
    list.add(15);

    int list_size = list.size();
    System.out.println("List size=" + list_size);
    for (int i = 0; i < list_size; i++) {
      int element = list.get(i);
      System.out.println("List element = " + list.get(i));
    }

    Set<Integer> set = new HashSet<>();
    set.add(1565);
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);
    set.add(4);
    set.add(4);
    set.add(4);
    set.add(5);
    set.add(15);
    System.out.println("Set Size= " + set.size());

    for (int set_element : set) {
      System.out.println("Set Element = " + set_element);
    }

    boolean b = set.contains(16);
    System.out.println("Set contains 15? "+b);
  }
}
