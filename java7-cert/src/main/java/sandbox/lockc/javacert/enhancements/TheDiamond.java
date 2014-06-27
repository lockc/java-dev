package sandbox.lockc.javacert.enhancements;

import java.util.ArrayList;
import java.util.List;

public class TheDiamond {

	
	public static void main(String args []) {
		
		TheDiamond.typeInference();
		
	}
	
	
	
	private static void typeInference() {
		

		/**
		 * An example of normal generics and parameterized types
		 */
		PairOf<String, Number> aPairOfThings1 = new PairOf<String, Number>("one", 1);
		System.out.println(aPairOfThings1);
		
		/**
		 * An example of Java 7 feature type inference, the types are omitted in the instantiation
		 */
		PairOf<String, Number> aPairOfThings2 = new PairOf<>("two", 2);
		System.out.println(aPairOfThings2);
		
		/**
		 * This is bad but legal, omitting the diamond altogether the compiler use the raw type, same as PairOf<Object, Object>
		 */
		PairOf<String, Number> aPairOfThings3 = new PairOf("three", 3);
		System.out.println(aPairOfThings3);
		
		/**
		 * Again this is bad but legal
		 */
		PairOf aPairOfThings4 = new PairOf("four", 4);
		System.out.println(aPairOfThings4);
		
		
		
		List<PairOf> listOfPairs = new ArrayList<>();
		listOfPairs.add(new PairOf<String, String>("", ""));
		listOfPairs.add(new PairOf<Number, Number>(1, 2));
		
		for(PairOf<Number, Number> p : listOfPairs) {
			p.getaThing().intValue();
		}
		
		
		
	}
	
	
	
	
	
	
	
	public static class PairOf<A, B> {
		private A aThing;
		private B bThing;
		
		public PairOf(A aThing, B bThing) {
			super();
			this.aThing = aThing;
			this.bThing = bThing;
		}
		
		public A getaThing() {
			return aThing;
		}

		public B getbThing() {
			return bThing;
		}

		@Override
		public String toString() {
			return String.format("{%s:%s}", aThing, bThing);
		}
	}
}
