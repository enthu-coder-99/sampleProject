package tmp.abstraction;

public abstract class AbstractCalculator implements CalculatorI {

  @Override
  public void add(int num1, int num2) {
    int sum = num1 + num2;
    System.out.println("Sum = " + sum);
  }

  @Override
  public int sub(int num1, int num2) {
    return 0;
  }

  public abstract int multiply(int num1, int num2);

  public abstract int divide(int num1, int num2);
}
