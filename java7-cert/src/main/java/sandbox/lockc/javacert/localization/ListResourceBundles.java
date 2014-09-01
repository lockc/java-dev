package sandbox.lockc.javacert.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ListResourceBundles {

	public static void main(String[] args) {
		
		Locale locale = Locale.getDefault();
		
//		String base = "sandbox.lockc.javacert.localization.ListResourceBundles.ResBundle";
		String base = "sandbox.lockc.javacert.localization.ResBundle";
		
		ResourceBundle messages = ResourceBundle.getBundle(base, locale);
		printMessages(messages);
		
		messages = ResourceBundle.getBundle(base, Locale.FRENCH);
		printMessages(messages);
	}
	
	private static void printMessages(ResourceBundle bundle) {
		
		System.out.println(String.format("----------- %s --------------", bundle.getLocale()));
		System.out.println(bundle.getString("1"));
		System.out.println(bundle.getString("2"));
		System.out.println(bundle.getString("3"));
		System.out.println(bundle.getString("4"));
	}

}
