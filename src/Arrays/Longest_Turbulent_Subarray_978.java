package Arrays;

public class Longest_Turbulent_Subarray_978 {

  public static void main(String[] args) {
    Longest_Turbulent_Subarray_978 obj = new Longest_Turbulent_Subarray_978();
    int[] input = {9, 4, 2, 10, 7, 8, 8, 1, 9};//5
    input = new int[]{4, 8};//2
    int ans = obj.maxTurbulenceSize(input);
    System.out.println("Answer = " + ans);
  }

  public int maxTurbulenceSize(int[] arr) {
    int l = arr.length;
    if (l <= 1) return l;
    if (l == 2) return (arr[0] - arr[1]) == 0 ? 1 : 2;

    int ans = 1;
    int left = 0;
    int right = 0;
    for (int i = 1; i < l - 1; i++) {
      int num = arr[i];
      if (num == arr[i - 1]) {
        left = i;
      } else if (isValleyOrMountan(i, arr)) {
        right = i + 1;
      } else {
        left = i;
        right = i + 1;
      }
      ans = Math.max(ans, right - left + 1);
      System.out.println(i + ", num=" + num + " ans=" + ans + ", isValleyOrMountan= " + isValleyOrMountan(i, arr));
    }
    return ans;
  }

  private boolean isValleyOrMountan(int index, int[] arr) {
    return isValleyOrMountan(arr[index - 1], arr[index], arr[index + 1]);
  }

  private boolean isValleyOrMountan(int num1, int num2, int num3) {
    return (num1 < num2 && num2 > num3) || (num1 > num2 && num2 < num3);
  }
}
