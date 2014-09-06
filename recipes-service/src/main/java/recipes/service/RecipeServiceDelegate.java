package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import recipes.dao.RecipeDao;
import recipes.domain.Recipe;
import recipes.domain.Recipes;

@Component
public class RecipeServiceDelegate {

	@Autowired(required=true)
	private RecipeDao dao;
	
	public Recipes getRecipes() {
		Recipes recipes = new Recipes();
		recipes.setRecipes(dao.getAllRecipesShallow());
		return recipes;
	}

	public Recipe getRecipe(int recipeId) {
		return dao.getRecipe(recipeId);
	}
	
	public void postRecipe(Recipe recipe) {
		dao.updateRecipe(recipe);
	}
	
	public int putRecipe(Recipe recipe) {
		return dao.addRecipe(recipe);
	}
	
	public void deleteRecipe(int recipeId) {
		Recipe recipe = dao.getRecipe(recipeId);
		dao.deleteRecipe(recipe);
	}
	
}

