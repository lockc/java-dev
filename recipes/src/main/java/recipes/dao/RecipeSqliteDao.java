/**
 * 
 */
package recipes.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import recipes.domain.Ingredient;
import recipes.domain.Recipe;

/**
 * @author lockc
 *
 */
public class RecipeSqliteDao implements RecipeDao {

	static Logger logger = Logger.getLogger(RecipeSqliteDao.class);
	
	private SessionFactory sessionFactory;
	
	public RecipeSqliteDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	



	/* (non-Javadoc)
	 * @see recipe.dao.RecipeDao#getAllRecipes()
	 */
	@Override
	public List<Recipe> getAllRecipes()  {
		
		List<Recipe> recipes = new ArrayList<Recipe>();

		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Recipe");
			recipes = query.list();
		} finally {
			session.close();
		}
		
		
		return recipes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see recipes.dao.RecipeDao#getIngredients(int)
	 */
	public List<Ingredient> getIngredients(int recipe_id) {
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
		
		return ingredients;

}

}
