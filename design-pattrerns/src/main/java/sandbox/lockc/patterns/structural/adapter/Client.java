package sandbox.lockc.patterns.structural.adapter;

import java.util.List;

public class Client {

	public static void main(String[] args) {
		Target tagretInterface = new Adapter();
		List<String> strings = tagretInterface.getListOfStrings();
		System.out.println(strings);
	}

}
