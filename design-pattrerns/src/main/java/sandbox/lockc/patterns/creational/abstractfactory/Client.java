package sandbox.lockc.patterns.creational.abstractfactory;

public class Client {

	public static void main(String[] args) {
		
//		String colour = args[0];
		String colour = "red";
		
		AbstractCarFacory carFactory = null;
		
		if(colour.equals("red")) {
			carFactory = new RedCarFactory();
		} else {
			carFactory = new BlueCarFactory();
		}
		
		
		AbstractCar car = carFactory.makeCar();
		
		
		System.out.println(car.getColour());
		
		
		

	}

}
