package sandbox.lockc.javacert.localization;


import java.util.*;

/*
 * http://docs.oracle.com/javase/tutorial/i18n/intro/index.html
 * 
 */
public class I18NSample {

	public static void fallbackToDefaultBundle() {
		
		Locale locale = Locale.getDefault();
		ResourceBundle messages = ResourceBundle.getBundle("DefaultBundle", locale);
		printMessages(messages);
		
		locale = Locale.FRANCE;
		messages = ResourceBundle.getBundle("DefaultBundle", locale);
		printMessages(messages);
		
		messages = ResourceBundle.getBundle("DefaultBundle");
		printMessages(messages);
	}
	
	public static void messagesBundle() {
		
		Locale currentLocale;
		ResourceBundle messages;

		currentLocale = new Locale("de", "DE");
		// currentLocale = Locale.getDefault();

		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

		printMessages(messages);
		
	}
	
	static public void main(String[] args) {

		fallbackToDefaultBundle();
		

		
	}
	
	
	private static void printMessages(ResourceBundle bundle) {
		
		System.out.println(String.format("----------- %s --------------", bundle.getLocale()));
		System.out.println(bundle.getString("greetings"));
		System.out.println(bundle.getString("inquiry"));
		System.out.println(bundle.getString("farewell"));
	}
}
