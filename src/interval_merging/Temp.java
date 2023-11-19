package interval_merging;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Temp {

  public static void main(String[] args) {
    int[][] events = new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 10}};
    int k = 2;
    Temp obj = new Temp();
    int ans = 0;
    System.out.println("Final AnsWer= " + ans);
  }

  TreeMap<Integer, Integer> treeMap = new TreeMap<>();

  public void addRange(int left, int right) {
    System.out.println("1- addRange- left= " + left + ", right= " + right + ", treeMap= " + treeMap);
    right--;
    Map.Entry<Integer, Integer> leftFloorEntry = treeMap.floorEntry(left);
    Map.Entry<Integer, Integer> rightFloorEntry = treeMap.floorEntry(right);
    int newLeft = left;
    int newRight = right;
    if (leftFloorEntry != null) {
      // if overlaps with left
      int start = leftFloorEntry.getKey();
      int end = leftFloorEntry.getValue();
      if (end >= left) {
        newLeft = Math.min(start, left);
      }
    }

    if (rightFloorEntry != null) {
      int start = rightFloorEntry.getKey();
      int end = rightFloorEntry.getValue();
      if (end >= right) {
        newRight = Math.max(end, right);
      }
    }
    treeMap.subMap(newLeft, true, newRight, true).clear();
    treeMap.put(newLeft, newRight);
    System.out.println("After- addRange- left= " + left + ", right= " + right + ", treeMap= " + treeMap);
  }

  public boolean queryRange(int left, int right) {
    System.out.println("2- queryRange- left= " + left + ", right= " + right + ", treeMap= " + treeMap);
    right--;
    Map.Entry<Integer, Integer> leftFloorEntry = treeMap.floorEntry(left);
    if (leftFloorEntry != null) {
      return leftFloorEntry.getValue() >= right;
    }
    return false;
  }

  public void removeRange(int left, int right) {
    System.out.println("3- removeRange- left= " + left + ", right= " + right + ", treeMap= " + treeMap);
    right--;

    Map.Entry<Integer, Integer> leftFloorEntry = treeMap.floorEntry(left);
    Map.Entry<Integer, Integer> rightFloorEntry = treeMap.floorEntry(right);

    if (leftFloorEntry != null) {
      // if overlaps with left
      int start = leftFloorEntry.getKey();
      int end = leftFloorEntry.getValue();
      if (end >= left) {
        treeMap.put(start, left - 1);
        treeMap.put(left, end);
      }
    }

    if (rightFloorEntry != null) {
      int start = rightFloorEntry.getKey();
      int end = rightFloorEntry.getValue();
      if (end >= right) {
        treeMap.put(start, right);
        treeMap.put(right + 1, end);
      }
    }
    treeMap.subMap(left, true, right, true).clear();
    System.out.println("After- removeRange- left= " + left + ", right= " + right + ", treeMap= " + treeMap);
  }

  static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
    int sum = 0;
    int leftIndex = 0;
    for (int i = 0; i < n; i++) {
      int num = arr[i];
      sum += num;
      while (sum > s) {
        sum = sum - arr[leftIndex];
        leftIndex++;
      }
      if (sum == s) {
        return new ArrayList<>(List.of(leftIndex + 1, i + 1));
      }
    }
    return new ArrayList<>(List.of(-1));

  }
}
