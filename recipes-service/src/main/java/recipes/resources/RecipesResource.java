package recipes.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import recipes.domain.Recipes;
import recipes.serialisation.SerialisationException;
import recipes.serialisation.Serialiser;
import recipes.service.RecipeServiceDelegate;

@Path("recipes")
public class RecipesResource {

	@Autowired(required=true)
	private RecipeServiceDelegate delegate;
	
	@Autowired(required=true)
	private Serialiser serialiser;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response recipes() throws SerialisationException  {
		Recipes recipes = delegate.recipesResourceGet();
		return Response.ok(serialiser.serialise(recipes), MediaType.APPLICATION_XML).build();
	}
}
