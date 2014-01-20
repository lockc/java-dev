/**
 * 
 */
package recipes.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.log4j.Logger;

import recipes.dao.RecipeDao;
import recipes.dao.RecipeSqliteDao;
import recipes.domain.Ingredient;
import recipes.domain.Recipe;
import recipes.domain.RecipeCategory;

/**
 * @author lockc
 *
 */
public class RecipeSelectorImpl implements RecipeSelector {

	static Logger logger = Logger.getLogger(RecipeSelectorImpl.class);
	
	private List<Recipe> recipes;
	private Map<RecipeCategory, Integer> categorySpread; 
	
	
	/**
	 * @return the recipes
	 */
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see recipe.app.RecipeSelector#selectRecipes(recipes.domain.Recipe[], int)
	 */
	@Override
	public List<Recipe> selectRecipes(List<Recipe> recipes,  int howMany) {


		this.recipes = new ArrayList<Recipe>();
		categorySpread = new HashMap<RecipeCategory, Integer>();
		
		Random random = new Random();
		int max = recipes.size();
		int min = 0;
		
		int selected = 0;
		while(selected++ < howMany) {
			int randomNumber = random.nextInt(max - min) + min;
			Recipe recipe = recipes.get(randomNumber);
			
			if(alreadySelected(recipe)) {
				logger.info("Meal already selected.  " + recipe.toString());
				selected--;
				continue;
			} 
			
			if(checkCategoryTally(recipe, this.recipes)) {
				logger.info("Meal category already selected.  " + recipe.toString());
				selected--;
				continue;
			}
			addToCategoryTally(recipe);
			
			logger.info("Selecting meal.  " + recipe.toString());
			
			RecipeDao dao = new RecipeSqliteDao();
			
			List<Ingredient> ingredients = dao.getIngredients(recipe.getRecipeId());
			
			List<String> newIngredients = new ArrayList<String>();
			for(Ingredient i : ingredients) {
				newIngredients.add(i.getDescription());
			}
			
			recipe.getIngredients().addAll(newIngredients);
			
			
			this.recipes.add(recipe);
		}
		
		
		return this.recipes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see recipes.app.RecipeSelector#creatShoppingList(java.util.List)
	 */
	@Override
	public String creatShoppingList(List<Recipe> recipes) {
		StringBuilder builder = new StringBuilder();
		
		for(Recipe recipe : recipes) {
			builder.append(recipe.toShoppingListItem());
		}
		
		return builder.toString();
	}

	
	
	/**
	 * Adds this meal to the meal category tally
	 * 
	 * @param recipe
	 */
	private void addToCategoryTally(Recipe recipe) {
		
		if(!categorySpread.containsKey(recipe.getCategory())) {
			// Category not found so add it and set to 1 recipe of this category
			categorySpread.put(recipe.getCategory(), 1);
			return;
		} 
		// if category already found then add one to existing number
		int alreadyFound = categorySpread.get(recipe.getCategory());
		alreadyFound++;
		categorySpread.remove(recipe.getCategory());
		categorySpread.put(recipe.getCategory(), alreadyFound);
		
	}
	
	
	/**
	 * Checks the tally of meal categories so we get an even spread
	 * 
	 * @param recipe
	 * @param selected
	 * @return
	 */
	private boolean checkCategoryTally(Recipe recipe, List<Recipe> selected) {
			
		RecipeCategory category = recipe.getCategory();
		
		/*
		 * if the category isn't even listed then we can certainly select the meal
		 */
		if(!categorySpread.containsKey(category)) {
			logger.info("Not even listed yet :" + recipe.getName());
			return false;
		}
		
		/*
		 * How many of this category do we already have 
		 */
		int alreadyHas = categorySpread.get(category);
		
		
		/*
		 * Go through the current category tally and check if this category is less
		 * than the others, if it is we can add it
		 */
		boolean sameAsAllOthers = true;
		
		for(Entry<RecipeCategory, Integer> entries : categorySpread.entrySet()) {
			
			RecipeCategory entryCat = entries.getKey();
			
			
			if(!entryCat.equals(category)) {
				int entryValue = entries.getValue();
				
				/*
				 * If it's less then ANY of the other categories then we can add it
				 */
				if(alreadyHas < entryValue) {
					logger.info("Less than one of the others :" + recipe.getName());
					return false;
				}
				
				/*
				 * if it's greater than ANY other category then we can't add it
				 */
				if(alreadyHas > entryValue) {
					logger.info("More than one of the others :" + recipe.getName());
					return true;
				}
				
				/*
				 * if it the same as ALL other categories the we can add it
				 */
				sameAsAllOthers = sameAsAllOthers && (alreadyHas == entryValue);
				
				
				
			}	
		}
		
		if (allCategoriesHaveBeenSelected()) {
			// yes, then we can add this recipe
			logger.info("All the same category all categories selected picking recipe :" + recipe.getName());
			return false;
		}
		// not all categores selected yet so no, cannot pipck this recipe
		logger.info("All the same categfory but not all categories selected, cannot pick recipe :" + recipe.getName());
		return true;
	}
	
	
	private boolean allCategoriesHaveBeenSelected() {
		for(RecipeCategory category : RecipeCategory.values()) {
			if(!categorySpread.containsKey(category)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	private boolean alreadySelected(Recipe recipe) {
		return this.recipes.contains(recipe);
	}

	

}
