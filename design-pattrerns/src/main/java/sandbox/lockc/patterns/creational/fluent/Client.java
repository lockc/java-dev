package sandbox.lockc.patterns.creational.fluent;


public class Client {
    
    public static void main(String[] args) {
    
        Customer customer = new Customer.Builder()
            .surname("Lock")
            .forenames("Christopher")
            .age(99)
            .gender("male")
            .address("12 Some Street, Somewhere, DE1 3FD")
            .address("12 Nasty Street, Nasty Place, NS1 1XX")
            .build();
        
    }
    
}
