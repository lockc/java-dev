package recipes.domain;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }
    
    public Recipes createRecipes() {
    	return new Recipes();
    }
    
    public Recipe createRecipe() {
    	return new Recipe();
    }
    
    
    public Ingredient createIngredient() {
    	return new Ingredient();
    }
    
    
    public Ingredients createIngredients() {
    	return new Ingredients();
    }
    
    
    

}
