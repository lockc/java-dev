package sandbox.lockc.patterns.creational.abstractfactory;

public class RedCarFactory implements AbstractCarFacory {

	@Override
	public AbstractCar makeCar() {
		AbstractCar car = new RedCar();
		car.assemble();
		car.paint();
		car.polish();
		return car;
	}

}
