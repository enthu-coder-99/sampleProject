package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Design_A_Food_rating_system_2353 {

  public static void main(String[] args) {
    Design_A_Food_rating_system_2353 obj = new Design_A_Food_rating_system_2353();
    String[] foods = new String[]{"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"};
    String[] cuisines = new String[]{"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"};
    int[] ratings = new int[]{2, 6, 18, 6, 5};
    obj.FoodRatings(foods, cuisines, ratings);
    obj.changeRating("qnvseohnoe", 11);
    obj.highestRated("fajbervsj");
    obj.changeRating("emgqdbo", 3);
    obj.changeRating("jmvfxjohq", 9);
    obj.changeRating("emgqdbo", 14);
    obj.highestRated("fajbervsj");
    obj.highestRated("snaxol");


  }

  Map<String, TreeMap<Integer, Set<String>>> cuisineMap = new HashMap();
  Map<String, Integer> foodToRatingMap = new HashMap();
  Map<String, String> foodToCuisineMap = new HashMap<>();

  public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    int n = foods.length;
    for (int i = 0; i < n; i++) {
      String food = foods[i];
      String cuisine = cuisines[i];
      int rating = ratings[i];
      if (!cuisineMap.containsKey(cuisine)) {
        cuisineMap.put(cuisine, new TreeMap());
      }
      if (!cuisineMap.get(cuisine).containsKey(rating)) {
        cuisineMap.get(cuisine).put(rating, new TreeSet<>());
      }
      cuisineMap.get(cuisine).get(rating).add(food);
      foodToCuisineMap.put(food, cuisine);
      foodToRatingMap.put(food, rating);
    }

    System.out.println("foodToCuisineMap = " + foodToCuisineMap);
    System.out.println("foodToRatingMap = " + foodToRatingMap);
    System.out.println("cuisineMap = " + cuisineMap);

  }

  void changeRating(String food, int newRating) {
    System.out.println("newRating=" + newRating + ", food=" + food + ", cuisineMap = " + cuisineMap);
    String cuisine = foodToCuisineMap.get(food);
    TreeMap<Integer, Set<String>> ratingToFoodsMap = cuisineMap.get(cuisine);
    Integer oldRating = foodToRatingMap.get(food);
    ratingToFoodsMap.get(oldRating).remove(food);
    if (ratingToFoodsMap.get(oldRating).size() == 0) {
      ratingToFoodsMap.remove(oldRating);
    }
    if (!ratingToFoodsMap.containsKey(newRating)) {
      ratingToFoodsMap.put(newRating, new TreeSet<>());
    }
    ratingToFoodsMap.get(newRating).add(food);
    foodToRatingMap.put(food, newRating);
  }

  String highestRated(String cuisine) {
    TreeMap<Integer, Set<String>> foodToRatingsMap = cuisineMap.get(cuisine);
    System.out.println("cuisine=" + cuisine + ", foodToRatingsMap=" + foodToRatingsMap);
    Map.Entry<Integer, Set<String>> highestRatingEntry = foodToRatingsMap.lastEntry();
    if (highestRatingEntry != null)
      return highestRatingEntry.getValue().stream().findFirst().get();
    return "";
  }
}
