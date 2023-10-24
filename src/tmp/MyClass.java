package tmp;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
  static int i1;
  static Float f1;
  static float f2;
  static long l1;
  static Long l2;

  public static void main(String[] args) {
    List<Student> list = new ArrayList();

    Student student1 = new Student();
    student1.setId(1);
    student1.setfName("Ram");
    student1.setlName("Mittal");

    Student student2 = new Student();
    student2.setId(3);
    student2.setfName("Luxman");
    student2.setlName("Mittal");

    Student student3 = new Student();
    student2.setId(31);
    student2.setfName("Bharat");
    student2.setlName("Agarwa)l");

    list.add(student1);
    list.add(student2);
    list.add(student3);
    //-------------------------
    exampleOfArrayList();
    // divide(12, 0);
  }

  private static void exampleOfArrayList() {
    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.set(2, 60);

    System.out.println(list);

    int size = list.size();
    System.out.println("Size of the list = " + size);
    for (Integer element : list) {
      System.out.println(element);
    }

    int firstElm = list.get(0);
    int lastElm = list.get(size - 1);


  }


  public static double divide(int num1, int num2) {
    double d = 0;
    d = num1 / num2;
    System.out.println("After the calculation1....");
    System.out.println("After the calculation.2...");
    System.out.println("After the calculation..3..");
    System.out.println("After the calculation...4.");
    System.out.println("After the calculation....5");
    System.out.println("After the calculation....6");

    System.out.println(num1 + " / " + num2 + " = " + d);
    System.out.println("num1 / num2 +  = " + d);
    return d;
  }

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n == 0) return true;
    int l = flowerbed.length;
    int noOfSpotsAvailLeft = -1;

    for (int i = 0; i < l; i++) {
      int num = flowerbed[i];
      if (num == 1) {
        int spotsAvailable = i - noOfSpotsAvailLeft;
        if (noOfSpotsAvailLeft >= 0 && spotsAvailable > 1) {
          if (noOfSpotsAvailLeft == 0) {
            n = n - (spotsAvailable) / 2;
          } else {
            n = n - (spotsAvailable - 1) / 2;
          }
        }
        noOfSpotsAvailLeft = -1;
      } else {
        if (noOfSpotsAvailLeft < 0)
          noOfSpotsAvailLeft = i;
      }
      if (n <= 0) return true;
    }

    int spotsAvailable = l - 1 - noOfSpotsAvailLeft;
    if (noOfSpotsAvailLeft >= 0 && spotsAvailable > 1) {
      n = n - (spotsAvailable) / 2;
    }
    return n <= 0;
  }
}
