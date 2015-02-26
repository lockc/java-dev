package lockc.java8.lambda;

public class ReferenceMethodsExample2 {
    
    public static void main(String[] args) {
    
        /**
         * Using method references on a static class method inside
         * a Runnable functional interface
         */
        
        // From this ...
        Thread t = new Thread(new Runnable() {
            
            @Override
            public void run() {
            
                SomeClass.doSomethingStatic();
                
            }
        });
        
        // to this ...
        t = new Thread(() -> {
            SomeClass.doSomethingStatic();
        });
        t.run();
        
        // to this ...
        t = new Thread(SomeClass::doSomethingStatic);
        t.run();
        
    }
    
    private static class SomeClass {
        
        public static void doSomethingStatic() {
        
            System.out.println("Say hi to static.");
        };
        
    }
    
}
