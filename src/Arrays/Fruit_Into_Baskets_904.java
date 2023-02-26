package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Fruit_Into_Baskets_904 {

  public static void main(String[] args) {
    System.err.println(totalFruit(new int[]{1, 2, 1}));
    System.err.println(totalFruit(new int[]{0, 1, 2, 2}));
    System.err.println(totalFruit(new int[]{1, 2, 3, 2, 2}));

  }

  public static int totalFruit(int[] fruits) {
    if (fruits.length < 3) return fruits.length;
    Map<Integer, Integer> fruitsCounts = new HashMap<>();
    int startingIndex = 0;
    int maxNosOfFruits = 0;
    for (int i = 0; i < fruits.length; i++) {
      int fruit = fruits[i];
      if (fruitsCounts.size() >= 2 && !fruitsCounts.containsKey(fruit)) {
        maxNosOfFruits = Math.max(maxNosOfFruits, i - startingIndex);
        // No more new types of Fruits can be accomodated. so remove one fruit.
        int lastFruitType = fruits[i - 1];// This fruit will continue.
        Integer oldFruitType = null;
        for (Integer fruitType : fruitsCounts.keySet()) {
          if (fruitType != lastFruitType) {
            oldFruitType = fruitType;
            Integer removedFruitLastIndex = fruitsCounts.get(oldFruitType);
            startingIndex = removedFruitLastIndex + 1;
          }
        }
        fruitsCounts.remove(oldFruitType);
        fruitsCounts.put(fruit, i);
      } else {
        fruitsCounts.put(fruit, i);
      }
    }

    maxNosOfFruits = Math.max(maxNosOfFruits, fruits.length - startingIndex);

    return maxNosOfFruits;
  }
}
