package interval_merging;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Number_of_Flowers_in_Full_Bloom_2251 {

  //Solution#2 - Not much Initutive
  public int[] fullBloomFlowers_single_pq(int[][] flowers, int[] people) {

    int l = flowers.length;
    int people_l = people.length;
    int[] answer = new int[people_l];

    //300-> PEOPLE INDEX ENTRY entry in PQ
    //100-> Flower Bloom Index entry in PQ
    //200- Flower Die Index entry in PQ
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    for (int i = 0; i < l; i++) {
      int[] flower = flowers[i];
      int start = flower[0];
      int end = flower[1];
      pq.add(new int[]{start, 100});
      pq.add(new int[]{end, 200});
    }

    for (int i = 0; i < people_l; i++) {
      pq.add(new int[]{people[i], 300, i});

    }
    int count_Of_Blooms = 0;
    while (pq.size() > 0) {
      int[] pq_details = pq.poll();
      int index_PQ = pq_details[0];
      int itemType = pq_details[1];
      if (itemType == 100) {
        count_Of_Blooms++;
      } else if (itemType == 200) {
        count_Of_Blooms--;
      } else {
        answer[index_PQ] = count_Of_Blooms;
      }
    }
    return answer;
  }


  //Solution#1 - Intuitive
  public int[] fullBloomFlowers_multiple_pq(int[][] flowers, int[] people) {

    int l = flowers.length;
    int people_l = people.length;
    PriorityQueue<Integer> pq_start = new PriorityQueue<>();
    PriorityQueue<Integer> pq_end = new PriorityQueue<>();

    for (int i = 0; i < l; i++) {
      int[] flower = flowers[i];
      int start = flower[0];
      int end = flower[1];
      pq_start.add(start);
      pq_end.add(end);
    }

    int started_count = 0;
    int ended_count = 0;
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int i = 0; i < people_l; i++) {
      treeMap.put(people[i], 0);
    }

    for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
      Integer key = entry.getKey();
      while (pq_start.size() > 0 && pq_start.peek() <= key) {
        pq_start.poll();
        started_count++;
      }

      while (pq_end.size() > 0 && pq_end.peek() < key) {
        pq_end.poll();
        ended_count++;
      }
      entry.setValue(started_count - ended_count);
    }
    int[] answer = new int[people_l];
    for (int i = 0; i < people_l; i++) {
      answer[i] = treeMap.get(people[i]);
    }
    return answer;
  }
}
