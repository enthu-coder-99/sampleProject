package DP;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Race_Car_818 {
  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    System.err.println(racecar(812));
  }

  public static int racecar(int target) {
    return bfs(target);
  }

  public static int bfs(int target) {
    Set<String> memoSet = new HashSet<>();// To capture Position and Speed. If same positon and same speed already processed than do not do again.
    Deque<List<Integer>> deque = new ArrayDeque<>();
    deque.add(List.of(0, 1));
    memoSet.add(0 + "," + 1);
    int count = 0;
    while (deque.size() > 0) {
      int size = deque.size();
      count++;
      while (size > 0) {
        size--;
        List<Integer> list = deque.poll();
        int currentPosition = list.get(0);
        int currentSpeed = list.get(1);
        if (currentPosition == target)
          return count - 1;

        // Next we have take 2 actions A or R.
        // If we choose - A
        int nextPositionWithChoice_A = currentPosition + currentSpeed;
        int nextSpeedWithChoice_A = currentSpeed * 2;
        if (nextPositionWithChoice_A == currentPosition)
          return count;

        String key_A = nextPositionWithChoice_A + "," + nextSpeedWithChoice_A;

        if (!memoSet.contains(key_A) && (Math.abs(target - nextPositionWithChoice_A) < target)) {
          deque.offer(List.of(nextPositionWithChoice_A, nextSpeedWithChoice_A));
          memoSet.add(key_A);
        }

        if ((currentSpeed > 0 && nextPositionWithChoice_A > target) || (currentSpeed < 0 && nextPositionWithChoice_A < target)) {
          int nextPositionWithChoice_R = currentPosition;
          int nextSpeedWithChoice_R = currentSpeed > 0 ? -1 : 1;
          String key_R = nextPositionWithChoice_R + "," + nextSpeedWithChoice_R;
          if (!memoSet.contains(key_R) && Math.abs(target - nextPositionWithChoice_R) < target) {
            deque.offer(List.of(nextPositionWithChoice_R, nextSpeedWithChoice_R));
            memoSet.add(key_R);
          }
        }
      }
    }
    return count;
  }
}
