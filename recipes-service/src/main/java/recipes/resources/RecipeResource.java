package recipes.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import recipes.domain.Recipe;
import recipes.service.RecipeServiceDelegate;

@Path("recipes/{recipeId}")
public class RecipeResource {

	@Autowired(required=true)
	private RecipeServiceDelegate delegate;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getRecipe(@PathParam("recipeId") int recipeId) {
		Recipe recipe = delegate.getRecipe(recipeId);
		return Response.ok(recipe, MediaType.APPLICATION_XML).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateRecipe(@PathParam("recipeId") int recipeId, Recipe recipe) {
		if (recipeId != recipe.getRecipeId()) {
			throw new RuntimeException("BadRequest!");
		}
		delegate.postRecipe(recipe);
		return Response.ok().build();
	}
	
	@DELETE
	public Response deleteRecipe(@PathParam("recipeId") int recipeId) {
		delegate.deleteRecipe(recipeId);
		return Response.ok().build();
	}
}
