package algo.graph.topoSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Find_All_Possible_Recipes_from_Given_Supplies_2115 {

  Set<String> recipeReadySet = new HashSet();
  Map<Integer, List<Integer>> parentToChildRecipeIMap = new HashMap<>();
  Map<String, Integer> recipeNameToIndexMap = new HashMap<>();

  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    buildAdjList(supplies, recipes);
    List<String> ans = new ArrayList<>();
    int l = recipes.length;
    int[] preRecipeCount = new int[l];
    for (int i = 0; i < l; i++) {
      int recipe_i = i;
      List<String> ingreList = ingredients.get(i);
      for (String ingre : ingreList) {
        if (!recipeReadySet.contains(ingre)) {
          // i.e. ingre can be a Recipe OR the ingre is not available.
          preRecipeCount[i]++;

          if (recipeNameToIndexMap.containsKey(ingre)) {
            // Ingre is a Recipe as well.
            int parentRecipe_i = recipeNameToIndexMap.get(ingre);
            if (!parentToChildRecipeIMap.containsKey(parentRecipe_i))
              parentToChildRecipeIMap.put(parentRecipe_i, new ArrayList<>());
            parentToChildRecipeIMap.get(parentRecipe_i).add(recipe_i);
          }
        }
      }
    }

    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < l; i++) {
      if (preRecipeCount[i] == 0) {
        // This recipe is ready.. Hurrah
        int recipe_i = i;
        deque.add(recipe_i);
      }
    }
    while (deque.size() > 0) {
      int recipe_id = deque.pop();// This recipe is ready.. so make child recipe also partial/fully ready.
      recipeReadySet.add(recipes[recipe_id]);
      if (parentToChildRecipeIMap.containsKey(recipe_id)) {
        List<Integer> childRecipeIds = parentToChildRecipeIMap.get(recipe_id);
        for (int childRecipeId : childRecipeIds) {
          preRecipeCount[childRecipeId]--;
          if (preRecipeCount[childRecipeId] == 0) {
            deque.add(childRecipeId);
          }
        }
      }
    }

    for (int i = 0; i < recipes.length; i++) {
      String recipeName = recipes[i];
      if (recipeReadySet.contains(recipeName))
        ans.add(recipeName);
    }
    return ans;
  }


  public void buildAdjList(String[] supplies, String[] recipes) {
    for (String s : supplies) {
      recipeReadySet.add(s);
    }

    for (int i = 0; i < recipes.length; i++) {
      recipeNameToIndexMap.put(recipes[i], i);
    }
  }


}
