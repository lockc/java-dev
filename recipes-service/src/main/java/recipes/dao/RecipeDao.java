package recipes.dao;

import java.util.List;

import recipes.domain.RecipeBook;
import recipes.domain.Recipe;

public interface RecipeDao {

	List<Recipe> getAllRecipes();
	
	List<Recipe> getAllRecipesShallow();
	
	List<RecipeBook> getRecipeBooks();
	
	RecipeBook getRecipeBook(String name);
	
	Recipe getRecipe(int recipeId);
	
	void addRecipeBook(RecipeBook recipeBook);
	
	int addRecipe(Recipe recipe);
	
	void updateRecipe(Recipe recipe);

	void deleteIngredients(Recipe recipe);

	void deleteRecipe(Recipe recipe);
	
}
