/**
 * 
 */
package recipes.dao;

import java.util.List;

import recipes.domain.Ingredient;
import recipes.domain.Recipe;

/**
 * @author lockc
 *
 */
public interface RecipeDao {

	List<Recipe> getAllRecipes() throws Exception;
	
	List<Ingredient> getIngredients(int recipe_id);
}
