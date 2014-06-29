package recipes.tx;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import recipes.dao.RecipeDao;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;

public class RecipeManagerImpl implements RecipeManager {

	private RecipeDao recipeDao;
	
	public void setRecipeDao(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}

	@Override
	@Transactional
	public void addRecipe(Recipe recipe) {
		recipeDao.addRecipe(recipe);
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return recipeDao.getAllRecipes();
	}

	@Override
	public List<RecipeBook> getRecipeBooks() {
		return recipeDao.getRecipeBooks();
	}

	@Override
	public RecipeBook getRecipeBook(String name) {
		return recipeDao.getRecipeBook(name);
	}

	@Override
	public Recipe getRecipe(int recipeId) {
		return recipeDao.getRecipe(recipeId);
	}

	@Override
	public void addRecipeBook(RecipeBook recipeBook) {
		recipeDao.addRecipeBook(recipeBook);
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		recipeDao.updateRecipe(recipe);
	}

	@Override
	public void deleteIngredients(Recipe recipe) {
		recipeDao.deleteIngredients(recipe);
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		recipeDao.deleteRecipe(recipe);
	}

}
