/**
 * 
 */
package recipes.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import recipes.domain.Ingredient;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;

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
	
	@Override
	public Recipe getRecipe(long recipeId) {
		Recipe recipe = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Recipe where ID = :recipe_id");
			query.setParameter("recipe_id", recipeId);
			recipe = (Recipe) query.uniqueResult();
		} finally {
			session.close();
		}
		
		return recipe;
	}
	
	@Override
	public void addRecipe(Recipe recipe) {
		
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session .beginTransaction();
			session.save(recipe);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void updateRecipe(Recipe recipe) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session .beginTransaction();
			session.update(recipe);
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void deleteIngredients(Recipe recipe) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session .beginTransaction();
			session.delete(recipe.getIngredients());
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<RecipeBook> getRecipeBooks() {
		List<RecipeBook> recipesBooks = new ArrayList<RecipeBook>();

		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from RecipeBook");
			recipesBooks = query.list();
		} finally {
			session.close();
		}
		return recipesBooks;
	}

	@Override
	public RecipeBook getRecipeBook(String name) {
		RecipeBook recipeBook = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from RecipeBook where NAME = :name");
			query.setParameter("name", name);
			recipeBook = (RecipeBook) query.uniqueResult();
		} finally {
			session.close();
		}
		
		
		return recipeBook;
	}

	@Override
	public void addRecipeBook(RecipeBook recipeBook) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session .beginTransaction();
			session.save(recipeBook);
			session.getTransaction().commit();
		} finally {
			session.close();
		}	
	}




	@Override
	public void deleteRecipe(Recipe recipe) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session .beginTransaction();
			
			Iterator<Ingredient> it = recipe.getIngredients().iterator();
			while (it.hasNext()) {
				Ingredient i = it.next();
				it.remove();
				session.delete(i);
			}
			
			session.delete(recipe);
			session.flush(); 
			session.getTransaction().commit();
		} finally {
			session.close();
		}	
	}
	





	




	



	

}
