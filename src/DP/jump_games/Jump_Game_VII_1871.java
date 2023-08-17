package DP.jump_games;

import utils.BigDataPlayer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jump_Game_VII_1871 {
  static int counter = 0;

  public static void main(String[] args) throws Exception {
    String input = BigDataPlayer.getStringData("Jump_game_1871");
    System.err.println(input);
    Jump_Game_VII_1871 obj = new Jump_Game_VII_1871();
    System.err.println(obj.canReach(input, 1, 99999));

    /*s = "011010";
    System.err.println(s + " and result======" + canReach_WithMemo(s, 2, 3));

    s = "01101110";
    System.err.println(s + " and result=======" + canReach_WithMemo(s, 1, 99999));*/
  }


  public static boolean canReach(String s, int minJump, int maxJump) {
    char[] chars = s.toCharArray();
    int l = chars.length;
    if (l == 1) return true;
    if (chars[l - 1] == '1') return false;
    System.out.println("Length=" + l);
    Deque<Integer> deque = new ArrayDeque();
    deque.add(0);
    while (deque.size() > 0) {
      int index = deque.pop();
      System.out.println("Index=" + index);
      if (index == l - 1) return true;

      int minIndexToReach = index + minJump;
      int maxIndexToReach = Math.min(index + maxJump, l - 1);
      for (int i = minIndexToReach; i <= maxIndexToReach; i++) {
        if (chars[i] == '0') {
          deque.add(i);
          if (i == l - 1) return true;
          chars[i] = '1';
        }
      }
    }
    System.out.println("Length=" + l);

    return false;
  }

}
