package Arrays;

public class Can_Place_Flowers_605 {

  public static void main(String[] args) {
    Can_Place_Flowers_605 obj = new Can_Place_Flowers_605();
    int[] flowerbed = new int[]{1, 0, 0, 0, 1, 0, 0};
    int n = 2;
    boolean ans = obj.canPlaceFlowers(flowerbed, n);
    System.out.println("ans= " + ans);
  }

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n == 0) return true;
    int l = flowerbed.length;
    if (l == 1) return flowerbed[0] == 0 && n <= 1;

    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
      flowerbed[0] = 1;
      n--;
    }

    if (flowerbed[l - 1] == 0 && flowerbed[l - 2] == 0) {
      flowerbed[l - 1] = 1;
      n--;
    }

    if (n <= 0) return true;

    int noOfSpotsAvailLeft = -1;
    for (int i = 0; i < l; i++) {
      int num = flowerbed[i];
      if (num == 1) {
        if (noOfSpotsAvailLeft >= 0) {
          int spotsAvailable = i - noOfSpotsAvailLeft;
          n = n - (spotsAvailable - 1) / 2;
        }
        noOfSpotsAvailLeft = -1;
      } else {
        if (noOfSpotsAvailLeft < 0)
          noOfSpotsAvailLeft = i;
      }
      if (n <= 0) return true;
    }

    if (noOfSpotsAvailLeft >= 0) {
      int spotsAvailable = l - noOfSpotsAvailLeft;
      n = n - (spotsAvailable - 1) / 2;
    }
    return n <= 0;
  }
}
