/**
 * 
 */
package recipes.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

//import com.almworks.sqlite4java.SQLiteConnection;
//import com.almworks.sqlite4java.SQLiteException;
//import com.almworks.sqlite4java.SQLiteStatement;

import recipes.app.RecipeApp;
import recipes.domain.CarbType;
import recipes.domain.Ingredient;
import recipes.domain.Ingredients;
import recipes.domain.Recipe;
import recipes.domain.RecipeCategory;

/**
 * @author lockc
 *
 */
public class RecipeSqliteDao implements RecipeDao {

	static Logger logger = Logger.getLogger(RecipeSqliteDao.class);
	
	private Recipe[] recipes;
	
	private String dbUrl ="";
	
	public RecipeSqliteDao() {
		
		dbUrl = RecipeApp.properties.getProperty("db.url");
		
//		// TODO: replace this with SQLite DB
//		recipes = new Recipe[] {
//				
//				// Meat
//				new Recipe("Spaghetti Bolognese", RecipeCategory.MEAT, CarbType.PASTA, null),
//				new Recipe("Meatballs", RecipeCategory.MEAT, CarbType.PASTA, null),
//				new Recipe("Creamy Pasta", RecipeCategory.MEAT, CarbType.PASTA, null),
//				new Recipe("Spaghetti Carbonara", RecipeCategory.MEAT, CarbType.PASTA, null),
//				new Recipe("Potee Champenoise", RecipeCategory.MEAT, CarbType.POTATO, null),
//				new Recipe("Cilli Concarne", RecipeCategory.MEAT, CarbType.RICE, null),
//				new Recipe("Beef Stir fry", RecipeCategory.MEAT, CarbType.RICE, null),
//				new Recipe("Hyderbadi Lamb with Tomatoes", RecipeCategory.MEAT, CarbType.BREAD, null),
//				new Recipe("Moghlai Lamb with Spinach", RecipeCategory.MEAT, CarbType.RICE, null),
//				new Recipe("Lamb Tagine", RecipeCategory.MEAT, CarbType.RICE, null),
//				new Recipe("Sausage Casserole", RecipeCategory.MEAT, CarbType.POTATO, null),
//				new Recipe("Shepherds pie", RecipeCategory.MEAT, CarbType.POTATO, null),
//				new Recipe("Cottage pie", RecipeCategory.MEAT, CarbType.POTATO, null),
//				
//
//				
//				
//				
//				// Poultry
//				new Recipe("Thai style chicken and noodles", RecipeCategory.POULTRY, CarbType.NOODLES, null),
//				new Recipe("Thai chicken curry", RecipeCategory.POULTRY, CarbType.RICE, null),
//				new Recipe("Chicken pie", RecipeCategory.POULTRY, CarbType.POTATO, null),
//				new Recipe("Chicken Stir fry ", RecipeCategory.POULTRY, CarbType.RICE, null),
//				new Recipe("Delia chicken and rice ", RecipeCategory.POULTRY, CarbType.RICE, null),
//				new Recipe("Chicken and creme fraiche", RecipeCategory.POULTRY, CarbType.POTATO, null),
//				new Recipe("Mediterranean chicken in rice", RecipeCategory.POULTRY, CarbType.RICE, null),
//				
//				// Fish
//				new Recipe("Salmaon and broccoli bake", RecipeCategory.FISH, CarbType.PASTA, null),
//				new Recipe("Fish pie", RecipeCategory.FISH, CarbType.POTATO, null),
//				new Recipe("Thai style prawns and noodles", RecipeCategory.FISH, CarbType.NOODLES, null),
//				new Recipe("Prawn Stir fry ", RecipeCategory.FISH, CarbType.RICE, null),
//				new Recipe("Fish fingers", RecipeCategory.FISH, CarbType.POTATO, null),
//				new Recipe("Salmon/Trout with pesto crust", RecipeCategory.FISH, CarbType.POTATO, null),
//				new Recipe("Fish in white parsley sauce", RecipeCategory.FISH, CarbType.POTATO, null),
//				new Recipe("Fish w/couscous salad", RecipeCategory.FISH, CarbType.RICE, null),
//				
//				// Veg
//				new Recipe("Thai style veg and noodles", RecipeCategory.VEG, CarbType.NOODLES, null),
//				new Recipe("Pasta with tomato sauce", RecipeCategory.VEG, CarbType.PASTA, null),
//				new Recipe("Fersh pesto pasta", RecipeCategory.VEG, CarbType.PASTA, null),
//				new Recipe("Vegetable curry", RecipeCategory.VEG, CarbType.RICE, null),
//				new Recipe("Jacket potato and salad", RecipeCategory.VEG, CarbType.POTATO, null)
//		};		
//		for(Recipe r : recipes) {
//			r.toSQL();
//		}
		
	}




	/* (non-Javadoc)
	 * @see recipe.dao.RecipeDao#getAllRecipes()
	 */
	@Override
	public List<Recipe> getAllRecipes()  {
		
		List<Recipe> recipes = new ArrayList<Recipe>();
//		
////		String query = "select * from recipes;";
//		String query = "select r.id, r.name, r.category, r.carb_type, rb.name, r.page_number from recipes r, recipe_books rb where rb.id = r.recipe_book_id or r.recipe_book_id is null;";
//		
//		SQLiteConnection db = new SQLiteConnection(new File(dbUrl));
//	    try {
//			db.open(true);
//			
//			SQLiteStatement st = db.prepare(query);
//
//			try {
//			      
//			      while (st.step()) {
//			        int id = st.columnInt(0);
//			        String name = st.columnString(1);
//			        String cat = st.columnString(2);
//			        String carbType = st.columnString(3);
//			        String book = st.columnString(4);
//			        int page_no = st.columnInt(5); 
//			        
//			        logger.debug(String.format("ID: %d, Name: %s, Category: %s, Carb Type: %s, Recipe Book: %s, PAge Number %d", id, name, cat, carbType, book, page_no));
//			        
//			        Recipe r = new Recipe(name, RecipeCategory.valueOf(cat), CarbType.valueOf(carbType), book, page_no, new Ingredients());
//			        r.setRecipeId(id);
//			        			        
//			        recipes.add(r);
//			        
//			      }
//			      
//			      
//			    } finally {
//			      st.dispose();
//			    }
//
//			
//		} catch (SQLiteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//			db.dispose();
//		}
		
		return recipes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see recipes.dao.RecipeDao#getIngredients(int)
	 */
	public List<Ingredient> getIngredients(int recipe_id) {
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
//		String query = "select * from ingredients where recipe_id = %s;";
//		
//		SQLiteConnection db = new SQLiteConnection(new File(dbUrl));
//	    try {
//			db.open(true);
//			
//			SQLiteStatement st = db.prepare(String.format(query, recipe_id));
//
//			try {
//			      
//			      while (st.step()) {
//			        int id = st.columnInt(0);
//			        String description = st.columnString(1);
//			        
//			        logger.debug(String.format("Ingredient ID: %d, Desc: %s, Recipe ID: %s", id, description, recipe_id));
//			        
//			        ingredients.add(new Ingredient(recipe_id, description));
//			        
//			      }
//			      
//			      
//			    } finally {
//			      st.dispose();
//			    }
//
//			
//		} catch (SQLiteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//			db.dispose();
//		}
		
		return ingredients;

}

}
