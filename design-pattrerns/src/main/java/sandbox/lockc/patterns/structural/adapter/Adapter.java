package sandbox.lockc.patterns.structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adapter implements Target {

	private Adaptee adaptee = new Adaptee();
	
	@Override
	public List<String> getListOfStrings() {
		String[] arrayOfStrings = adaptee.getArrayOfStrings();
		return new ArrayList<String>(Arrays.asList(arrayOfStrings));
	}

}
