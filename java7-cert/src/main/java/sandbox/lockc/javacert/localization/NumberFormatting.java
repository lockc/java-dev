package sandbox.lockc.javacert.localization;

import java.text.Format;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class NumberFormatting {

	public static void main(String[] args) {
		List<Locale> locales = Arrays.asList(Locale.UK, Locale.US, Locale.ITALY, Locale.GERMANY);
		
		System.out.println("-----------------------------");
		System.out.println("Currencies");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = NumberFormat.getCurrencyInstance(locale);
			System.out.println(locale.getDisplayCountry(locale) + " " + formatter.format(2.56));
		}
		
		System.out.println("-----------------------------");
		System.out.println("Numbers");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = NumberFormat.getNumberInstance(locale);
			System.out.println(locale.getDisplayCountry(locale) + " " + formatter.format(1234567890.45543));
		}
		
		System.out.println("-----------------------------");
		System.out.println("Integers");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = NumberFormat.getIntegerInstance(locale);
			System.out.println(locale.getDisplayCountry(locale) + " " + formatter.format(1234567890.68678));
		}
		
		System.out.println("-----------------------------");
		System.out.println("Percent");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = NumberFormat.getPercentInstance(locale);
			System.out.println(locale.getDisplayCountry(locale) + " " + formatter.format(97.8));
		}
	
		
	}

}
