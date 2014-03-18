package recipes.app;

import java.util.ArrayList;
import java.util.List;

import recipes.dao.RecipeDao;
import recipes.domain.Ingredient;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;

public class RecipeEditorDelegate {

	private final RecipeDao dao;
	private Recipe recipe;
	
	public RecipeEditorDelegate(RecipeDao dao, Recipe recipe) {
		this.dao = dao;
		this.recipe = recipe;
	}
	
	public Recipe getRecipe() {
		return recipe;
	}
	
	public boolean isEditMode() {
		return recipe != null;
	}
	
	public List<RecipeBook> getRecipeBooks() {
		return dao.getRecipeBooks();
	}
	
	public void saveRecipe(String name, RecipeBook book, String page, String ingredients) {
		if(isEditMode()) {
			updateRecipe(name, book, page, ingredients);
		} else {
			addNewRecipe(name, book, page, ingredients);
		}
	}
	
	private void addNewRecipe(String name, RecipeBook book, String page, String ingredients) {
		recipe = new Recipe();
		recipe.setName(name);
		recipe.setPageNumber(Integer.valueOf(page));
		recipe.setRecipeBook(book);
		
		List<Ingredient> ingredients2 = new ArrayList<>();
		
		String[] ingredientsArr = ingredients.split("\n");
		for(String i : ingredientsArr) {
			Ingredient e = new Ingredient();
			e.setDescription(i);
			ingredients2.add(e);
		}
		recipe.setIngredients(ingredients2);
		
		dao.addRecipe(recipe);
	}
	
	private void updateRecipe(String name, RecipeBook book, String page, String ingredients) {
		
		recipe.setName(name);
		recipe.setPageNumber(Integer.valueOf(page));
		recipe.setRecipeBook(book);
		
//		List<Ingredient> ingredients2 = new ArrayList<>();
//		
//		String[] ingredientsArr = ingredients.split("\n");
//		for(String i : ingredientsArr) {
//			Ingredient e = new Ingredient();
//			e.setDescription(i);
//			ingredients2.add(e);
//		}
//		recipe.setIngredients(ingredients2);
		
		dao.updateRecipe(recipe);
	}
}
