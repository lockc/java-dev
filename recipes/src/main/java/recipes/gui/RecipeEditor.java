package recipes.gui;

import recipes.app.RecipeEditorDelegate;
import recipes.domain.Ingredient;
import recipes.domain.Recipe;
import recipes.domain.RecipeBook;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;

public class RecipeEditor {

	private RecipeEditorDelegate delegate;
	
	private JFrame frame;
	private JButton btnSave;
	private JButton btnDelete;
	private JTextField textFieldRecipeName;
	private JTextField textFieldPageNumber;
	private JComboBox<RecipeBook> comboBoxRecipeBook;
	private JTextPane textPaneIngredients;
	
	private RecipeEditor(RecipeEditorDelegate delegate) {
		this.delegate = delegate;
		initialize(); // needs to be here for the Swing GUI Builder to work properly
	}

	public static RecipeEditor newInstance(RecipeEditorDelegate delegate) {
		return new RecipeEditor(delegate);
	}

	public void show() {
		loadRecipeBooks();
		registerEvents();
		prePopulateRecipe();
		frame.setVisible(true);
	}
	
	public void registerWindowListener(WindowListener listener) {
		frame.addWindowListener(listener);
	}

	private void loadRecipeBooks() {
		List<RecipeBook> books =  delegate.getRecipeBooks();
		for(RecipeBook book : books) {
			comboBoxRecipeBook.addItem(book);
		}
	}
	
	private void prePopulateRecipe() {
		if(delegate.isEditMode()) {
			Recipe recipe = delegate.getRecipe();
			textFieldRecipeName.setText(recipe.getName());
			comboBoxRecipeBook.setSelectedItem(recipe.getRecipeBook());
			textFieldPageNumber.setText(String.valueOf(recipe.getPageNumber()));
			
			StringBuilder sb = new StringBuilder();
			for(Ingredient i : recipe.getIngredients()) {
				sb.append(i).append("\n");
			}
			
			textPaneIngredients.setText(sb.toString().trim());
		}
	}
	
	private void registerEvents() {
		/*
		 * When save button pressed it will either add a new recipe or update the existing one 
		 * depending on the context.
		 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delegate.saveRecipe(textFieldRecipeName.getText(), (RecipeBook) comboBoxRecipeBook.getSelectedItem(), 
						textFieldPageNumber.getText(), textPaneIngredients.getText());
				
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delegate.deleteRecipe();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 531, 445);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(391, 380, 117, 25);
		panel.add(btnSave);
		
		comboBoxRecipeBook = new JComboBox<RecipeBook>();
		comboBoxRecipeBook.setBounds(143, 43, 365, 25);
		panel.add(comboBoxRecipeBook);
		
		textFieldRecipeName = new JTextField();
		textFieldRecipeName.setBounds(143, 12, 365, 25);
		panel.add(textFieldRecipeName);
		textFieldRecipeName.setColumns(10);
		
		textFieldPageNumber = new JTextField();
		textFieldPageNumber.setBounds(144, 77, 364, 25);
		panel.add(textFieldPageNumber);
		textFieldPageNumber.setColumns(10);
		
		textPaneIngredients = new JTextPane();
		textPaneIngredients.setBounds(143, 122, 365, 234);
		panel.add(textPaneIngredients);
		
		JLabel lblRecipeName = new JLabel("Recipe Name");
		lblRecipeName.setBounds(12, 14, 113, 17);
		panel.add(lblRecipeName);
		
		JLabel lblRecipeBook = new JLabel("Recipe Book");
		lblRecipeBook.setBounds(12, 48, 104, 15);
		panel.add(lblRecipeBook);
		
		JLabel lblPageNumber = new JLabel("Page Number");
		lblPageNumber.setBounds(12, 82, 104, 15);
		panel.add(lblPageNumber);
		
		JLabel lblIngredients = new JLabel("Ingredients");
		lblIngredients.setBounds(12, 122, 104, 15);
		panel.add(lblIngredients);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(143, 380, 117, 25);
		panel.add(btnDelete);
	}
}
