/**
 * 
 */
package recipes.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;

import recipes.domain.Ingredient;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;
import recipes.domain.Recipes;
import recipes.serialisation.XmlSerialiser;

/**
 * @author lockc
 *
 */
public class RecipeXmlDao implements RecipeDao {

	private Resource xmlResource;
	private String xml;
	
	public RecipeXmlDao(Resource xmlResource) {
		this.xmlResource = xmlResource;
	}
	


	/* (non-Javadoc)
	 * @see recipe.dao.RecipeDao#getAllRecipes()
	 */
	@Override
	public List<Recipe> getAllRecipes()  {
		
		try {
//			loadXml(System.getProperty("user.dir") + System.getProperty("file.separator") + "recipes.xml");
			loadXml(xmlResource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Recipe>();
		}
		
		Recipes recipes = null;
		try {
			recipes = (Recipes) new XmlSerialiser().deserialise(xml, Recipes.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return recipes != null ? recipes.getRecipes() : new ArrayList<Recipe>();
	}
	
	@Override
	public void addRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<RecipeBook> getRecipeBooks() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RecipeBook getRecipeBook(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addRecipeBook(RecipeBook recipeBook) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Recipe getRecipe(long recipeId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}

	
	
	private void loadXml(Resource resource) throws IOException {
//		in = this.getClass().getClassLoader().getResourceAsStream(file);
		InputStreamReader is = new InputStreamReader(resource.getInputStream());
		StringBuilder sb=new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read = br.readLine();

		while(read != null) {
		    sb.append(read);
		    read =br.readLine();

		}

		xml = sb.toString();
	}



	@Override
	public void deleteIngredients(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}
}
