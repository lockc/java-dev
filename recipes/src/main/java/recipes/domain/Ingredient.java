package recipes.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author lockc
 *
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="ingredients")
public class Ingredient implements Serializable {

	@XmlTransient
	@Id
	@Column(name="ID", unique=true, nullable=false)
	@GeneratedValue
	private int id;
	
	@XmlTransient
	@Column(name="RECIPE_ID", unique=false)
	private int recipeId;
	
	@Column(name="DESC", unique=false)
	@XmlElement
	private String description;
	
//	@ManyToOne
//	private Recipe recipe;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecipeId() {
		return recipeId;
	}
	
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return getDescription();
	}
}
