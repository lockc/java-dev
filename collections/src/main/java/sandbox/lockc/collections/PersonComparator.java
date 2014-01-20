package sandbox.lockc.collections;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	/**
	 * Compare by last name first, then first name and finally age to 
	 * distinguish between Person objects.
	 */
	@Override
	public int compare(Person o1, Person o2) {
		int last = o1.getLastName().compareTo(o2.getLastName());
		if(last != 0) return last;
		
		int first = o1.getFirstName().compareTo(o2.getFirstName());
		if(first != 0) return first;
		
		int age = o1.getAge() == o2.getAge() ? 0 : ageDifference(o1.getAge(), o2.getAge());
		return (age != 0 ? age : 0); 
	}
	
	private int ageDifference(int a, int b) {
		return a - b;
	}

}
