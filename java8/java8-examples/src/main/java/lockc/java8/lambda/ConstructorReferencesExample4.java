package lockc.java8.lambda;

public class ConstructorReferencesExample4 {
    
    public static void main(String[] args) {
    
        /**
         * This shows constructor references in the simplest form
         */
        
        // From this ...
        Switcher<String, String, SomeClass> switcher0 = new Switcher<String, String, SomeClass>() {
            
            @Override
            public SomeClass switchIt(String it1, String it2) {
            
                return new SomeClass(it1 + " " + it2);
            }
        };
        SomeClass sc0 = SomeClass.switchTo(switcher0, "hello", "there");
        sc0.print();
        
        // To this ...
        Switcher<String, String, SomeClass> switcher1 = (it1, it2) -> new SomeClass(it1, it2);
        SomeClass sc1 = SomeClass.switchTo(switcher1, "hello", "there");
        sc1.print();
        
        // to this ...
        Switcher<String, String, SomeClass> switcher2 = SomeClass::new;
        SomeClass sc2 = SomeClass.switchTo(switcher2, "hello", "there");
        sc2.print();
        
        /*
         * compiler error - String.class has no constructor that
         * takes 2 string parameters
         */
//        Switcher<String, String, String> switcher3 = String::new;
    }
    
    @FunctionalInterface
    private static interface Switcher<T, U, S> {
        
        S switchIt(T it1, U it2);
    }
    
    private static class SomeClass {
        
        private String value;
        
        public <T> SomeClass(T value) {
        
            this.value = value.toString();
        }
        
        public <T> SomeClass(T value, T value2) {
            
            this.value = value.toString() + " " + value2.toString();
        }
        
        public static <T, U, S> S switchTo(Switcher<T, U, S> switcher, T t, U u) {
        
            return switcher.switchIt(t, u);
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
