package lockc.java8.lambda;

public class ReferenceMethodsExample1 {
    
    public static void main(String[] args) {
    
        SomeClass someClass = new SomeClass();
        int res = 0;
        
        /**
         * An example using instance methods as a reference method
         * 
         */
        
        // From this ...
        res = someClass.doSomethingWithSummer(new Summer() {
            
            @Override
            public int sum(short s, byte b, int i) {
            
                return SumUtil.sum(s, b, i);
            }
        });
        System.out.println(res);
        
        // To this ...
        res = someClass.doSomethingWithSummer((s, b, i) -> {
            return SumUtil.sum(s, b, i);
        });
        System.out.println(res);
        
        // To this ...
        res = someClass.doSomethingWithSummer(SumUtil::sum);
        System.out.println(res);
    }
    
    static class SomeClass {
                
        public int doSomethingWithSummer(Summer summer) {
        
            return summer.sum((short) 1, (byte) 2, 3);
        };
        
    }
    
    /**
     * A handy utility that just so happens to have a method already 
     * that does what we want.
     * 
     * @author lockc
     *
     */
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
