package recipes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import recipes.serialisation.IngredientAdaptor;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Recipe implements Serializable {

	@XmlElement(name = "recipe-id", required = true)
	private int recipeId;
	
	@XmlElement(required = true)
	private String name;

	@XmlElement(name = "recipe-book")
	private RecipeBook recipeBook;
	
	@XmlElement(name = "page-number", required = true)
	private int pageNumber;

	@XmlElementWrapper(name="ingredients")
    @XmlElement(name="ingredient")
	@XmlJavaTypeAdapter(value=IngredientAdaptor.class)
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	@XmlElement(required = false)
	private Link link;

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RecipeBook getRecipeBook() {
		return recipeBook;
	}

	public void setRecipeBook(RecipeBook recipeBook) {
		this.recipeBook = recipeBook;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object object) {
		
		if(object == this) return true;
		
		if(!(object instanceof Recipe)) return false;
		
		Recipe recipe = (Recipe) object;
		
		if(recipe.getRecipeId() != this.getRecipeId()) return false;
		if(!recipe.getName().equals(this.getName())) return false;
		if(recipe.getPageNumber() != this.getPageNumber()) return false;
		if(!recipe.getRecipeBook().equals(this.getRecipeBook())) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + recipeId;
		result = 31 * result + pageNumber;
		result = 31 * result + recipeBook.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}
	

	public String toShoppingListItem() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("---------------------------------------").append("\r\n");
		builder.append(this.getName()).append(".  (").append(this.getRecipeBook()).append(" p").append(this.getPageNumber()).append(").\r\n");
		builder.append("---------------------------------------").append("\r\n");
				
		for(Ingredient ingredient : this.getIngredients()) {
			builder.append(ingredient.getDescription()).append("\r\n");
		}
		
		return builder.toString();
	}
	
	
}
