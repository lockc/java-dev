package recipes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import recipes.domain.Ingredient;
import recipes.domain.RecipeBook;
import recipes.domain.Recipe;

public class RecipeDaoJdbcImpl extends JdbcDaoSupport implements RecipeDao {
	
	@Override
	public List<Recipe> getAllRecipes() {
		return doGetAllRecipes();
	}
	
	@Override
	public List<Recipe> getAllRecipesShallow() {
		return doGetAllRecipesShallow();
	}
	
	@Override
	public Recipe getRecipe(int recipeId) {
		return doGetRecipe(recipeId);
	}

	@Override
	public List<RecipeBook> getRecipeBooks() {
		return doGetRecipeBooks();
	}
	
	@Override
	public RecipeBook getRecipeBook(String name) {
		return doGetRecipeBook(name);
	}

	@Override
	public void addRecipeBook(RecipeBook recipeBook) {
		// TODO Auto-generated method stub

	} 

	@Override
	public void addRecipe(Recipe recipe) {
		doInsertRecipe(recipe);
		int recipeId = getRecipeId(recipe.getName());
		recipe.setRecipeId(recipeId);
		doInsertIngredients(recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		doUpdateRecipe(recipe);
		doDeleteIngredients(recipe);
		doInsertIngredients(recipe);
	}

	@Override
	public void deleteIngredients(Recipe recipe) {
		doDeleteIngredients(recipe);
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		doDeleteIngredients(recipe);
		doDeleteRecipe(recipe.getRecipeId());
	}
	
	
	
	
	private void doUpdateRecipe(final Recipe recipe) {
		getJdbcTemplate().update(new PreparedStatementCreator() {
			String sql = "update recipes set name=?, recipe_book_id=?, page_no=? "
					+ "where id=?";	
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, recipe.getName());
				ps.setInt(2, recipe.getRecipeBook().getId());
				ps.setInt(3, recipe.getPageNumber());
				ps.setInt(4, recipe.getRecipeId());
				return ps;
			}
		});
	}
	
	private void doDeleteIngredients(Recipe recipe) {
		final int recipeId = recipe.getRecipeId();
		
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "delete from ingredients where recipe_id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, recipeId);
				return ps;
			}
		});
	}
	
	private void doDeleteRecipe(final int recipeId) {
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "delete from recipes where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, recipeId);
				return ps;
			}
		});
	}
	
	private List<RecipeBook> doGetRecipeBooks() {
		return getJdbcTemplate().query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				return con.prepareStatement("select r.id, r.name from recipe_books r");
			}
		}, 
		new ResultSetExtractor<List<RecipeBook>>() {
			
			@Override
			public List<RecipeBook> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<RecipeBook> recipeBookList = new ArrayList<>();
				
				while(rs.next()) {
					RecipeBook rb = new RecipeBook();
					rb.setId(rs.getInt(1));
					rb.setName(rs.getString(2));
					recipeBookList.add(rb);
				}
				rs.close();
				return recipeBookList;
			}
		});
	}
	
	private List<Recipe> doGetAllRecipes() {
		return getJdbcTemplate().query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				return con.prepareStatement("select r.id, r.name, r.recipe_book_id, r.page_no from recipes r");
			}
		},
		new ResultSetExtractor<List<Recipe>>() {
			
			@Override
			public List<Recipe> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<Recipe> recipeList = new ArrayList<>();
				
				while(rs.next()) {
					Recipe r = new Recipe();
					r.setRecipeId(rs.getInt(1));
					r.setName(rs.getString(2));
					r.setPageNumber(rs.getInt(4));
					
					RecipeBook recipeBook = doGetRecipeBook(rs.getInt(3));
					r.setRecipeBook(recipeBook);
					
					List<Ingredient> ingredients = doGetIngredients(rs.getInt(1));
					r.setIngredients(ingredients);
					
					
					recipeList.add(r);
				}
				rs.close();
				return recipeList;
			}
		});
	}
	
	private List<Recipe> doGetAllRecipesShallow() {
		return getJdbcTemplate().query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				return con.prepareStatement("select r.id, r.name, r.recipe_book_id, r.page_no from recipes r");
			}
		},
		new ResultSetExtractor<List<Recipe>>() {
			
			@Override
			public List<Recipe> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<Recipe> recipeList = new ArrayList<>();
				
				while(rs.next()) {
					Recipe r = new Recipe();
					r.setRecipeId(rs.getInt(1));
					r.setName(rs.getString(2));
					r.setPageNumber(rs.getInt(4));
					recipeList.add(r);
				}
				rs.close();
				return recipeList;
			}
		});
	}
	
	private Recipe doGetRecipe(int recipeId) {
		String sql = "select r.id, r.name, r.recipe_book_id, r.page_no from recipes r where r.id = ?";
		
		return getJdbcTemplate().queryForObject(sql, new RowMapper<Recipe>() {

			@Override
			public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Recipe r = new Recipe();
				r.setRecipeId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setPageNumber(rs.getInt(4));
				
				RecipeBook recipeBook = doGetRecipeBook(rs.getInt(3));
				r.setRecipeBook(recipeBook);
				
				List<Ingredient> ingredients = doGetIngredients(rs.getInt(1));
				r.setIngredients(ingredients);
				
				return r;
			}
		}, recipeId);
	}
	
	private void doInsertRecipe(final Recipe recipe) {
		getJdbcTemplate().update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement("insert into recipes "
						+ "(name, recipe_book_id, page_no) values (?, ?, ?)");
				ps.setString(1, recipe.getName());
				ps.setInt(2, recipe.getRecipeBook().getId());
				ps.setInt(3, recipe.getPageNumber());
				return ps;
			}
		});
	}

	private void doInsertIngredients(final Recipe recipe) {
		final List<Ingredient> ingredients = recipe.getIngredients();
		
		getJdbcTemplate().batchUpdate("insert into ingredients (recipe_id, description) values (?, ?)", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, recipe.getRecipeId());
				ps.setString(2, ingredients.get(i).getDescription());
			}
			
			@Override
			public int getBatchSize() {
				return ingredients.size();
			}
		});
	}
	
	private int getRecipeId(String name) {
		return getJdbcTemplate().queryForObject("select r.id from recipes r where r.name = ?", Integer.class, name);
	}
	
	private RecipeBook doGetRecipeBook(int id) {
		
		String sql = "select r.id, r.name from recipe_books r where r.id = ?";
		
		return getJdbcTemplate().queryForObject(sql, new RowMapper<RecipeBook>() {

			@Override
			public RecipeBook mapRow(ResultSet rs, int rowNum) throws SQLException {
				RecipeBook b = new RecipeBook();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				
				return b;
			}
		}, id);
	}
	
	private List<Ingredient> doGetIngredients(final int recipeId) {
		return getJdbcTemplate().query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement("select i.id, i.recipe_id, i.description "
						+ "from ingredients i where i.recipe_id = ?");
				ps.setInt(1, recipeId);
				return ps;
			}
		}, 
		new ResultSetExtractor<List<Ingredient>>() {
			
			@Override
			public List<Ingredient> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<Ingredient> ingredients = new ArrayList<>();
				
				while(rs.next()) {
					Ingredient i = new Ingredient();
					i.setId(rs.getInt(1));
					i.setRecipeId(rs.getInt(2));
					i.setDescription(rs.getString(3));
					ingredients.add(i);
				}
				rs.close();
				return ingredients;
			}
		});
	}
	
	private RecipeBook doGetRecipeBook(String name) {
		String sql = "select r.id, r.name from recipe_books r where r.name = ?";
		
		return getJdbcTemplate().queryForObject(sql, new RowMapper<RecipeBook>() {

			@Override
			public RecipeBook mapRow(ResultSet rs, int rowNum) throws SQLException {
				RecipeBook b = new RecipeBook();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				
				return b;
			}
		}, name);
	}
}
