package DP.jump_games;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Jump_Game_IV_1345 {

  public static void main(String[] args) {
    // System.err.println(minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
    pq.add(5);
    pq.add(15);
    pq.add(15);
    pq.add(25);
    pq.add(20);
    pq.add(13);
    pq.add(3);
    pq.add(14);
    pq.add(11);
    pq.add(1);
    pq.add(2);
    pq.add(55);
    pq.add(45);
    pq.add(50);
    System.err.println("1- Size=" + pq.size());
    System.err.println("2- Size=" + pq.size());

    while (!pq.isEmpty())
      System.err.println(pq.poll());
    System.err.println("3- Size=" + pq.size());


  }

  public static int minJumps(int[] arr) {
    Map<Integer, List<Integer>> valueToIndexMap = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (valueToIndexMap.get(arr[i]) == null)
        valueToIndexMap.put(arr[i], new ArrayList<>());
      valueToIndexMap.get(arr[i]).add(i);
    }
    Deque<Set<Integer>> deque = new ArrayDeque<>();
    deque.add(Set.of(0));
    return bfs(arr, valueToIndexMap, deque);

  }

  private static int bfs(int[] arr, Map<Integer, List<Integer>> valueToIndexMap, Deque<Set<Integer>> deque) {
    int l = arr.length;
    int[] memo = new int[l];
    int level = 0;
    while (deque.size() > 0) {
      Set<Integer> bfsCurrentLevelIndexList = deque.pop();
      Set<Integer> nextLevelIndexesList = new HashSet<>();
//7,7,7,7,7,7,7,7,7,7,11
      for (int currentLevelIndex : bfsCurrentLevelIndexList) {
        if (currentLevelIndex == (l - 1)) {
          return level;
        } else {
          if (memo[currentLevelIndex] == -1) continue;

          if (currentLevelIndex + 1 < l) {
            nextLevelIndexesList.add(currentLevelIndex + 1);
          }

          if (currentLevelIndex - 1 >= 0) {
            nextLevelIndexesList.add(currentLevelIndex - 1);
          }
          int currentLevelIndexValue = arr[currentLevelIndex];
          if (valueToIndexMap.containsKey(currentLevelIndexValue)) {
            List<Integer> currentIndexValueAllIndexes = valueToIndexMap.get(currentLevelIndexValue);
            for (int i = 0; i < currentIndexValueAllIndexes.size(); i++) {
              if (currentLevelIndex != currentIndexValueAllIndexes.get(i) && memo[currentIndexValueAllIndexes.get(i)] != -1) {
                nextLevelIndexesList.add(currentIndexValueAllIndexes.get(i));
              }
            }
            valueToIndexMap.remove(currentLevelIndexValue);
          }
          memo[currentLevelIndex] = -1;// Mark this index so that it won't get process in future..
        }
      }
      if (nextLevelIndexesList.size() > 0)
        deque.add(nextLevelIndexesList);
      level++;
    }
    return -1;
  }


}
