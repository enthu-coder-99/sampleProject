package tmp;

public class Assignment1_01242024 {

  public static void main(String[] args) {
    double area1 = calculateArea(1.25d);
    double area2 = calculateArea(2.5d);
    double totalArea = area1 + area2;
    System.out.println("totalArea= " + totalArea);

  }


  private int calcMax(int[] nums){

    return -1;
  }

  public static double calculateArea(double radius) {
    double area = radius * radius * 3.14;
    System.out.println("area = " + area);
    return area;
  }
}
