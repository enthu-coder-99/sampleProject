package DP.jump_games;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Jump_Game_VII_1871 {
  static int counter = 0;

  public static void main(String[] args) throws Exception {
    String s = "";

    List<String> lines = Files.readAllLines(Paths.get("/Users/vinitk/MyWork/learning/sampleProject/src/", "input.txt"));
    System.err.println(lines.get(0));
    s = lines.get(0);
    System.err.println( "\n and result======" + canReach(s, 1, 49999));

    /*s = "011010";
    System.err.println(s + " and result======" + canReach_WithMemo(s, 2, 3));

    s = "01101110";
    System.err.println(s + " and result=======" + canReach_WithMemo(s, 1, 99999));*/
  }


  public static boolean canReach(String s, int minJ, int maxJ) {
    int n = s.length(), pre = 0;
    boolean[] dp = new boolean[n];
    dp[0] = true;
    for (int i = 1; i < n; ++i) {
      System.err.print(" , i="+i);
      if (i >= minJ && dp[i - minJ]) {
        pre++;
      }
      if (i > maxJ && dp[i - maxJ - 1]) {
        pre--;
      }
      System.err.print(i + " and pre=" + pre + ", ");
      dp[i] = (pre > 0 && s.charAt(i) == '0');
    }
    return dp[n - 1];
  }

  public static boolean canReach_bfs(String s, int minJump, int maxJump) {
    int n = s.length();
    if (s.charAt(n - 1) != '0') return false;
    System.err.println(s + " and total length=" + n);
    int last_index_to_touch = n - 1;
    int i = n - 2;
    for (; i >= 0; i--) {
      char c = s.charAt(i);
      if (c != '0')
        continue;
      System.err.println(i + " and last_index_to_touch=" + last_index_to_touch);
      if ((i + minJump) <= (n - 1) && (i + maxJump) >= last_index_to_touch && (i + minJump) <= last_index_to_touch) {
        System.err.println("Jumped from index=" + i);
        last_index_to_touch = i;
      }
    }
    return (last_index_to_touch <= 1);
  }

  public static boolean canReach_WithMemo(String s, int minJump, int maxJump) throws InterruptedException {
    char[] s_chars = s.toCharArray();
    int n = s.length();
    if (s_chars[n - 1] != '0') return false;
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    int maxInPreviousRound = 0;
    while (queue.size() > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int startingIndex = queue.pop();
        int nextIndexAfterMinJump = startingIndex + minJump;
        nextIndexAfterMinJump = Math.max(maxInPreviousRound, nextIndexAfterMinJump);
        int nextIndexAfterMaxJump = startingIndex + maxJump;//inclusive
        for (int j = nextIndexAfterMinJump; j <= nextIndexAfterMaxJump && j < n; j++) {
          maxInPreviousRound = Math.max(maxInPreviousRound, j);
          if (s_chars[j] != '0') continue;
          else if (j == (n - 1)) return true;
          else {
            queue.add(j);
            s_chars[j] = '2';
          }
        }
      }
    }

    return false;
  }

}
