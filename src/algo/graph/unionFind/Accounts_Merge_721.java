package algo.graph.unionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Accounts_Merge_721 {

  public static void main(String[] args) {
    List<List<String>> inputAccount = new ArrayList<>();
    inputAccount.add(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"));
    inputAccount.add(List.of("John", "johnsmith@mail.com", "john00@mail.com"));
    inputAccount.add(List.of("Mary", "mary@mail.com"));
    inputAccount.add(List.of("John", "johnnybravo@mail.com"));
    List<List<String>> response = accountsMerge(inputAccount);
    System.err.println("response=" + response);

  }

  public static List<List<String>> accountsMerge(List<List<String>> accounts) {
    int l = accounts.size();
    Map<String, Integer> emailToParentAccountIndexMap = new HashMap<>();
    TreeSet<String>[] emailAddressByAccount = new TreeSet[l];
    List<List<String>> accountsAfterMergerResponse = new ArrayList<>();

    for (int i = 0; i < accounts.size(); i++) {
      emailAddressByAccount[i] = new TreeSet();
      List<String> account = accounts.get(i);
      int ultimate_parent_account_index = -1;
      Set<Integer> duplicateAccountIndexSet = new HashSet();
      for (int j = 1; j < account.size(); j++) {
        // Check if this email already exists i.e. duplicate account.
        String email = account.get(j);
        if (emailToParentAccountIndexMap.containsKey(email)) {
          duplicateAccountIndexSet.add(emailToParentAccountIndexMap.get(email));
        }
      }
      if (duplicateAccountIndexSet.size() > 0) {
        for (int duplicateChildAccountIndex : duplicateAccountIndexSet) {
          // Attach previous duplicate accounts to ultimate_parent_account_index.
          ultimate_parent_account_index = ultimate_parent_account_index < 0 ? duplicateChildAccountIndex : ultimate_parent_account_index;
          // Attached child to parent
          reattachAccounts(emailAddressByAccount, emailToParentAccountIndexMap, ultimate_parent_account_index, duplicateChildAccountIndex);
        }
      }

      int parentAccountIndexToI = ultimate_parent_account_index >= 0 ? ultimate_parent_account_index : i;
      // Attach emails to parent/new account
      for (int j = 1; j < account.size(); j++) {
        String email = account.get(j);
        emailToParentAccountIndexMap.put(email, parentAccountIndexToI);
        emailAddressByAccount[parentAccountIndexToI].add(email);
      }
    }

    for (int i = 0; i < emailAddressByAccount.length; i++) {
      TreeSet<String> emailAddresses = emailAddressByAccount[i];
      if (emailAddresses != null && emailAddresses.size() > 0) {
        Set<String> emailAddressesSet = new TreeSet<>(emailAddressByAccount[i]);
        List<String> mergedAccount = new ArrayList<>();
        mergedAccount.add(accounts.get(i).get(0));// Setting the account Name
        mergedAccount.addAll(emailAddressesSet);
        accountsAfterMergerResponse.add(mergedAccount);
      }
    }

    return accountsAfterMergerResponse;
  }

  public static void reattachAccounts(TreeSet<String>[] emailAddressByAccount, Map<String, Integer> emailToParentAccountIndexMap, int parentIndex, int childIndex) {
    if (parentIndex == childIndex) return;
    TreeSet<String> childEmailAddressList = emailAddressByAccount[childIndex];
    //1- Let us update the parent Index in map
    for (String email : childEmailAddressList) {
      emailToParentAccountIndexMap.put(email, parentIndex);
    }
    emailAddressByAccount[parentIndex].addAll(childEmailAddressList);
    emailAddressByAccount[childIndex] = new TreeSet<>();
  }


}
