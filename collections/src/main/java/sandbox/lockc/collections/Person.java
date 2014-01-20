package sandbox.lockc.collections;

public class Person implements Comparable<Person> {
    
    private String firstName;
    private String lastName;
    private int age;
    
    public Person(String firstName, String lastName, int age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " ("+ this.age +")";
    }
    
    @Override
    public int compareTo(Person o) {
        return new PersonComparator().compare(this, o);
    }
    
    @Override
    public int hashCode() {
    	return 31 * (this.getLastName().hashCode() + this.getFirstName().hashCode() + this.age);
    }
}
