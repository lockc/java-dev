package recipes.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RecipeBook implements Serializable {

	@XmlElement(required = true)
	private int id;
	
	@XmlElement(required = true)
	private String name;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object object) {
		
		if(object == this) return true;
		
		if(!(object instanceof RecipeBook)) return false;
		
		RecipeBook book = (RecipeBook) object;
		
		if(book.getId() != this.getId()) return false;
		if(!book.getName().equals(this.getName())) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + id;
		result = 31 * result + name.hashCode();
		return result;
	}
}
