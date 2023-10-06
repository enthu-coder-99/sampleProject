package tmp.abstraction;

public class ConcreteClass extends AbstractCalculator {
  @Override
  public int multiply(int num1, int num2) {
    return num1 * num2;
  }

  @Override
  public int divide(int num1, int num2) {
    return num1 / num2;
  }
}