import java.util.ArrayList;
import java.util.List;

class MinStack {
  List<Integer> list = null;

  public MinStack() {
    list = new ArrayList();
  }

  public void push(int val) {
    list.add(val);
  }

  public void pop() {
    Integer remove = list.remove(list.size() - 1);
  }

  public int top() {
    return list.get(list.size() - 1);
  }

  public int getMin() {
    int minValue = 0;
    for (int val : list) {
      minValue = Math.min(minValue, val);
    }
    return minValue;
  }
}