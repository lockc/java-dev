/**
 * 
 */
package recipes.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import recipes.dao.RecipeDao;
import recipes.domain.Ingredient;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;
import recipes.gui.RecipesWindow;

/**
 * @author lockc
 *
 */
public class RecipeApp {

	public static Properties properties;
	
	public static void main(String[] args) throws Exception {
		
		properties = new Properties();
		properties.load(RecipeApp.class.getClassLoader().getResourceAsStream("settings.properties"));
		PropertyConfigurator.configure("src/main/resources/settings.properties");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		
		RecipeDao dao = (RecipeDao) context.getBean("dao");
		
		Recipe recipe = new Recipe();
		recipe.setName("Yummy meal");
		recipe.setPageNumber(13);
		
		RecipeBook book = dao.getRecipeBook("book 3");

		if(book != null) {
			recipe.setRecipeBook(book);
		} else {
			RecipeBook newBook = new RecipeBook();
			newBook.setName("book 3");
			dao.addRecipeBook(newBook);
			recipe.setRecipeBook(newBook);
		}
		
		
		String [] ingredientsArray = new String[] {"garlic", "pork", "rice", "onion"};
		List<Ingredient> ingredients = new ArrayList<>();
		
		for(String s : ingredientsArray) {
			Ingredient e = new Ingredient();
			e.setDescription(s);
			ingredients.add(e);
		}
		
		recipe.setIngredients(ingredients);
		
		
		dao.addRecipe(recipe);
		
		
	}

}
