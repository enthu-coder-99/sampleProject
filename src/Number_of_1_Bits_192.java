public class Number_of_1_Bits_192 {
  public static void main(String[] args) {
    System.err.println(hammingWeight(00000000000000000000000000001011));
  }

  public static int hammingWeight(int n) {
    String s = String.valueOf(n);
    char[] cs = s.toCharArray();
    int t = 0;
    for(int i =0 ;i <cs.length;i++){
      if(cs[i]=='1')
        t++;
    }
    return t;
  }
}
