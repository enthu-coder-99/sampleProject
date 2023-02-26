package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses_93 {

  public static void main(String[] args) {
    System.err.println(restoreIpAddresses("25525511135"));
  }


  public static List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();

    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        for (int k = 1; k <= 3; k++) {
          for (int l = 1; l <= 3; l++) {
            if (i + j + k + l == s.length()) {
              String part1 = s.substring(0, i);
              if (!valid(part1)) continue;
              String part2 = s.substring(i, i + j);
              if (!valid(part2)) continue;
              String part3 = s.substring(i + j, i + j + k);
              if (!valid(part3)) continue;
              String part4 = s.substring(i + j + k);
              if (!valid(part4)) continue;
              String result = part1 + "." + part2 + "." + part3 + "." + part4;
              res.add(result);
            }
          }
        }
      }
    }
    return res;
  }

  private static boolean valid(String str) {
    if (str == null || str.length() == 0 || str.length() > 3) return false;
    if (str.startsWith("0") && str.length() > 1) return false;
    Integer ip = Integer.valueOf(str);
    if (ip < 0 || ip > 255) return false;
    return true;
  }
}
