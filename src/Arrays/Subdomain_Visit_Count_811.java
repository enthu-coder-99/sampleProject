package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subdomain_Visit_Count_811 {

  public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> countMap = new HashMap<>();
    List<String> resultList = new ArrayList<>();
    for (int i = 0; i < cpdomains.length; i++) {
      String cpdomain = cpdomains[i];
      String[] countAndDomains = cpdomain.split(" ");
      int count = Integer.valueOf(countAndDomains[0]);
      String domains = countAndDomains[1];
      countMap.put(domains, countMap.getOrDefault(domains, 0) + count);
      char[] chars = domains.toCharArray();
      for (int j = 0; j < chars.length; j++) {
        int c = chars[j];
        if (c == '.') {
          String subDomain = domains.substring(j + 1);
          countMap.put(subDomain, countMap.getOrDefault(subDomain, 0) + count);
        }
      }
    }

    for (String domain : countMap.keySet()) {
      resultList.add(countMap.get(domain) + " " + domain);
    }
    return resultList;
  }
}
