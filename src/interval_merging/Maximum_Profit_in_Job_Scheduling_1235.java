package interval_merging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Maximum_Profit_in_Job_Scheduling_1235 {


  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

    int l = startTime.length;

    List<Job> list = new ArrayList<Job>();

    for (int i = 0; i < l; i++) {
      list.add(new Job(startTime[i], endTime[i], profit[i]));
    }
    Collections.sort(list, (Job j1, Job j2) -> {
      if (j1.startTime == j2.startTime)
        return j1.endTime - j2.endTime;
      return j1.startTime - j2.startTime;
    });

    return dp(list);
  }

  //TLE as it is a n^2 time complexity
  public int dp(List<Job> list) {

    int l = list.size();

    int[] maxProfitAt = new int[l + 1];
    TreeMap<Integer, Integer> treeMap = new TreeMap();
    maxProfitAt[l - 1] = list.get(l - 1).profit;
    for (int i = l - 2; i >= 0; i--) {
      Job job_i = list.get(i);
      int start_i = job_i.startTime;
      int end_i = job_i.endTime;
      int profit_i = job_i.profit;
      maxProfitAt[i] = maxProfitAt[i + 1];
      Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(end_i);
      if (ceilingEntry != null) {
        maxProfitAt[i] = Math.max(maxProfitAt[i], profit_i + ceilingEntry.getValue());
      }
      treeMap.put(start_i, maxProfitAt[i]);
    }
    return maxProfitAt[0];
  }

  class Job {
    int startTime;
    int endTime;
    int profit;

    public Job(int startTime, int endTime, int profit) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.profit = profit;
    }
  }
}
