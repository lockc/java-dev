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
	
	
	public Recipes recipesResource() {
		Recipes recipes = new Recipes();
		recipes.setRecipes(dao.getAllRecipesShallow());
		return recipes;
	}

	public Recipe recipeResource(int recipeId) {
		return dao.getRecipe(recipeId);
	}
}

