package recipes.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import recipes.domain.Recipe;
import recipes.serialisation.SerialisationException;
import recipes.serialisation.Serialiser;
import recipes.service.RecipeServiceDelegate;

@Path("recipes/{recipeId}")
public class RecipeResource {

	@Autowired(required=true)
	private RecipeServiceDelegate delegate;
	
	@Autowired(required=true)
	private Serialiser serialiser;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response recipes(@PathParam("recipeId") int recipeId) throws SerialisationException  {
		Recipe recipe = delegate.recipeResource(recipeId);
		return Response.ok(serialiser.serialise(recipe), MediaType.APPLICATION_XML).build();
	}
}
