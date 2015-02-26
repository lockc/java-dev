package lockc.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ReferenceMethodsExample3 {
    
    public static void main(String[] args) {
    
        /**
         * Example of x.equals(y) type method reference
         */
        
        String[] strings = { "A", "c", "R", "z", "h" };
        String[] strings2 = { "A", "c", "R", "z", "h" };
        
        // This is short for ...
        Arrays.sort(strings, String::compareToIgnoreCase);
        
        // this.
        Arrays.sort(strings2, new Comparator<String>() {
            
            @Override
            public int compare(String o1, String o2) {
            
                return o1.compareToIgnoreCase(o2);
            }
        });
        
    }
    
}
