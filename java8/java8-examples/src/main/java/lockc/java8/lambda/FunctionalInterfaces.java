package lockc.java8.lambda;

import java.util.Comparator;

public class FunctionalInterfaces {

	public static void main(String[] args) {

		/**
		 * Create a Comparator using a Lambda expression and an example of the old alternative.
		 */
		Comparator<String> lambyComparator = (String first, String second) -> {return Integer.compare(first.length(), second.length());};
		System.out.println(lambyComparator.compare("a", "bc"));
		
		Comparator<String> standardComparator = new Comparator<String>() {
			@Override
			public int compare(String first, String second) {
				return Integer.compare(first.length(), second.length());
			}
		};
		System.out.println(standardComparator.compare("a", "bc"));
		
		
		
		/**
		 * An example of our own functional interface being implemented using a Lambda expression
		 */
		HelloLamda lamby = (short s, byte b, int i) -> {return s + b + i; };
		System.out.println(lamby.average((short)1, (byte)2, 3));
		
		
		
		/**
		 * An example of passing a Runnable to a thread using a lambda expression
		 * 
		 * Notice the empty parentheses for a no parameter method.
		 */
		Thread t = new Thread(() -> {System.out.println("my runnable");});
		t.run();
		
		
	}

	/**
	 * An example of a FunctionalInterface i.e. an interface with a single abstract method
	 *
	 */
	@FunctionalInterface
	private interface HelloLamda {
		int average(short s, byte b, int i);
	}
}
