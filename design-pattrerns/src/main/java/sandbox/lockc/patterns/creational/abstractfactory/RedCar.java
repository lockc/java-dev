package sandbox.lockc.patterns.creational.abstractfactory;

public class RedCar implements AbstractCar {

	private String colour; 
	
	@Override
	public void polish() {
		
	}

	@Override
	public void paint() {
		
		colour = "RED";
		
	}

	@Override
	public void assemble() {
		
	}

	@Override
	public String getColour() {
		return colour;
	}

	
	

}
