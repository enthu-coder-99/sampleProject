package greedy;

public class Gas_Station_134 {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int l = gas.length;
    int[] diff = new int[l];
    int gasSum = 0;
    int costSum = 0;
    for (int i = 0; i < l; i++) {
      diff[i] = gas[i] - cost[i];
      gasSum = gasSum + gas[i];
      costSum = costSum + cost[i];
    }

    if (costSum > gasSum)
      return -1;
    int diffSum = 0;
    int startingIndex = -1;
    for (int j = 0; j < l; j++) {
      int diff1 = diff[j];
      diffSum = diffSum + diff1;
      if (diffSum < 0) {
        diffSum = 0;
        startingIndex = -1;
      } else if (startingIndex < 0) {
        startingIndex = j;
      }
    }
    return startingIndex;
  }
}
