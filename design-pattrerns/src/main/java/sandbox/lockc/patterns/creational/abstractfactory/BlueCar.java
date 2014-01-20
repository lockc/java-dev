package sandbox.lockc.patterns.creational.abstractfactory;

public class BlueCar implements AbstractCar {

	private String colour; 
	
	@Override
	public void polish() {
		
	}

	@Override
	public void paint() {
		
		colour = "BLUE";
		
	}

	@Override
	public void assemble() {
		
	}

	@Override
	public String getColour() {
		return colour;
	}

	
	

}
