/**
 * 
 */
package recipes.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import recipes.domain.Ingredient;
import recipes.domain.Recipe;
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
	public List<Recipe> getAllRecipes() throws Exception  {
		
		loadXml(System.getProperty("user.dir") + System.getProperty("file.separator") + "recipes.xml");
		
		Recipes recipes = (Recipes) new XmlSerialiser().deserialise(xml, Recipes.class);
		
		return recipes.getRecipes();
	}
	
	/*
	 * (non-Javadoc)
	 * @see recipes.dao.RecipeDao#getIngredients(int)
	 */
	public List<Ingredient> getIngredients(int recipe_id) {
		return null;
	}

}
