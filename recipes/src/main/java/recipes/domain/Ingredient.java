/**
 * 
 */
package recipes.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lockc
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ingredient {

	private int recipeId;
	
	@XmlElement(required = true)
	private String description;
	
	
	
	public Ingredient() {
		super();
	}
	public Ingredient(int recipeId, String description) {
		super();
		this.recipeId = recipeId;
		this.description = description;
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
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
