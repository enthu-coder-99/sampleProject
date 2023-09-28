package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Time_Needed_to_Inform_All_Employees_1376 {

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> managerToSubsMap = buildManageToEmployeesMap(manager);
    return dfs(managerToSubsMap, headID, informTime);
  }

  public int bfs(Map<Integer, List<Integer>> managerToSubsMap, int headID, int[] informTime) {
    int maxTimeToInforamAllEmployees = 0;
    Deque<int[]> deque = new ArrayDeque<>();// In Array, First element is employee ID
    // and second argument is starting time that this guy will start informing to this subordinates.
    deque.add(new int[]{headID, 0});
    while (deque.size() > 0) {
      int[] employee = deque.poll();
      int empId = employee[0];
      int startingTimeToInform = employee[1];
      maxTimeToInforamAllEmployees = Math.max(maxTimeToInforamAllEmployees, startingTimeToInform);
      List<Integer> subordinatesEmpIdList = managerToSubsMap.get(empId);
      if (subordinatesEmpIdList == null) continue;
      for (int i = 0; i < subordinatesEmpIdList.size(); i++) {
        deque.offer(new int[]{subordinatesEmpIdList.get(i), startingTimeToInform + informTime[empId]});
      }
    }
    return maxTimeToInforamAllEmployees;
  }

  public int dfs(Map<Integer, List<Integer>> managerToSubsMap, int empId, int[] informTime) {

    if (!managerToSubsMap.containsKey(empId) || managerToSubsMap.get(empId) == null
      || managerToSubsMap.get(empId).size() == 0) return 0;

    List<Integer> subordinatesEmpIdList = managerToSubsMap.get(empId);
    int timeTakenToPassToSubs = informTime[empId];
    int maxTimeTakeBySubs = 0;
    for (int subEmpId : subordinatesEmpIdList) {
      int timeTakenBySub_dfs = timeTakenToPassToSubs + dfs(managerToSubsMap, subEmpId, informTime);
      maxTimeTakeBySubs = Math.max(maxTimeTakeBySubs, timeTakenBySub_dfs);
    }
    return maxTimeTakeBySubs;
  }


  public Map<Integer, List<Integer>> buildManageToEmployeesMap(int[] manager) {
    Map<Integer, List<Integer>> managerToEmployeesMap = new HashMap();
    for (int i = 0; i < manager.length; i++) {
      if (!managerToEmployeesMap.containsKey(manager[i])) managerToEmployeesMap.put(manager[i], new ArrayList<>());
      managerToEmployeesMap.get(manager[i]).add(i);
    }
    return managerToEmployeesMap;
  }
}
