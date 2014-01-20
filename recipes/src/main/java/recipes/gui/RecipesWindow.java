package recipes.gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import recipes.app.RecipeSelector;
import recipes.app.RecipeSelectorImpl;
import recipes.dao.RecipeDao;
import recipes.dao.RecipeXmlDao;
import recipes.domain.Recipe;

import java.awt.Dimension;


public class RecipesWindow {

	private static RecipesWindow window;
	private JFrame frame;
	private JList listAvailable;
	private JList listSelected;
	private DefaultListModel resultListSelected = new DefaultListModel();
	private DefaultListModel resultListAvailable = new DefaultListModel();
	
	private List<Recipe> allRecipes;
	private List<Recipe> selectedRecipes;
	
	/**
	 * Launch the application.
	 * @throws InvocationTargetException 
	 * @throws InterruptedException 
	 */
	public static RecipesWindow launch() throws InterruptedException, InvocationTargetException {
		EventQueue.invokeAndWait(new Runnable() {
			public void run() {
				try {
					RecipesWindow window = new RecipesWindow();
					window.frame.setVisible(true);
					RecipesWindow.window = window;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return RecipesWindow.window;
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public RecipesWindow() throws Exception {
		initialize();
		
		RecipeDao dao = new RecipeXmlDao();
		allRecipes = dao.getAllRecipes();
		
		List<String> availables = new ArrayList<String>();
		for(Recipe recipe : allRecipes) {
			availables.add(recipe.getName());
		}
		populateAvailable(availables.toArray(new String[0]));
		
		selectedRecipes = new ArrayList<Recipe>();
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
		btnAddMeal.setBounds(320, 126, 49, 23);
		panel.add(btnAddMeal);
		
		JButton btnRemoveMeal = new JButton("<<");
		btnRemoveMeal.setBounds(320, 180, 49, 23);
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
		RecipeSelector selector = new RecipeSelectorImpl();
		String list = selector.creatShoppingList(selectedRecipes);
		
		String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "ShoppingList.txt";
		System.out.println(filePath);
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(list.getBytes());
		fos.write(0);
		fos.flush();
		fos.close();
		
	}
	
	private Recipe findRecipe(String name) {
		
		for(Recipe recipe : allRecipes) {
			if(recipe.getName().equalsIgnoreCase(name)) {
				return recipe;
			}
		}
		
		return null;
	}
	
	public void populateAvailable(String[] availables) {
		for(String available : availables) {
			resultListAvailable.addElement(available);
		}
		frame.getContentPane().validate();
	}
}
