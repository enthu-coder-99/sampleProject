package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee_Importance_690 {

  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> employeeMap = builEmployeeMap(employees);
    int importance = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    deque.offer(id);
    while (deque.size() > 0) {
      Employee employee = employeeMap.get(deque.poll());
      importance += employee.importance;
      employee.subordinates.forEach(sub -> deque.offer(sub));
    }

    return importance;
  }

  private Map<Integer, Employee> builEmployeeMap(List<Employee> employees) {
    Map<Integer, Employee> employeeMap = new HashMap<>();
    for (Employee e : employees)
      employeeMap.put(e.id, e);
    return employeeMap;
  }


  class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  }

  ;
}
