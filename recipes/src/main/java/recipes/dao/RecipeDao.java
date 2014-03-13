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
	
	void addRecipeBook(RecipeBook recipeBook);
	
	void addRecipe(Recipe recipe);
	
	
	List<Ingredient> getIngredients(int recipe_id);
}
