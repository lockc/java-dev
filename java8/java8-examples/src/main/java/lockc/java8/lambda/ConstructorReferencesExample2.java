package lockc.java8.lambda;

public class ConstructorReferencesExample2 {
    
    public static void main(String[] args) {
    
        SomeClass someClass = new SomeClass("THE THING");
        someClass.print();
        
        // From this ...
        SomeOtherClass someOtherClass2 = someClass.switchTo(new Switcher<SomeClass, SomeOtherClass>() {
            
            @Override
            public SomeOtherClass switchIt(SomeClass it) {
            
                return new SomeOtherClass(it.value);
            }
        });
        someOtherClass2.print();
        
        // to this ...
        SomeOtherClass someOtherClass1 = someClass.switchTo(it -> {
            return new SomeOtherClass(it.value);
        });
        
        // to this ...
        someOtherClass1 = someClass.switchTo(it -> new SomeOtherClass(it.value));
        someOtherClass1.print();
        
        // to this ...
        SomeOtherClass someOtherClass = someClass.switchTo(SomeOtherClass::new);
        someOtherClass.print();
        
        // and visa versa
        SomeClass someClass2 = someOtherClass.switchTo(SomeClass::new);
        someClass2.print(); 
        
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
        
        public <S> S switchTo(Switcher<SomeClass, S> switcher) {
        
            return switcher.switchIt(this);
        }
        
        public void print() {
        
            System.out.println(super.toString() + " : " + this.toString());
        }
        
        @Override
        public String toString() {
        
            return value;
        }
        
    }
    
    private static class SomeOtherClass {
        
        private String value;
        
        public <T> SomeOtherClass(T value) {
        
            this.value = value.toString();
        }
        
        public <S> S switchTo(Switcher<SomeOtherClass, S> switcher) {
        
            return switcher.switchIt(this);
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
