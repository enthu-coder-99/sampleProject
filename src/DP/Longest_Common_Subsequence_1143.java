package DP;

import java.util.concurrent.atomic.AtomicInteger;

public class Longest_Common_Subsequence_1143 {
  /**
   * Same questions like Longest_Common_Subsequence
   * https://leetcode.com/problems/delete-operation-for-two-strings/
   * @param args
   */
  public static void main(String[] args) {
    String text1 = "ezupkr", text2 = "ubmrapg";
    text1 = "mhunuzqrkzsnidwbun";
    text2 = "szulspmhwpazoxijwbq";
    text1 = "psnw";
    text2 = "vozsh";
    text1 = "fcvafurqjylclorwfoladwfqzkbebslwnmpmlkbezkxoncvwhstwzwpqxqtyxozkpgtgtsjobujezgrkvevklmludgtyrmjaxyputqbyxqvupojutsjwlwluzsbmvyxifqtglwvcnkfsfglwjwrmtyxmdgjifyjwrsnenuvsdedsbqdovwzsdghclcdexmtsbexwrszihcpibwpidixmpmxshwzmjgtadmtkxqfkrsdqjcrmxkbkfoncrcvoxuvcdytajgfwrcxivixanuzerebuzklyhezevonqdsrkzetsrgfgxibqpmfuxcrinetyzkvudghgrytsvwzkjulmhanankxqfihenuhmfsfkfepibkjmzybmlkzozmluvybyzsleludsxkpinizoraxonmhwtkfkhudizepyzijafqlepcbihofepmjqtgrsxorunshgpazovuhktatmlcfklafivivefyfubunszyvarcrkpsnglkduzaxqrerkvcnmrurkhkpargvcxefovwtapedaluhclmzynebczodwropwdenqxmrutuhehadyfspcpuxyzodifqdqzgbwhodcjonypyjwbwxepcpujerkrelunstebopkncdazexsbezmhynizsvarafwfmnclerafejgnizcbsrcvcnwrolofyzulcxaxqjqzunedidulspslebifinqrchyvapkzmzwbwjgbyrqhqpolwjijmzyduzerqnadapudmrazmzadstozytonuzarizszubkzkhenaxivytmjqjgvgzwpgxefatetoncjgjsdilmvgtgpgbibexwnexstipkjylalqnupexytkradwxmlmhsnmzuxcdkfkxyfgrmfqtajatgjctenqhkvyrgvapctqtyrufcdobibizihuhsrsterozotytubefutaxcjarknynetipehoduxyjstufwvkvwvwnuletybmrczgtmxctuny";
    text2 = "nohgdazargvalupetizezqpklktojqtqdivcpsfgjopaxwbkvujilqbclehulatshehmjqhyfkpcfwxovajkvankjkvevgdovazmbgtqfwvejczsnmbchkdibstklkxarwjqbqxwvixavkhylqvghqpifijohudenozotejoxavkfkzcdqnoxydynavwdylwhatslyrwlejwdwrmpevmtwpahatwlaxmjmdgrebmfyngdcbmbgjcvqpcbadujkxaxujudmbejcrevuvcdobolcbstifedcvmngnqhudixgzktcdqngxmruhcxqxypwhahobudelivgvynefkjqdyvalmvudcdivmhghqrelurodwdsvuzmjixgdexonwjczghalsjopixsrwjixuzmjgxydqnipelgrivkzkxgjchibgnqbknstspujwdydszohqjsfuzstyjgnwhsrebmlwzkzijgnmnczmrehspihspyfedabotwvwxwpspypctizyhcxypqzctwlspszonsrmnyvmhsvqtkbyhmhwjmvazaviruzqxmbczaxmtqjexmdudypovkjklynktahupanujylylgrajozobsbwpwtohkfsxeverqxylwdwtojoxydepybavwhgdehafurqtcxqhuhkdwxkdojipolctcvcrsvczcxedglgrejerqdgrsvsxgjodajatsnixutihwpivihadqdotsvyrkxehodybapwlsjexixgponcxifijchejoxgxebmbclczqvkfuzgxsbshqvgfcraxytaxeviryhexmvqjybizivyjanwxmpojgxgbyhcruvqpafwjslkbohqlknkdqjixsfsdurgbsvclmrcrcnulinqvcdqhcvwdaxgvafwravunurqvizqtozuxinytafopmhchmxsxgfanetmdcjalmrolejidylkjktunqhkxchyjmpkvsfgnybsjedmzkrkhwryzan";
    System.err.println(new Longest_Common_Subsequence_1143().longestCommonSubsequence(text1, text2));

  }

  private String text1;
  private String text2;
  AtomicInteger count1 = new AtomicInteger(0);
  AtomicInteger countMy = new AtomicInteger(0);

  public int longestCommonSubsequence(String text1, String text2) {
    // Make the memo big enough to hold the cases where the pointers
    // go over the edges of the strings.
    int[][] memo = new int[text1.length() + 1][text2.length() + 1];
    // We need to initialise the memo array to -1's so that we know
    // whether or not a value has been filled in. Keep the base cases
    // as 0's to simplify the later code a bit.
    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        memo[i][j] = -1;
      }
    }
    this.text1 = text1;
    this.text2 = text2;
    int ans = dp_solution(text1, text2);
    System.err.println("Answer=" + ans + " and + count1=" + count1);
    return ans;
  }
  // Best solution
  private int dp_solution(String text1, String text2) {

    int l1 = text1.length();
    int l2 = text2.length();
    if (l1 == 0 || l2 == 0) return 0;
    if (l1 == l2 && text1.equals(text2)) return l1;
    int[][] dp = new int[l1 + 1][l2 + 1];
    char[] text1_c = text1.toCharArray();
    char[] text2_c = text2.toCharArray();

    for (int i = 1; i <= l1; i++) {
      char c1 = text1_c[i - 1];
      for (int j = 1; j <= l2; j++) {
        char c2 = text2_c[j - 1];
        if (c1 == c2) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[l1][l2];
  }


  private int memoSolve(int p1, int p2, int[][] memo) {
    // Check whether or not we've already solved this subproblem.
    // This also covers the base cases where p1 == text1.length
    // or p2 == text2.length.
    String mapKey = p1 + "_" + p1;

    if (memo[p1][p2] != -1) {
      count1.incrementAndGet();
      System.err.println("p1= " + p1 + ", p2=" + p2 + " is in memo= " + memo[p1][p2]);
      return memo[p1][p2];
    }

    // Recursive cases.
    int answer = 0;
    if (text1.charAt(p1) == text2.charAt(p2)) {
      answer = 1 + memoSolve(p1 + 1, p2 + 1, memo);
    } else {
      answer = Math.max(memoSolve(p1, p2 + 1, memo), memoSolve(p1 + 1, p2, memo));
    }

    // Add the best answer to the memo before returning it.
    memo[p1][p2] = answer;
    return memo[p1][p2];
  }

  public int longestCommonSubsequence_my_recursion(String text1, String text2) {
    int[][] memo = new int[text1.length() + 1][text2.length() + 1];

    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        memo[i][j] = -1;
      }
    }
    int resInt = recursion(text1, text2, 0, 0, memo);
    System.err.println("resInt= " + resInt + " and countMy=" + countMy.get());
    return resInt;
  }


  public int recursion(String text1, String text2, int text1_index, int text2_index, int[][] memo) {
    String mapKey = text1_index + "_" + text2_index;

    // System.err.println("text1 = " + text1.substring(text1_index) + ", text2=" + text2.substring(text2_index) + ", mapKey=" + mapKey);
    if (memo[text1_index][text2_index] != -1) {
      countMy.incrementAndGet();
      System.err.println("p1= " + text1_index + ", p2=" + text2_index + " is in memo= " + memo[text1_index][text2_index]);
      return memo[text1_index][text2_index];
    }
    int answer = 0;
    if (text1.charAt(text1_index) == text2.charAt(text2_index)) {
      answer = 1 + recursion(text1, text2, text1_index + 1, text2_index + 1, memo);
      //System.err.println(mapKey + " and Ans1= " + answer);
    } else {
      //System.err.println("Not matched");
      int res1 = recursion(text1, text2, text1_index + 1, text2_index, memo);
      int res2 = recursion(text1, text2, text1_index, text2_index + 1, memo);
      answer = Math.max(res1, res2);
      // System.err.println(mapKey + " and Ans2= " + answer);
    }
    memo[text1_index][text2_index] = answer;
    return answer;
  }
}
