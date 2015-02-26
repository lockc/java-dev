package lockc.java8.lambda;

/**
 * This example shows constructor references in the simplest form.
 * 
 * We define a Switcher in four ways:
 * 
 * - an anonymous class,
 * - a lambda function syntax
 * - a short lambda function syntax
 * - a constructor reference syntax.
 * 
 * 
 * What this does is declare a generic Switcher who's switchIt method
 * takes a single String argument and returns a SomeClass based on the T
 * and S type parameters. The constructor reference syntax is
 * saying, create a Switcher instance who's implementation constructs
 * a new SomeClass and try and match a constructor signature of
 * SomeClass with a single String constructor based on the method
 * signature of the functional interface.
 * 
 * @author lockc
 *
 */
public class ConstructorReferencesExample3 {
    
    public static void main(String[] args) {
    
        // From this ...
        Switcher<String, SomeClass> switcher0 = new Switcher<String, SomeClass>() {
            
            @Override
            public SomeClass switchIt(String it) {
            
                return new SomeClass(it);
            }
        };
        SomeClass sc0 = SomeClass.switchTo(switcher0, "anonymous class");
        sc0.print();
        
        // To this ...
        Switcher<String, SomeClass> switcher1 = (it) -> {
            return new SomeClass(it);
        };
        SomeClass sc1 = SomeClass.switchTo(switcher1, "lambda function synta");
        sc1.print();
        
        // To this ...
        Switcher<String, SomeClass> switcher9 = (it) -> new SomeClass(it);
        SomeClass sc9 = SomeClass.switchTo(switcher9, "shorthand lambda function syntax");
        sc9.print();
        
        // To this ...
        Switcher<String, SomeClass> switcher2 = SomeClass::new;
        SomeClass sc2 = SomeClass.switchTo(switcher2, "lambda constructor reference ");
        sc2.print();
        
        /*
         * compiler error - String.class has no constructor that
         * takes a SomeClass
         */
        // Switcher<SomeClass, String> switcher4 = String::new;
        
        // Just to show from String to String because the String class
        // also has a constructor that takes a string
        Switcher<String, String> switcher3 = String::new;
        String s = SomeClass.switchTo(switcher3, "hello");
        System.out.println(s.getClass().getName() + " : " + s);
        
        /**
         * These examples show constructor references in an even simpler
         * form, the Creator functional interface simply constructs
         * new objects and returns them. Here the Creator interface
         * has a method that takes no arguments, hence the compiler
         * tries to match the no-arg constructor of each object type.
         */
        
        Creator<Object> object = Object::new;
        Object obj = SomeClass.create(object);
        System.out.println(obj.toString());
        
        Creator<String> string = String::new;
        String str = SomeClass.create(string);
        System.out.println(str.toString());
        
        Creator<SomeClass> someClass = SomeClass::new;
        SomeClass sc = SomeClass.create(someClass);
        System.out.println(sc.toString());
    }
    
    /**
     * 
     * @author lockc
     *
     * @param <T> from type
     * @param <S> to type
     */
    @FunctionalInterface
    private static interface Switcher<T, S> {
        
        /**
         * A method that takes a T and converts it to an S
         * 
         * @param it
         * @return the converted object
         */
        S switchIt(T it);
    }
    
    @FunctionalInterface
    private static interface Creator<T> {
        
        T createIt();
    }
    
    /**
     * Some class that provides a static switchTo method to illustrate the examples
     * 
     * @author lockc
     *
     */
    private static class SomeClass {
        
        private String value;
        
        public SomeClass() {
        
        }
        
        /**
         * A generic constructor allows conversion from any type so the compiler
         * doesn't complain it cannot find a constructor. We could just as well put
         * the following but this would mean only String<i>s<i> could be converted
         * because the compiler would complain.
         * 
         * <pre>
         * 
         * 
         * 
         * public &lt;T&gt; SomeClass(T value) {
         * 
         *     this.value = value.toString();
         * }
         * </pre>
         * 
         * @param value
         */
        public <T> SomeClass(T value) {
        
            this.value = value.toString();
        }
        
        public static <T, S> S switchTo(Switcher<T, S> switcher, T t) {
        
            return switcher.switchIt(t);
        }
        
        public static <T> T create(Creator<T> creator) {
        
            return creator.createIt();
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
