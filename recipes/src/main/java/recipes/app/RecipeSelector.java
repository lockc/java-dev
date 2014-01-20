/**
 * 
 */
package recipes.app;

import java.util.List;

import recipes.domain.Recipe;

/**
 * @author lockc
 *
 */
public interface RecipeSelector {

	
	 List<Recipe> selectRecipes(List<Recipe> recipes,  int howMany);
	
	 public String creatShoppingList(List<Recipe> recipes); 
}
