package sandbox.lockc.patterns.creational.abstractfactory;

public class BlueCarFactory implements AbstractCarFacory {

	@Override
	public AbstractCar makeCar() {
		AbstractCar car = new BlueCar();
		car.assemble();
		car.paint();
		car.polish();
		return car;
	}

}
