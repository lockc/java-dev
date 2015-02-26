package lockc.java8.lambda;

public class DefaultMethodsExample1 {
    
    public static void main(String[] args) {
    
        Man man = new Man();
        man.sayHello("Chris");
        
        Woman woman = new Woman();
        woman.sayHello("Sheila");
        
    }
    
    private static interface Person {
        
        default void sayHello(String name) {
        
            System.out.println("hello " + name);
        }
        
        default void sayGoodbye(String name) {
        
            System.out.println("goodbye " + name);
        }
        
    }
    
    private static class Man implements Person {
        
        @Override
        public void sayHello(String name) {
        
            Person.super.sayHello(name);
            
            System.out.println("hello " + name + " man!");
        }
        
    }
    
    private static class Woman implements Person {
        
        // look no impl ...
        
    }
    
}
