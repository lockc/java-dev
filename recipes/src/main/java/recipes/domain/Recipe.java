package recipes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author lockc
 *
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="recipes")
public class Recipe implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="ID", unique=true, nullable=false)
	@XmlElement(name = "recipe-id", required = true)
	private int recipeId;
	
	@Column(name="NAME", unique=false, nullable=false)
	@XmlElement(required = true)
	private String name;
	
	@Transient
	@XmlElement(required = true)
	private RecipeCategory category;
	
	@Transient
	@XmlElement(name = "carb-type", required = true)
	private CarbType carbType;
	
	/*
	 * Many recipes can have the same recipe book.  This relationship is unidirectional
	 * in that the RecipeBook class doesn't have a list of recipes.
	 */
	@ManyToOne(fetch=FetchType.EAGER)  
	@JoinColumn(name="RECIPE_BOOK_ID")
	@XmlElement(required = true)
	private RecipeBook recipeBook;
	
	@Column(name="PAGE_NO", unique=true, nullable=false)
	@XmlElement(name = "page-number", required = true)
	private int pageNumber;

	/**
	 * N.B. 
	 * 
	 * CascadeType.ALL ensures that the List of ingredients are persisted with the
	 * recipe.  Without this Transient object errors are thrown because the list isn't
	 * a persisted object.
	 */
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="RECIPE_ID")
	@XmlElementWrapper(name="ingredients")
    @XmlElement(name="ingredient")
	private List<Ingredient> ingredients;
	
	
	
	
	public Recipe() {
		super();
		ingredients = new ArrayList<Ingredient>();
	}





	public Recipe(String name, RecipeCategory category, CarbType carbType, RecipeBook recipeBook, int pageNumber, Ingredients ingredients) {
		super();
		this.name = name;
		this.category = category;
		this.carbType = carbType;
		this.recipeBook = recipeBook;
		this.pageNumber = pageNumber;
	}
	
	

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

	public CarbType getCarbType() {
		return carbType;
	}

	public void setCarbType(CarbType carbType) {
		this.carbType = carbType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RecipeCategory getCategory() {
		return category;
	}

	public void setCategory(RecipeCategory category) {
		this.category = category;
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





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Name: %s.", this.getName());
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
