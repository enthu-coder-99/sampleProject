package utils;

public class CallingClass {

  public static void main(String[] args) {
    SuperClass1 s1 = new SubClass1();
    SuperClass1 s2 = new SubClass2();
    System.err.println(s1.callM2());
    System.err.println(s2.callM2());

  }
}
