package sandbox.lockc.patterns.structural.facade;

public class HolidayBookerFacade {

	private FlightBooker flightBooker = new FlightBooker();
	private HotelBooker hotelBooker = new HotelBooker();
	private HireCarBooker hireCarBooker = new HireCarBooker();
	
	
	public void bookHoliday() {
		flightBooker.bookFlight();
		hotelBooker.bookHotel();
		hireCarBooker.bookHireCar();
	}

}
