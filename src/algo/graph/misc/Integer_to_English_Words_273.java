package algo.graph.misc;

public class Integer_to_English_Words_273 {

  static int MILLION = 1_000_000;
  static int BILLION = 1_000_000_000;

  public static void main(String[] args) {
    int num = 22000;
    System.err.println(Integer.MAX_VALUE);
    System.out.println(convertFourNumDigit(Integer.MAX_VALUE));
  }

  public static String numberToWords(int num) {
    if (num == 0) return "ZERO";
    return convertBillionNumDigit(num);
  }

  // BILLION+
  public static String convertBillionNumDigit(int num) {

    if (num < BILLION)
      return convertMillionNumDigit(num);
    int MAIN_NUM = BILLION;
    StringBuilder sb = new StringBuilder();
    int whole = num / MAIN_NUM;
    sb.append(convertMillionNumDigit(whole)).append(" Billion");
    int remainder = num % MAIN_NUM;
    if (remainder > 0)
      sb.append(" ").append(convertMillionNumDigit(remainder));
    return sb.toString();
  }


  // MILLION - <BILLION
  public static String convertMillionNumDigit(int num) {

    if (num < MILLION)
      return convertFourNumDigit(num);
    int MAIN_NUM = MILLION;
    StringBuilder sb = new StringBuilder();
    int whole = num / MAIN_NUM;
    sb.append(convertFourNumDigit(whole)).append(" Million");
    int remainder = num % MAIN_NUM;
    if (remainder > 0)
      sb.append(" ").append(convertFourNumDigit(remainder));
    return sb.toString();
  }

  //1000-999999
  public static String convertFourNumDigit(int num) {

    if (num < 1000)
      return convertThreeDigit(num);
    int MAIN_NUM = 1000;
    StringBuilder sb = new StringBuilder();
    int whole = num / MAIN_NUM;
    sb.append(convertThreeDigit(whole)).append(" Thousand");
    int remainder = num % MAIN_NUM;
    if (remainder > 0)
      sb.append(" ").append(convertThreeDigit(remainder));
    return sb.toString();
  }

  //100-999
  public static String convertThreeDigit(int num) {

    if (num < 100)
      return convertTwoDigit(num);

    int MAIN_NUM = 100;
    StringBuilder sb = new StringBuilder();
    int whole = num / MAIN_NUM;
    sb.append(convertOneDigit(whole)).append(" Hundred");
    int remainder = num % MAIN_NUM;
    if (remainder > 0)
      sb.append(" ").append(convertTwoDigit(remainder));
    return sb.toString();
  }

  // 10 - 99
  public static String convertTwoDigit(int num) {

    if (num < 10)
      return convertOneDigit(num);

    switch (num) {
      case 10:
        return "Ten";
      case 11:
        return "Eleven";
      case 12:
        return "Twelve";
      case 13:
        return "Thirteen";
      case 14:
        return "Fourteen";
      case 15:
        return "Fifteen";
      case 16:
        return "Sixteen";
      case 17:
        return "Seventeen";
      case 18:
        return "Eighteen";
      case 19:
        return "Nineteen";
      case 20:
        return "Twenty";
    }
    int MAIN_NUM = 10;
    StringBuilder sb = new StringBuilder();
    int whole = num / MAIN_NUM;
    sb.append(mapTwoDigits(whole));
    int remainder = num % MAIN_NUM;
    if (remainder > 0)
      sb.append(" ").append(convertOneDigit(remainder));
    return sb.toString();
  }

  //1-9
  public static String convertOneDigit(int num) {

    switch (num) {
      case 1:
        return "One";
      case 2:
        return "Two";
      case 3:
        return "Three";
      case 4:
        return "Four";
      case 5:
        return "Five";
      case 6:
        return "Six";
      case 7:
        return "Seven";
      case 8:
        return "Eight";
      case 9:
        return "Nine";
    }
    return "";
  }

  public static String mapTwoDigits(int num) {

    switch (num) {
      case 2:
        return "Twenty";
      case 3:
        return "Thirty";
      case 4:
        return "Forty";
      case 5:
        return "Fifty";
      case 6:
        return "Sixty";
      case 7:
        return "Seventy";
      case 8:
        return "Eighty";
      case 9:
        return "Ninety";
    }
    return "";
  }
}
