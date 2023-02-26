package Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Keys_and_Rooms_841 {

  public static void main(String[] args) {

  }

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {

    Set<Integer> roomsVisited = new HashSet<>();
    roomsVisited.add(0);
    List<Integer> keyNos = (rooms.get(0));
    while (keyNos.size() > 0) {
      Integer keyNo = keyNos.remove(0);
      if (roomsVisited.contains(keyNo))
        continue;
      roomsVisited.add(keyNo);
      if (roomsVisited.size() >= rooms.size()) {
        return true;
      }
      keyNos.addAll(rooms.get(keyNo));
    }
    return roomsVisited.size() >= rooms.size();
  }
}
