package utils;

public abstract class SuperClass1 {

  public abstract String callM1();

  public String callM2() {
    System.err.println("callM2() From SuperClass1 and callM1() = " + callM1());
    return "callM2() from SuperClass1 and callM1() = " + callM1();
  }
}
