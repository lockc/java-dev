/**
 * 
 */
package recipes.app;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import recipes.gui.RecipesWindow;

/**
 * @author lockc
 *
 */
public class RecipeApp {

	public static Properties properties;
	
	public static void main(String[] args) throws Exception {
		
		properties = new Properties();
		properties.load(RecipeApp.class.getClassLoader().getResourceAsStream("settings.properties"));
		PropertyConfigurator.configure("src/main/resources/settings.properties");
				
		RecipesWindow.launch();
				
	}

}
