package algo.graph.misc;

import java.util.Arrays;
import java.util.Comparator;

public class Rank_Teams_by_Votes_1366 {

  public static void main(String[] args) {
    String[] votes = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};
    System.err.println(rankTeams(votes));
  }

  public static String rankTeams(String[] votes) {
    int team_len = votes[0].length();
    int[][] teamRanking = new int[26][team_len + 1];

    for (int j = 0; j < votes.length; j++) {
      String vote = votes[j];
      for (int i = 0; i < vote.length(); i++) {
        int team = vote.charAt(i) - 'A';
        teamRanking[team][i]++;
      }
    }

    Comparator<int[]> comparator = new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        int l = o1.length;
        for (int i = 0; i < l; i++) {
          if (o1[i] != o2[i])
            return o2[i] - o1[i];
        }
        return 0;
      }
    };
    Arrays.sort(teamRanking, (o1, o2) -> {
      int l = o1.length;
      for (int i = 0; i < l; i++) {
        if (o1[i] != o2[i])
          return o2[i] - o1[i];
      }
      return 0;
    });
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < team_len; i++) {
      sb.append(teamRanking[i][0]);
    }
    return sb.toString();

  }
}
