/**
 * 
 */
package recipes.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

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

	
	private InputStream in;
	
	private String xml;
	

	private void loadXml(String file) throws IOException {
//		in = this.getClass().getClassLoader().getResourceAsStream(file);
		FileInputStream in = new FileInputStream(file);
		
		InputStreamReader is = new InputStreamReader(in);
		StringBuilder sb=new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read = br.readLine();

		while(read != null) {
		    //System.out.println(read);
		    sb.append(read);
		    read =br.readLine();

		}

		xml = sb.toString();
	}


	/* (non-Javadoc)
	 * @see recipe.dao.RecipeDao#getAllRecipes()
	 */
	@Override
	public List<Recipe> getAllRecipes()  {
		
		try {
			loadXml(System.getProperty("user.dir") + System.getProperty("file.separator") + "recipes.xml");
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
	
	/*
	 * (non-Javadoc)
	 * @see recipes.dao.RecipeDao#getIngredients(int)
	 */
	public List<Ingredient> getIngredients(int recipe_id) {
		return null;
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

}
