/**
 * 
 */
package recipes.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lockc
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Recipe {

	@XmlElement(name = "recipe-id", required = true)
	private int recipeId;
	@XmlElement(required = true)
	private String name;
	@XmlElement(required = true)
	private RecipeCategory category;
	@XmlElement(name = "carb-type", required = true)
	private CarbType carbType;
	@XmlElement(name = "recipe-book", required = true)
	private String recipeBook;
	@XmlElement(name = "page-number", required = true)
	private int pageNumber;
//	@XmlElementWrapper(name="ingredients")
//    @XmlElement(name="ingredient")
//	private List<Ingredient> ingredients;
	
	@XmlElementWrapper(name="ingredients")
    @XmlElement(name="ingredient")
	private List<String> ingredients;
	
	
	
	
	public Recipe() {
		super();
//		ingredients = new ArrayList<Ingredient>();
		ingredients = new ArrayList<String>();
	}





	public Recipe(String name, RecipeCategory category, CarbType carbType, String recipeBook, int pageNumber, Ingredients ingredients) {
		super();
		this.name = name;
		this.category = category;
		this.carbType = carbType;
		this.recipeBook = recipeBook;
		this.pageNumber = pageNumber;
		
//		this.ingredients = ingredients;
	}
	
	
	
	
	
	/**
	 * @return the recipeId
	 */
	public int getRecipeId() {
		return recipeId;
	}


	/**
	 * @param recipeId the recipeId to set
	 */
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

//	/**
//	 * @return the ingredients
//	 */
//	public List<Ingredient> getIngredients() {
//		return ingredients;
//	}
//
//
//	/**
//	 * @param ingredients the ingredients to set
//	 */
//	public void setIngredients(List<Ingredient> ingredients) {
//		this.ingredients = ingredients;
//	}

	/**
	 * @return the ingredients
	 */
	public List<String> getIngredients() {
		return ingredients;
	}


	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the carbType
	 */
	public CarbType getCarbType() {
		return carbType;
	}


	/**
	 * @param carbType the carbType to set
	 */
	public void setCarbType(CarbType carbType) {
		this.carbType = carbType;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the category
	 */
	public RecipeCategory getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(RecipeCategory category) {
		this.category = category;
	}




	/**
	 * @return the recipeBook
	 */
	public String getRecipeBook() {
		return recipeBook;
	}





	/**
	 * @param recipeBook the recipeBook to set
	 */
	public void setRecipeBook(String recipeBook) {
		this.recipeBook = recipeBook;
	}





	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}





	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Name: %s.", this.getName());
	}
	
	
	
	public String toSQL() {
		String sql = String.format("insert into recipes(name, category, carb_type) values('%s', '%s', '%s');", this.name, this.category, this.carbType);
		System.out.println(sql);
		return sql;
	}
	
	public String toShoppingListItem() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("---------------------------------------").append("\r\n");
		builder.append(this.getName()).append(".  (").append(this.getRecipeBook()).append(" p").append(this.getPageNumber()).append(").\r\n");
		builder.append("---------------------------------------").append("\r\n");
		
//		for(Ingredient ingredient : this.getIngredients()) {
//			builder.append(ingredient.getDescription()).append("\n");
//		}
		
		for(String ingredient : this.getIngredients()) {
			builder.append(ingredient).append("\r\n");
		}
		
		return builder.toString();
	}
	
	
}
