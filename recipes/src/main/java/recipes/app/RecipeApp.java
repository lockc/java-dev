package recipes.app;

import java.awt.EventQueue;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import recipes.dao.RecipeDao;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;
import recipes.gui.RecipesWindow;

/**
 * @author lockc
 *
 */
public class RecipeApp {

	public static Properties properties;
	
	private static RecipeDao dao;
	private static RecipeDao xmlDao;
	
	public static void main(String[] args) throws Exception {
		
		properties = new Properties();
		properties.load(RecipeApp.class.getClassLoader().getResourceAsStream("settings.properties"));
		PropertyConfigurator.configure("src/main/resources/settings.properties");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		dao = (RecipeDao) context.getBean("dao");
		xmlDao = (RecipeDao) context.getBean("xmlDao");
		
		xmlDao.getAllRecipes();
		
		final RecipesWindow window = (RecipesWindow) context.getBean("recipesWindow");
		
		
		EventQueue.invokeAndWait(new Runnable() {
			public void run() {
				window.show();
			}
		});
		
		
		
//		importXmlToSqlite();
		
	}
	
	
	
	private static void importXmlToSqlite() {
		
		List<Recipe> recipes = xmlDao.getAllRecipes();
		
		for(Recipe r : recipes) {
			
			RecipeBook book = dao.getRecipeBook(r.getRecipeBook().getName());
			if(book != null) {
				r.setRecipeBook(book);
			} else {
				RecipeBook newBook = new RecipeBook();
				newBook.setName(r.getRecipeBook().getName());
				dao.addRecipeBook(newBook);
				r.setRecipeBook(newBook);
			}
			
			dao.addRecipe(r);
			
		}
	}

}
