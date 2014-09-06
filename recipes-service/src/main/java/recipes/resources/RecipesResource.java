package recipes.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import recipes.domain.Recipe;
import recipes.domain.Recipes;
import recipes.service.RecipeServiceDelegate;

@Path("recipes")
public class RecipesResource {

	@Autowired(required=true)
	private RecipeServiceDelegate delegate;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getRecipes() {
		Recipes recipes = delegate.getRecipes();
		return Response.ok(recipes, MediaType.APPLICATION_XML).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response createRecipe(Recipe recipe) {
		int recipeId = delegate.putRecipe(recipe);
		URI responseUri = null;
		
		// TODO
		try {
			responseUri = new URI("http://localhost:8080/recipes/" + recipeId);
		} catch (URISyntaxException e) {
		}
		return Response.created(responseUri).build();
	}
}
