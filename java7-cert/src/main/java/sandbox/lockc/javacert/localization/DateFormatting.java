package sandbox.lockc.javacert.localization;

import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateFormatting {

	public static void main(String[] args) {
		
		List<Locale> locales = Arrays.asList(Locale.UK, Locale.US, Locale.ITALY, Locale.GERMANY);
		
		Date now = Calendar.getInstance().getTime();
		
		System.out.println("-----------------------------");
		System.out.println("Date FULL Style");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = DateFormat.getDateInstance(DateFormat.FULL, locale);
			System.out.println(locale.getDisplayCountry(locale) + ": " + formatter.format(now));
		}
		
		System.out.println("-----------------------------");
		System.out.println("Date SHORT Style");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
			System.out.println(locale.getDisplayCountry(locale) + ": " + formatter.format(now));
		}
		
		
		System.out.println("-----------------------------");
		System.out.println("DateTime FULL Style");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
			System.out.println(locale.getDisplayCountry(locale) + ": " + formatter.format(now));
		}
		
		System.out.println("-----------------------------");
		System.out.println("DateTime SHORT Style");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
			System.out.println(locale.getDisplayCountry(locale) + ": " + formatter.format(now));
		}
		
		System.out.println("-----------------------------");
		System.out.println("Time FULL Style");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = DateFormat.getTimeInstance(DateFormat.FULL, locale);
			System.out.println(locale.getDisplayCountry(locale) + ": " + formatter.format(now));
		}
		
		System.out.println("-----------------------------");
		System.out.println("Time SHORT Style");
		System.out.println("-----------------------------");
		for(Locale locale : locales) {
			Format formatter = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
			System.out.println(locale.getDisplayCountry(locale) + ": " + formatter.format(now));
		}
		

	}

}
