package lockc.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ReferenceMethods {
    
    public static void main(String[] args) {
    
        String[] strings = { "A", "c", "R", "z", "h" };
        String[] strings2 = { "A", "c", "R", "z", "h" };
        
        /**
         * Example of x.equals(y) type method reference
         */
        
        // This is short for ...
        Arrays.sort(strings, String::compareToIgnoreCase);
        
        // this.
        Arrays.sort(strings2, new Comparator<String>() {
            
            @Override
            public int compare(String o1, String o2) {
            
                return o1.compareToIgnoreCase(o2);
            }
        });
        
        /**
         * Using method references on a static class method inside
         * a Runnable functional interface
         * 
         * SomeClass.doSomethingStatic();
         * 
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
        
        /**
         * 
         */
        
        SomeClass someClass = new SomeClass();
        
        // From this ...
        someClass.doSomethingWithSummer(new Summer() {
            
            @Override
            public int sum(short s, byte b, int i) {
            
                return SumUtil.sum(s, b, i);
            }
        });
        
        // To this ...
        someClass.doSomethingWithSummer((s, b, i) -> {
            return SumUtil.sum(s, b, i);
        });
        
        // To this ...
        someClass.doSomethingWithSummer(SumUtil::sum);
        
    }
    
    private static class SomeClass {
        
        public static void doSomethingStatic() {
        
            System.out.println("Say hi static.");
        };
                
        public int doSomethingWithSummer(Summer summer) {
        
            return summer.sum((short) 1, (byte) 2, 3);
        };
        
    }
    
    private static class SumUtil {
        
        static int sum(short s, byte b, int i) {
        
            return s + b + i;
        }
        
    }
    
    @FunctionalInterface
    private static interface Summer {
        
        int sum(short s, byte b, int i);
    }
}
