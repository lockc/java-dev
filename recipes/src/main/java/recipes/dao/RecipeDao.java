/**
 * 
 */
package recipes.dao;

import java.util.List;

import recipes.domain.Ingredient;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;

/**
 * @author lockc
 *
 */
public interface RecipeDao {

	List<Recipe> getAllRecipes();
	
	List<RecipeBook> getRecipeBooks();
	
	RecipeBook getRecipeBook(String name);
	
	Recipe getRecipe(long recipeId);
	
	void addRecipeBook(RecipeBook recipeBook);
	
	void addRecipe(Recipe recipe);
	
	void updateRecipe(Recipe recipe);

	void deleteIngredients(Recipe recipe);

	void deleteRecipe(Recipe recipe);
	
}
