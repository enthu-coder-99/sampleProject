package dfs;

import utils.CommonLogging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reconstruct_Itinerary_332 {


  public static void main(String[] args) {
    String[][] input = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
    //input = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};

    int[][] is = new int[][]{{35, 21}, {5, 10}, {6, 11}, {25, 15}, {24, 14}, {24, 11}, {24, 13}, {24, 12}, {24, 13}};
    Comparator<int[]> cpm = (o1, o2) -> (o1[0] - o2[0]) == 0 ? (o1[1] - o2[1]) : (o1[0] - o2[0]);

    Arrays.sort(is, cpm);

    for (int[] i : is) {
      System.err.println(i[0] + "," + i[1]);
    }

    input = new String[][]{{"JFK", "A11"}, {"JFK", "A21"}, {"A11", "B11"}, {"A11", "B12"}, {"A21", "B21"}, {"A21", "B22"}};
    input = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
    input = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
    findItinerary_stringArrays((input));
  }

  public static List<String> findItinerary_stringArrays(String[][] tickets_str) {
    List<List<String>> tickets = new ArrayList<>();
    for (String[] s1 : tickets_str) {
      tickets.add(Arrays.asList(s1));
    }
    return findItinerary(tickets);
  }

  public static List<String> findItinerary(List<List<String>> tickets) {
    List<String> allPossibleRoute = new ArrayList<>();
    Map<String, List<String>> flights = buildGraph(tickets);
    List<String> airportsVisisted = new ArrayList<>();
    airportsVisisted.add("JFK");
    List<String> path = dfs(flights, "JFK", airportsVisisted, allPossibleRoute, tickets.size() + 1);
    System.err.println("path=" + path);
    return path;
    //allPossibleRoute.forEach(e -> System.err.println("Route= " + e));
  }

  public static List<String> dfs(Map<String, List<String>> flightsMap, String
    startAirport, List<String> path, List<String> allPossibleRoute, int airportLength) {

    if (path.size() == airportLength) {
      System.err.println("returning path = " + path);
      return path;
    }

    if (!flightsMap.containsKey(startAirport) || flightsMap.get(startAirport).size() == 0) {
      //System.err.println(startAirport + " is the last airport so ending loop. and Path =" + path);
      allPossibleRoute.add(CommonLogging.printList("Path is= ", path));
      System.err.println(airportLength + " and path length=" + path.size());
      return null;
    }
    List<String> connections = flightsMap.get(startAirport);
    for (int i = 0; i < connections.size(); i++) {
      String connection = connections.get(i);
      int p_size = path.size();
      path.add(p_size, connections.remove(i));
      ;
      //System.err.println("i=" + i + " and path= " + path);
      List<String> dfsReturn = dfs(flightsMap, connection, path, allPossibleRoute, airportLength);
      if (dfsReturn != null)
        return dfsReturn;
      //System.err.println("dfsReturn= " + dfsReturn + " and path=" + path + " and removing = " + path.get(p_size));
      path.remove(p_size);
      connections.add(i, connection);
    }
    return null;
  }

  public static Map<String, List<String>> buildGraph(List<List<String>> tickets) {
    Map<String, List<String>> flights = new HashMap<>();
    for (List<String> ticket : tickets) {
      flights.putIfAbsent(ticket.get(0), new ArrayList<>());
      flights.get(ticket.get(0)).add(ticket.get(1));
    }
    flights.values().forEach(Collections::sort);
    return flights;
  }
}
