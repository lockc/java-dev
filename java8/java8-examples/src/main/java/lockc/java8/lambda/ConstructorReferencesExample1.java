package lockc.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorReferencesExample1 {
    
    public static void main(String[] args) {
    
        List<String> labels = Arrays.asList("a", "b", "c");
        
        // From this ...
        Stream<SomeClass> stream = labels.stream().map(new Function<String, SomeClass>() {
            
            @Override
            public SomeClass apply(String t) {
            
                return new SomeClass(t);
            }
        });
        List<SomeClass> someClasses = stream.collect(Collectors.toList());
        System.out.println(someClasses);
        
        // to this ...
        stream = labels.stream().map(s -> {
            return new SomeClass(s);
        });
        someClasses = stream.collect(Collectors.toList());
        System.out.println(someClasses);
        
        // to this ...
        stream = labels.stream().map(SomeClass::new);
        
        someClasses = stream.collect(Collectors.toList());
        System.out.println(someClasses);
        
    }
    
    
    
    private static class SomeClass {
        
        private String value;
        
        public SomeClass(String value) {
        
            this.value = value;
        }
        
        @Override
        public String toString() {
        
            return value;
        }
    }
    
}
