package sandbox.lockc.javacert.localization;

import java.util.ListResourceBundle;

// Default bundle
public class ResBundle extends ListResourceBundle {

	@Override
	public Object[][] getContents() {
		return contents;
	}
	
	static final Object[][] contents = {
		
		{"1", "Default One"},
		{"2", "Default Two"},
		{"3", "Default Three"},
		{"4", "Default Four"}
		
	};
	
	
}