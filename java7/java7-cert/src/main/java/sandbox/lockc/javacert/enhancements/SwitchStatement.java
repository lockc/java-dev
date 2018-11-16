package sandbox.lockc.javacert.enhancements;

public class SwitchStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String theString = "camelCase";
		
		switch(theString) {
		
		case "CAMELCASE":
			System.out.println("CAMELCASE");
			break;
		case "camelcase":
			System.out.println("camelcase");
			break;
		case "camelCase":
			System.out.println("camelCase");
			break;
		default:
			System.out.println("no match");
		}
		
		
		
	}

}
