package recipes.gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import recipes.dao.RecipeDao;
import recipes.dao.RecipeXmlDao;
import recipes.domain.Recipe;

import java.awt.Dimension;


public class RecipesWindow {

	private RecipeDao dao;
	
	private JFrame frame;
	private JList listAvailable;
	private JList listSelected;
	private DefaultListModel resultListSelected = new DefaultListModel();
	private DefaultListModel resultListAvailable = new DefaultListModel();
	
	private List<Recipe> allRecipes;
	private List<Recipe> selectedRecipes;

	private RecipesWindow(RecipeDao dao) throws Exception {
		this.dao = dao;
		allRecipes = dao.getAllRecipes();
		selectedRecipes = new ArrayList<Recipe>();
	}
	
	public static RecipesWindow launch(RecipeDao dao) throws Exception {
		final RecipesWindow window = new RecipesWindow(dao);
		
		EventQueue.invokeAndWait(new Runnable() {
			public void run() {
				try {
					window.initialize();
					window.populateAvailable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		return window;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(16, 10));
		panel.setBorder(null);
		panel.setBounds(0, 11, 704, 475);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAvailableMeals = new JLabel("Available meals");
		lblAvailableMeals.setBounds(31, 6, 258, 14);
		panel.add(lblAvailableMeals);
		
		JLabel lblSelectedMeals = new JLabel("Selected meals");
		lblSelectedMeals.setBounds(425, 6, 258, 14);
		panel.add(lblSelectedMeals);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 26, 258, 410);
		panel.add(scrollPane);
		
		listAvailable = new JList();
		listAvailable.setVisibleRowCount(20);
		scrollPane.setViewportView(listAvailable);
		listAvailable.setModel(resultListAvailable);
		
		JButton btnAddMeal = new JButton(">>");
		btnAddMeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] values = listAvailable.getSelectedValues();
				for(Object value : values) {
					resultListSelected.addElement(String.valueOf(value));
					resultListAvailable.remove(resultListAvailable.indexOf(value));
					selectedRecipes.add(findRecipe(String.valueOf(value)));
				}
			}
		});
		btnAddMeal.setBounds(320, 210, 62, 23);
		panel.add(btnAddMeal);
		
		JButton btnRemoveMeal = new JButton("<<");
		btnRemoveMeal.setBounds(320, 245, 62, 23);
		panel.add(btnRemoveMeal);
		btnRemoveMeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Object[] values = listSelected.getSelectedValues();
				for(Object value : values) {
					resultListAvailable.addElement(String.valueOf(value));
					resultListSelected.remove(resultListSelected.indexOf(value));
					selectedRecipes.remove(findRecipe(String.valueOf(value)));
				}
				
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(425, 26, 258, 410);
		panel.add(scrollPane_1);
		
		listSelected = new JList();
		scrollPane_1.setViewportView(listSelected);
		listSelected.setModel(resultListSelected);
		
		JButton btnNewButton = new JButton("Create shopping list...");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					createShoppingList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		
		btnNewButton.setBounds(425, 452, 258, 23);
		panel.add(btnNewButton);
		
	}
	
	private void createShoppingList() throws Exception {
		
		StringBuilder builder = new StringBuilder();
		for(Recipe recipe : selectedRecipes) {
			builder.append(recipe.toShoppingListItem());
		}
		String list = builder.toString();
		
		String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "ShoppingList.txt";
		System.out.println(filePath);
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			fos.write(list.getBytes());
			fos.write(0);
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
		}
	}
	
	
	private Recipe findRecipe(String name) {
		
		for(Recipe recipe : allRecipes) {
			if(recipe.getName().equalsIgnoreCase(name)) {
				return recipe;
			}
		}
		
		return null;
	}
	
	public void populateAvailable() {
		for(Recipe available : allRecipes) {
			resultListAvailable.addElement(available.getName());
		}
		frame.getContentPane().validate();
	}
}
