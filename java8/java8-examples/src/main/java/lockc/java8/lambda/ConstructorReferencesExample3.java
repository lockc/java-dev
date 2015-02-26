package lockc.java8.lambda;

public class ConstructorReferencesExample3 {
    
    public static void main(String[] args) {
    
        /**
         * This shows constructor references in the simplest form
         */
        
        // From this ...
        Switcher<String, SomeClass> switcher0 = new Switcher<String, SomeClass>() {
            
            @Override
            public SomeClass switchIt(String it) {
            
                return new SomeClass(it);
            }
        };
        SomeClass sc0 = SomeClass.switchTo(switcher0, "hello");
        sc0.print();
        
        // To this ...
        Switcher<String, SomeClass> switcher1 = (it) -> new SomeClass(it);
        SomeClass sc1 = SomeClass.switchTo(switcher1, "hello");
        sc1.print();
        
        Switcher<String, SomeClass> switcher2 = SomeClass::new;
        SomeClass sc2 = SomeClass.switchTo(switcher2, "hello");
        sc2.print();
        
        Switcher<String, String> switcher3 = String::new;
        String str = SomeClass.switchTo(switcher3, "hello");
        System.out.println(str.getClass().getName() + " : " + str);
        
        /*
         * compiler error - String.class has no constructor that
         * takes a SomeClass
         */
        // Switcher<SomeClass, String> switcher4 = String::new;
        
    }
    
    @FunctionalInterface
    private static interface Switcher<T, S> {
        
        S switchIt(T it);
    }
    
    private static class SomeClass {
        
        private String value;
        
        public <T> SomeClass(T value) {
        
            this.value = value.toString();
        }
        
        public static <T, S> S switchTo(Switcher<T, S> switcher, T t) {
        
            return switcher.switchIt(t);
        }
        
        public void print() {
        
            System.out.println(super.toString() + " : " + this.toString());
        }
        
        @Override
        public String toString() {
        
            return value;
        }
        
    }
    
}
