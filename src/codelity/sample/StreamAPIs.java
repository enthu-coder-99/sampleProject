package codelity.sample;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIs {

  public static void main(String[] args) {
    sortMapByValue();

    Map<String, Integer> map = Map.of("Ram", 3, "Luxman", 2, "Bharat", 1);
    Stream<String> sorted = map.keySet().stream().sorted();
    sorted.forEach(System.out::println);

    List<Integer> list = List.of(1, 2, 3, 4, 2, 3, 4, 5, 2, 12, 1);
    Map<Integer, Long> result = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    System.err.println(result);
    System.err.println(list.stream().max((e1, e2) -> e1 - e2));
    System.err.println(list.stream().min((e1, e2) -> e1 - e2));
    System.err.println(list.stream().count());

  }

  private static void sortMapByValue() {
    Map<Integer, Integer> map = Map.of(12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1);
    System.err.println("map=" + map);

    //Map<Integer, Integer> map2 =
    map.entrySet().stream().sorted((e1, e2) -> e1.getValue() - e2.getValue()).forEach((e1) -> System.out.print(e1 + " # "));

    Map map2 = map.entrySet().stream().sorted((e1, e2) -> e1.getValue() - e2.getValue()).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));
    System.err.println("map2=" + map2);

    Map map3 = map.entrySet().stream()
      .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    System.err.println("map3=" + map3);
    priorityQueue1();
  }

  private static void priorityQueue1() {
    List<Integer> list = List.of(5, 19, 4, 23, 17, 3, 12, 4, 22, 2, 26, 1);
    PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
    for (int num : list) {
      pq.offer(num);
    }
    System.err.println("pq=" + pq);
    while (pq.peek() != null)
      System.err.print(pq.poll() + "||");
    System.err.println("");
  }
}
