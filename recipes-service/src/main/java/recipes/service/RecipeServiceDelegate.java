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
	
	public Recipes recipesResourceGet() {
		Recipes recipes = new Recipes();
		recipes.setRecipes(dao.getAllRecipesShallow());
		return recipes;
	}

	public Recipe recipeResourceGet(int recipeId) {
		return dao.getRecipe(recipeId);
	}
	
	public void recipeResourcePost(Recipe recipe) {
		dao.updateRecipe(recipe);
	}
	
}

