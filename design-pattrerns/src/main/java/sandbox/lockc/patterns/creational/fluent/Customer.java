package sandbox.lockc.patterns.creational.fluent;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    
    private String surname;
    private String forenames;
    private int age;
    private String gender;
    private List<String> addresses;
    
    public String getSurname() {
    
        return surname;
    }
    
    public String getForenames() {
    
        return forenames;
    }
    
    public int getAge() {
    
        return age;
    }
    
    public String getGender() {
    
        return gender;
    }
    
    public List<String> getAddresses() {
    
        return addresses;
    }
    
    public static class Builder {
        
        private Customer cust = new Customer();
        
        public Builder surname(String surname) {
        
            cust.surname = surname;
            return this;
        }
        
        public Builder forenames(String forenames) {
        
            cust.forenames = forenames;
            return this;
        }
        
        public Builder age(int age) {
        
            cust.age = age;
            return this;
        }
        
        public Builder gender(String gender) {
        
            cust.gender = gender;
            return this;
        }
        
        public Builder address(String address) {
        
            if (cust.addresses == null) {
                cust.addresses = new ArrayList<String>();
            }
            cust.addresses.add(address);
            return this;
        }
        
        public Customer build() {
        
            return cust;
        }
    }
}
