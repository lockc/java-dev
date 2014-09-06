package recipes.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import recipes.domain.Ingredient;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;

public class ClientApp {

	private static Client client = ClientBuilder.newClient();
	
	public static void main(String[] args) {
		
		
		createRecipe();
		
	}
	
	
	
	public static void createRecipe() {
		
		RecipeBook recipeBook = new RecipeBook();
		recipeBook.setId(3);
		
		Ingredient i = new Ingredient();
		i.setDescription("Yummy stuff");
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(i);
		
		Recipe r = new Recipe();
		r.setName("Test Meal 1");
		r.setPageNumber(12);
		r.setRecipeBook(recipeBook);
		r.setIngredients(ingredients);
		
		
		WebTarget webTarget = client.target("http://localhost:8080/recipes");
		Invocation.Builder invocationBuilder =
				webTarget.request(MediaType.APPLICATION_XML);
		
		
		Response response = invocationBuilder.put(Entity.entity(r, MediaType.APPLICATION_XML), Response.class);
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
	}
	
	
	public static void deleteRecipe() {
		
		RecipeBook recipeBook = new RecipeBook();
		recipeBook.setId(3);
		
		Ingredient i = new Ingredient();
		i.setDescription("Yummy stuff");
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(i);
		
		Recipe r = new Recipe();
		r.setName("Test Meal 1");
		r.setPageNumber(12);
		r.setRecipeBook(recipeBook);
		r.setIngredients(ingredients);
		
		
		WebTarget webTarget = client.target("http://localhost:8080/recipes");
		Invocation.Builder invocationBuilder =
				webTarget.request(MediaType.APPLICATION_XML);
		
		
		Response response = invocationBuilder.put(Entity.entity(r, MediaType.APPLICATION_XML), Response.class);
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		
	}

}
