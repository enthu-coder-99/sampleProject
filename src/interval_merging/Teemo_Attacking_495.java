package interval_merging;

public class Teemo_Attacking_495 {

  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int ans = 0;
    int poisonedTill = -1;
    for (int i = 0; i < timeSeries.length; i++) {
      int currentTime = timeSeries[i];
      if (currentTime > poisonedTill) {
        ans = ans + duration;
        poisonedTill = currentTime + duration - 1;
      } else {
        ans = ans - (poisonedTill - currentTime + 1);
        ans = ans + duration;
        poisonedTill = currentTime + duration - 1;
      }
    }

    return ans;
  }
}
