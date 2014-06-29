package recipes.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

import recipes.app.RecipeEditorDelegate;
import recipes.dao.RecipeDao;
import recipes.domain.Recipe;
import recipes.tx.RecipeManager;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecipesWindow {

	private RecipeDao dao;
	private List<Recipe> allRecipes;
	private List<Recipe> selectedRecipes;
	
	private JFrame frame;
	private JList<Recipe> listAvailable;
	private JList<Recipe> listSelected;
	private DefaultListModel<Recipe> resultListSelected = new DefaultListModel<Recipe>();
	private DefaultListModel<Recipe> resultListAvailable = new DefaultListModel<Recipe>();
	private JButton btnAddMeal;
	private JButton btnRemoveMeal;
	private JButton btnShoppingList;
	private JButton btnAddRecipe;
	private JButton btnEditRecipe;

	private RecipesWindow(RecipeDao dao) {
		this.dao = dao;
		initialize();
	}
	
	public static RecipesWindow newInstance(RecipeDao dao) {
		return new RecipesWindow(dao);
	}
	
	public void show() {
		selectedRecipes = new ArrayList<Recipe>();
		registerEvents();
		populateAvailable();
		frame.setVisible(true);
	}
	
	private void populateAvailable() {
		clearAvailable();
		allRecipes = dao.getAllRecipes();
		for(Recipe available : allRecipes) {
			resultListAvailable.addElement(available);
		}
		frame.getContentPane().validate();
	}
	
	private void clearAvailable() {
		resultListAvailable.clear();
	}
	
	private void registerEvents() {
		
		
		btnAddMeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] values = listAvailable.getSelectedValues();
				for(Object value : values) {
					resultListSelected.addElement((Recipe)value);
					resultListAvailable.remove(resultListAvailable.indexOf(value));
					selectedRecipes.add(findRecipe(String.valueOf(value)));
				}
			}
		});
		
		btnRemoveMeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Object[] values = listSelected.getSelectedValues();
				for(Object value : values) {
					resultListAvailable.addElement((Recipe)value);
					resultListSelected.remove(resultListSelected.indexOf(value));
					selectedRecipes.remove(findRecipe(String.valueOf(value)));
				}
				
			}
		});
		
		btnShoppingList.addMouseListener(new MouseAdapter() {
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
		
		btnAddRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RecipeEditor editor = RecipeEditor.newInstance(new RecipeEditorDelegate(dao, null));
				editor.disableDeleteButton();
				editor.show();
				
				editor.registerWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						populateAvailable();
					}
				});
			}
		});
		
		btnEditRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recipe recipe = (Recipe) listAvailable.getSelectedValues()[0];
				RecipeEditor editor = RecipeEditor.newInstance(new RecipeEditorDelegate(dao, recipe));
				editor.show();

				
				editor.registerWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent arg0) {
						populateAvailable();
					}
				});
			}
		});
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
		panel.setPreferredSize(new Dimension(733, 542));
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
		
		listAvailable = new JList<Recipe>();
		listAvailable.setVisibleRowCount(20);
		scrollPane.setViewportView(listAvailable);
		listAvailable.setModel(resultListAvailable);
		
		btnAddMeal = new JButton(">>");
		btnAddMeal.setBounds(320, 210, 62, 23);
		panel.add(btnAddMeal);
		
		btnRemoveMeal = new JButton("<<");
		btnRemoveMeal.setBounds(320, 245, 62, 23);
		panel.add(btnRemoveMeal);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(425, 26, 258, 410);
		panel.add(scrollPane_1);
		
		listSelected = new JList<Recipe>();
		scrollPane_1.setViewportView(listSelected);
		listSelected.setModel(resultListSelected);
		
		btnShoppingList = new JButton("Create shopping list...");
		btnShoppingList.setBounds(425, 452, 258, 23);
		panel.add(btnShoppingList);
		
		btnAddRecipe = new JButton("Add");
		btnAddRecipe.setBounds(31, 451, 117, 25);
		panel.add(btnAddRecipe);
		
		btnEditRecipe = new JButton("Edit");
		btnEditRecipe.setBounds(172, 451, 117, 25);
		panel.add(btnEditRecipe);
		
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
	
	
}
