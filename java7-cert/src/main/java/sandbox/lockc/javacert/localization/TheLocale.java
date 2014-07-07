package sandbox.lockc.javacert.localization;

import java.util.Locale;

public class TheLocale {

	
	
	public static void main(String[] args) {
		
		
//		identifyingAvailableLocales();
		
		creatingLocales();
		
	}
	
	public static void creatingLocales() {
		printLocale(Locale.getDefault(), Locale.ENGLISH);
		printLocale(Locale.getDefault());
		
		/*
		 * Constructor
		 */
		Locale.setDefault(new Locale("zh", "CH"));
		printLocale(Locale.getDefault(), Locale.ENGLISH);
		printLocale(Locale.getDefault());
		
		/*
		 * Constants
		 */
		Locale.setDefault(Locale.CANADA_FRENCH);
		printLocale(Locale.getDefault(), Locale.ENGLISH);
		printLocale(Locale.getDefault());
		
		/*
		 * Builder class
		 */
		Locale.setDefault(new Locale.Builder().setLanguage("th").setRegion("TH").setScript("Thai").build());
		printLocale(Locale.getDefault(), Locale.ENGLISH);
		printLocale(Locale.getDefault());
	}
	
	
	public static void identifyingAvailableLocales() {
		for(Locale locale : Locale.getAvailableLocales()) {
			printLocale(locale);			
		}
	}
	
	
	private static void printLocale(Locale locale) {
		System.out.println(String.format("Locale Code %s: Language %s (%s), Country %s (%s), Script %s (%s), Variant %s (%s), Display Name %s ", 
				locale.toString(), 
				locale.getLanguage(), 
				locale.getDisplayLanguage(),
				locale.getCountry(), 
				locale.getDisplayCountry(),
				locale.getScript(), 
				locale.getDisplayScript(),
				locale.getVariant(),
				locale.getDisplayVariant(),
				locale.getDisplayName()));
	}
	
	private static void printLocale(Locale locale, Locale inLocale) {
		System.out.println(String.format("Locale Code %s: Language %s (%s), Country %s (%s), Script %s (%s), Variant %s (%s), Display Name %s ", 
				locale.toString(), 
				locale.getLanguage(), 
				locale.getDisplayLanguage(inLocale),
				locale.getCountry(), 
				locale.getDisplayCountry(inLocale),
				locale.getScript(), 
				locale.getDisplayScript(inLocale),
				locale.getVariant(),
				locale.getDisplayVariant(inLocale),
				locale.getDisplayName()));
	}
	
}
