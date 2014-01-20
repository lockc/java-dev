package sandbox.lockc.patterns.structural.facade;

public class Client {

	public static void main(String[] args) {
		HolidayBookerFacade holidayBooker = new HolidayBookerFacade();
		holidayBooker.bookHoliday();
	}

}
